package metodos;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;

public class MetodosComunes {

    //uso collections, la clase mas abstracta para asi poder pasarle cualquier tipo de lista


    public static void anadirElementos(Collection<Integer> lista) {
        for (int i = 0; i <= 2000000; i++) {
            lista.add(i);
        }
    }

    public static long tiempoAnadir(Collection<Integer> lista) {
        Instant inicio = Instant.now();
        anadirElementos(lista);
        Instant fin = Instant.now();

        long duracion = Duration.between(inicio, fin).toMillis();

        return duracion;
    }

    public static long tiempoBorrar(Collection<Integer> lista) {

        anadirElementos(lista);

        Instant inicio = Instant.now();
        lista.clear();
        Instant fin = Instant.now();

        long duracion = Duration.between(inicio, fin).toMillis();

        return duracion;
    }


    public static long medirTiempoBuscar(Collection<Integer> lista) {
        anadirElementos(lista);
        Instant inicio = Instant.now();
        for (int i = 0; i < lista.size() ; i++) {
            lista.contains(250);
            
        }
        Instant fin = Instant.now();
        return Duration.between(inicio, fin).toMillis();
    }


     public static long medirTiempoRecorrer(Collection<Integer> lista) {
        anadirElementos(lista);

        Instant inicio = Instant.now();
        for (Integer elemento : lista) {
            //elemento lo uso solo para iterar en la lista, no para mostrar los datos
        }
        Instant fin = Instant.now();
        return Duration.between(inicio, fin).toMillis();
    }

}
