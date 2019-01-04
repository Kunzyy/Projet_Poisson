package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ContainerAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;


public class listeclient extends JFrame{
    private JTable table1;
    private JPanel panel6;
    private JButton sortiePDFButton;

    int positionClient = -1;

    public listeclient(){
        add(panel6);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(0,140,1,1);
        setPreferredSize(new Dimension(450,800));
        setMinimumSize(new Dimension(450,800));
        setVisible(true);

        String query = "SELECT* FROM Client ORDER BY Client.idClient";
        ResultSet rs = fun.selectQuery(query);


        String[][] data = new String[1000][3];
        String[] titre = {"ID Client","Nom","Téléphone"};
        int i=0;

        while (true) {
            try {
                if (!rs.next()) break;
                data[i][0]= rs.getString("idClient");
                data[i][1]= rs.getString("Nom");
                data[i][2]= rs.getString("Telephone");

        i++;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        fun.gettm(table1,data,titre);

        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table1.rowAtPoint(evt.getPoint());
                int col = table1.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    positionClient = row;
                }
            }
        });


        sortiePDFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(positionClient != -1) {
                    positionClient++;   //Pour que les ID commencent à 1,2,3... au lieu de 0,1,2...

                    ArrayList<String> list = new ArrayList<>();
                    list.add(data[positionClient][0]);
                    list.add(data[positionClient][1]);
                    list.add(data[positionClient][2]);
                    //pdf.pdfClient(list);
                    System.out.println("Coucou" + positionClient);
                }
            }
        });
    }
}
