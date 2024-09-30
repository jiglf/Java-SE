public class TeoriaRueda {
    public static void main(String[] args)  {

        rangoValores();
        System.out.println(" ***** TEORIA DE LA RUEDA *****");
        teoriaRuedaByte();
        teoriaRuedaInteger();

        

    }

    public static void rangoValores() {

        System.out.println("Vamos a ver el rango de valores de los tipos primitivos");

        System.out.println("Rango de valores para byte: " + Byte.MIN_VALUE + " hasta " + Byte.MAX_VALUE);

        System.out.println("Rango de valores para short: " + Short.MIN_VALUE + " hasta " + Short.MAX_VALUE);
        
        System.out.println("Rango de valores para int: " + Integer.MIN_VALUE + " hasta " + Integer.MAX_VALUE);

        System.out.println("Rango de valores para long: " + Long.MIN_VALUE + " hasta " + Long.MAX_VALUE);

        System.out.println("Rango de valores para float: " + Float.MIN_VALUE + " hasta " + Float.MAX_VALUE);

        System.out.println("Rango de valores para double: " + Double.MIN_VALUE + " hasta " + Double.MAX_VALUE);

        System.out.println();
    }

    public static void teoriaRuedaByte() {

        System.out.println(" * Teoria de la rueda Byte");
        System.out.println("Vamos a ver la teoria de la rueda, cuando una variable llega a su valor maximo vuelve a empezar");
        
        byte b1 = 127, b2 = 1, b3;

        System.out.println("Vamos a realizar la suma de " + b1 + " y de " + b2 + ", vamos a sumarlo en una variable b3 casteada a byte");

        b3 = (byte)(b1 + b2);
        
        System.out.println("El restutado de b3 es " + b3 + ", esta es la teoria de la rueda vuelve a empezar en el valor minimo");

        System.out.println();

    }

    public static void teoriaRuedaInteger() {

        System.out.println(" * Teoria de la rueda Integer");
        System.out.println("Vamos a ver la teoria de la rueda, cuando una variable llega a su valor maximo vuelve a empezar");

        int i1 = 2147483647, i2 = 1, i3;

        System.out.println("Vamos a realizar la suma de " + i1 + " y de " + i2 + ", vamos a sumarlo en una variable i3 casteada a int");

        i3 = i1 + i2;

        System.out.println("Comprobamos que vuelva a su valor minimo " + i3);



    }


}
