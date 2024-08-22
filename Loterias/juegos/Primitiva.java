package juegos;


import static utiles.Util.aleatorio;

public class Primitiva {

    public static void principalPrimitiva() {
        System.out.println("***** Esta es la simulación del sorteo de la primitiva. ¡SUERTE! *****");
        int[] primitivaArray = new int[6];
        int numeroReintegro;

        for (int i = 0; i < primitivaArray.length; i++) {
            int numeroGenerado;
            boolean repetido; //variable booleana que determinara si un numero esta o no repetido en el array

            do {
                repetido = false;
                numeroGenerado = aleatorio.nextInt(49) + 1;


                for (int j = 0; j < i; j++) {
                    if (primitivaArray[j] == numeroGenerado) {
                        repetido = true; //si esta repetido, sale y no lo incluye
                        break;
                    }
                }
            } while (repetido);

            primitivaArray[i] = numeroGenerado;
        }

        System.out.println("Estos son los 6 números elegidos:");
        for (int n : primitivaArray) {
            System.out.print(n + " ");
        }

        numeroReintegro = aleatorio.nextInt(9);
        System.out.println("\nEste es el reintegro: " + numeroReintegro);
    }


}
