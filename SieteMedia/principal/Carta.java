package principal;

public class Carta {

    private String palo;
    private String numero;
    public Carta(String palo, String numero) {
        this.palo = palo;
        this.numero = numero;
    }
    public String getPalo() {
        return palo;
    }
    public double getValor() {
        //segun el valor de la numero, le asigno un valor numerico a la carta
        double valor = 0;
        switch(numero) {
            case "As": valor = 1; 
                break;
    	    case "Dos": valor = 2;
                break;
    	    case "Tres": valor = 3;
                break;
    	    case "Cuatro": valor = 4;
                break;
    	    case "Cinco": valor = 5;
                break;
    	    case "Seis": valor = 6;
                break;
    	    case "Siete": valor = 7;
                break;
    	    case "Sota": valor = 0.5;
                break;
    	    case "Caballo": valor = 0.5;
                break;
    	    case "Rey": valor = 0.5;
                break;

        }
        return valor;
    }
    @Override
    public String toString() {
        return numero + " de " + palo +". Valor: " + getValor();
    }
    
 
}
