import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DiasCumpleaños {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        LocalDate fechaNacimiento = null;//variable que se uso para validar la fecha si es correcto el formato
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d-M-yyyy");//formato de fecha
        LocalDate fechaActual = LocalDate.now();//variable con la fecha actual

        // bucle while para gestionar hasta que la fecha este en formato correcto
        while (fechaNacimiento == null) {
            try {
                System.out.print("Introduce tu fecha de nacimiento (d-M-yyyy): ");
                String fecha = teclado.nextLine();
                //intenta validar la fecha con el formato indicado    
                fechaNacimiento = LocalDate.parse(fecha, formato);

            } catch (DateTimeParseException e) {
                // Si la fecha no se valida con el formato y salta la excepcion, sigue el bucle
                System.out.println("Fecha no válida. Por favor, introduce la fecha en el formato d-M-yyyy.");
            }
        }

        // Creo fecha proximo cumple con el año de la fecha actual
        LocalDate proximoCumple = fechaNacimiento.withYear(fechaActual.getYear());

        // si el cumpleaños ya paso, año uno y muestro mensaje
        if (proximoCumple.isBefore(fechaActual) || proximoCumple.isEqual(fechaActual)) {
            proximoCumple = proximoCumple.plusYears(1);
            System.out.println("Ya celebraste tu cumpleaños este año.");

        }

        // indico los dias hasta el proximo cumple
        int diasFaltan = (int) ChronoUnit.DAYS.between(fechaActual, proximoCumple);
        if (diasFaltan == 1) {
            System.out.println("Falta " + diasFaltan + " día para tu próximo cumpleaños.");
        } else {
            System.out.println("Faltan " + diasFaltan + " días para tu próximo cumpleaños.");
        }
        teclado.close();
    }
}