package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.SeleccionadorBloqueCompuesto;
import edu.fiuba.algo3.javafx.Vista;
import edu.fiuba.algo3.javafx.botones.BotonSimple;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.Algoritmo;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
