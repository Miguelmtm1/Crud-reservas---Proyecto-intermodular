package dao;

import model.DisponibleEn;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisponibleEnDAO {

    public boolean insertar(DisponibleEn d) {
        String sql = "INSERT INTO disponibleen (id_recurso, id_horario) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, d.getIdRecurso());
            ps.setInt(2, d.getIdHorario());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar disponibilidad: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idRecurso, int idHorario) {
        String sql = "DELETE FROM disponibleen WHERE id_recurso=? AND id_horario=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idRecurso);
            ps.setInt(2, idHorario);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar disponibilidad: " + e.getMessage());
            return false;
        }
    }

    public List<DisponibleEn> listar() {
        List<DisponibleEn> lista = new ArrayList<>();
        String sql = "SELECT id_recurso, id_horario FROM disponibleen";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                DisponibleEn d = new DisponibleEn(
                        rs.getInt("id_recurso"),
                        rs.getInt("id_horario")
                );
                lista.add(d);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar disponibilidad: " + e.getMessage());
        }

        return lista;
    }
}
