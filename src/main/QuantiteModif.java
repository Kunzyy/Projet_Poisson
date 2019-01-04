package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class QuantiteModif extends JFrame {
    private JSpinner spinner1;
    private JPanel panel8;
    private JButton enregistrerButton;


    QuantiteModif(String nommodif, ArrayList<String> Arrayl2, int idCommande){

        add(panel8);
        setBounds(850,400,1,1);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        setPreferredSize(new Dimension(350,200));
        setMinimumSize(new Dimension(350,200));

        String query ="INSERT INTO Modif ( idComPlat, Modif, idIngredient, AjoutRetrait, Quantite )" +
                "VALUES (?, ?, ?, ?, ?);";
        ArrayList<String> tab = new ArrayList<>();

        tab.add(Integer.toString(idCommande));

        tab.add("true");

        int idIngredient = fun.recupId(nommodif,"SELECT IngredientsModif.idIngredient FROM IngredientsModif;","idIngredient",Arrayl2);

        tab.add(Integer.toString(idIngredient));

        tab.add("true");

        spinner1.setValue(0);





         enregistrerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String q2 = spinner1.getValue().toString();
                tab.add(q2);
              setVisible(false);
                fun.insertQuery(query,tab);
            }

        });
    }
}
