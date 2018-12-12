package main;

import main.guit;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static int  getlm(JList j,ArrayList<String> a){


        // à faire : la partie database, il faudra charger les ingrédients de base depuis la data base dans l'arrayList



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

public static ArrayList<String> getS(){
        ArrayList<String> a = new ArrayList<>();
      for(int i =1;i<25;i++) {
          a.add("coucou" + i);
      }

        return a;
};

    public static ArrayList<String> gettest(String s){
      ArrayList<String> a = new ArrayList<>();
      a.add(s);

       return  a;
    }



    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, SQLException {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Windows Look and feel
            guit frame = new guit();

    }

}