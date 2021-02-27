package edu.fiuba.algo3.javafx;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class ScrollPaneVista extends ScrollPane {

    public ScrollPaneVista(int altura, int ancho, Pane unContenido){
        super(unContenido);
        this.setMinViewportWidth(ancho);
        this.setPrefViewportHeight(altura);
    }
}
