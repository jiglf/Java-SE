package juegos;


import static utiles.Util.aleatorio;

public class Euromillones {

    public static void principalEuromillones (){
        System.out.println("***** Esta es la simulación del sorteo del euromillones. ¡SUERTE! *****");
        int[] euromillonesArray = new int[5];
        int[] numerosEstrellaArray = new int[2];

        for (int i = 0; i < euromillonesArray.length; i++) {
            int numeroGenerado;
            boolean repetido; //variable booleana que determinara si un numero esta o no repetido en el array

            do {
                repetido = false;
                numeroGenerado = aleatorio.nextInt(50) + 1;


                for (int j = 0; j < i; j++) {
                    if (euromillonesArray[j] == numeroGenerado) {
                        repetido = true; //si esta repetido, sale y no lo incluye
                        break;
                    }
                }
            } while (repetido);

            euromillonesArray[i] = numeroGenerado;
        }

        for (int i = 0; i < numerosEstrellaArray.length; i++) {
            int numeroGenerado;
            boolean repetido; //variable booleana que determinara si un numero esta o no repetido en el array

            do {
                repetido = false;
                numeroGenerado = aleatorio.nextInt(12) + 1;
                for (int j = 0; j < i; j++) {
                    if (euromillonesArray[j] == numeroGenerado) {
                        repetido = true; //si esta repetido, sale y no lo incluye
                        break;
                    }
                }
            } while (repetido);

            numerosEstrellaArray[i] = numeroGenerado;
        }



        System.out.println("Estos son los 5 números elegidos:");
        for (int n : euromillonesArray) {
            System.out.print(n + " ");
        }
        System.out.println("\nEstos son los numeros estrella:");
        for (int n : numerosEstrellaArray) {
            System.out.println(n + " ");
        }


    }


}
