package main;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


class poisson {

    public static void main(String[] args) throws IOException, SQLException {

        System.out.println("Bonjour");


        //SQL
        //connect();
        String query = "SELECT idClient, Nom, Telephone FROM Client";
        System.out.println("Coucou2");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn =DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/projet","root","admin178");
            //here sonoo is database name, root is username and password
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query);

            System.out.println("Coucou");
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("idClient") +  "\t" +
                        rs.getString("Nom") + "\t" +
                        rs.getString("Telephone"));
            }
        }catch(Exception e){ System.out.println(e);}

        //
        //
        //

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

        } catch (DocumentException e) {
            e.printStackTrace();
        }


        System.out.println("Done ! Au revoir ;)");

        //if (conn != null)
        //  conn.close();
    }


    public static void connect() {

        //Pour le insert, le code est simple et c'est :

        String query = "INSERT INTO Client(idClient,Nom,Telephone) VALUES(?,?,?)";

        ArrayList<String> tab = new ArrayList<>();
        tab.add("4");
        tab.add("Francis");
        tab.add("117 217");

        fun.insertQuery(query, tab);


        /*try {
            Connection conn = Main.getConnection();

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, 4);
            pst.setString(2, "Georges");
            pst.setString(3, "118 218");

            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }*/

            /*

            String query = "SELECT idClient, Nom, Téléphone FROM Client";

            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query);


                // loop through the result set
                while (rs.next()) {
                    System.out.println(rs.getInt("idClient") +  "\t" +
                            rs.getString("Nom") + "\t" +
                            rs.getString("Téléphone"));
                }
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
        }*/


        Connection conn = null;
        String url = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)}; DBQ=Database.accdb";

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (
                ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Probeleme avec le driver");
        }

        try {
            conn = DriverManager.getConnection(url, "", "");
        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Problème avec la base de données !");
        }
        //return conn;
    }
}