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

    public static void pdfClient (ArrayList<String> client) {
    //public static void main(String[] args) {

        /*ArrayList<String> client = new ArrayList<>();
        client.add("5");
        client.add("Kuntz");
        client.add("178178");*/


        String query1 = "SELECT * FROM Commande_1 WHERE(idClient = " + client.get(0) + ")";
        String query2 = "SELECT * FROM Commande_2 WHERE(idClient = " + client.get(0) + ")";
        String query3 = "SELECT * FROM Commande_3 WHERE(idClient = " + client.get(0) + ")";

        ResultSet rs1 = fun.selectQuery(query1);
        ResultSet rs2 = fun.selectQuery(query2);
        ResultSet rs3 = fun.selectQuery(query3);

        String data1[][] = new String[50][4];
        String data2[][] = new String[50][4];
        String data3[][] = new String[50][4];


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
                //data1[i][3]= rs1.getString("idClient");                    //Pas nécéssaire, on l'a déjà
                data1[i][3]= rs1.getString("idDate");
                i++;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (int l = 0; l < i; l++) {

            String queryId1 = "SELECT Plat.Nom FROM Plat WHERE Plat.idPlat = " + data1[l][1];
            String queryId2 = "SELECT DateCommande.Date FROM DateCommande WHERE DateCommande.idDate = " + data1[l][3];

            data1[l][1] = fun.singleselectQuery(queryId1,"Nom");
            data1[l][3] = fun.singleselectQuery(queryId2,"Date");

            System.out.println("Commande : "+data1[l][0]+" Plat : "+data1[l][1]+" Personnes : "+data1[l][2]+" Date : "+data1[l][3]);
        }


        //
        //Les indices 2 travaillent avec la table Commande_2
        //

        while(true)
        {
            try {
                if(!rs2.next())
                    break;
                //data2[j][0]= rs2.getString("idClient");
                data2[j][0]= rs2.getString("idPoisson");
                data2[j][1]= rs2.getString("Quantite");
                data2[j][2]= rs2.getString("Unite");
                data2[j][3]= rs2.getString("idDate");

                if(Integer.parseInt(data2[j][2]) == 1)
                    data2[j][2] = "tranches";
                else
                    data2[j][2] = "grammes";

                j++;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (int l = 0; l < j; l++) {

            String queryId1 = "SELECT Poisson.Nom FROM Poisson WHERE Poisson.idPoisson = " + data2[l][0];
            String queryId2 = "SELECT DateCommande.Date FROM DateCommande WHERE DateCommande.idDate = " + data2[l][3];

            data2[l][0] = fun.singleselectQuery(queryId1,"Nom");
            data2[l][3] = fun.singleselectQuery(queryId2,"Date");

            System.out.println("Poisson : "+data2[l][0]+" Quantite : "+data2[l][1]+" Unite : "+data2[l][2]+" Date : "+data2[l][3]);
        }

        //
        //Les indices 3 travaillent avec la table Commande_3
        //

        while(true)
        {
            try {
                if(!rs3.next())
                    break;
                //data3[k][0]= rs3.getString("idClient");
                data3[k][0]= rs3.getString("idHomard");
                data3[k][1]= rs3.getString("idCuisson");
                data3[k][2]= rs3.getString("Quantite");
                data3[k][3]= rs3.getString("idDate");

                k++;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (int l = 0; l < k; l++) {

            String queryId1 = "SELECT Homard.Calibre FROM Homard WHERE Homard.idHomard = " + data3[l][0];
            String queryId2 = "SELECT Type_Cuisson.TypeCuisson FROM Type_Cuisson WHERE Type_Cuisson.idCuisson = " + data3[l][1];
            String queryId3 = "SELECT DateCommande.Date FROM DateCommande WHERE DateCommande.idDate = " + data3[l][3];

            data3[l][0] = fun.singleselectQuery(queryId1,"Calibre");
            data3[l][1] = fun.singleselectQuery(queryId2,"TypeCuisson");
            data3[l][3] = fun.singleselectQuery(queryId3,"Date");

            System.out.println("Calibre : "+data3[l][0]+" Cuisson : "+data3[l][1]+" Quantite : "+data3[l][2]+" Date : "+data3[l][3]);
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

            document.add(new Paragraph("N° Client : "+client.get(0)));
            document.add(new Paragraph("Nom du Client : "+client.get(1)));
            document.add(new Paragraph("Téléphone : "+client.get(2)));
            document.add(Chunk.NEWLINE);
            document.add(image);
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Liste des commandes : "));
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);


            for (int l = 0; l < j; l++) {

                int tmp = l+1;
                document.add(new Paragraph("Commande Poisson "+tmp));
                document.add(new Paragraph("Type de poisson : "+data2[l][0]));
                document.add(new Paragraph("Quantité commandée : "+data2[l][1]+" "+data2[l][2]));
                document.add(new Paragraph("Date : "+data2[l][3]));

                document.add(Chunk.NEWLINE);
            }


            for (int l = 0; l < k; l++) {

                int tmp = l+1;
                document.add(new Paragraph("Commande Poisson "+tmp));
                document.add(new Paragraph("Calibre : "+data3[l][0]));
                document.add(new Paragraph("Quantité commandée : "+data3[l][1]));
                document.add(new Paragraph("Cuisson : "+data3[l][2]));
                document.add(new Paragraph("Date : "+data3[l][3]));

                document.add(Chunk.NEWLINE);
            }




            if(i==0 && j==0 && k==0)
            {
                document.add(Chunk.NEWLINE);
                document.add(new Paragraph(" Pas de commande pour ce client..."));
            }



            document.close();
            writer.close();
            JOptionPane.showMessageDialog(null,"PDF crée dans "+dirName);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }
}
