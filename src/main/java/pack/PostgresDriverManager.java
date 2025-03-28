package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDriverManager {
    private static PostgresDriverManager instance;
    private String URL = "jdbc:postgresql://localhost:5432/tms";
    private String USER = "postgres";
    private String PASSWORD = "Xysvgh80";

    private PostgresDriverManager() {
        init();
    }
    private void init(){
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("Exception load driver: " + e.getMessage());
        }
    }

    public static PostgresDriverManager getInstance() {
        if (instance == null) {
            instance = new PostgresDriverManager();
        }
        return instance;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
