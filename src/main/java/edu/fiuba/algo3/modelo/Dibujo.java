package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Dibujo {
    List<Linea> lineas = new ArrayList<>();

    public void dibujarLinea(Posicion origen, Posicion destino, boolean esVisible) {
        Linea linea = new Linea(origen, destino, esVisible);
        lineas.add(linea);
    }

    public boolean tieneLinea(Linea unaLinea){
        return lineas.stream().anyMatch(linea -> linea.esIgual(unaLinea));
    }

    public int getCantidadLineas() { return lineas.size(); }

    public List<Linea> getLineas(){return lineas;}

    public boolean lineaEsVisible(int pos){
        return lineas.get(pos).esVisible();
    }
}
