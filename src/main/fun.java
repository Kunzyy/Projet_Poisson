package main;


//class qui contient toutes les fonctions utiles au programme
//fun pour functions

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class fun {

    public static int getlm(JList j, ArrayList<String> a){

        DefaultListModel lm = new DefaultListModel();
        for(int i = 0; i < a.size(); i++)
        {
            lm.addElement(a.get(i));
        }
        j.setModel(lm);
        return 0;
    }

    public static int getcm(JComboBox c,ArrayList<String> a){

        DefaultComboBoxModel cm = new DefaultComboBoxModel();
        for(int i =0; i<a.size();i++){
            cm.addElement(a.get(i));
        }

        c.setModel(cm);


        return 0;
    }


    public static Connection getConnection()
    {
        Connection conn = null;
        String url  = "jdbc:sqlite:/Users/Nicolas/Desktop/Dvlp/data.db";

        try {
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null,"Problème avec la base de données !");
        }
        return conn;
    }



    public static ResultSet selectQuery(String query)
    {
        Connection conn = getConnection();

        Statement stmt  = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet rs  = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }





    public static void insertQuery(String query,ArrayList<String> tab)
    {
        Connection conn = getConnection();

        try {

            PreparedStatement pst = conn.prepareStatement(query);

            for(int i = 0;i<tab.size();i++)
                pst.setString(i+1, tab.get(i));

            pst.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void remplirList(String query,String label, ArrayList<String> tab)
    {
        ResultSet rs = selectQuery(query);

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                tab.add(rs.getString(label));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
