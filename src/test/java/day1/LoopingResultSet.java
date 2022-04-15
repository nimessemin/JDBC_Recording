package day1;

import java.sql.*;

public class LoopingResultSet {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@100.24.24.67:1521:XE";
        String username = "hr";
        String passwprd = "hr";

        try {
            Connection con = DriverManager.getConnection(url, username, passwprd);

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");


            //next method is moving the cursor to next line and returning true false according to another we have next row
            while(rs.next() ){
                System.out.println(rs.getString(1) + " | " + rs.getString(2));
            }
            rs.beforeFirst();
            while(rs.next() ){
                System.out.println("ROW NUMBER IS "+ rs.getRow() );
                System.out.println(rs.getString(1) + " | " + rs.getString(2));
            }

            //getting row number
            rs.last();
            System.out.println("ROW COUNT IS " + rs.getRow() );




        } catch (SQLException e) {
            System.out.println("ERROR HAS OCCURED " + e.getMessage());

        }
    }
}
