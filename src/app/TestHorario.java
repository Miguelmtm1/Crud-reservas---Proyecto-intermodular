package app;

import controller.HorarioController;

public class TestHorario {
    public static void main(String[] args) {

        HorarioController hc = new HorarioController();

        // PRUEBA 1: Insertar un horario
        boolean ok = hc.agregarHorario("Lunes", "09:00", "11:00");
        System.out.println("Insertar horario: " + ok);

        // PRUEBA 2: Listar horarios
        System.out.println("Listado de horarios:");
        hc.obtenerHorarios().forEach(System.out::println);

        // PRUEBA 3: Eliminar horario con id 1
        boolean eliminado = hc.eliminarHorario(1);
        System.out.println("Eliminar horario 1: " + eliminado);
    }
}
