import java.util.Scanner;

import metodos.EjemploListas;


public class App {
    public static void main(String[] args) {

        System.out.println("COMPARACIÓN ENTRE LISTAS");
        System.out.println(" ***** OPCIONES *****");
        System.out.println("1. Comparar tiempos para añadir 2000000 números a las listas");
        System.out.println("2. Comparar el tiempo para eliminar los 2000000 números");
        System.out.println("3. Comparar el tiempo que tarda cada lista en buscar el elemento 250");
        System.out.println("4. Comparar el tiempo que tarda en recorrer cada lista");

        System.out.print("¿Que opción deseas? ");

        try (Scanner teclado = new Scanner(System.in);){

            int opcion = Integer.parseInt(teclado.nextLine());

                switch(opcion) {
                    case 1: EjemploListas.comparacionesAnhadir();
                        break;
                    case 2: EjemploListas.eliminarElementosListas();
                        break;
                    case 3: EjemploListas.comparacionBuscar();
                        break;
                    case 4: EjemploListas.comparacionRecorrer();
                        break;

                    default:System.out.println("Opcion no correcta");    
                }


        } catch (NumberFormatException nfe) {
            nfe.getMessage();
            System.out.println("Opción no correcta");
        }
        


    }

}
