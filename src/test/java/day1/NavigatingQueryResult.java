package day1;

import java.sql.*;

public class NavigatingQueryResult {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@100.24.24.67:1521:XE";
        String username = "hr";
        String passwprd = "hr";

        try {
            Connection con = DriverManager.getConnection(url,username,passwprd);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT *FROM  REGIONS");

            rs.next();

            System.out.println("Region ID on first row is "+rs.getString(1));
            System.out.println("Region ID on first row is "+rs.getString("REGION_ID") );
            System.out.println("Region name on first row is "+rs.getString(2));
            System.out.println("Region name on first row is "+rs.getString("REGION_NAME") );

            rs.next();
            System.out.println("Region name on second row is "+rs.getString("REGION_NAME"));

            rs.previous();

        } catch (SQLException e) {
            System.out.println("error has occured"+e.getMessage());
        }


    }
}
