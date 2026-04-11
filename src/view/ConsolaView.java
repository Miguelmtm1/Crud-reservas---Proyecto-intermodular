package view;

import controller.RecursoController;
import controller.HorarioController;
import controller.DisponibleEnController;
import controller.ReservaController;
import model.Reserva;

import java.util.Scanner;

public class ConsolaView {

    private Scanner sc = new Scanner(System.in);

    // ============================
    // MENÚ PRINCIPAL
    // ============================
    public int mostrarMenuPrincipal() {
        System.out.println("\n===== SISTEMA DE RESERVAS =====");
        System.out.println("1. Gestionar usuarios");
        System.out.println("2. Gestionar recursos");
        System.out.println("3. Gestionar horarios");
        System.out.println("4. Gestionar disponibilidad");
        System.out.println("5. Gestionar reservas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");

        return sc.nextInt();
    }

    // ============================
    // MENÚ DE RECURSOS
    // ============================
    public void menuRecursos(RecursoController controller) {
        int opcion;

        do {
            System.out.println("\n===== GESTIÓN DE RECURSOS =====");
            System.out.println("1. Añadir recurso");
            System.out.println("2. Listar recursos");
            System.out.println("3. Actualizar recurso");
            System.out.println("4. Eliminar recurso");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = sc.nextLine();
                    System.out.print("Ubicación: ");
                    String ubicacion = sc.nextLine();
                    System.out.print("Capacidad: ");
                    int capacidad = sc.nextInt();
                    sc.nextLine();

                    if (controller.agregarRecurso(nombre, descripcion, ubicacion, capacidad))
                        System.out.println("Recurso añadido correctamente");
                    else
                        System.out.println("Error al añadir recurso");
                }

                case 2 -> {
                    System.out.println("\n--- LISTA DE RECURSOS ---");
                    controller.obtenerRecursos().forEach(System.out::println);
                }

                case 3 -> {
                    System.out.print("ID del recurso a actualizar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Nueva descripción: ");
                    String descripcion = sc.nextLine();
                    System.out.print("Nueva ubicación: ");
                    String ubicacion = sc.nextLine();
                    System.out.print("Nueva capacidad: ");
                    int capacidad = sc.nextInt();
                    sc.nextLine();

                    if (controller.actualizarRecurso(id, nombre, descripcion, ubicacion, capacidad))
                        System.out.println("Recurso actualizado");
                    else
                        System.out.println("Error al actualizar recurso");
                }

                case 4 -> {
                    System.out.print("ID del recurso a eliminar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (controller.eliminarRecurso(id))
                        System.out.println("Recurso eliminado");
                    else
                        System.out.println("Error al eliminar recurso");
                }

                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }

    // ============================
    // MENÚ DE HORARIOS
    // ============================
    public void menuHorarios(HorarioController controller) {
        int opcion;

        do {
            System.out.println("\n===== GESTIÓN DE HORARIOS =====");
            System.out.println("1. Añadir horario");
            System.out.println("2. Listar horarios");
            System.out.println("3. Actualizar horario");
            System.out.println("4. Eliminar horario");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Día de la semana: ");
                    String dia = sc.nextLine();
                    System.out.print("Hora inicio (HH:MM): ");
                    String inicio = sc.nextLine();
                    System.out.print("Hora fin (HH:MM): ");
                    String fin = sc.nextLine();

                    if (controller.agregarHorario(dia, inicio, fin))
                        System.out.println("Horario añadido correctamente");
                    else
                        System.out.println("Error al añadir horario");
                }

                case 2 -> {
                    System.out.println("\n--- LISTA DE HORARIOS ---");
                    controller.obtenerHorarios().forEach(System.out::println);
                }

                case 3 -> {
                    System.out.print("ID del horario a actualizar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nuevo día: ");
                    String dia = sc.nextLine();
                    System.out.print("Nueva hora inicio: ");
                    String inicio = sc.nextLine();
                    System.out.print("Nueva hora fin: ");
                    String fin = sc.nextLine();

                    if (controller.actualizarHorario(id, dia, inicio, fin))
                        System.out.println("Horario actualizado");
                    else
                        System.out.println("Error al actualizar horario");
                }

                case 4 -> {
                    System.out.print("ID del horario a eliminar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (controller.eliminarHorario(id))
                        System.out.println("Horario eliminado");
                    else
                        System.out.println("Error al eliminar horario");
                }

                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }

    // ============================
    // MENÚ DE DISPONIBLEEN
    // ============================
    public void menuDisponibleEn(DisponibleEnController controller) {
        int opcion;

        do {
            System.out.println("\n===== DISPONIBILIDAD DE RECURSOS =====");
            System.out.println("1. Añadir disponibilidad");
            System.out.println("2. Listar disponibilidades");
            System.out.println("3. Eliminar disponibilidad");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("ID del recurso: ");
                    int idRecurso = sc.nextInt();
                    System.out.print("ID del horario: ");
                    int idHorario = sc.nextInt();
                    sc.nextLine();

                    if (controller.agregarDisponibilidad(idRecurso, idHorario))
                        System.out.println("Disponibilidad añadida");
                    else
                        System.out.println("Error al añadir disponibilidad");
                }

                case 2 -> {
                    System.out.println("\n--- LISTA DE DISPONIBILIDADES ---");
                    controller.obtenerDisponibilidades().forEach(System.out::println);
                }

                case 3 -> {
                    System.out.print("ID del recurso: ");
                    int idRecurso = sc.nextInt();
                    System.out.print("ID del horario: ");
                    int idHorario = sc.nextInt();
                    sc.nextLine();

                    if (controller.eliminarDisponibilidad(idRecurso, idHorario))
                        System.out.println("Disponibilidad eliminada");
                    else
                        System.out.println("Error al eliminar disponibilidad");
                }

                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }

    // ============================
    // MENÚ DE RESERVAS
    // ============================
    public void menuReservas(ReservaController controller) {
        int opcion;

        do {
            System.out.println("\n===== GESTIÓN DE RESERVAS =====");
            System.out.println("1. Añadir reserva");
            System.out.println("2. Listar reservas");
            System.out.println("3. Eliminar reserva");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("ID del recurso: ");
                    int idRecurso = sc.nextInt();
                    System.out.print("ID de la reserva local: ");
                    int idReservaLocal = sc.nextInt();
                    System.out.print("ID del usuario: ");
                    int idUsuario = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fecha = sc.nextLine();
                    System.out.print("Hora inicio (HH:MM): ");
                    String horaInicio = sc.nextLine();
                    System.out.print("Hora fin (HH:MM): ");
                    String horaFin = sc.nextLine();

                    System.out.print("Coste: ");
                    double coste = sc.nextDouble();
                    System.out.print("Número de plazas: ");
                    int plazas = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Motivo: ");
                    String motivo = sc.nextLine();
                    System.out.print("Observaciones: ");
                    String obs = sc.nextLine();

                    Reserva r = new Reserva(idRecurso, idReservaLocal, idUsuario, fecha,
                            horaInicio, horaFin, coste, plazas, motivo, obs);

                    if (controller.agregarReserva(r))
                        System.out.println("Reserva añadida correctamente");
                    else
                        System.out.println("Error al añadir reserva");
                }

                case 2 -> {
                    System.out.println("\n--- LISTA DE RESERVAS ---");
                    controller.obtenerReservas().forEach(System.out::println);
                }

                case 3 -> {
                    System.out.print("ID del recurso: ");
                    int idRecurso = sc.nextInt();
                    System.out.print("ID de la reserva local: ");
                    int idReservaLocal = sc.nextInt();
                    sc.nextLine();

                    if (controller.eliminarReserva(idRecurso, idReservaLocal))
                        System.out.println("Reserva eliminada");
                    else
                        System.out.println("Error al eliminar reserva");
                }

                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }
}
