package principal;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Baraja {

    private String[] numeros = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Sota", "Caballo", "Rey"};
    private String[] palos ={"Espadas", "Copas", "Bastos", "Oros"};
    private static List<Carta> cartas = new ArrayList<>();
    Random aleatorio = new Random();

    public Baraja() {
        for (String numero : numeros) {
            for (String palo : palos) {
                cartas.add(new Carta(palo, numero));
            }
        }
    }
    public void mostrarBaraja() {
        for (Carta carta : cartas){
            System.out.println(carta);
        }
    }
    public void barajar() {
        Collections.shuffle(cartas);//barajo las cartas
    }

    public Carta sacarCarta() {
        if(!cartas.isEmpty()) {
            return cartas.remove(0);
        } else {
            return null; //no hay más cartas
        }
    }

    public int cartasRestantes() {
        return cartas.size();
    }

}
