package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.BloquesDisponibles;
import edu.fiuba.algo3.javafx.Vista;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class LayoutBloques extends VBox{

    static private VBox contenido;
    private final BloquesDisponibles bloquesDisponibles;

    public LayoutBloques(double altura) {

        contenido = new VBox(10);
        ScrollPane sP = new ScrollPane(contenido);
        sP.setPrefViewportHeight(altura-30);
        sP.setMinViewportWidth(150);

        Vista.agregarTitulo(this, "Bloques");
        this.getChildren().add(sP);

        this.bloquesDisponibles = new BloquesDisponibles();
        bloquesDisponibles.agregarBotones(contenido);
    }

    public void agregarBloquePersonalizado(String nombre, AlgoBlocks algoBlocks){
        bloquesDisponibles.agregarBloquePersonalizado(nombre, algoBlocks, contenido);
    }



}
