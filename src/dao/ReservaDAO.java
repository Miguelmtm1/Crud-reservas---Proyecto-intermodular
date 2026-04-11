package dao;

import model.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public boolean insertar(Reserva r) {
        String sql = "INSERT INTO reserva (id_recurso, id_reserva_local, id_usuario, fecha, hora_inicio, hora_fin, coste, numero_plazas, motivo, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, r.getIdRecurso());
            ps.setInt(2, r.getIdReservaLocal());
            ps.setInt(3, r.getIdUsuario());
            ps.setString(4, r.getFecha());
            ps.setString(5, r.getHoraInicio());
            ps.setString(6, r.getHoraFin());
            ps.setDouble(7, r.getCoste());
            ps.setInt(8, r.getNumeroPlazas());
            ps.setString(9, r.getMotivo());
            ps.setString(10, r.getObservaciones());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar reserva: " + e.getMessage());
            return false;
        }
    }

    public List<Reserva> listar() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reserva";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Reserva r = new Reserva(
                        rs.getInt("id_recurso"),
                        rs.getInt("id_reserva_local"),
                        rs.getInt("id_usuario"),
                        rs.getString("fecha"),
                        rs.getString("hora_inicio"),
                        rs.getString("hora_fin"),
                        rs.getDouble("coste"),
                        rs.getInt("numero_plazas"),
                        rs.getString("motivo"),
                        rs.getString("observaciones")
                );
                lista.add(r);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar reservas: " + e.getMessage());
        }

        return lista;
    }

    public boolean eliminar(int idRecurso, int idReservaLocal) {
        String sql = "DELETE FROM reserva WHERE id_recurso=? AND id_reserva_local=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idRecurso);
            ps.setInt(2, idReservaLocal);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar reserva: " + e.getMessage());
            return false;
        }
    }
}
