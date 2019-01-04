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





    public static void insertQuery(String query, ArrayList<String> tab)
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
    }

    public static void recupId(HashMap<Integer, String> map, String query,String id,ArrayList<String> list)
    {
        ArrayList<String> ArrayId = new ArrayList<>();
        remplirList(query,id,ArrayId);
        for(int i = 0;i<list.size();i++)
        {
            map.put(Integer.parseInt(ArrayId.get(i)),list.get(i));
        }
    }

    public static Integer getKey(HashMap<Integer, String> map, String value) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
