package edu.fiuba.algo3.modelo.lapiz;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Dibujo;

public class Lapiz {
    private CondicionLapiz condicion = new LapizArriba();

    public void bajar(Dibujo dibujo, Posicion posicion) {
        condicion = new LapizAbajo();
        dibujo.dibujarLinea(posicion, posicion, true);
    }

    public void subir(Dibujo dibujo, Posicion posicion) {
        condicion = new LapizArriba();
        dibujo.dibujarLinea(posicion, posicion, false);
    }

    public void dibujarLinea(Posicion origen, Posicion destino, Dibujo dibujo){
        condicion.dibujarLinea(origen, destino, dibujo);
    }
}
