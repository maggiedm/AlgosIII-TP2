package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BotonReiniciar {

    public BotonReiniciar(HBox layoutEjecutarReiniciar, ImageView logo, Tooltip descripcion) {
        Button botonReiniciar = new Button("", logo);
        botonReiniciar.setTooltip(descripcion);
        //botonAgregarBloque.setOnAction(new BotonAgregarBloqueEventHandler(bloque, algoBlocks));
        layoutEjecutarReiniciar.getChildren().add(botonReiniciar);
    }
}
