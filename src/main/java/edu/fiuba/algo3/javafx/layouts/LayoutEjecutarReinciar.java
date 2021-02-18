package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.botones.BotonSimple;
import edu.fiuba.algo3.javafx.handlers.BotonEjecutarEventHandler;
import edu.fiuba.algo3.javafx.handlers.BotonReiniciarEventHandler;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class LayoutEjecutarReinciar {
    public static HBox crear(){

        HBox layoutEjecutarReiniciar = new HBox();
        layoutEjecutarReiniciar.setSpacing(10);

        layoutEjecutarReiniciar.getChildren().addAll(

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/Y4SfCB6/BTN-Ejecutar.png"),
                    new Tooltip("Ejecutar el algoritmo."),
                    new BotonEjecutarEventHandler()
            ),

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/jb3hrQ9/BTN-Reiniciar.png"),
                    new Tooltip("Reiniciar el algoritmo."),
                    new BotonReiniciarEventHandler()
            )
        );
        return layoutEjecutarReiniciar;
    }
}
