package edu.fiuba.algo3.javafx.handlers;

import edu.fiuba.algo3.javafx.layouts.LayoutDibujo;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonEjecutarEventHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final LayoutDibujo layoutDibujo;

    public BotonEjecutarEventHandler(AlgoBlocks unAlgoBlocks, LayoutDibujo unLayoutDibujo){
        algoBlocks = unAlgoBlocks;
        layoutDibujo = unLayoutDibujo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        algoBlocks.ejecutarAlgoritmo();
        layoutDibujo.reiniciar();
        layoutDibujo.graficarMovimientos(algoBlocks.getDibujo());
    }
}
