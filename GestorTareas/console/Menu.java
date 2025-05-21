package console;

import model.Task;
import service.Manager;
import utils.Priority;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
                    //showTask();
                    showFile();
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

        
        saveTask(task);
    }

    public static void saveTask(Task task) {
        try (FileWriter writer = new FileWriter("tareas.txt", true)) {
            writer.write(String.valueOf(task));
        } catch (IOException ioe) {
            System.out.println("Error al guardar la tarea.");

        }
    }

    public static void showFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("tareas.txt"))) {
            String linea;
            System.out.println("TAREAS GUARDADAS:");
            System.out.println("==================");

            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de tareas.");
            e.printStackTrace();
        }
    }


}
