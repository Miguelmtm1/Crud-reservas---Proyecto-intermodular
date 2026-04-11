package controller;

import dao.RecursoDAO;
import model.Recurso;

import java.util.List;

public class RecursoController {

    private RecursoDAO dao = new RecursoDAO();

    public boolean agregarRecurso(String nombre, String descripcion, String ubicacion, int capacidad) {
        Recurso r = new Recurso(nombre, descripcion, ubicacion, capacidad);
        return dao.insertar(r);
    }

    public List<Recurso> obtenerRecursos() {
        return dao.listar();
    }

    public boolean actualizarRecurso(int id, String nombre, String descripcion, String ubicacion, int capacidad) {
        Recurso r = new Recurso(id, nombre, descripcion, ubicacion, capacidad);
        return dao.actualizar(r);
    }

    public boolean eliminarRecurso(int id) {
        return dao.eliminar(id);
    }
}
