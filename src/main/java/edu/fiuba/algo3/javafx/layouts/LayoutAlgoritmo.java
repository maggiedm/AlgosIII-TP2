package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.SeleccionadorBloqueCompuesto;
import edu.fiuba.algo3.javafx.Vista;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.Algoritmo;
import javafx.scene.layout.VBox;

public class LayoutAlgoritmo {

    public static VBox crear(AlgoBlocks algoBlocks) {

        Algoritmo algoritmo = algoBlocks.getAlgoritmo();

        VBox layoutAlgoritmo = new VBox();

        Vista.agregarTitulo(layoutAlgoritmo,"Algoritmo");

        new SeleccionadorBloqueCompuesto(algoritmo, layoutAlgoritmo);

        Vista.agregarMarcadorFinal(layoutAlgoritmo,"Algoritmo");//Puntero final de Algoritmo

        return layoutAlgoritmo;
    }


}
