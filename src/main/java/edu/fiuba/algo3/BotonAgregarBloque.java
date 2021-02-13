package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class BotonAgregarBloque extends Button{

    public BotonAgregarBloque(Bloque bloque, AlgoBlocks algoBlocks, VBox layoutBloques){

        Button botonAgregarBloque = new Button();
        botonAgregarBloque.setText(bloque.getDescripcion());
        botonAgregarBloque.setOnAction(new BotonAgregarBloqueEventHandler(bloque, algoBlocks));
        layoutBloques.getChildren().add(botonAgregarBloque);
    }
}
