package main;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


//Cette classe va gérer tous les outputs PDF

public class pdf {

    //public static void pdfClient (ArrayList<String> client) {
    public static void main(String[] args) {

        ArrayList<String> client = new ArrayList<>();
        client.add("2");
        client.add("Kuntz");
        client.add("178178");

        String query = "SELECT * FROM Commande_1 WHERE(idClient = " + client.get(0) + ")";

        ResultSet rs = fun.selectQuery(query);

        while(true)
        {
            try {
                if(!rs.next())
                    break;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        //Pdf Writer
        Document document = new Document(PageSize.A4);

        document.addAuthor("Kuntz");
        document.addTitle("Projet");

        String dirName = "/Users/Nicolas/Documents/PDF_Outputs";
        new File(dirName).mkdir();


        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dirName+"/Client"+client.get(0)+".pdf"));

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
            javax.swing.JOptionPane.showMessageDialog(null,"PDF crée dans "+dirName);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }
}
