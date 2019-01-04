package main;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
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


        String query1 = "SELECT * FROM Commande_1 WHERE(idClient = " + client.get(0) + ")";
        String query2 = "SELECT * FROM Commande_2 WHERE(idClient = " + client.get(0) + ")";
        String query3 = "SELECT * FROM Commande_3 WHERE(idClient = " + client.get(0) + ")";

        ResultSet rs1 = fun.selectQuery(query1);
        ResultSet rs2 = fun.selectQuery(query2);
        ResultSet rs3 = fun.selectQuery(query3);

        String data1[][] = new String[50][5];
        String data2[][] = new String[50][5];
        String data3[][] = new String[50][5];


        //
        //Les indices 1 travaillent avec la table Commande_1
        //

        int i = 0,j = 0,k =0;


        while(true)
        {
            try {
                if(!rs1.next())
                    break;
                data1[i][0]= rs1.getString("idComPlat");
                data1[i][1]= rs1.getString("idPlat");
                data1[i][2]= rs1.getString("NombrePersonnes");
                data1[i][3]= rs1.getString("idClient");
                data1[i][4]= rs1.getString("idDate");
                i++;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (int l = 0; l < i; l++) {


        }


        //
        //Les indices 2 travaillent avec la table Commande_2
        //

        while(true)
        {
            try {
                if(!rs2.next())
                    break;
                data2[j][0]= rs2.getString("idClient");
                data2[j][1]= rs2.getString("idPoisson");
                data2[j][2]= rs2.getString("Quantite");
                data2[j][3]= rs2.getString("Unite");
                data2[j][4]= rs2.getString("idDate");
                j++;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        //
        //Les indices 3 travaillent avec la table Commande_3
        //

        while(true)
        {
            try {
                if(!rs3.next())
                    break;
                data3[k][0]= rs3.getString("idClient");
                data3[k][1]= rs3.getString("idHomard");
                data3[k][2]= rs3.getString("idCuisson");
                data3[k][3]= rs3.getString("Quantite");
                data3[k][4]= rs3.getString("idDate");
                k++;

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
            JOptionPane.showMessageDialog(null,"PDF crée dans "+dirName);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }
}
