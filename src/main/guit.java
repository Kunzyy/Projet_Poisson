package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guit extends JFrame{
    private JPanel panel1;
    private JButton nouvelleCommandeButton;
    private JButton commandesEnregistréesButton;


    public guit (){
        add(panel1);
        setSize(600,300);
        nouvelleCommandeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                new1 frame2 = new new1();

                frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame2.pack();
                frame2.setSize(1800,400);
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


}

