package main;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


public class new1 extends JFrame{
    private JPanel panel2;
    private JTabbedPane tabbedPane1;
    private JRadioButton nouveauClientRadioButton;
    private JRadioButton clientEnregistréRadioButton;
    private JLabel labelid;
    private JTextField textField2;
    private JTextField textField3;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JButton enregistrerButton;
    private JComboBox cbnom;
    private JComboBox jComboBoxPlat;
    private JComboBox tfnompoisson;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JButton enregistrerButton2;
    private JSpinner spinner5;
    private JButton enregistrerButton1;
    private JComboBox cbcalibre;
    private JComboBox cbtypecuisson;
    private JButton modificationButton;
    private JPanel PNouveauClient;
    private JPanel PClientEnregistre;
    private JButton retourButton;
    private JCheckBox unitéEnGrammesCheckBox;
    private JLabel label4;
    private boolean tranchesOuGrammes;  // 1 = grammes et 0 = tranches


ArrayList<String> Arrayplat = new ArrayList<>();
ArrayList<String> ArrayidPlat = new ArrayList<>();
ArrayList<String> Arraynomclient = new ArrayList<>();
ArrayList<String> Arraynompoisson = new ArrayList<>();
ArrayList<String> Arraycalibre = new ArrayList<>();
ArrayList<String> Arraytypecuisson = new ArrayList<>();

HashMap<Integer,String> MapPlat = new HashMap<>();


    public new1(){

        getnew1();

        ArrayList<String> idClientArray = new ArrayList<>();
        fun.remplirList("SELECT Client.idClient FROM Client ORDER BY Client.idClient","idClient",idClientArray);


        int id;
        System.out.println(idClientArray.size());
        for( id=0;id<=idClientArray.size()-1;id++) {

System.out.println(id);
System.out.println(idClientArray.get(id));
               if (Integer.parseInt(idClientArray.get(id)) != id) {
                   break;
               }
        }
        id++;

        labelid.setText(Integer.toString(id));

        PClientEnregistre.setVisible(false);
        PNouveauClient.setVisible(false);

        spinner1.setModel(new SpinnerNumberModel(1, 1, 200, 1));
        spinner4.setModel(new SpinnerNumberModel(1, 1, 200, 1));
        spinner5.setModel(new SpinnerNumberModel(1, 1, 200, 1));


        fun.remplirList("SELECT Plat.Nom FROM Plat;","Nom",Arrayplat);
        fun.remplirList("SELECT Poisson.Nom FROM Poisson;","Nom",Arraynompoisson);
        fun.remplirList("SELECT Client.Nom FROM Client;","Nom",Arraynomclient);
        fun.remplirList("SELECT Homard.Calibre FROM Homard;","Calibre",Arraycalibre);
        fun.remplirList("SELECT Type_Cuisson.TypeCuisson FROM Type_Cuisson;","TypeCuisson",Arraytypecuisson);
        fun.remplirList("SELECT Plat.idPlat FROM Plat;","idPlat",ArrayidPlat);

        for(int i = 0;i<Arrayplat.size();i++)
        {
            MapPlat.put(Integer.parseInt(ArrayidPlat.get(i)),Arrayplat.get(i));
        }

        fun.getcm(jComboBoxPlat,Arrayplat);
        fun.getcm(tfnompoisson,Arraynompoisson);
        fun.getcm(cbnom,Arraynomclient);
        fun.getcm(cbcalibre,Arraycalibre);
        fun.getcm(cbtypecuisson,Arraytypecuisson);



        modificationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nomplat = jComboBoxPlat.getSelectedItem().toString();
                int idPlat = fun.getKey(MapPlat,nomplat);
                Modif frame3 = new Modif(nomplat,idPlat);
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
        int finalId = id;
        enregistrerButton.addActionListener(new ActionListener() {      //Panel Plat
            @Override
            public void actionPerformed(ActionEvent e) {



                String query = "INSERT INTO Client(idClient,Nom,Telephone) VALUES(?,?,?)";

                ArrayList<String> tab = new ArrayList<>();
                tab.add(Integer.toString(finalId));
                tab.add(textField2.getText());
                tab.add(textField3.getText());

                fun.insertQuery(query,tab);
                new1 frame2 = new new1();
                setVisible(false);

            }

        });
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                guit frame = new guit();
                setVisible(false);
            }

        });
        enregistrerButton2.addActionListener(new ActionListener() {  //Panel Poisson
            @Override
            public void actionPerformed(ActionEvent e) {

                new1 frame2 = new new1();
                setVisible(false);

            }

        });
        enregistrerButton1.addActionListener(new ActionListener() { // Panel Homard
            @Override
            public void actionPerformed(ActionEvent e) {

                new1 frame2 = new new1();
                setVisible(false);

            }

        });


        unitéEnGrammesCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(label4.getText()== "Nombre de poissons :") {
                    label4.setText("Quantité de poisson :");
                    spinner4.setModel(new SpinnerNumberModel(50, 1, 10000, 50));
                    tranchesOuGrammes = true;
                }
                else {
                    label4.setText("Nombre de poissons :");
                    spinner4.setModel(new SpinnerNumberModel(1, 1, 200, 1));
                    tranchesOuGrammes = false;
                }
            }
        });
    }

    public void getnew1(){

        add(panel2);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(560,340,1,1);
        setPreferredSize(new Dimension(800,400));
        setMinimumSize(new Dimension(800,400));


    }
}
