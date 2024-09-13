import java.util.Scanner;

import exception.SoloNumerosException;

public class App {
    public static void main(String[] args)  {

        
        System.out.print("Introduce un texto (frase o palabra): ");

        try (Scanner teclado = new Scanner(System.in);){
            String textoAnalizar = teclado.nextLine();

            //analizo si en el texto solo hay numeros con una expresion regular y en el caso lanzo la excepcion

            if (textoAnalizar.matches("[0-9]+")) {
                throw new SoloNumerosException("Solo has introducido numeros");
            }
            System.out.println("Has introducido " + analizarTexto(textoAnalizar) + " vocales en el texto");

        } catch(SoloNumerosException sne) {
            System.out.println(sne.getMessage());
        }

    }

    public static int analizarTexto(String textoAnalizar) {
         char [] letraAnalizar = textoAnalizar.toLowerCase().toCharArray();//paso a minusculas para facilitar la comparación
         int vocales = 0;

         for (char letra : letraAnalizar) {
            switch (letra) {
                case 'a':
                case 'e':    
                case 'i':
                case 'o':
                case 'u':
                        vocales++;
                    break;        

            }
         }
        return vocales;
    }


}
