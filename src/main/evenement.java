package main;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class evenement extends JFrame {


    private JTable table1;

    public evenement(int idDate){
      String query ="SELECT [Union_Ingr+A-R/Homa" +
              "rds_Date].Date, [Union_Ingr+A-R/Homards_Date].Nom, Sum([Union_Ingr+A-R/Homards_Date].SommeDealpha) AS SommeDeSommeDealpha"+
        "FROM [Union_Ingr+A-R/Homards_Date]"+
        "GROUP BY [Union_Ingr+A-R/Homards_Date].Date, [Union_Ingr+A-R/Homards_Date].Nom, [Union_Ingr+A-R/Homards_Date].idDate"+
        "WHERE [Union_Ingr+A-R/Homards_Date].idDate ='"+idDate+
              "'ORDER BY [Union_Ingr+A-R/Homards_Date].idDate";

        ResultSet rs = fun.selectQuery(query);

        String[][] data = new String[1000][3];
        String[]titre = {"Date","Nom","Quantité"};
        int i=0;
        while (true) {
            try {
                if (!rs.next()) break;
                data[i][0]= rs.getString("Date");
                data[i][1]= rs.getString("Nom");
                data[i][2]= rs.getString("Quantité");
                i++;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        fun.gettm(table1,data,titre);

    }
}
