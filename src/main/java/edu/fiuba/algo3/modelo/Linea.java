package edu.fiuba.algo3.modelo;

public class Linea {

    private final Posicion origen;
    private final Posicion destino;
    private final Boolean visibilidad;

    public Linea (Posicion inicioLinea, Posicion finLinea, boolean esVisible){
        /*if(inicioLinea.esIgualA(finLinea)){
            throw new LineaInvalidaException();
        }*/
        origen = inicioLinea;
        destino = finLinea;
        visibilidad = esVisible;
    }

    public Posicion getOrigen() {
        return origen;
    }

    public Posicion getDestino() {
        return destino;
    }

    public boolean esVisible(){
        return visibilidad;
    }

    public boolean esIgual(Linea linea){
        return ((origen.esIgualA(linea.origen) && destino.esIgualA(linea.destino) && visibilidad == linea.esVisible()));
    }

    public String getDireccion(){
        return Direccion.direccionDesplazamiento(origen.desplazaminetoEnX(destino), origen.desplazamientoEnY(destino));
    }
}
