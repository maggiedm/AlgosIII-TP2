package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.BloquesDisponibles;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class LayoutBloques extends VBox{

    static private VBox contenido;
    private final BloquesDisponibles bloquesDisponibles;

    public LayoutBloques(double altura) {

        contenido = new VBox(10);
        ScrollPane sP = new ScrollPane(contenido);
        sP.setPrefViewportHeight(altura - 50);
        sP.setMinViewportWidth(150);

        this.getChildren().addAll(new LayoutTitulo("Bloques"), sP);
        this.setStyle("-fx-background-color: lightgray;" + "-fx-border-width: 2px;" + "-fx-border-color: lightgray");

        this.bloquesDisponibles = new BloquesDisponibles();
        bloquesDisponibles.agregarBotones(contenido);
    }

    public void agregarBloquePersonalizado(String nombre, AlgoBlocks algoBlocks){
        bloquesDisponibles.agregarBloquePersonalizado(nombre, algoBlocks, contenido);
    }



}
