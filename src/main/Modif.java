package main;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.InputMethodListener;
import java.util.ArrayList;
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
    private JComboBox tf1;

    ArrayList<String> Arrayl1 = Main.getS();
    ArrayList<String> Arrayl2 = Main.getS();

    int t =  Main.getlm(list1,Arrayl1);
    int t1 =  Main.getlm(list2,Arrayl2);

    public Modif() {
           getModif();
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


        list2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {



                ArrayList<String> a =new ArrayList<>();


               String s = list2.getSelectedValue().toString();
                 if(s!=list1.getModel().getElementAt(0)) a.add(s);

               for (int i=0;i<list1.getModel().getSize();i++){

a.add(list1.getModel().getElementAt(i));
               }
                int t3 =  Main.getlm(list1,a);


            }
        });
    }

    public void getModif(){
        add(Panel3);
        setBounds(650,200,1,1);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        setPreferredSize(new Dimension(500,800));
        setMinimumSize(new Dimension(500,800));
    }



}
