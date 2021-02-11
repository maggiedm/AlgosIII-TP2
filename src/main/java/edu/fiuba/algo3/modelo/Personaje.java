package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.lapiz.Lapiz;

public class Personaje {

    private Posicion posicion = new Posicion();
    private final Lapiz lapiz = new Lapiz();
    private final Dibujo dibujo;

    public Personaje(Dibujo dib){
        dibujo = dib;
    }

    public Boolean estaEnPosicion(Posicion unaPosicion) { return posicion.esIgualA(unaPosicion); }

    public void bajarLapiz() {
        lapiz.bajar();
    }

    public void subirLapiz() {
        lapiz.subir();
    }

    public void mover(Direccion unaDireccion) {
        Posicion posVieja = posicion;
        posicion = posicion.obtenerSiguiente(unaDireccion);
        lapiz.dibujarLinea(posVieja, posicion, dibujo);
    }
}
