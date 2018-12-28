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
    private JButton enregistrerButton;
    private JComboBox cbnom;
    private JComboBox jComboBoxPlat;
    private JComboBox jComboBoxPoisson;
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
    private JComboBox comboBoxDate2;
    private JComboBox comboBoxDate3;
    private JComboBox comboBoxDate1;

    private boolean newClient; //0 Client déjà enregistré et 1 nouveau client
    private boolean tranchesOuGrammes;  // 1 = grammes et 0 = tranches
    private int idClient;


    ArrayList<String> Arrayplat = new ArrayList<>();
    ArrayList<String> Arraynomclient = new ArrayList<>();
    ArrayList<String> Arraynompoisson = new ArrayList<>();
    ArrayList<String> Arraycalibre = new ArrayList<>();
    ArrayList<String> Arraytypecuisson = new ArrayList<>();
    ArrayList<String> ArrayDate = new ArrayList<>();


    public new1(){

        getnew1();

        fun.remplirList("SELECT Plat.Nom FROM Plat;","Nom",Arrayplat);
        fun.remplirList("SELECT Poisson.Nom FROM Poisson;","Nom",Arraynompoisson);
        fun.remplirList("SELECT Client.Nom FROM Client;","Nom",Arraynomclient);
        fun.remplirList("SELECT Homard.Calibre FROM Homard;","Calibre",Arraycalibre);
        fun.remplirList("SELECT Type_Cuisson.TypeCuisson FROM Type_Cuisson;","TypeCuisson",Arraytypecuisson);
        fun.remplirList("SELECT DateCommande.Date FROM DateCommande;","Date",ArrayDate);

        PClientEnregistre.setVisible(false);
        PNouveauClient.setVisible(false);

        spinner1.setModel(new SpinnerNumberModel(1, 1, 200, 1));
        spinner4.setModel(new SpinnerNumberModel(1, 1, 200, 1));
        spinner5.setModel(new SpinnerNumberModel(1, 1, 200, 1));


        fun.getcm(jComboBoxPlat,Arrayplat);
        fun.getcm(jComboBoxPoisson,Arraynompoisson);
        fun.getcm(cbnom,Arraynomclient);
        fun.getcm(cbcalibre,Arraycalibre);
        fun.getcm(cbtypecuisson,Arraytypecuisson);
        fun.getcm(comboBoxDate1,ArrayDate);
        fun.getcm(comboBoxDate2,ArrayDate);
        fun.getcm(comboBoxDate3,ArrayDate);




        modificationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                HashMap<Integer,String> MapPlat = new HashMap<>();

                fun.recupId(MapPlat,"SELECT Plat.idPlat FROM Plat;","idPlat",Arrayplat);

                String nomplat = jComboBoxPlat.getSelectedItem().toString();
                int idPlat = fun.getKey(MapPlat,nomplat);

                Modif frame3 = new Modif(nomplat,idPlat);
            }

        });
        nouveauClientRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                idClient = Arraynomclient.size()+1;
                labelid.setText(Integer.toString(idClient));

                PClientEnregistre.setVisible(false);
                PNouveauClient.setVisible(true);
                newClient = true;
            }

        });
        clientEnregistréRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PClientEnregistre.setVisible(true);
                PNouveauClient.setVisible(false);
                newClient = false;
            }

        });

        enregistrerButton.addActionListener(new ActionListener() {      //Panel Plat
            @Override
            public void actionPerformed(ActionEvent e) {

                enregistrerClient();

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

                enregistrerClient();

                HashMap<Integer,String> MapPoisson = new HashMap<>();

                fun.recupId(MapPoisson,"SELECT Poisson.idPoisson FROM Poisson;","idPoisson",Arraynompoisson);

                String nompoisson = jComboBoxPoisson.getSelectedItem().toString();
                int idPoisson = fun.getKey(MapPoisson,nompoisson);

                new1 frame2 = new new1();
                setVisible(false);

            }

        });
        enregistrerButton1.addActionListener(new ActionListener() { // Panel Homard
            @Override
            public void actionPerformed(ActionEvent e) {

                enregistrerClient();

                HashMap<Integer,String> MapHomard = new HashMap<>();
                HashMap<Integer,String> MapCuisson = new HashMap<>();
                HashMap<Integer,String> MapDate = new HashMap<>();

                fun.recupId(MapHomard,"SELECT Homard.idHomard FROM Homard;","idHomard",Arraycalibre);
                String calibre = cbcalibre.getSelectedItem().toString();
                int idHomard = fun.getKey(MapHomard,calibre);

                fun.recupId(MapCuisson,"SELECT Type_Cuisson.idCuisson FROM Type_Cuisson;","idCuisson",Arraytypecuisson);
                String cuisson = cbtypecuisson.getSelectedItem().toString();
                int idCuisson = fun.getKey(MapCuisson,cuisson);

                fun.recupId(MapDate,"SELECT DateCommande.idDate FROM DateCommande;","idDate",ArrayDate);
                String date = comboBoxDate3.getSelectedItem().toString();
                int idDate = fun.getKey(MapDate,date);


                ArrayList<String> tab = new ArrayList<>();

                tab.add(Integer.toString(idClient));
                tab.add(Integer.toString(idHomard));
                tab.add(Integer.toString(idCuisson));
                tab.add(Integer.toString((Integer) spinner5.getValue()));
                tab.add(Integer.toString(idDate));

                fun.insertQuery("INSERT INTO Commande_3(idClient,idHomard,idCuisson,Quantite,idDate) VALUES(?,?,?,?,?)",tab);

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



    private void enregistrerClient()
    {
        if(newClient)
        {
            idClient = Arraynomclient.size()+1;

            String query = "INSERT INTO Client(idClient,Nom,Telephone) VALUES(?,?,?)";

            ArrayList<String> tab = new ArrayList<>();
            tab.add(Integer.toString(idClient));
            tab.add(textField2.getText());
            tab.add(textField3.getText());

            fun.insertQuery(query,tab);
        }
        else
        {
            HashMap<Integer,String> MapClient = new HashMap<>();

            fun.recupId(MapClient,"SELECT Client.idClient FROM Client;","idClient",Arraynomclient);
            String nom = cbnom.getSelectedItem().toString();
            idClient = fun.getKey(MapClient,nom);
        }
    }
}
