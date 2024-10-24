import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Ordenamientos {
    public static void main(String[] args) {



        System.out.println("El metodo burbuja tarda " + tiempoBurbuja() + " milisegundos en ordenar");

        System.out.println("El metodo de selección tarda " + tiempoSeleccion() + " milisegundos en ordenar");

        System.out.println("El metodo de inserción tarda " + tiempoInsercion() + " milisegundos en ordenar");

        

       
        

    }

    //creo el array
    public static int[] numerosOrdenar() {
        Random aleatorio = new Random();
        int[] numerosOrdenar = new int[500];
    
        // creo un array de 500 posiciones con números aleatorios, diferentes para ejecutar el algoritmo de ordenamiento
        for (int i = 0; i < numerosOrdenar.length; i++) {
            int numeroGenerado;
            boolean repetido; // variable booleana que determinará si un número está o no repetido en el array
    
            do {
                repetido = false;
                numeroGenerado = aleatorio.nextInt(500) + 1;
    
                // comprueba si el número esta repetido
                for (int j = 0; j < i; j++) {
                    if (numerosOrdenar[j] == numeroGenerado) {
                        repetido = true; // si está repetido, sale y no lo incluye
                        break;
                    }
                }
            } while (repetido);
    
            // asigno del número generado al array
            numerosOrdenar[i] = numeroGenerado;
        }
    
        return numerosOrdenar; // retorno del array una vez lleno
    }

    //tiempos de ejecucción

    public static long tiempoBurbuja() {
        Instant inicio = Instant.now();
        burbuja(numerosOrdenar());
        Instant fin = Instant.now();

        long duracion = Duration.between(inicio, fin).toNanos();

        return duracion;
    }

    public static long tiempoSeleccion() {
        Instant inicio = Instant.now();
        seleccion(numerosOrdenar());
        Instant fin = Instant.now();

        long duracion = Duration.between(inicio, fin).toNanos();

        return duracion;
    }

    public static long tiempoInsercion() {
        Instant inicio = Instant.now();
        seleccion(numerosOrdenar());
        Instant fin = Instant.now();

        long duracion = Duration.between(inicio, fin).toNanos();

        return duracion;
    }


    //metodos de ordenamiento

        //metodo de ordenamiento burbuja
    public static void burbuja(int[] numerosOrdenar) {
        for (int i = 0; i < numerosOrdenar.length; i++) {
            for (int j = 0; j < numerosOrdenar.length - 1; j++) {
                if (numerosOrdenar[j] > numerosOrdenar[j + 1]) {
                    Integer temp = numerosOrdenar[j];
                    numerosOrdenar[j] = numerosOrdenar[j + 1];
                    numerosOrdenar[j + 1] = temp;
                }
            }
        }

    }

        //metodo de ordenadamiento por seleccion
    public static void seleccion(int[] numerosOrdenar) {
        for (int i = 0; i < numerosOrdenar.length; i++) {
            for (int j = i; j < numerosOrdenar.length; j++) {
                if (numerosOrdenar[i] > numerosOrdenar[j]) {
                    Integer aux = numerosOrdenar[j];
                    numerosOrdenar[j] = numerosOrdenar[i];
                    numerosOrdenar[i] = aux;
                }
            }
        }
    }

        //metodod de ordenamiento por inserción
    public static void insercion(int[] numerosOrdenar) {
        for (int i = 1; i < numerosOrdenar.length; i++) {
            Integer aux = numerosOrdenar[i];
            int j = i - 1;
            while (j >= 0 && numerosOrdenar[j] > aux) {
                numerosOrdenar[j + 1] = numerosOrdenar[j];
                j--;
            }
            numerosOrdenar[j + 1] = aux;
        }
    }
}
