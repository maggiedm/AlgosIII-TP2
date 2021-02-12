package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAgregarBloqueEventHandler implements EventHandler<ActionEvent> {

    Bloque bloque;
    AlgoBlocks algoBlocks;

    public BotonAgregarBloqueEventHandler(Bloque unBloque, AlgoBlocks unAlgoBlocks){
        bloque = unBloque;
        algoBlocks = unAlgoBlocks;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        algoBlocks.agregarBloque(bloque);

    }
}
