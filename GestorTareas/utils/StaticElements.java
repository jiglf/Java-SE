package utils;

import com.google.gson.Gson;
import model.Task;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaticElements {

    public static Scanner keyboard = new Scanner(System.in);
    public static Gson gson = new Gson();
    public static List<Task> listTask = new ArrayList<>();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");//para JSON guardo como cadena la fecha

}
