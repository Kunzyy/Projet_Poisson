package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



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

        sortiePDFButton.setEnabled(false);

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


        int j = i;
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table1.rowAtPoint(evt.getPoint());
                int col = table1.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0 && j>row) {
                    positionClient = row;
                    sortiePDFButton.setEnabled(true);
                }
                else
                    sortiePDFButton.setEnabled(false);
            }
        });


        sortiePDFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(positionClient != -1) {

                    int tmp = positionClient;
                    positionClient++;   //Pour que les ID commencent à 1,2,3... au lieu de 0,1,2...

                    ArrayList<String> list = new ArrayList<>();
                    list.add(data[tmp][0]);
                    list.add(data[tmp][1]);
                    list.add(data[tmp][2]);
                    pdf.pdfClient(list);
                }
            }
        });
    }
}
