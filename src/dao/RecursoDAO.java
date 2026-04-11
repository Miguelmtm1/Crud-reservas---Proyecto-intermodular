package dao;

import model.Recurso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecursoDAO {

    // LISTAR
    public List<Recurso> listar() {
        List<Recurso> lista = new ArrayList<>();
        String sql = "SELECT id_recurso, nombre, descripcion, ubicacion, capacidad FROM recurso";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Recurso r = new Recurso(
                        rs.getInt("id_recurso"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("ubicacion"),
                        rs.getInt("capacidad")
                );
                lista.add(r);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar recursos: " + e.getMessage());
        }

        return lista;
    }

    // INSERTAR
    public boolean insertar(Recurso recurso) {
        String sql = "INSERT INTO recurso (nombre, descripcion, ubicacion, capacidad) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, recurso.getNombre());
            ps.setString(2, recurso.getDescripcion());
            ps.setString(3, recurso.getUbicacion());
            ps.setInt(4, recurso.getCapacidad());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar recurso: " + e.getMessage());
            return false;
        }
    }

    // ACTUALIZAR
    public boolean actualizar(Recurso recurso) {
        String sql = "UPDATE recurso SET nombre=?, descripcion=?, ubicacion=?, capacidad=? WHERE id_recurso=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, recurso.getNombre());
            ps.setString(2, recurso.getDescripcion());
            ps.setString(3, recurso.getUbicacion());
            ps.setInt(4, recurso.getCapacidad());
            ps.setInt(5, recurso.getIdRecurso());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar recurso: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminar(int idRecurso) {
        String sql = "DELETE FROM recurso WHERE id_recurso=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idRecurso);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar recurso: " + e.getMessage());
            return false;
        }
    }
}
