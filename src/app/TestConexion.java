package app;

import dao.DBConnection;
import java.sql.Connection;

public class TestConexion {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        if (con != null) {
            System.out.println("Conexión correcta a la base de datos");
        } else {
            System.out.println("Error al conectar");
        }
    }
}
