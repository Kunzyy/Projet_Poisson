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


    QuantiteModif(ArrayList<String> Arrayl2, JList list2, int idCommande){

        add(panel8);
        setBounds(850,400,1,1);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        setPreferredSize(new Dimension(350,200));
        setMinimumSize(new Dimension(350,200));

        String query ="INSERT INTO Modif ( idCommande, [Modif?], idIngredient, [Ajout/Retrait], Quantite )" +
                "VALUES ([?], [?], [?], [?], [?]);";
        ArrayList<String> tab = new ArrayList<>();

        tab.add(Integer.toString(idCommande));

        tab.add("true");

        HashMap<Integer,String> Mapingredientsmodif = new HashMap<>();

        fun.recupId(Mapingredientsmodif,"SELECT IngredientsModif.idIngredient FROM IngredientsModif;","idIngredientsModif",Arrayl2);
        String nommodif = list2.getSelectedValue().toString();
        int idIngredient = fun.getKey(Mapingredientsmodif,nommodif);
        tab.add(Integer.toString(idIngredient));

        tab.add("true");

        String q="0";
        spinner1.setValue(q);





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
