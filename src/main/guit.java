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
        add(panel1);
        nouvelleCommandeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                new1 frame2 = new new1();

                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setBounds(560,340,1,1);
                frame2.setPreferredSize(new Dimension(800,400));
                frame2.setMinimumSize(new Dimension(800,400));
                frame2.setVisible(true);
                frame2.getnew1();
                setVisible(false);

            }
        });
        commandesEnregistréesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            String querry = "select* FROM IngrédientsBase";


                JOptionPane.showMessageDialog(panel1,querry);
            }
        });
    }

    public void getguit (){
        guit frame = new guit();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(735,340,1,1);
        frame.setPreferredSize(new Dimension(450,400));
        frame.setMinimumSize(new Dimension(450,400));
        frame.setVisible(true);
    }


}

