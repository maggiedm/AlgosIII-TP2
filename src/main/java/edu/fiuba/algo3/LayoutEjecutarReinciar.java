package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LayoutEjecutarReinciar {
    public static HBox crear(VBox layoutAlgoritmo){

        HBox layoutEjecutarReiniciar = new HBox();
        layoutEjecutarReiniciar.setSpacing(10);

        new BotonEjecutar(
                layoutEjecutarReiniciar,
                new ImageView("https://i.ibb.co/Y4SfCB6/BTN-Ejecutar.png"),
                new Tooltip("Ejecutar el algoritmo."));

        new BotonReiniciar(
                layoutEjecutarReiniciar,
                new ImageView("https://i.ibb.co/jb3hrQ9/BTN-Reiniciar.png"),
                new Tooltip("Reiniciar el algoritmo."));

        return layoutEjecutarReiniciar;
    }
}
