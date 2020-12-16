package edu.fiuba.algo3.modelo;

public class Linea {

    private Posicion origen;
    private Posicion destino;

    public Linea (Posicion inicioLinea, Posicion finLinea) {
        origen = inicioLinea;
        destino = finLinea;
    }

    public boolean esIgual(Posicion inicioLinea, Posicion finLinea) {
        return ((origen.esIgualA(inicioLinea) && destino.esIgualA(finLinea)) || (origen.esIgualA(finLinea) && destino.esIgualA(inicioLinea)));
    }
}
