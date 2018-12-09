package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Modif extends JFrame {
    public JList<String> list1;
    private JPanel Panel3;
    private JSpinner spinner1;
    private JButton retourButton;
    private JButton ajouterUnIngrédientButton;
    private JList list2;
    private JLabel autre;
    private JPanel ajoutpanel;


    int t=  Main.getz(list1);

public void getl(){
//String s = Main.getz();
ArrayList<String> l =null;
//l.add(s);
  // JList list1 = new JList(l.toArray());
}


    public Modif() {
        add(Panel3);
        setSize(600,300);
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
spinner1.setVisible (true);
            }
        });
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        ajouterUnIngrédientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
ajouterUnIngrédientButton.setVisible(false);
autre.setVisible(true);
list2.setVisible(true);
            }
        });
    }

    public void getModif(){
        add(Panel3);
        setSize(600,300);
    }


}
