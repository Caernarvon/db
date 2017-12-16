package run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection connection;
    public static String URL = "jdbc:postgresql://localhost:5432/Countries";
    public static String DRIVER = "org.postgresql.Driver";
    public static final String USER = "postgres";
    public static final String PASSWORD = "root";

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Successfully connected");
    }
}
