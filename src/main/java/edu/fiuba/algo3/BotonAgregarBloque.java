package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class BotonAgregarBloque extends Button{

    public BotonAgregarBloque(Bloque unBloque, String unaDescripcion, VBox unLayout, AlgoBlocks unAlgoBlocks){

        Button botonAgregarBloque = new Button();
        botonAgregarBloque.setText(unaDescripcion);
        botonAgregarBloque.setOnAction(new BotonAgregarBloqueEventHandler(unBloque, unAlgoBlocks));
        unLayout.getChildren().add(botonAgregarBloque);
    }
}
