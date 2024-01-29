package jstorra.filtrojava.persistence;

import java.sql.*;

public class ConnectionDB {
    private static String url;
    private static String user;
    private static String pw;
    private static Connection con;
 
    public static Connection MySQConnection() {
        url = "jdbc:mysql://192.168.110.91:3306/db_misiones";
        user = "juan";
        pw = "3163923995";
        try {
            con = DriverManager.getConnection(url, user, pw);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
