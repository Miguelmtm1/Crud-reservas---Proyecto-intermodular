package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3307/proyecto_intermodular?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            // Intentar cargar driver moderno (MySQL 9.x)
            try {
                Class.forName("com.mysql.cj.Driver");
            } catch (ClassNotFoundException e1) {
                // Intentar cargar driver clásico (MySQL 8.x)
                Class.forName("com.mysql.cj.jdbc.Driver");
            }

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró ningún driver MySQL compatible");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }

        return null;
    }
}
