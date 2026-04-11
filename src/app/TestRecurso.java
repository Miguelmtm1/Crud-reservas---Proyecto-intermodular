package app;

import dao.RecursoDAO;
import model.Recurso;

public class TestRecurso {
    public static void main(String[] args) {
        RecursoDAO dao = new RecursoDAO();

        System.out.println("Listado de recursos:");
        for (Recurso r : dao.listar()) {
            System.out.println(r);
        }
    }
}
