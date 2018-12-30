package main;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class evenement extends JFrame {


    private JTable table1;
    private JPanel panel6;

    public evenement(int idDate,int type){

        add(panel6);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(900,140,1,1);
        setPreferredSize(new Dimension(450,800));
        setMinimumSize(new Dimension(450,800));
        setVisible(true);



      /*String query ="SELECT [Union_Ingr+A-R/Homa" +
              "rds_Date].Date, [Union_Ingr+A-R/Homards_Date].Nom, Sum([Union_Ingr+A-R/Homards_Date].SommeDealpha) AS SommeDeSommeDealpha"+
        "FROM [Union_Ingr+A-R/Homards_Date]"+
        "GROUP BY [Union_Ingr+A-R/Homards_Date].Date, [Union_Ingr+A-R/Homards_Date].Nom, [Union_Ingr+A-R/Homards_Date].idDate"+
        "WHERE [Union_Ingr+A-R/Homards_Date].idDate ='"+idDate+
              "'ORDER BY [Union_Ingr+A-R/Homards_Date].idDate";
*/
      String query=null;
        System.out.println(type);
       if(type==1) {
            query = "SELECT* FROM CLient ORDER BY Client.Nom";

       }

           if(type==2) {
                query = "SELECT* FROM CLient ORDER BY Client.Nom";

           }

               if(type==3) {
                    query = "SELECT* FROM CLient ORDER BY Client.Nom";

               }
        System.out.println(query);
         ResultSet rs = fun.selectQuery(query);

        String[][] data = new String[1000][3];
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

