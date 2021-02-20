package edu.fiuba.algo3.javafx;

import javafx.scene.shape.Path;

public class Tramo {
    public Path tramo;
    public Boolean esVisible;
    public int tam;
    public String direccion;

    public Tramo(Path tramo, Boolean visibilidad, int tam, String direccion){
        this.tramo = tramo;
        this.esVisible = visibilidad;
        this.tam = tam;
        this.direccion = direccion;
    }
}
