package edu.fiuba.algo3.javafx.handlers;

import edu.fiuba.algo3.javafx.SeleccionadorBloqueCompuesto;
import edu.fiuba.algo3.javafx.layouts.LayoutAlgoritmo;
import edu.fiuba.algo3.javafx.layouts.LayoutDibujo;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonReiniciarEventHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final LayoutDibujo layoutDibujo;

    public BotonReiniciarEventHandler(AlgoBlocks unAlgoBlocks, LayoutDibujo unLayoutDibujo){
        algoBlocks = unAlgoBlocks;
        layoutDibujo = unLayoutDibujo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        algoBlocks.reiniciar();
        layoutDibujo.reiniciar();
        SeleccionadorBloqueCompuesto.reiniciar();
    }
}
