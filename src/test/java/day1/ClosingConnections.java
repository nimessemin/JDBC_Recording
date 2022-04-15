package day1;

import java.sql.*;

public class ClosingConnections {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:oracle:thin:@100.24.24.67:1521:XE";
        String username = "hr";
        String password = "hr";

        //    Connection con = null;
        //   Statement stmt = null;
        //   ResultSet rs = null;


        // try with resources -- only work with auto closable resources
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS")) {

            rs.next();
            System.out.println(rs.getString(2));
        } catch (SQLException e) {
            System.out.println("error occured ");
        }



        /*

        try {
             con = DriverManager.getConnection(url, username, password);
             stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             rs = stmt.executeQuery("SELECT * FROM REGIONS");


            System.out.println("All SUCCESSFUL");

        }catch (SQLException e) {
            System.out.println("ERROR HAS OCCURRED " + e.getMessage());
        }finally {

            try {
               if(rs!= null) rs.close();
               if(stmt!= null) stmt.close();
                if(con!= null) con.close();
            } catch (SQLException e) {
                System.out.println("error while closing resources " + e.getMessage() );
            }
        }

    }

         */
    }
}
