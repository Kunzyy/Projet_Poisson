package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class choixdonnees extends JFrame {
    private JPanel panel5;
    private JButton listeDesClientsButton;
    private JButton traiteurButton;
    private JButton evènementButton;
    private JButton retourButton;

    public choixdonnees(){

        add(panel5);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(735,340,1,1);
        setPreferredSize(new Dimension(450,400));
        setMinimumSize(new Dimension(450,400));
        setVisible(true);

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
        traiteurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        evènementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
