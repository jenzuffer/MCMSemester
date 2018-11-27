/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Carport;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author mwn
 */
public class PDFGenerator {

    private final String PATH = "src/main/webapp/Ressources/Pdf/";
    private final String JSPPATH = "Ressources/Pdf/";
    private final String FILEPREFIX = "pdf";
    private final String FILESUFFIX = ".pdf";
    private final String TEMPFILEPREFIX = "pdfTemp";
    private final String TEMPFILESUFFIX = ".pdf";

    private Carport carport;

    private PDDocument document;
    private File pdf = new File(PATH + FILEPREFIX + FILESUFFIX);
    private File temp = new File(PATH + TEMPFILEPREFIX + TEMPFILESUFFIX);

    private PDFont fontNormal = PDType1Font.HELVETICA;
    private PDFont fontBold = PDType1Font.HELVETICA_BOLD;

    public PDFGenerator(Carport carport) throws IOException {
        this.carport = carport;
        this.document = PDDocument.load(pdf);
        setFrontPage();
    }

    private void setFrontPage() throws IOException {
        document.save(temp);
        document.close();
    }

    public String getFilePath() throws IOException {
        return JSPPATH + TEMPFILEPREFIX + TEMPFILESUFFIX;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        Carport carport = new Carport(200, 200, 200, 200, false, false);
        PDFGenerator generator = new PDFGenerator(carport);
        System.out.println(generator.getFilePath());
        System.out.println("Finish");
    }
}
