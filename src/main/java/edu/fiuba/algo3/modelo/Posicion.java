package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direccion.Direccion;

public class Posicion {

    private Coordenadas coordenadas = new Coordenadas(0, 0);

    public Posicion() {

    }

    private Posicion(int x, int y) {
        coordenadas = new Coordenadas(x, y);
    }

    private static Posicion crearConCoordenadas(Coordenadas unasCoordenadas){
        Posicion pos = new Posicion();
        pos.coordenadas.desplazar(unasCoordenadas);

        return pos;
    }

    public static Posicion setPosicion(int x, int y){
        return new Posicion(x, y);
    }

    public Posicion obtenerSiguiente(Direccion unaDireccion) {

        Posicion posicion = Posicion.crearConCoordenadas(coordenadas);
        posicion.coordenadas.desplazar(unaDireccion.getCoordenadas());
        return posicion;
    }

    public boolean esIgualA(Posicion unaPosicion) {
        return (coordenadas.sonIgualesA(unaPosicion.coordenadas));
    }
}
