package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.SeleccionadorBloqueCompuesto;
import edu.fiuba.algo3.javafx.Vista;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.Algoritmo;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class LayoutAlgoritmo {

    public static VBox crear(AlgoBlocks algoBlocks, double altura) {

        Algoritmo algoritmo = algoBlocks.getAlgoritmo();

        VBox layoutAlgoritmo = new VBox();
        VBox contenido = new VBox(10);
        ScrollPane sP = new ScrollPane(contenido);
        sP.setMinViewportWidth(200);
        sP.setPrefViewportHeight(altura*3/4);
        Vista.agregarTitulo(layoutAlgoritmo,"Algoritmo");
        layoutAlgoritmo.getChildren().add(sP);

        new SeleccionadorBloqueCompuesto(algoritmo, contenido);

        Vista.agregarMarcadorFinal(contenido,"Algoritmo");//Puntero final de Algoritmo

        return layoutAlgoritmo;
    }


}
