package edu.fiuba.algo3.javafx;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class LayoutTitulo extends HBox {
    public LayoutTitulo(String titulo){
        this.setPadding(new Insets(10,10,10,10));
        Vista.agregarTitulo(this, titulo);
        this.setStyle("-fx-background-color: lightgray");
    }
}
