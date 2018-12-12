package main;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


class poisson {

    public static void main(String[] args) throws IOException,SQLException {

        System.out.println("Bonjour");


        //SQL
        connect();

        //
        //
        //

        //Pdf Writer
        Document document = new  Document(PageSize.A4);

        document.addAuthor("Kuntz");
        document.addTitle("Projet");

        try{

            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("test.pdf"));

            document.open();

            Image image = Image.getInstance("umons.png");
            image.scaleToFit(150,100);

            document.add(new Paragraph("Your developer journey with "));
            document.add(Chunk.NEWLINE);
            document.add(image);
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph(" begins here..."));


            document.close();
            writer.close();
            System.out.println("PDF crée");

        } catch (DocumentException e) {
            e.printStackTrace();
        }





        System.out.println("Done ! Au revoir ;)");

        //if (conn != null)
        //  conn.close();
    }


    public static void connect() throws SQLException {

        Connection conn = null;

        String url = "jdbc:sqlite:/Users/Nicolas/Desktop/Dvlp/Projet.db";

        try
        {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");


            //On va inserer des élements
            String query =  "INSERT INTO Client(idClient,Nom,Téléphone) VALUES(?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 4);
            pstmt.setString(2,"Georges");
            pstmt.setString(3,"118 218");

            String name;
            pstmt.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Base de données introuvable");
        }
        finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}