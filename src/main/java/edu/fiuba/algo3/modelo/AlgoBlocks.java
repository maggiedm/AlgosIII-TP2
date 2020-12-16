package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.Bloque;

public class AlgoBlocks {
    private Personaje personaje = new Personaje();
    private Algoritmo algoritmo = new Algoritmo();

    public void ejecutarAlgoritmo() {
        // personaje = new Personaje();
        algoritmo.ejecutar(personaje);
    }

    public void agregarBloque(Bloque unBloque) {
        algoritmo.agregarBloque(unBloque);
    }

    public Personaje getPersonaje() { return personaje; }

    public Algoritmo getAlgoritmo() { return algoritmo; }
}
