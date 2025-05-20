package service;


import model.Task;
import java.util.List;

import static utils.StaticElements.taskList;

public class Manager {


   public static void addTask(Task task) {
      taskList.add(task);
   }

   public static List<Task> listTasks()  {
      return taskList;
   }



}
