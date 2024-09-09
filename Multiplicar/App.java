import java.util.Scanner;

public class App {
    public static void main(String[] args)  {

        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce el numero que quieres calcular la tabla de multiplicar: ");
        int numeroPrincipal = Integer.parseInt(teclado.nextLine());

        System.out.print("Indica el número hasta el que quieres saber la tabla de multiplicar: ");
        int numeroLimite = Integer.parseInt(teclado.nextLine());

        multiplicar(numeroPrincipal, numeroLimite);
        teclado.close();

    }

    public static void multiplicar(int numeroPrincipal, int numeroLimite) {
        int linea = 0;
        for (int i = 1; i < numeroLimite; i++) {
            System.out.println(numeroPrincipal + " x " + i + " = " + (numeroPrincipal*i));
            linea++;
            if (linea == 10) {//para hacer mas facil la visualizacion en bloques de 10 en 10
                System.out.println();
                linea = 0;
            }
        }
    }
}
