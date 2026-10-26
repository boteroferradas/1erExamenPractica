package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    public static Connection conexion() {
        Connection conn = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String usuario = "postgres";
            String password = "admin";
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            System.out.println("Erro na conexion: " + e.getMessage());
        }
        return conn;
    }
}
