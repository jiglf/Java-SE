package principal;


import java.util.Random;
import java.util.Scanner;

public class Juego {

    /** creo Array opciones con las 4 opciones excistentes en este juego basada en la serie The Big Bang Theory */
    static String [] opciones = new String[] {"Piedra", "Papel", "Tijeras", "Lagarto", "Spock"};
    private static final Scanner teclado = new Scanner(System.in);
    private static final Random aleatorio = new Random();


    public static void menuOpciones() {
        for (int i = 0; i < opciones.length; i++) {
            int indice = i + 1;
            System.out.println(indice + " - " + opciones[i]);
        }
    }

    /** metodo para la seleccionar la eleccion por parte del jugador */
    public static int eleccionJugador() {
        int opcionEscogida;

        while (true) {
           System.out.print("Escoge tu elección (1-5): ");
           try {
                 opcionEscogida = Integer.parseInt(teclado.nextLine());
                      if (opcionEscogida >= 1 && opcionEscogida <= 5) {
                break;
                      } else {
                             System.out.println("Por favor, introduce un número entre 1 y 5.");
                             }
        }  catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, introduce un número.");
        }
    }
    return opcionEscogida;
    }

    /** metodo creado para seleccionar de manera aleatoria la eleccion del ordenador */
    public static int eleccionOrdenador() {
        int eleccionOrdenador = aleatorio.nextInt(opciones.length);

        return eleccionOrdenador;
    }

    public static void logicaJuego( int eleccionJugador, int eleccionOrdenador) {
          /* ya que la eleccion del jugador se basa en los indices que no se corresponden con los indices
        reales de las posiciones del array le resto 1 para igualar el dato introducido con las posiciones reales
         */
        int eleccionArray = eleccionJugador -1;

        /* presentacion de las elecciones de cada uno de los usuarios */
        System.out.println("La elección escogida por el jugador es " + opciones[eleccionArray]);
        System.out.println("La elección escogida por el ordenador es " + opciones[eleccionOrdenador]);
        System.out.println();

        if (eleccionArray == eleccionOrdenador) {
            System.out.println("Habeis elegido igual, el resultado es empate");
        }
        else {
            // con el primer switch evaluo la eleccion del jugador, con el segundo switch evaluo la eleccion del ordenador

            switch(eleccionArray) {
                case 0: //piedra
                    switch (eleccionOrdenador) {
                        case 1://papel
                            System.out.println("Has perdido, papel tapa a piedra");
                            break;
                        case 2: //tijera
                            System.out.println("Enhorabuena, has ganado, piedra aplasta a tijeras");
                            break;
                        case 3: //lagarto
                            System.out.println("Enhorabuena, has ganado, piedra aplasta a lagarto");
                            break;
                        case 4: //spock
                            System.out.println("Has perdido, Spock vaporiza a piedra");
                            break;
                    }
                break;

                case 1: //papel
                    switch (eleccionOrdenador) {
                        case 0: //piedra
                            System.out.println("Enhorabuena, has ganado, papel tapa a piedra");
                            break;
                        case 2: //tijera
                            System.out.println("Has perdido, tijeras cortan a papel");
                            break;
                        case 3: //lagarto
                            System.out.println("Has perdido, lagarto devora a papel");
                            break;
                        case 4: //spock
                            System.out.println("Enhorabuena, has ganado, papel desautoriza a Spock");
                            break;
                    }
                    break;

                case 2: //tijera
                    switch (eleccionOrdenador) {
                        case 0: //piedra
                             System.out.println("Has perdido, piedra aplasta a tijeras");
                             break;
                        case 1: //papel
                             System.out.println("Enhorabuena, has ganado, tijeras corta a papel");
                             break;
                        case 3: //lagarto
                            System.out.println("Has perdido, tijeras decapita a lagarto");
                            break;
                        case 4: //spock
                            System.out.println("Has perdido, Spock rompe tijeras");
                            break;

                    }
                    break;

                case 3: //lagarto
                    switch (eleccionOrdenador) {
                        case 0: //piedra
                            System.out.println("Has perdido, piedra aplasta a lagarto");
                            break;
                        case 1: //papel
                            System.out.println("Enhorabuena, lagarto devora papel");
                            break;
                        case 2: //tijera
                            System.out.println("Has perdido, tijeras decapita a lagarto");
                            break;
                        case 4: //spock
                            System.out.println("Has perdido, lagarto envenena a Spock");
                            break;
                    }
                    break;

                case 4: //spock
                    switch (eleccionOrdenador) {
                        case 0://piedra
                            System.out.println("Enhorabuena, has ganado, Spock vaporiza piedra");
                            break;
                        case 1: //papel
                            System.out.println("Has perdido, papel desautoriza a Spock");
                            break;
                        case 2: //tijera
                            System.out.println("Enhorabuena, has ganado Spock rompe tijeras");
                            break;
                        case 3:// lagarto
                            System.out.println("Has perdido, lagarto envenena a Spock");
                            break;
                    }
                    break;


            }

        }

    }
}