package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class guit extends JFrame{
    private JPanel panel1;
    private JButton nouvelleCommandeButton;
    private JButton commandesEnregistréesButton;

    public guit () {

        add(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,150,1,1);
        setPreferredSize(new Dimension(450,400));
        setMinimumSize(new Dimension(450,400));
        setVisible(true);

        nouvelleCommandeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new1 frame2 = new new1();
                setVisible(false);
            }

        });

        commandesEnregistréesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                choixdonnees frame6 = new choixdonnees();
                setVisible(false);
            }

        });

    }

}

