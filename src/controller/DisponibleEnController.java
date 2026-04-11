package controller;

import dao.DisponibleEnDAO;
import model.DisponibleEn;

import java.util.List;

public class DisponibleEnController {

    private DisponibleEnDAO dao = new DisponibleEnDAO();

    public boolean agregarDisponibilidad(int idRecurso, int idHorario) {
        DisponibleEn d = new DisponibleEn(idRecurso, idHorario);
        return dao.insertar(d);
    }

    public boolean eliminarDisponibilidad(int idRecurso, int idHorario) {
        return dao.eliminar(idRecurso, idHorario);
    }

    public List<DisponibleEn> obtenerDisponibilidades() {
        return dao.listar();
    }
}

