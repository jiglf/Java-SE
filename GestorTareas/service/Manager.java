package service;


import model.Task;
import java.util.Comparator;
import java.util.List;

import static utils.StaticElements.taskList;

public class Manager {


   public static void addTask(Task task) {
      taskList.add(task);
   }

   public static List<Task> listTasks()  {
      return taskList;
   }

   public static List<Task> listByPriority() {
      //agrupa las tareas por la prioridad indicada
      taskList.sort(Comparator.comparing(t -> t.getPriority()));
      return taskList;
   }

   public static List<Task> listByDate() {
      //agrupa las tareas por la fecha de creación
      taskList.sort(Comparator.comparing(t -> t.getRegistrationDate()));
      return taskList;
   }

   public static void completedMark(int index) {
       //se le pasa el indice de la tarea que se marcara ya como completada
       if (index >= 0 && index < taskList.size()) {
                taskList.get(index).setCompleted(true);
       }
   }

}
