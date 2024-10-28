import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Repite {

    public static void main(String[] args) {

        System.out.println("Vamos a comprobar quien repite más si la clase Radom o el metodo Math.ramdon");

        valoresAleatorios();

        valoresRandom();



    }


    public static void valoresAleatorios () {
            // Creamos un objeto de la clase Random
            Random aleatorio = new Random();

            // Definimos el tamaño del array y lo inicializamos
            int[] valoresAleatorios = new int[100];
            // creo set para meter los resultados del array
            Set<Integer> valoresSinRepetidos = new HashSet<>();



            for (int i = 0; i < valoresAleatorios.length; i++) {
                valoresAleatorios[i] = aleatorio.nextInt(50)+1;
            }

            /* añado los valores al Set pero como no incluye repetidos solo se añaden los que no estan repetidos
                por lo que al sacar el tamaño del set se saca el valor de los no repetidos por lo que al restar el
                tamaño inicial del array se obtiene el numero de repetidos
            */
            for (int n : valoresAleatorios) {
                valoresSinRepetidos.add(n);

            }

        System.out.println("Hay un total de " + (valoresAleatorios.length - valoresSinRepetidos.size()) + " valores repetidos con la clase Random");

        }

        public static void valoresRandom() {

            // Definimos el tamaño del array y lo inicializamos
            int[] valoresAleatorios = new int[100];
            // creo set para meter los resultados del array
            Set<Integer> valoresSinRepetidos = new HashSet<>();

            for (int i = 0; i < valoresAleatorios.length; i++) {
                valoresAleatorios[i] = (int) (Math.random() * 50) + 1;
            }

            /* añado los valores al Set pero como no incluye repetidos solo se añaden los que no estan repetidos
                por lo que al sacar el tamaño del set se saca el valor de los no repetidos por lo que al restar el
                tamaño inicial del array se obtiene el numero de repetidos
            */
            for (int n : valoresAleatorios) {
                valoresSinRepetidos.add(n);

            }

            System.out.println("Hay un total de " + (valoresAleatorios.length - valoresSinRepetidos.size()) + " valores repetidos con el metodo estatico");

        }
}
