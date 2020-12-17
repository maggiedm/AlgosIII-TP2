package edu.fiuba.algo3.modelo;

public class Linea {

    private Posicion origen;
    private Posicion destino;

    public Linea (Posicion inicioLinea, Posicion finLinea) {
        origen = inicioLinea;
        destino = finLinea;
    }

    public boolean esIgual(Linea linea) {
        return ((origen.esIgualA(linea.origen) && destino.esIgualA(linea.destino)) || (origen.esIgualA(linea.destino) && destino.esIgualA(linea.origen)));
    }
}
