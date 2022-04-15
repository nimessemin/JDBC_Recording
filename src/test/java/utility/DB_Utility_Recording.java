package utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class DB_Utility_Recording {

    static Connection conn ;

    public static void createConnection() {

        String url = "jdbc:oracle:thin:@100.24.24.67:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
             conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful ");
        } catch (SQLException e) {
            System.out.println("Connection has failed " + e.getMessage());
        }

    }

    public static ResultSet runQuery(String query){

    }


    public static void main(String[] args) {

        createConnection();
        Statement stmnt =

    }
}
