package edu.fiuba.algo3.vista.algoritmo;

import edu.fiuba.algo3.javafx.SeleccionadorContenedorBloques;
import edu.fiuba.algo3.vista.ScrollPaneVista;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.vista.LayoutTitulo;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LayoutAlgoritmo extends VBox {
    private static final SeleccionadorContenedorBloquesVista seleccionadorContenedorBloquesVista  = new SeleccionadorContenedorBloquesVista("Algoritmo");

    public LayoutAlgoritmo(AlgoBlocks algoBlocks, int altura) {
        ScrollPaneVista scrollPaneVista = new ScrollPaneVista(altura - 50, 240, null);
        HBox layoutTituloYSeleccionador = new HBox(10, new LayoutTitulo("Algoritmo"), seleccionadorContenedorBloquesVista);
        layoutTituloYSeleccionador.setAlignment(Pos.CENTER_LEFT);
        this.getChildren().addAll(layoutTituloYSeleccionador, scrollPaneVista);
        this.setStyle("-fx-background-color: lightgray;" + "-fx-border-width: 2px;" + "-fx-border-color: lightgray");

        new SeleccionadorContenedorBloques(algoBlocks, scrollPaneVista, seleccionadorContenedorBloquesVista);
    }

    public static void reiniciar(){
        seleccionadorContenedorBloquesVista.reiniciar();
        SeleccionadorContenedorBloques.reiniciar();
    }
}
