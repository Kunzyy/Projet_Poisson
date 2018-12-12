package main;

import main.Modif;
import main.guit;
import main.Main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.InputMethodListener;
import java.util.ArrayList;

public class new1 extends JFrame {
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
    private JButton enregisterButton;
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


ArrayList<String> Arraypoisson = Main.getS();
ArrayList<String> Arraynomclient = Main.getS();
ArrayList<String> Arraynompoisson = Main.getS();
ArrayList<String> Arraycalibre = Main.getS();
ArrayList<String> Arraytypecuisson = Main.getS();


int t = Main.getcm(formattedTextField1,Arraypoisson);
int t1 = Main.getcm(cbnom,Arraynomclient);
int t2 = Main.getcm(tfnompoisson,Arraynompoisson);
int t3 = Main.getcm(cbcalibre,Arraynompoisson);
int t4 = Main.getcm(cbtypecuisson,Arraynompoisson);


    public new1(){
        getnew1();
        PClientEnregistre.setVisible(false);
        PNouveauClient.setVisible(false);
        label6.setVisible(false);
        spinner6.setVisible(false);





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

            }

        });
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                guit frame = new guit();
                setVisible(false);
            }

        });
        enregisterButton.addActionListener(new ActionListener() {
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
