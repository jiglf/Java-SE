package principal;

import juegos.Euromillones;
import juegos.Primitiva;
import utiles.Util;

import static utiles.Util.*;

public class Menu {

    public static void mostrarMenu() {

        System.out.println("Bienvenido a mi simulador de loterías");
        System.out.println("**** Opciones ****");
        System.out.println("1 - Primitiva");
        System.out.println("2 - Euromillones");
        System.out.println("0 - Salir");

        System.out.print("¿De que quieres concurso quieres simular los resultados? ");
        int opcion = Integer.parseInt(teclado.nextLine());

        switch(opcion) {
            case 1://primitiva
                Primitiva.principalPrimitiva();
                Util.volverAJugar();
                break;
            case 2: //euromillones
                Euromillones.principalEuromillones();
                Util.volverAJugar();
                break;
            case 0: //salir
                System.out.println("Vuelve cuando quieras probar suerte");
                salir = true;
                break;
            default:
                System.out.println("La opción escogida no es correcta");
        }
    }


}
