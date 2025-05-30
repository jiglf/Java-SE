package model;

import utils.Priority;

import java.io.Serializable;
import java.time.LocalDate;

import static utils.StaticElements.formatter;

public class Task implements Serializable {

    private String title;
    private String description;
    private String registrationDate;// a pesar de ser una fecha la declaro String para guardarlo en el JSON
    private Priority priority;
    private boolean completed;

    public Task(String title, String description, Priority priority) {
        //en el constructor los datos registrationDate y completed son valores que se crean por defecto
        this.title = title;
        this.description = description;
        this.priority = priority;
        registrationDate = LocalDate.now().format(formatter);//la fecha actual en formato String
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

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {

        return
                "TÍTULO               : " + title.toUpperCase() + "\n" +
                "DESCRIPCIÓN          : " + description + "\n" +
                "FECHA DE REGISTRO    : " + registrationDate + "\n" +
                "PRIORIDAD            : " + priority + "\n" +
                "COMPLETADA           : " + completed + "\n" +
                "\n";

    }
}
