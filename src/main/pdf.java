package main;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class pdf {

    public static void pdfWriter() {
        //Pdf Writer
        Document document = new Document(PageSize.A4);

        document.addAuthor("Kuntz");
        document.addTitle("Projet");

        try {

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("test.pdf"));

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


            System.out.println("Done ! Au revoir ;)");
        }
    }
}
