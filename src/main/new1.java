package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class new1 extends JFrame{
    private JPanel panel2;
    private JTabbedPane tabbedPane1;
    private JRadioButton nouveauClientRadioButton;
    private JRadioButton clientEnregistréRadioButton;
    private JComboBox textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JButton enregistrerButton;
    private JComboBox cbnom;
    private JComboBox formattedTextField1;
    private JComboBox tfnompoisson;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JButton enregistrerButton2;
    private JSpinner spinner5;
    private JButton enregistrerButton1;
    private JComboBox cbcalibre;
    private JComboBox cbtypecuisson;
    private JButton modificationButton;
    private JPanel PNouveauClient;
    private JPanel PClientEnregistre;
    private JButton retourButton;
    private JCheckBox unitéEnGrammesCheckBox;
    private JSpinner spinner6;
    private JLabel label6;
    private JLabel label4;


ArrayList<String> Arrayplat = new ArrayList<>();
ArrayList<String> Arraynomclient = new ArrayList<>();
ArrayList<String> Arraynompoisson = new ArrayList<>();
ArrayList<String> Arraycalibre = new ArrayList<>();
ArrayList<String> Arraytypecuisson = new ArrayList<>();


    public new1(){


        getnew1();
        PClientEnregistre.setVisible(false);
        PNouveauClient.setVisible(false);
        label6.setVisible(false);
        spinner6.setVisible(false);

        fun.remplirList("SELECT Plat.Nom FROM Plat;","Nom",Arrayplat);
        fun.remplirList("SELECT Poisson.Nom FROM Poisson;","Nom",Arraynompoisson);
        fun.remplirList("SELECT Client.Nom FROM Client;","Nom",Arraynomclient);
        fun.remplirList("SELECT Homard.Calibre FROM Homard;","Calibre",Arraycalibre);
        fun.remplirList("SELECT Type_Cuisson.Type_Cuisson FROM Type_Cuisson;","Type_Cuisson",Arraytypecuisson);

        int t0 = fun.getcm(formattedTextField1,Arrayplat);
        int t1 = fun.getcm(tfnompoisson,Arraynompoisson);
        int t2 = fun.getcm(cbnom,Arraynomclient);
        int t3 = fun.getcm(cbcalibre,Arraycalibre);
        int t4 = fun.getcm(cbtypecuisson,Arraytypecuisson);



        modificationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Modif frame3 = new Modif();
            }

        });
        nouveauClientRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PClientEnregistre.setVisible(false);
                PNouveauClient.setVisible(true);
            }

        });
        clientEnregistréRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PClientEnregistre.setVisible(true);
                PNouveauClient.setVisible(false);
            }

        });
        enregistrerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new1 frame2 = new new1();
                setVisible(false);

                String query = "INSERT INTO Client(idClient,Nom,Telephone) VALUES(?,?,?)";

                int idClient = 1;

                ArrayList<String> tab = new ArrayList<>();
                tab.add(Integer.toString(idClient));
                tab.add(textField2.getText());
                tab.add(textField3.getText());

                fun.insertQuery(query,tab);
            }

        });
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                guit frame = new guit();
                setVisible(false);
            }

        });
        enregistrerButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new1 frame2 = new new1();
                setVisible(false);

            }

        });
        enregistrerButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new1 frame2 = new new1();
                setVisible(false);

            }

        });


        unitéEnGrammesCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(label4.getText()== "Nombre de poissons :") {
                    label4.setText("Quantité de poisson :");

                }
                    else {
                        label4.setText("Nombre de poissons :");

                }


            }
        });
    }

    public void getnew1(){

        add(panel2);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(560,340,1,1);
        setPreferredSize(new Dimension(800,400));
        setMinimumSize(new Dimension(800,400));


    }
}
