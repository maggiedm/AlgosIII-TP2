package tp2;

import java.util.ArrayList;
import java.util.List;

public class AlgoBlocks {
    private Personaje personaje = new Personaje();
    private Algoritmo algoritmo = new Algoritmo();
    private List<Bloque> bloquesDisponibles = new ArrayList<>; //(List.of)); -> Para agregar los bloques

    public void ejecutar() {
        algoritmo.ejecutar(personaje);
    }

    public void agregarBloque(Bloque unBloque) {
        algoritmo.agregarBloque(unBloque);
    }

}