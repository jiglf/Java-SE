package model;

import utils.Priority;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {

    private String title;
    private String description;
    private LocalDate registrationDate;
    private Priority priority;
    private boolean completed;

    public Task(String title, String description, Priority priority) {
        //en el constructor los datos registrationDate y completed son valores que se crean por defecto
        this.title = title;
        this.description = description;
        this.priority = priority;
        registrationDate = LocalDate.now();//la fecha actual en la cual se crea la tarea
        completed = false;//al crear una tarea por defecto se crea como no completada

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {

        //creo este formatter para darle formato espanhol en la salida de la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return "\n" +
                "TÍTULO     : " + title.toUpperCase() + "\n" +
                "DESCRIPCIÓN: " + description + "\n" +
                "FECHA      : " + formatter.format(registrationDate) + "\n" +
                "PRIORIDAD  : " + priority + "\n" +
                "COMPLETADA : " + completed + "\n";

    }
}
