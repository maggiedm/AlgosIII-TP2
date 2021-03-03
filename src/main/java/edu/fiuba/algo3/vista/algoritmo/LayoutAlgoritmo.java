package edu.fiuba.algo3.vista.algoritmo;

import edu.fiuba.algo3.javafx.SeleccionadorContenedorBloques;
import edu.fiuba.algo3.vista.VistaScrollPane;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.vista.LayoutTitulo;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LayoutAlgoritmo extends VBox {
    private static final SelectorContenedorDeBloquesActual selectorContenedorDeBloquesActual = new SelectorContenedorDeBloquesActual("Algoritmo");

    public LayoutAlgoritmo(AlgoBlocks algoBlocks, int altura) {
        VistaScrollPane vistaScrollPane = new VistaScrollPane(altura - 50, 240, null);
        HBox layoutTituloYSeleccionador = new HBox(10, new LayoutTitulo("Algoritmo"), selectorContenedorDeBloquesActual);
        layoutTituloYSeleccionador.setAlignment(Pos.CENTER_LEFT);
        this.getChildren().addAll(layoutTituloYSeleccionador, vistaScrollPane);
        this.setStyle("-fx-background-color: lightgray;" + "-fx-border-width: 2px;" + "-fx-border-color: lightgray");

        new SeleccionadorContenedorBloques(algoBlocks, vistaScrollPane, selectorContenedorDeBloquesActual);
    }

    public static void reiniciar(){
        selectorContenedorDeBloquesActual.reiniciar();
        SeleccionadorContenedorBloques.reiniciar();
    }
}
