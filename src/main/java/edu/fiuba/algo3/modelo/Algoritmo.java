package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.Bloque;

import java.util.ArrayList;
import java.util.List;

public class Algoritmo {

    private List<Bloque> secuenciaDeBloques = new ArrayList();

    public void ejecutar(Personaje personaje) {
        secuenciaDeBloques.forEach(bloque -> bloque.ejecutar(personaje));
    }

    public void agregarBloque(Bloque unBloque) {
        secuenciaDeBloques.add(unBloque);
    }

    public List<Bloque> getSecuenciaDeBloques() { return secuenciaDeBloques; }

}
