package main;

import main.Modif;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class new1 extends JFrame {
    private JPanel panel2;
    private JTabbedPane tabbedPane1;
    private JRadioButton nouveauClientRadioButton;
    private JRadioButton clientEnregistréRadioButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JButton enregistrerButton;
    private JComboBox comboBox1;
    private JFormattedTextField formattedTextField1;
    private JTextField textField4;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JButton enregisterButton;
    private JSpinner spinner5;
    private JButton button1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton modificationButton;
    private JPanel PNouveauClient;
    private JPanel PClientEnregistre;

    public new1(){
        add(panel2);
        PClientEnregistre.setVisible(false);
        PNouveauClient.setVisible(false);
        setSize(600,300);

        modificationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modif frame3 = new Modif();
                frame3.setSize(800,400);
                frame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame3.pack();
                frame3.setVisible(true);
                PClientEnregistre.setVisible(false);
                PNouveauClient.setVisible(false);
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
    }

    public void getnew1(){
        add(panel2);
        setSize(600,300);
    }
}
