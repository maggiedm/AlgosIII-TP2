package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.botones.BotonSimple;
import edu.fiuba.algo3.javafx.handlers.BotonEjecutarEventHandler;
import edu.fiuba.algo3.javafx.handlers.BotonReiniciarEventHandler;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class LayoutEjecutarReiniciar extends HBox {

    static final String RUTA_IMAGENES = "recursos/imagenes/botones/";

    public LayoutEjecutarReiniciar(AlgoBlocks algoBlocks, LayoutDibujo layoutDibujo){
        super();
        this.setSpacing(10);

        BotonEjecutarEventHandler handlerEjecutar = new BotonEjecutarEventHandler(algoBlocks, layoutDibujo);
        BotonReiniciarEventHandler handlerReiniciar = new BotonReiniciarEventHandler(algoBlocks, layoutDibujo);
        Button botonEjecutar = new BotonSimple(
                 RUTA_IMAGENES + "Ejecutar.png",
                "Ejecutar el algoritmo.",
                handlerEjecutar
        );
        Button botonReiniciar = new BotonSimple(
                RUTA_IMAGENES + "Reiniciar.png",
                "Reiniciar el algoritmo.",
                handlerReiniciar
        );

        handlerEjecutar.desactivarBoton(botonEjecutar);
        handlerReiniciar.activarBoton(botonEjecutar);

        this.getChildren().addAll(botonEjecutar, botonReiniciar);
    }
}
