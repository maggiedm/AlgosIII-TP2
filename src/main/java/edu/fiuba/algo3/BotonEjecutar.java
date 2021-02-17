package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class BotonEjecutar extends Button {

    public BotonEjecutar(HBox layoutEjecutarReiniciar, ImageView logo, Tooltip descripcion) {
        Button botonEjecutar = new Button("", logo);
        botonEjecutar.setTooltip(descripcion);
        //botonAgregarBloque.setOnAction(new BotonAgregarBloqueEventHandler(bloque, algoBlocks));
        layoutEjecutarReiniciar.getChildren().add(botonEjecutar);
    }
}
