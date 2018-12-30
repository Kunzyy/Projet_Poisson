package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

public class choixdonnees extends JFrame {
    private JPanel panel5;
    private JButton listeDesClientsButton;
    private JButton commandedetailButton;
    private JButton evenementButton;
    private JButton retourButton;
    private JComboBox comboBoxevenement;
    private JComboBox comboBoxevenement2;
    private JButton voirButton;

    public choixdonnees(){

        add(panel5);
        comboBoxevenement.setVisible(false);
        comboBoxevenement2.setVisible(false);
        voirButton.setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(735,340,1,1);
        setPreferredSize(new Dimension(450,400));
        setMinimumSize(new Dimension(450,400));
        setVisible(true);

        ArrayList<String>ArrayDate = new ArrayList<>();
        ArrayList<String>Arraychoix = new ArrayList<>();
        Arraychoix.add("Commande");
        Arraychoix.add("Poisson");
        Arraychoix.add("Homard");
        fun.getcm(comboBoxevenement2,Arraychoix);
        fun.remplirList("SELECT DateCommande.Date FROM DateCommande;","Date",ArrayDate);

        fun.getcm(comboBoxevenement,ArrayDate);

        HashMap<Integer,String> MapDate = new HashMap<>();

        fun.recupId(MapDate,"SELECT DateCommande.idDate FROM DateCommande;","idDate",ArrayDate);



        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guit frame = new guit();
                setVisible(false);
            }
        });
        listeDesClientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
listeclient frame6 = new listeclient();
            }
        });
        commandedetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
detailcommande frame6 = new detailcommande();
            }
        });
        evenementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
comboBoxevenement.setVisible(true);
comboBoxevenement2.setVisible(true);
voirButton.setVisible(true);
evenementButton.setVisible(false);
            }
        });

        voirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int type=0;
                String t =comboBoxevenement2.getModel().getSelectedItem().toString();
                if(t.matches("Commande")) type=1;
                if(t.matches("Poisson")) type=2;
                if(t.matches("Hommard")) type=3;

                int idDate = fun.getKey(MapDate,comboBoxevenement.getModel().getSelectedItem().toString());
                evenement frame7 = new evenement(idDate,type);

            }
        });
    }
}
