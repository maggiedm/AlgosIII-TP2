package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.botones.BotonSimple;
import edu.fiuba.algo3.javafx.handlers.BotonEjecutarEventHandler;
import edu.fiuba.algo3.javafx.handlers.BotonReiniciarEventHandler;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class LayoutEjecutarReiniciar {
    public static HBox crear(AlgoBlocks algoBlocks, LayoutDibujo layoutDibujo){

        HBox layoutEjecutarReiniciar = new HBox();
        layoutEjecutarReiniciar.setSpacing(10);

        BotonEjecutarEventHandler handlerEjecutar = new BotonEjecutarEventHandler(algoBlocks, layoutDibujo);
        BotonReiniciarEventHandler handlerReiniciar = new BotonReiniciarEventHandler(algoBlocks, layoutDibujo);
        Button botonEjecutar = BotonSimple.crearBotonSimple(
                new ImageView("https://i.ibb.co/Y4SfCB6/BTN-Ejecutar.png"),
                new Tooltip("Ejecutar el algoritmo."),
                handlerEjecutar
        );
        Button botonReiniciar = BotonSimple.crearBotonSimple(
                new ImageView("https://i.ibb.co/jb3hrQ9/BTN-Reiniciar.png"),
                new Tooltip("Reiniciar el algoritmo."),
                handlerReiniciar
        );

        handlerEjecutar.desactivarBoton(botonEjecutar);
        handlerReiniciar.activarBoton(botonEjecutar);

        layoutEjecutarReiniciar.getChildren().addAll(botonEjecutar, botonReiniciar);
        return layoutEjecutarReiniciar;
    }
}
