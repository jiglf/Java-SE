

import java.util.Scanner;

import principal.Juego;

public class Main {

    static Scanner teclado = new Scanner(System.in);
    static char volverJugar;

    public static void main(String[] args) {
        System.out.println("Bienvenido al juego, estas son las opciones disponibles.");
        Juego.menuOpciones();
        Juego.logicaJuego(Juego.eleccionJugador(), Juego.eleccionOrdenador());

        do {
            System.out.println();
            System.out.println("¿Quieres volver a jugar? (S/N)");
        
            //paso a mayusculas para la comparación
            volverJugar = teclado.nextLine().toUpperCase().charAt(0);

        
            // Verifica que el usuario introduzca solo 'S' o 'N' 
            while (volverJugar != 'S' && volverJugar != 'N') {
                System.out.println("Opción no valida");
                System.out.print("¿Quieres volver a jugar? (S/N)");
                volverJugar = teclado.nextLine().toUpperCase().charAt(0);
            }
        
            if (volverJugar == 'S') {
                System.out.println("Escoge de nuevo tu opcion");
                Juego.menuOpciones();
                Juego.logicaJuego(Juego.eleccionJugador(), Juego.eleccionOrdenador());
            } else {
                System.out.println("Gracias por haber jugado. ¡Hasta la próxima!");
            }
        
        } while (volverJugar != 'N');
    }



}
