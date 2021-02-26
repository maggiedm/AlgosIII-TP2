package edu.fiuba.algo3.javafx.handlers;

import edu.fiuba.algo3.javafx.GuardarBloqueVista;
import edu.fiuba.algo3.javafx.layouts.LayoutBloques;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.event.ActionEvent;

public class BotonGuardarAlgoritmoEventHandler extends BotonHandler {

    private final AlgoBlocks algoBlocks;
    private final LayoutBloques layoutBloques;

    public BotonGuardarAlgoritmoEventHandler(AlgoBlocks unAlgoBlocks, LayoutBloques unLayoutBloques) {
        algoBlocks = unAlgoBlocks;
        layoutBloques = unLayoutBloques;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        new GuardarBloqueVista(algoBlocks, layoutBloques);
    }
}
