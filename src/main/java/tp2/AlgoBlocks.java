package tp2;

import java.util.ArrayList;
import java.util.List;

public class AlgoBlocks {
    private Personaje personaje = new Personaje();
    private Algoritmo algoritmo = new Algoritmo();

    public void ejecutar() {
        algoritmo.ejecutar(personaje);
    }

    public void agregarBloque(Bloque unBloque) {
        algoritmo.agregarBloque(unBloque);
    }

}