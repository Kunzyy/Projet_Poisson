package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guit extends JFrame{
    private JPanel panel1;
    private JButton nouvelleCommandeButton;
    private JButton commandesEnregistréesButton;


    public guit (){

        getguit();

        nouvelleCommandeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new1 frame2 = new new1();
                frame2.getnew1();
                setVisible(false);

            }

        });

        commandesEnregistréesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new2 frame4 = new new2();
                frame4.getnew2();
                setVisible(false);
            }

        });

    }

    public void getguit (){

        add(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(735,340,1,1);
        setPreferredSize(new Dimension(450,400));
        setMinimumSize(new Dimension(450,400));
        setVisible(true);

    }


}

