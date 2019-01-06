package main;


//Class qui contient toutes les fonctions utiles au programme
//fun pour functions


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
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

    public static void gettm(JTable table, String[][]data,String[]titre ){
        DefaultTableModel tm = new DefaultTableModel(data,titre);
       table.setModel(tm);
    }


    public static Connection getConnection()
    {
        Connection conn = null;
        String url  = "jdbc:mysql://localhost:3306/projet";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "admin178";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
        }
        catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null,"Problème avec la base de données !");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null,"Problème de driver!");
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

    public static String singleselectQuery(String query,String label)
    {

        ResultSet rs = selectQuery(query);
        String result = null;
        try {
            if(rs.next())
                result = rs.getString(label);
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    //Cette fonction remplit une liste vide par une colonne d'une table, il s'agit d'une requete SQL à un seul élément donc
    // plus facile à en faire une seule fonction

    public static void remplirList(String query, String label, ArrayList<String> tab)
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

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    public static void insertQuery(String query, ArrayList<String> tab)
    {
        Connection conn = getConnection();

        try {
            PreparedStatement pst = conn.prepareStatement(query);

            for(int i = 0;i<tab.size();i++)
                pst.setString(i+1, tab.get(i));

            pst.executeUpdate();
            conn.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    //Fonction simple pour effectuer des deletes ou des drops

    public static void simpleQuery(String query)
    {
        Connection conn = getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.executeUpdate();
            conn.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }


    // Cette fonction permet de récupérer l'id d'un élément d'une table à partir de son nom, il faut juste une liste des noms
    // récupérée par une requete (un remplirlist). La map est crée à partir d'une list d'id et la liste de nom. C'est plus facile
    // pour la creation de la liste d'id d'utiliser la requete et remplirlist car on n'utilise nulle part autre une liste d'id alors
    // qu'on a deja cree une liste de noms avant dans le new1.

    public static int recupId(String nom, String query,String id,ArrayList<String> list)
    {
        HashMap<Integer, String> map = new HashMap<>();

        ArrayList<String> ArrayId = new ArrayList<>();
        remplirList(query,id,ArrayId);
        for(int i = 0;i<list.size();i++)
        {
            map.put(Integer.parseInt(ArrayId.get(i)),list.get(i));
        }

        return fun.getKey(map,nom);
    }

    //Fonction pour retrouver une clé à partir d'un nom dans une map

    public static Integer getKey(HashMap<Integer, String> map, String value) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
