package edu.fiuba.algo3.vista.algoritmo;

import javafx.scene.control.ChoiceBox;

public class SeleccionadorContenedorBloquesVista extends ChoiceBox<String> {

    public SeleccionadorContenedorBloquesVista(String nombre){
        super();
        agregar(nombre);
        this.setValue(nombre);
    }

    public void agregar(String nombre){
        this.getItems().add(nombre);
    }

    public String getActual() {
        return this.getValue();
    }
}
