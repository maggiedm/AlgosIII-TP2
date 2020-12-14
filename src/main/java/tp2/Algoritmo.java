package tp2;

import java.util.ArrayList;
import java.util.List;

public class Algoritmo {

    private List<Bloque> secuenciaDeBloques = new ArrayList<>;

    public void ejecutar(Personaje personaje) {
        for (Bloque unBloque : secuenciaDeBloques) unBloque.ejecutar(personaje);
    }

    public void agregarBloque(Bloque unBloque) {
        secuenciaDeBloques.add(unBloque);
    }
}
