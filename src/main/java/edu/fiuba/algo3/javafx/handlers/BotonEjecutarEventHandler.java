package edu.fiuba.algo3.javafx.handlers;

import edu.fiuba.algo3.javafx.layouts.LayoutDibujo;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonEjecutarEventHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final LayoutDibujo layoutDibujo;
    Button botonEjecutar;

    public BotonEjecutarEventHandler(AlgoBlocks unAlgoBlocks, LayoutDibujo unLayoutDibujo){
        algoBlocks = unAlgoBlocks;
        layoutDibujo = unLayoutDibujo;
    }

    public void desactivarBoton(Button unBotonEjecutar) {
        botonEjecutar = unBotonEjecutar;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        algoBlocks.ejecutarAlgoritmo();
        layoutDibujo.reiniciar();
        layoutDibujo.graficarMovimientos(algoBlocks.getDibujo());
        //layoutDibujo.slider.setDisable(true);
        botonEjecutar.setDisable(true);
    }

}
