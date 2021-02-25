package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.SeleccionadorBloqueCompuesto;
import edu.fiuba.algo3.javafx.Vista;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class LayoutAlgoritmo extends VBox {

    public LayoutAlgoritmo(AlgoBlocks algoBlocks, double altura) {

        super();
        VBox contenedor = new VBox(10);
        ScrollPane sP = new ScrollPane(contenedor);
        sP.setMinViewportWidth(200);
        sP.setPrefViewportHeight(altura*3/4);
        Vista.agregarTitulo(this,"Algoritmo");
        this.getChildren().add(sP);

        VBox contenido = new VBox(10);
        contenedor.getChildren().add(contenido);
        new SeleccionadorBloqueCompuesto(algoBlocks.getAlgoritmo(), contenido);


        Vista.agregarMarcadorFinal(contenedor,"Algoritmo");//Puntero final de Algoritmo

    }

}
