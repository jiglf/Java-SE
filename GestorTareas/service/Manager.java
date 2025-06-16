package service;


import com.google.gson.reflect.TypeToken;
import model.Task;
import utils.Priority;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static utils.StaticElements.*;


public class Manager {

   public static void includeTask() {
      //cargo las tareas existentes ya en el JSON para añadir y no sobreescribir
      listTask = loadTasksFromJson();

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

      //añado a la lista el objeto tarea creado
      listTask.add(task);

      saveTasksToJson(listTask);//guarda la tarea en el fichero formato json
      saveTask(task);//guarda la tarea en el fichero plano
   }

   public static void saveTask(Task task) {
      try (FileWriter writer = new FileWriter("tareas.txt", true)) {
         writer.write(String.valueOf(task));
      } catch (IOException ioe) {
         System.out.println("Error al guardar la tarea.");

      }
   }

   public static void saveTasksToJson(List<Task> tasks) {
      try (FileWriter writer = new FileWriter("tareas.json")) {
         gson.toJson(tasks, writer);
      } catch (IOException e) {
         System.out.println("Error al guardar tareas.");
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

   public static List<Task> loadTasksFromJson() {
      List<Task> tasks = new ArrayList<>();
      try (Reader reader = new FileReader("tareas.json")) {
         Type taskListType = new TypeToken<List<Task>>() {}.getType();
         /*
         Gson necesita este Type especial para entender que no es solo Task, sino List<Task>.
🔸       Por uso TypeToken
          */
         tasks = gson.fromJson(reader, taskListType);
         if (tasks == null) {
            tasks = new ArrayList<>(); // Si el archivo está vacío o no hay tareas
         }
      } catch (FileNotFoundException e) {
         // Si el archivo no existe aún, devolvemos la lista vacía
      } catch (IOException e) {
         System.out.println("Error al leer tareas desde JSON.");
      }
      return tasks;
   }

   //para mostrar las tareas guardadas en el JSON
   public static void showPendingTasks() {
      List<Task> tasks = loadTasksFromJson();  // Carga las tareas desde JSON
      if (tasks.isEmpty()) {
         System.out.println("No hay tareas guardadas.");
         return;
      }

      System.out.println("Tareas pendientes:");
      for (Task t : tasks) {
         if (!t.isCompleted()) {
            System.out.println(t);  
         }
      }
   }


}
