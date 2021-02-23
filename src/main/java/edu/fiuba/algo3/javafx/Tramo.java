package edu.fiuba.algo3.javafx;

import javafx.scene.shape.Path;

public class Tramo {
    private Path camino;
    private Boolean esVisible;
    private int tam;
    private String direccion;

    public Tramo(Path camino, Boolean visibilidad, int tam, String direccion){
        this.camino = camino;
        this.esVisible = visibilidad;
        this.tam = tam;
        this.direccion = direccion;
    }

    public Path getCamino() {
        return camino;
    }

    public int getTam() {
        return tam;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean esVisible(){
        return esVisible;
    }
}
