package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static final String url = "jdbc:mysql://localhost:3306/HealthClinicDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Ayushi@200405";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, USER, PASSWORD);
    }
}