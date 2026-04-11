package controller;

import dao.HorarioDAO;
import model.Horario;

import java.util.List;

public class HorarioController {

    private HorarioDAO dao = new HorarioDAO();

    public boolean agregarHorario(String dia, String inicio, String fin) {
        Horario h = new Horario(dia, inicio, fin);
        return dao.insertar(h);
    }

    public List<Horario> obtenerHorarios() {
        return dao.listar();
    }

    public boolean actualizarHorario(int id, String dia, String inicio, String fin) {
        Horario h = new Horario(id, dia, inicio, fin);
        return dao.actualizar(h);
    }

    public boolean eliminarHorario(int id) {
        return dao.eliminar(id);
    }
}


