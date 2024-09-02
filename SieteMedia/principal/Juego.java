package principal;

import java.util.Scanner;

public class Juego {

    public static void iniciar() {

        Scanner teclado = new Scanner(System.in);
        boolean seguirJugando = true;

        System.out.println("Bienvenido al juego de las 7 y media. ¡Intenta ganar a la banca!");
        System.out.print("¿Cual es tu nombre? ");
        String nombreJugador = teclado.nextLine(); 
        Jugador jugador = new Jugador(nombreJugador);//creo el jugador con el nombre pasado
        Baraja baraja = new Baraja();//creo la baraja

        while(seguirJugando) {
            baraja.barajar();//mezclo las cartas antes de iniciar
            Carta nuevaCarta = baraja.sacarCarta();//saco una carta
            System.out.println("La carta obtenida es: " + nuevaCarta);
            jugador.recibirCarta(nuevaCarta);//añade la carta obtenida al mazo del jugador
            jugador.mostrarMano();

            if (jugador.getPuntuacion() > 7.5) {
                System.out.println("Lo siento, te has pasado de 7.5 puntos. ¡Has perdido!");
                seguirJugando = false;
                teclado.close();
                return;
            }

            System.out.println("¿Quieres otra carta? (s/n)");
            String respuestaJugador = teclado.nextLine().toLowerCase();//paso a minusculas para la comparacion
            if (respuestaJugador.equals("n")) {
                seguirJugando = false;
            }

        }

        //Turno de la banca
        Jugador jugadorBanca = new Jugador("Banca");
        while (jugadorBanca.getPuntuacion() < 7.5) {
            Carta nuevaCarta = baraja.sacarCarta();
            System.out.println("La banca saca: " + nuevaCarta);
            jugadorBanca.recibirCarta(nuevaCarta);
        }
        jugadorBanca.mostrarMano();

        //Determinar el ganador

        if ((jugadorBanca.getPuntuacion() > 7.5) || (jugador.getPuntuacion() > jugadorBanca.getPuntuacion())) {
            System.out.println("¡Felicidades has ganado a la banca!");
        } else if (jugador.getPuntuacion() == jugadorBanca.getPuntuacion()) {
            System.out.println("Habeis empatado");
        } else {
            System.out.println("¡La banca ha ganado!");
        }
        
        teclado.close();
    }

    

}
