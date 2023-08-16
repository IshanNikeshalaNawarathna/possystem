package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MySQL {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_db", "root", "Ishan9952@*v$");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ResultSet execute(String query) throws Exception {

        if (query.startsWith("SELECT")) {
            return connection.createStatement().executeQuery(query);
        } else {
            connection.createStatement().executeUpdate(query);
            return null;
        }

    }

}
