package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

import java.util.List;


public class BotonAgregarBloque extends Button{

    public BotonAgregarBloque(Bloque bloque, VBox layoutBloques, EventHandler<ActionEvent> handler){

        Button botonAgregarBloque = new Button();
        botonAgregarBloque.setText(bloque.getDescripcion());
        botonAgregarBloque.setOnAction(handler);
        layoutBloques.getChildren().add(botonAgregarBloque);
    }
}
