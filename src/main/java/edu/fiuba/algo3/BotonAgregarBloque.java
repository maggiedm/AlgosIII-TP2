package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.List;


public class BotonAgregarBloque extends Button{

    public BotonAgregarBloque(ImageView logo, Tooltip descripcion, VBox layoutBloques, EventHandler<ActionEvent> handler){

        Button botonAgregarBloque = new Button("", logo);
        botonAgregarBloque.setTooltip(descripcion);
        botonAgregarBloque.setTooltip(descripcion);
        botonAgregarBloque.setOnAction(handler);
        layoutBloques.getChildren().add(botonAgregarBloque);
    }
}
