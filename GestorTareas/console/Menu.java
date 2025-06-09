package console;


import service.Manager;


import static utils.StaticElements.keyboard;


public class Menu {

    public static void menu() {
        int option;
        do {
            System.out.println("--- Menú de Tareas ---");
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Listar Todas");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            option = Integer.parseInt(keyboard.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Agregar tarea");
                    Manager.includeTask();
                    break;
                case 2:
                    System.out.println("Listar tareas");
                    //showTask();
                    //Manager.showFile();
                    Manager.showPendingTasks();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción incorrecta. Vuelve a intentarlo");
            }

        } while (option != 0);
    }




}
