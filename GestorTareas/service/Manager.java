package service;


import model.Task;
import utils.Priority;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import static utils.StaticElements.keyboard;


public class Manager {

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
