package console;

import model.Task;
import service.Manager;
import utils.Priority;



import static utils.StaticElements.keyboard;
import static utils.StaticElements.taskList;

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
                    includeTask();
                    break;
                case 2:
                    System.out.println("Listar tareas");
                    showTask();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción incorrecta. Vuelve a intentarlo");
            }

        } while (option != 0);
    }

    public static void includeTask() {
        System.out.print("Indica el titulo de la tarea: ");
        String title = keyboard.nextLine();
        System.out.print("Introduce la descripción de la tarea: ");
        String description = keyboard.nextLine();
        //controlo que el valor sea un tipo de prioridad indicado
        Priority priority = null;
        try {
            System.out.print("Introduce la prioridad de la tarea: (alta, media, baja) ");
            //la paso a mayuscula para la comparación
            priority = Priority.valueOf(keyboard.nextLine().toUpperCase());
        } catch (IllegalArgumentException iae) {
            System.out.println("Error. Tienes que incluir una prioridad de las indicadas");
        }

        //creo la tarea con los datos introducidos, se creara tambien la tarea con los datos por defecto fecha y completada
        Task task = new Task(title, description, priority);

        Manager.addTask(task);
    }

    public static void showTask() {
        //compruebo si la lista esta vacia
        if (taskList.isEmpty()) {
            System.out.println("No tienes tareas registradas");
        } else {
            int j = 1;
            System.out.println("Tareas en el sistema: ");
            for (Task t : taskList) {
                System.out.println("---------- Tarea " + j + " ----------");
                System.out.println(t);
                j++;

            }
        }


    }
}
