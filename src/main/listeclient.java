package main;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class listeclient extends JFrame{
    private JTable table1;
    private JPanel panel6;


    public listeclient(){
        add(panel6);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(0,140,1,1);
        setPreferredSize(new Dimension(450,800));
        setMinimumSize(new Dimension(450,800));
        setVisible(true);

        String query ="SELECT* FROM CLient ORDER BY Client.Nom";
        ResultSet rs = fun.selectQuery(query);
        try {
            int s = rs.getFetchSize();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[][] data = new String[100][3];
       String[]titre = {"Nom","Téléphone","Id"};
int i=0;
        while (true) {
            try {
                if (!rs.next()) break;
data[i][0]= rs.getString("Nom");
data[i][1]= rs.getString("Telephone");
data[i][2]= rs.getString("idClient");
i++;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        fun.gettm(table1,data,titre);



    }
}
