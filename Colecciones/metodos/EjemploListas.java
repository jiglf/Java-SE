package metodos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EjemploListas {

    //instancio las diferentes tipos de lista que uso para la comparacion
    static List<Integer> arrayList = new ArrayList<>();
    static List<Integer> linkedList = new LinkedList<>();
    static Set<Integer> hashSet = new HashSet<>();
    static Set<Integer> treeSet = new TreeSet<>();

    public static void comparacionesAnhadir() {
        System.out.println("***** Tiempo que tarda en añadir archivos *****");
        System.out.println("El arrayList tarda: " + MetodosComunes.tiempoAnadir(arrayList) + " milisegundos");
        System.out.println("El linkedList tarda: " + MetodosComunes.tiempoAnadir(linkedList) + " milisegundos");
        System.out.println("El hashSet tarda: " + MetodosComunes.tiempoAnadir(hashSet) + " milisegundos");
        System.out.println("El treeSet tarda: " + MetodosComunes.tiempoAnadir(treeSet) + " milisegundos");
    }

    public static void eliminarElementosListas() {
        System.out.println("***** Tiempo que tarda en borrar archivos *****");
        System.out.println("El arrayList tarda: " + MetodosComunes.tiempoBorrar(arrayList) + " milisegundos");
        System.out.println("El linkedList tarda: " + MetodosComunes.tiempoBorrar(linkedList) + " milisegundos");
        System.out.println("El hashSet tarda: " + MetodosComunes.tiempoBorrar(hashSet) + " milisegundos");
        System.out.println("El treeSet tarda: " + MetodosComunes.tiempoBorrar(treeSet) + " milisegundos");
    }

    public static void comparacionBuscar() {
        System.out.println("***** Tiempo que tarda en buscar *****");
        System.out.println("El arrayList tarda: " + MetodosComunes.medirTiempoBuscar(arrayList) + " milisegundos");
        System.out.println("El linkedList tarda: " + MetodosComunes.medirTiempoBuscar(linkedList) + " milisegundos");
        System.out.println("El hashSet tarda: " + MetodosComunes.medirTiempoBuscar(hashSet) + " milisegundos");
        System.out.println("El treeSet tarda: " + MetodosComunes.medirTiempoBuscar(treeSet) + " milisegundos");
    }

    public static void comparacionRecorrer() {
        System.out.println("***** Tiempo que tarda en recorrer *****");
        System.out.println("El arrayList tarda: " + MetodosComunes.medirTiempoRecorrer(arrayList) + " milisegundos");
        System.out.println("El linkedList tarda: " + MetodosComunes.medirTiempoRecorrer(linkedList) + " milisegundos");
        System.out.println("El hashSet tarda: " + MetodosComunes.medirTiempoRecorrer(hashSet) + " milisegundos");
        System.out.println("El treeSet tarda: " + MetodosComunes.medirTiempoRecorrer(treeSet) + " milisegundos");
    }

}
