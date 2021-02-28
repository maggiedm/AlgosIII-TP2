package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.BloquesDisponibles;
import edu.fiuba.algo3.javafx.ScrollPaneVista;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.scene.layout.VBox;

public class LayoutBloques extends VBox{

    static private VBox contenido;
    private final BloquesDisponibles bloquesDisponibles;

    public LayoutBloques(int altura) {

        contenido = new VBox(10);
        this.getChildren().addAll(new LayoutTitulo("Bloques"), new ScrollPaneVista(altura - 50, 150, contenido));
        this.setStyle("-fx-background-color: lightgray;" + "-fx-border-width: 2px;" + "-fx-border-color: lightgray");

        this.bloquesDisponibles = new BloquesDisponibles();
        bloquesDisponibles.agregarBotones(contenido);
    }

    public void agregarBloquePersonalizado(String nombre, AlgoBlocks algoBlocks){
        bloquesDisponibles.agregarBloquePersonalizado(nombre, algoBlocks, contenido);
    }
}
