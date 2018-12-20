package main;


//Class qui contient toutes les fonctions utiles au programme
//fun pour functions

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

public class fun {

    public static void getlm(JList j, ArrayList<String> a){

        DefaultListModel lm = new DefaultListModel();
        for(int i = 0; i < a.size(); i++)
        {
            lm.addElement(a.get(i));
        }
        j.setModel(lm);
    }

    public static void getcm(JComboBox c,ArrayList<String> a){

        DefaultComboBoxModel cm = new DefaultComboBoxModel();
        for(int i =0; i<a.size();i++){
            cm.addElement(a.get(i));
        }

        c.setModel(cm);
    }


    public static Connection getConnection()
    {
        Connection conn = null;
        String url  = "jdbc:sqlite:C:\\Users\\frost\\Documents\\BA3\\Base de données\\data.db";

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

        Statement stmt;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
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
                tab.add(rs.getString(label));

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
