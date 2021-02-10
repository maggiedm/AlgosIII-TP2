package edu.fiuba.algo3.modelo;

public class Linea {

    private final Posicion origen;
    private final Posicion destino;

    public Linea (Posicion inicioLinea, Posicion finLinea){
        if(inicioLinea.esIgualA(finLinea)){
            throw new LineaInvalidaException();
        }
        origen = inicioLinea;
        destino = finLinea;
    }

    public boolean esIgual(Linea linea){
        return ((origen.esIgualA(linea.origen) && destino.esIgualA(linea.destino)) || (origen.esIgualA(linea.destino) && destino.esIgualA(linea.origen)));
    }
}
