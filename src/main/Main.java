package main;

import main.guit;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static int  getz(JList j){


// à faire : la partie database, il faudra charger les ingrédients de base depuis la data base dans l'arrayList


        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Hatchet");
        arr.add("Sword");
        arr.add("Shield");
        arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");
        arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");
        arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");arr.add("Shield");

        DefaultListModel lm = new DefaultListModel();
        for(int i = 0; i < arr.size(); i++)
        {
            lm.addElement(arr.get(i));
        }
        j.setModel(lm);
        return 0;
    }


    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, SQLException {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Windows Look and feel

            guit frame = new guit();
             frame.getguit();


    }

}