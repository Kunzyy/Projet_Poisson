package main;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

public class pdf {

    public static void main(String args[]) {
        //Pdf Writer
        Document document = new Document(PageSize.A4);

        document.addAuthor("Kuntz");
        document.addTitle("Projet");

        String dirName = "/Users/Nicolas/Documents/PDF_Outputs";
        new File(dirName).mkdir();

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dirName+"/test2.pdf"));

            document.open();

            Image image = Image.getInstance("umons.png");
            image.scaleToFit(150, 100);

            document.add(new Paragraph("Your developer journey with "));
            document.add(Chunk.NEWLINE);
            document.add(image);
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph(" begins here..."));


            document.close();
            writer.close();
            System.out.println("PDF crée");

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done ! Au revoir ;)");
    }
}
