package edu.fiuba.algo3.vista.algoritmo;

import edu.fiuba.algo3.javafx.SeleccionadorContenedorBloques;
import edu.fiuba.algo3.vista.ScrollPaneVista;
import edu.fiuba.algo3.vista.Vista;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.vista.LayoutTitulo;
import javafx.scene.layout.VBox;

public class LayoutAlgoritmo extends VBox {

    public LayoutAlgoritmo(AlgoBlocks algoBlocks, int altura) {
        super();
        VBox contenedor = new VBox(10);
        this.getChildren().addAll(new LayoutTitulo("Algoritmo"), new ScrollPaneVista(altura - 50, 200, contenedor));
        this.setStyle("-fx-background-color: lightgray;" + "-fx-border-width: 2px;" + "-fx-border-color: lightgray");

        VBox contenido = new VBox(10);
        contenedor.getChildren().add(contenido);
        new SeleccionadorContenedorBloques(algoBlocks, contenido);


        Vista.agregarMarcadorFinal(contenedor,"Algoritmo");//Puntero final de Algoritmo

    }

}
