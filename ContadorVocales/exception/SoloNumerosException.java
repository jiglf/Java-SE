package exception;

//creo excepcion personalizada para controlar que no se introduzcan solo numeros
public class SoloNumerosException extends Exception {

    public SoloNumerosException(String mensaje) {
        super(mensaje);
    }

}
