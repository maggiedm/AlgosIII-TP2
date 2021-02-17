package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.Algoritmo;
import javafx.scene.layout.VBox;

public class LayoutAlgoritmo {

    public static VBox crear() {

        Algoritmo algoritmo = new Algoritmo();
        AlgoBlocks algoBlocks = new AlgoBlocks(algoritmo);//se utilizará en ejecutar y guardarAlgoritmo

        VBox layoutAlgoritmo = new VBox();

        Vista.agregarTitulo(layoutAlgoritmo,"Algoritmo");

        new SeleccionadorBloqueCompuesto(algoritmo, layoutAlgoritmo);

        Vista.agregarMarcadorFinal(layoutAlgoritmo,"Algoritmo");//Puntero final de Algoritmo

        return layoutAlgoritmo;
    }


}
