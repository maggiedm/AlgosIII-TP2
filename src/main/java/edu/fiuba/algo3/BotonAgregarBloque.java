package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class BotonAgregarBloque extends Button{

    public BotonAgregarBloque(Bloque bloque, String descripcion, AlgoBlocks algoBlocks, VBox  algoritmo, VBox layoutBloques){

        Button botonAgregarBloque = new Button();
        botonAgregarBloque.setText(descripcion);
        botonAgregarBloque.setOnAction(new BotonAgregarBloqueEventHandler(bloque, algoBlocks, descripcion, algoritmo));
        layoutBloques.getChildren().add(botonAgregarBloque);
    }
}
