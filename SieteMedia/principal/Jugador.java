package principal;

import java.util.List;
import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private double puntuacion;// para llevar el control de la puntuacion de cada jugador
    private List<Carta> mano;// para registrar la mano de cada jugador

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
        this.puntuacion = 0;// inicio la puntuacion de cada jugador a 0
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void recibirCarta(Carta carta) {
        //añade la carta a la mano del jugador y va sumando el valor
        mano.add(carta);
        puntuacion += carta.getValor();
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void mostrarMano() {
        System.out.println(nombre + " tiene las siguientes cartas: ");
        for (Carta carta : mano) {
            System.out.println(carta);
        }
        System.out.println("Puntuación: " + puntuacion);
    }

}
