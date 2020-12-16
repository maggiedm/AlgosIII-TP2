package edu.fiuba.algo3.modelo.direccion;

import edu.fiuba.algo3.modelo.Coordenadas;

public abstract class Direccion {

    private Coordenadas coordenadas;

    protected Direccion(int dirHorizontal, int dirVertical){
        coordenadas = new Coordenadas(dirHorizontal, dirVertical);
    }

    public Coordenadas getCoordenadas() { return coordenadas; }
}
