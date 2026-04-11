package controller;

import view.ConsolaView;

public class AppController {

    private ConsolaView vista = new ConsolaView();

    private RecursoController recursoController = new RecursoController();
    private HorarioController horarioController = new HorarioController();
    private DisponibleEnController disponibleEnController = new DisponibleEnController();
    private ReservaController reservaController = new ReservaController();

    public void iniciar() {

        int opcion;

        do {
            opcion = vista.mostrarMenuPrincipal();

            switch (opcion) {

                case 1 -> {
                    System.out.println("Gestión de usuarios (en desarrollo)");
                }

                case 2 -> {
                    vista.menuRecursos(recursoController);
                }

                case 3 -> {
                    vista.menuHorarios(horarioController);
                }

                case 4 -> {
                    vista.menuDisponibleEn(disponibleEnController);
                }

                case 5 -> {
                    vista.menuReservas(reservaController);
                }

                case 0 -> {
                    System.out.println("Saliendo del sistema...");
                }

                default -> {
                    System.out.println("Opción no válida");
                }
            }

        } while (opcion != 0);
    }
}

