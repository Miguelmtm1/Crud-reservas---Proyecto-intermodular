package dao;

import model.Horario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HorarioDAO {

    public List<Horario> listar() {
        List<Horario> lista = new ArrayList<>();
        String sql = "SELECT id_horario, dia_semana, hora_inicio, hora_fin FROM horario";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Horario h = new Horario(
                        rs.getInt("id_horario"),
                        rs.getString("dia_semana"),
                        rs.getString("hora_inicio"),
                        rs.getString("hora_fin")
                );
                lista.add(h);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar horarios: " + e.getMessage());
        }

        return lista;
    }

    public boolean insertar(Horario horario) {
        String sql = "INSERT INTO horario (dia_semana, hora_inicio, hora_fin) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, horario.getDiaSemana());
            ps.setString(2, horario.getHoraInicio());
            ps.setString(3, horario.getHoraFin());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar horario: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Horario horario) {
        String sql = "UPDATE horario SET dia_semana=?, hora_inicio=?, hora_fin=? WHERE id_horario=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, horario.getDiaSemana());
            ps.setString(2, horario.getHoraInicio());
            ps.setString(3, horario.getHoraFin());
            ps.setInt(4, horario.getIdHorario());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar horario: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idHorario) {
        String sql = "DELETE FROM horario WHERE id_horario=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idHorario);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar horario: " + e.getMessage());
            return false;
        }
    }
}
