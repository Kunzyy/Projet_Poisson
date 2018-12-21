package main;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.InputMethodListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    private JLabel label1;
    private JScrollPane jsp1;

    ArrayList<String> Arrayl1 = new ArrayList<>();
    ArrayList<String> Arrayl2 = new ArrayList<>();

    ArrayList<String> tab = new ArrayList<>();
    ArrayList<String> quant = new ArrayList<>();


    public Modif(String nomPlat,int idPlat) {
        label1.setText(nomPlat);
        getModif();


        String query = "SELECT Contient.idPlat, Contient.idIngredientsBase, Contient.Quantite FROM Contient WHERE (((Contient.idPlat)='" +
                idPlat+"')) ORDER BY Contient.idPlat;";

        ResultSet rs = fun.selectQuery(query);

        while (true) {
            try {
                if (!rs.next()) break;

                tab.add(rs.getString("idIngredientsBase"));
                quant.add(rs.getString("Quantite"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



        for(int i = 0;i<tab.size();i++) {
            String query2 = "SELECT IngredientsBase.Nom FROM IngredientsBase WHERE (((IngredientsBase.idIngredientsBase)='" +
            tab.get(i) + "'))";

            ResultSet rs2 = fun.selectQuery(query2);

            while (true) {
                try {
                    if (!rs2.next()) break;

                    Arrayl1.add(rs2.getString("Nom"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(Arrayl1.get(2));

        fun.remplirList("SELECT IngredientsModif.Nom FROM IngredientsModif;","Nom",Arrayl2);

        fun.getlm(list1,Arrayl1);
        fun.getlm(list2,Arrayl2);

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
                jsp1.setVisible(true);

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
                fun.getlm(list1,a);


            }
        });

        spinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String s = list1.getSelectedValue();
                int i  = Arrayl1.indexOf(s);
                quant.set(i, Integer.toString((Integer) spinner1.getValue()));
            }
        });
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                String s = list1.getSelectedValue();
                int i  = Arrayl1.indexOf(s);
                spinner1.setModel(new SpinnerNumberModel(Integer.parseInt(quant.get(i)), 1, 200, 1));
            }
        });
    }

    public void getModif(){
        add(Panel3);
        setBounds(650,200,1,1);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        setPreferredSize(new Dimension(750,800));
        setMinimumSize(new Dimension(750,800));

    }



}
