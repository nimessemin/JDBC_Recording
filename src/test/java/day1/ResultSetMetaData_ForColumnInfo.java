package day1;

import java.sql.*;

public class ResultSetMetaData_ForColumnInfo {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@100.24.24.67:1521:XE";
        String username = "hr";
        String passwprd = "hr";

        try {
            Connection con = DriverManager.getConnection(url, username, passwprd);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
      //      String firstColName = rsmd.getColumnName(1);

     //       System.out.println("columnCount = " + columnCount);
      //      System.out.println("firstColName = " + firstColName);

            for ( int colIndex = 1; colIndex <= columnCount; colIndex++) {
                System.out.println(rsmd.getColumnName(colIndex) + " \t");
            }
            System.out.println("------------------------------------");

            // printing all data in one row
           while(rs.next() ) {
               for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                   System.out.println(rs.getString(colIndex) + " \t");
               }
           }








        } catch (SQLException e) {
            System.out.println("ERROR  OCCURED " + e.getMessage());
        }

    }
}
