package edu.fiuba.algo3.javafx;

import javafx.scene.control.ChoiceBox;


public class SeleccionadorBloqueCompuestoVista extends ChoiceBox<String> {

    public SeleccionadorBloqueCompuestoVista(String nombre){
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
