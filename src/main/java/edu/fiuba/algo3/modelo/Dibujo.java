package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Dibujo {
    List<Linea> lineas = new ArrayList<>();

    public void dibujarLinea(Posicion origen, Posicion destino) {
        if(!this.lineaYaExiste(origen, destino)){
            lineas.add(new Linea(origen, destino));
        }
    }

    private boolean lineaYaExiste(Posicion origen, Posicion destino){

        return lineas.stream().anyMatch(linea -> linea.esIgual(origen, destino));
    }

    public List<Linea> getLineas() { return lineas; }
}
