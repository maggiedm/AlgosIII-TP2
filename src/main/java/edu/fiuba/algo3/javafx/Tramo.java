package edu.fiuba.algo3.javafx;

import javafx.scene.shape.Path;

public class Tramo {
    public Path tramo;
    public Boolean esVisible;
    public int tamano;

    public Tramo(Path camino, Boolean visibilidad, int tam){
        tramo = camino;
        esVisible = visibilidad;
        tamano = tam;
    }
}
