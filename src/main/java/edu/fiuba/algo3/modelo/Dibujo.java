package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Dibujo {
    List<Linea> lineas = new ArrayList();

    public void dibujarLinea(Posicion origen, Posicion destino) {
        Linea linea = new Linea(origen, destino);
        if(!this.tieneLinea(linea)){
            lineas.add(linea);
        }
    }

    public boolean tieneLinea(Linea unaLinea){
        return lineas.stream().anyMatch(linea -> linea.esIgual(unaLinea));
    }

    public int getCantidadLineas() { return lineas.size(); }
}
