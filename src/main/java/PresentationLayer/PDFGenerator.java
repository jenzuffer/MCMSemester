/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.Materiale;
import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.datatable.DataTable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author mwn
 */
public class PDFGenerator {

    private final String PATH = "src/main/webapp/Ressources/";
    private final String IMG_PATH = "src/main/webapp/Ressources/FogLogo.png";
    private final String JSP_PATH = "";
    private final String PDF_PREFIX = "pdf";
    private final String PDF_SUFFIX = ".pdf";

    private Carport carport;
    private final String[] HEADERS = {"Name", "Length", "Amount", "Unit", "Description"};

    private PDDocument document;
    private File pdf = new File(PATH + PDF_PREFIX + PDF_SUFFIX);

    private final PDFont FONT_NORMAL = PDType1Font.HELVETICA;
    private final PDFont FONT_BOLD = PDType1Font.HELVETICA_BOLD;

    public PDFGenerator(Carport carport) throws IOException {
        this.carport = carport;
        this.document = new PDDocument();
        setFrontPage();
        drawTable(carport.getMaterials());
        setImageOnFrontPage(IMG_PATH, -75, 617);
        document.save(pdf);
        document.close();
    }

    private void setFrontPage() throws IOException {
        PDPage frontPage = new PDPage();
        setTextCenter("Fog", 30, 24, FONT_BOLD, frontPage);
        if (carport.isShedChosen()) {
            setTextCenter("Carport med skur", 70, 20, FONT_NORMAL, frontPage);
            setTextCenter("Carport " + carport.getLength() + " X " + carport.getWidth() + " cm.", 130, 16, FONT_NORMAL, frontPage);
            setTextCenter("Skur " + carport.getShedLength() + " X " + carport.getShedWidth() + " cm.", 160, 16, FONT_NORMAL, frontPage);
        } else {
            setTextCenter("Carport", 70, 20, FONT_NORMAL, frontPage);
            setTextCenter("Carport " + carport.getLength() + " X " + carport.getWidth() + " cm.", 130, 16, FONT_NORMAL, frontPage);
        }
        document.addPage(frontPage);
    }

    private void setImageOnFrontPage(String imagePath, int x, int y) throws IOException {
        PDPage frontPage = document.getPage(0);
        PDPageContentStream cs = new PDPageContentStream(document, frontPage, PDPageContentStream.AppendMode.APPEND, false);
        PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, document);
        cs.drawImage(pdImage, x, y);
        cs.close();
    }

    private void drawTable(List<Materiale> list) throws IOException {
        PDPage page = new PDPage();
        document.addPage(page);
        float margin = 20;
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        float yStart = yStartNewPage;
        float bottomMargin = 0;
        List<List> data = new ArrayList();
        data.add(new ArrayList<>(Arrays.asList(HEADERS)));
        for (int i = 1; i <= list.size(); i++) {
            for (Materiale m : list) {
                data.add(new ArrayList<>(
                        Arrays.asList(m.getName(), m.getLength(), m.getAmount(), m.getUnit(), m.getDescription())));
            }
        }
        BaseTable dataTable = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, document, page, true, true);
        DataTable t = new DataTable(dataTable, page);
        t.addListToTable(data, DataTable.HASHEADER);
        dataTable.draw();
    }

    private void setTextCenter(String text, int marginTop, int fontSize, PDFont font, PDPage page) throws IOException {
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
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        Carport carport = new Carport(580, 780, 200, 200, true, true);
        PDFGenerator generator = new PDFGenerator(carport);
        System.out.println("Finish");
    }
}
