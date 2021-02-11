package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.Bloque;

public class AlgoBlocks {
    private final Dibujo dibujo = new Dibujo();
    private final Personaje personaje = new Personaje(dibujo);
    private final Algoritmo algoritmo = new Algoritmo();

    public void ejecutarAlgoritmo(){
        // personaje = new Personaje();
        algoritmo.ejecutar(personaje);
    }

    public void agregarBloque(Bloque unBloque) {
        algoritmo.agregarBloque(unBloque);
    }

    public Boolean personajeEstaEnPosicion(Posicion unaPosicion){
        return personaje.estaEnPosicion(unaPosicion);
    }

    public int cantidadLineasDibujadas() { return dibujo.getCantidadLineas();}

    public int cantidadDeBloquesEnAlgoritmo(){
        return algoritmo.getCantidadDeBloques();
    }
}
