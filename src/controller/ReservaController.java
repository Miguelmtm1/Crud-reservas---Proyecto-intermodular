package controller;

import dao.ReservaDAO;
import model.Reserva;
import java.util.List;

public class ReservaController {

    private ReservaDAO dao = new ReservaDAO();

    public boolean agregarReserva(Reserva r) {
        return dao.insertar(r);
    }

    public List<Reserva> obtenerReservas() {
        return dao.listar();
    }

    public boolean eliminarReserva(int idRecurso, int idReservaLocal) {
        return dao.eliminar(idRecurso, idReservaLocal);
    }
}
