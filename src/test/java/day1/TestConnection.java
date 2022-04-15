package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@100.24.24.67:1521:XE";
        String username = "hr";
        String passwprd = "hr";

        try {
            Connection con = DriverManager.getConnection(url,username,passwprd);
            System.out.println("Connection was succesfull");
        } catch (SQLException e) {
            System.out.println("connection has failed"+e.getMessage());
        }

    }
}
