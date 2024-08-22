package utiles;

import principal.Menu;

import java.util.Scanner;
import java.util.Random;

public class Util {


    public static Scanner teclado = new Scanner(System.in);
    public static boolean salir = false;
    public static Random aleatorio = new Random();

    public static void volverAJugar () {
        System.out.println("¿Deseas crear otra combinación? Si/No");
        char respuesta = teclado.nextLine().toLowerCase().charAt(0);
        if (respuesta == 's') {
            Menu.mostrarMenu();
        } else {
            System.out.println("Hasta luego");
            System.exit(0);

        }

    }




}
