package main;

import main.Modif;
import main.guit;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JComboBox comboBox1;
    private JComboBox formattedTextField1;
    private JComboBox textField4;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JButton enregisterButton;
    private JSpinner spinner5;
    private JButton enregistrerButton1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton modificationButton;
    private JPanel PNouveauClient;
    private JPanel PClientEnregistre;
    private JButton retourButton;



    public new1(){
        add(panel2);
        PClientEnregistre.setVisible(false);
        PNouveauClient.setVisible(false);
        setSize(600,300);

        modificationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modif frame3 = new Modif();
                frame3.setBounds(650,200,1,1);
                frame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame3.pack();
                frame3.setVisible(true);
                frame3.setPreferredSize(new Dimension(500,800));
                frame3.setMinimumSize(new Dimension(500,800));
                frame3.getModif();


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
                frame2.getnew1();
                frame2.setVisible(true);
                frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame2.setBounds(560,340,1,1);
                frame2.setPreferredSize(new Dimension(800,400));
                frame2.setMinimumSize(new Dimension(800,400));
                setVisible(false);
            }
        });
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guit frame = new guit();
                frame.getguit();
                setVisible(false);
            }
        });
        enregisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new1 frame2 = new new1();
                frame2.getnew1();
                frame2.setVisible(true);
                frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame2.setBounds(560,340,1,1);
                frame2.setPreferredSize(new Dimension(800,400));
                frame2.setMinimumSize(new Dimension(800,400));
                setVisible(false);
            }
        });
        enregistrerButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new1 frame2 = new new1();
                frame2.getnew1();
                frame2.setVisible(true);
                frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame2.setBounds(560,340,1,1);
                frame2.setPreferredSize(new Dimension(800,400));
                frame2.setMinimumSize(new Dimension(800,400));
                setVisible(false);
            }
        });
    }

    public void getnew1(){
        add(panel2);
        setSize(600,300);
    }


}
