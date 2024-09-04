package juego;

import java.util.Random;
import java.util.Scanner;

public class Juego {

    static Random aleatorio = new Random();
    static Scanner teclado = new Scanner(System.in);

    public static String escogerPalabra() {
        //creo un array de palabras con las palabras que entran en el juego
        String [] palabras = {"pelota", "camisa", "pesado", "amigas", "zapato", "tomate", "jugada", "balon", "casa", "almohada", "ventilador"};
        int opcionAleatoria = aleatorio.nextInt(palabras.length);
        String palabraElegida = palabras[opcionAleatoria];

        return palabraElegida;

    }

    public static char[] generarGuiones(String palabraElegida) {
        char[] guiones = new char[palabraElegida.length()];//creo un array con la palabra elegida
        for (int i = 0; i < guiones.length; i++) {
            guiones[i] = '-';//relleno con guiones el array con el mismo numeros de las posiciones de la palabra
        }

        return guiones;
    }

    public static int numeroIntentos (char[] guiones) {
        int numeroIntentos = guiones.length;

        return numeroIntentos;
    }

    public static void juego() {
        String objetivo = escogerPalabra();//eligo la palabra y la almaceno en variable
        char [] enJuego = generarGuiones(objetivo);//paso la palabra elegida a guiones
        char guion = '-';
        int intentos = enJuego.length;
        boolean adivinado = false;

        System.out.println("Bienvenido al juego del ahorcado");
        System.out.println("Intenta adivinar la palabra");
        System.out.println("\t" +String.valueOf(enJuego));
        System.out.println("Intentos: " + intentos);

        do {
            boolean acierto = false;
            System.out.print("Dime la letra que quieres jugar: ");
            char letraJugada = teclado.nextLine().toLowerCase().charAt(0);//para escoger la primera letra y lo paso a minusculas para la comparacion

            for (int i = 0; i < objetivo.length(); i++) {//comparo la letra introducida con las letras del array elegido
                char letra = objetivo.charAt(i);
                if (letra == letraJugada) {
                    acierto = true;
                    enJuego[i]= letraJugada;
                }
            }
            if (!acierto) {//si falla disminuyo intentos
                intentos--;

            }
            adivinado = true;
            for (int i = 0; i < objetivo.length(); i++) {
                adivinado &= enJuego[i] != guion;// verifica que aun no tenga guiones   
            }

            System.out.println(String.valueOf(enJuego));
            System.out.println("Intentos: " + intentos);

        } while(!adivinado && intentos > 0);   
        
        if (adivinado) {
            System.out.println("Enhorabuena, has acertado");
        } else {
            System.out.println("Lo siento, has perdido. La palabra era " + objetivo);
        }
    }

}
