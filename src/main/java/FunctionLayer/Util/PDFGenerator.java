/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Util;

import FunctionLayer.Carport;
import FunctionLayer.Exceptions.PDFException;
import FunctionLayer.Material;
import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.datatable.DataTable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;

/**
 *
 * @author mwn
 */
public class PDFGenerator {

    private Carport carport;

    private final String[] HEADERS = {"Name", "Length", "Amount", "Unit", "Description"};
    private final PDFont FONT_NORMAL = PDType1Font.HELVETICA;
    private final PDFont FONT_BOLD = PDType1Font.HELVETICA_BOLD;
    private String svg;

    public PDFGenerator(Carport carport, String svg) {
        this.carport = carport;
        this.svg = svg;
    }

    public byte[] generatePdf() throws PDFException {
        ByteArrayOutputStream out;
        try (PDDocument document = new PDDocument()) {
            out = new ByteArrayOutputStream();
            setFrontPage(document);
            drawTable(document, carport.getListOfLists());
            document.save(out);
        } catch (IOException ex) {
            throw new PDFException("Could not generate PDF: " + ex);
        }
        return out.toByteArray();
    }

    private void setFrontPage(PDDocument document) throws PDFException {
        PDPage frontPage = new PDPage();
        setTextCenter("Fog", 30, 24, FONT_BOLD, frontPage, document);
        if (carport.isShedChosen()) {
            setTextCenter("Carport med skur", 70, 20, FONT_NORMAL, frontPage, document);
            setTextCenter("Carport " + carport.getLength() + " X " + carport.getWidth() + " cm.", 130, 16, FONT_NORMAL, frontPage, document);
            setTextCenter("Skur " + carport.getShedLength() + " X " + carport.getShedWidth() + " cm.", 160, 16, FONT_NORMAL, frontPage, document);
        } else {
            setTextCenter("Carport", 70, 20, FONT_NORMAL, frontPage, document);
            setTextCenter("Carport " + carport.getLength() + " X " + carport.getWidth() + " cm.", 130, 16, FONT_NORMAL, frontPage, document);
        }
        setSVGImage(document, this.svg, frontPage);
        document.addPage(frontPage);
    }

    private void drawTable(PDDocument document, HashMap<String, List<Material>> map) throws IOException {
        PDPage page = new PDPage();
        document.addPage(page);
        float margin = 20;
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        float yStart = yStartNewPage;
        float bottomMargin = 0;
        List<List> data = new ArrayList();
        data.add(new ArrayList<>(Arrays.asList(HEADERS)));

        for (List<Material> list : map.values()) {
            for (Material m : list) {
                data.add(new ArrayList<>(
                        Arrays.asList(m.getName(), m.getLength(), m.getAmount(), m.getUnit(), m.getDescription())));
            }
        }

        BaseTable dataTable = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, document, page, true, true);
        DataTable t = new DataTable(dataTable, page);
        t.addListToTable(data, DataTable.HASHEADER);
        dataTable.draw();
    }

    private void setTextCenter(String text, int marginTop, int fontSize, PDFont font, PDPage page, PDDocument document) throws PDFException {
        try (PDPageContentStream cs = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, false)) {
            float titleWidth = font.getStringWidth(text) / 1000 * fontSize;
            float titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;

            float startX = (page.getMediaBox().getWidth() - titleWidth) / 2;
            float startY = page.getMediaBox().getHeight() - marginTop - titleHeight;

            cs.beginText();
            cs.setFont(font, fontSize);
            cs.newLineAtOffset(startX, startY);
            cs.showText(text);
            cs.endText();
            cs.close();
        } catch (IOException ex) {
            throw new PDFException("Could not edit pdf: " + ex);
        }
    }

    private void setSVGImage(PDDocument document, String svg, PDPage page) throws PDFException  {
        try {
            PDImageXObject img = JPEGFactory.createFromStream(document, new ByteArrayInputStream(svgConversion(svg)));
            try (PDPageContentStream contents = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, false)) {
                float x = page.getMediaBox().getUpperRightX();
                float y = page.getMediaBox().getUpperRightY();
                float viewboxX = 400;
                float viewboxY = 400;
                float centerX = x/2 - viewboxX/2 + ((float) carport.getLength());
                float centerY = y/4;
                System.out.println(x + "," + y);
                System.out.println(x/2 + "," + y/2);
                System.out.println((x/2 - viewboxX/2)+ "," + (y/2 - viewboxY/2));
                System.out.println(x/2 - viewboxX/2 + "," + centerY);
                
                
                contents.drawImage(img, x/2 - viewboxX/2 , y/2 - viewboxY/2, 400, 386);
                contents.close();
            }
        } catch(IOException ex) {
            throw new PDFException("could not set SVG image: " + ex);
        }
    }

    private byte[] svgConversion(String svg) throws PDFException {

        try {
            // Create a JPEG transcoder
            JPEGTranscoder t = new JPEGTranscoder();
            
            // Set the transcoding hints.
            t.addTranscodingHint(JPEGTranscoder.KEY_QUALITY,
                    new Float(.8));
            
            // Create the transcoder input.
            TranscoderInput input = new TranscoderInput(new ByteArrayInputStream(svg.getBytes()));
            // Create the transcoder output.
            ByteArrayOutputStream ostream = new ByteArrayOutputStream();
            TranscoderOutput output = new TranscoderOutput(ostream);
            
            // Save the image.
            t.transcode(input, output);
            
            // Flush and close the stream.
            ostream.flush();
            ostream.close();
            return ostream.toByteArray();
        } catch (TranscoderException | IOException ex) {
            throw new PDFException("SVG conversion failed: " + ex);
        }
    }

    /*
     */
}
