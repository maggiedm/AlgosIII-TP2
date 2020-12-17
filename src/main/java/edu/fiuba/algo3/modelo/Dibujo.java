package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Dibujo {
    List<Linea> lineas = new ArrayList<>();

    public void dibujarLinea(Posicion origen, Posicion destino) {
        Linea linea = new Linea(origen, destino);
        if(!this.lineaYaExiste(linea)){
            lineas.add(linea);
        }
    }

    private boolean lineaYaExiste(Linea nLinea){

        return lineas.stream().anyMatch(linea -> linea.esIgual(nLinea));
    }

    public List<Linea> getLineas() { return lineas; }
}
