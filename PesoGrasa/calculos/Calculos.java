package calculos;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculos {

    public static Scanner teclado = new Scanner(System.in);

    public static double calculoIMC(double peso, double altura) {

                double IMC = peso/Math.pow(altura, 2);

        return IMC;

    }

    public static String valoracionIMC(double IMC) {

        
        String valoracion;

        if (IMC < 18.4) {
            valoracion = "insuficiencia ponderal";
        } else if (IMC < 24.9) {
            valoracion = "normal";  
        } else if (IMC < 29.9) {
            valoracion = "sobrepeso";   
        } else if (IMC < 34.9) {
            valoracion = "obesidad tipo I";      
        } else if (IMC < 39.9) {
            valoracion = "obesidad tipo II";          
        } else {
            valoracion = "obesidad tipo III";
        }

        return valoracion;

    }

    public static double calculoGrasa(double IMC, int edad, int sexo) {

        double porcentajeGrasa = (1.2 * IMC) + (0.23 * edad) - (10.8 * sexo) - 5.4;

        return porcentajeGrasa;

    }

    public static void solicitarDatos() {

        double peso, altura, IMC, grasa;
        int edad, sexo = 0; 
        char datoSexo;

        System.out.println("Introduce tu peso: ");
        peso = Double.parseDouble(teclado.nextLine());

        System.out.println("Introduce tu altura en metros: ");
        altura = Double.parseDouble(teclado.nextLine());

        System.out.println("Introduce tu edad: ");
        edad = Integer.parseInt(teclado.nextLine());

        System.out.println("¿De que sexo eres? (varon o mujer): ");
        datoSexo = teclado.nextLine().charAt(0);
        
        if (datoSexo == 'v') {
            sexo = 1;
        } else if (datoSexo == 'm') {
            sexo = 0;
        }

        
        IMC = calculoIMC(peso, altura);
        grasa = calculoGrasa(IMC, edad, sexo);

        DecimalFormat formatoDecimal = new DecimalFormat("#.00");

        System.out.println("Tu valor de IMC es " + formatoDecimal.format(IMC) + " la valoración es " + valoracionIMC(IMC)) ;
        System.out.println("Tu porcentaje de grasa es " + formatoDecimal.format(grasa));

        

    }


}


