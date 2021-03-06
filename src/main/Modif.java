package main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
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
    private JList <String>list2;
    private JLabel autre;
    private JLabel label1;
    private JScrollPane jsp1;
    private JList list3;
    private JScrollPane jsp2;
    private JLabel Ingredientsajoutes;
    private JButton supprimerButton;
    private JLabel quantajoutlabel;

    ArrayList<String> Arrayl1 = new ArrayList<>();
    ArrayList<String> Arrayl2 = new ArrayList<>();
    ArrayList<String> Arrayl3 = new ArrayList<>();
    ArrayList<String> tab = new ArrayList<>();
    ArrayList<String> quant = new ArrayList<>();
    ArrayList<String> quantcopy = new ArrayList<>() ;
    ArrayList<String> idIngrebase = new ArrayList<>();

    public Modif(String nomPlat,int idPlat,int idCommande) {
        label1.setText(nomPlat);
        add(Panel3);
        setBounds(650,200,1,1);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        setPreferredSize(new Dimension(750,800));
        setMinimumSize(new Dimension(750,800));



        String query = "SELECT Contient.idIngredientsBase FROM Contient WHERE idPlat ='"+idPlat+"';";

        ResultSet rs = fun.selectQuery(query);

        while (true) {
            try {
                if (!rs.next()) break;

                idIngrebase.add(rs.getString("idIngredientsBase"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        for (int i = 0; i < idIngrebase.size(); i++) {

            fun.remplirList("SELECT IngredientsBase.Nom FROM IngredientsBase WHERE idIngredientsBase ='" + idIngrebase.get(i) + "';", "Nom", Arrayl1);
        }
        fun.remplirList("SELECT IngredientsModif.Nom FROM IngredientsModif;","Nom",Arrayl2);
        fun.getlm(list1,Arrayl1);
        fun.getlm(list2,Arrayl2);



        String queryl1 = "SELECT Contient.idPlat, Contient.idIngredientsBase, Contient.Quantite,Contient.Quantite AS Quantcopy FROM Contient WHERE (((Contient.idPlat)='" +
                idPlat+"')) ORDER BY Contient.idPlat;";

        ResultSet rsl1 = fun.selectQuery(queryl1);

        while (true) {
            try {
                if (!rsl1.next()) break;

                tab.add(rsl1.getString("idIngredientsBase"));
                quant.add(rsl1.getString("Quantite"));
                quantcopy.add(rsl1.getString("Quantcopy"));
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





        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                spinner1.setVisible (true);

            }
        });
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i <quant.size() ; i++) {

                    if(!quant.get(i).matches(quantcopy.get(i))){

                        String query ="INSERT INTO Modif (idComPlat, Modif, idIngredient, AjoutRetrait, Quantite )" +
                                "VALUES (?, ?, ?, ?, ?);";
                        ArrayList<String> tab = new ArrayList<>();

                        tab.add(Integer.toString(idCommande));

                        tab.add("0");

                        int idIngredient = fun.recupId(list1.getSelectedValue(),"SELECT IngredientsBase.idIngredientsBase FROM IngredientsBase;","idIngredientsBase",Arrayl1);

                        tab.add(Integer.toString(idIngredient));

                        if(Integer.parseInt(quant.get(i)) > Integer.parseInt(quantcopy.get(i))){
                            tab.add("1");
                            tab.add(Integer.toString(Integer.parseInt(quant.get(i)) - Integer.parseInt(quantcopy.get(i))));
                        }else{
                            tab.add("0");
                            tab.add(Integer.toString(Integer.parseInt(quantcopy.get(i))-Integer.parseInt(quant.get(i))));
                        }
                        fun.insertQuery(query,tab);
                    }
                }
                setVisible(false);

            }
        });

        ajouterUnIngrédientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ajouterUnIngrédientButton.setVisible(false);
                autre.setVisible(true);
                jsp1.setVisible(true);
                jsp2.setVisible(true);
                Ingredientsajoutes.setVisible(true);
                quantajoutlabel.setVisible(true);
                supprimerButton.setVisible(true);
            }
        });


        list2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {


               String s = list2.getSelectedValue().toString();

               boolean doublon =false;

               for(int i=0;i<Arrayl3.size();i++) {

                   if (s.matches(Arrayl3.get(i))) doublon=true ;
               }

               if(doublon==false) {

                Arrayl3.add(s);
                fun.getlm(list3,Arrayl3);
                   QuantiteModif frame8 = new QuantiteModif(s,Arrayl2,idCommande);
               }
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

                int i  = Arrayl1.indexOf(list1.getSelectedValue());
                spinner1.setModel(new SpinnerNumberModel(Integer.parseInt(quant.get(i)), 1, 200, 1));
            }
        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(Arrayl3.size() > 0)
                {
                    String eff = list3.getSelectedValue().toString();
                    for (int i = 0; i <Arrayl3.size() ; i++) {
                        if(Arrayl3.get(i).matches(eff)){
                            Arrayl3.remove(i);
                            fun.getlm(list3,Arrayl3);
                        }
                    }
                    int idingre = fun.recupId(eff,"SELECT IngredientsModif.idIngredient FROM IngredientsModif ","idIngredient",Arrayl2);
                    String query4 = "DELETE FROM Modif WHERE idComPlat ='"+idCommande+"' AND idIngredient ='"+idingre+"';";
                    fun.simpleQuery(query4);
                }
            }
        });

        list3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int id = fun.recupId(list3.getSelectedValue().toString(), "SELECT IngredientsModif.idIngredient FROM IngredientsModif ", "idIngredient", Arrayl2);

                String query3 = "SELECT Modif.Quantite FROM Modif WHERE idIngredient='" + id + "'AND idComPlat ='" + idCommande + "';";

                String res = fun.singleselectQuery(query3, "Quantite");

                quantajoutlabel.setText("Quantité : "+ res);
            }
        });
    }
}
