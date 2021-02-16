package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonAgregarBloqueEventHandler implements EventHandler<ActionEvent> {

    Bloque bloque;
    AlgoBlocks algoBlocks;
    String nombreBloque;
    VBox algoLista;

    public BotonAgregarBloqueEventHandler(Bloque unBloque, AlgoBlocks unAlgoBlocks, String descripcion, VBox algoritmo){
        bloque = unBloque;
        algoBlocks = unAlgoBlocks;
        nombreBloque = descripcion;
        algoLista = algoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        algoBlocks.agregarBloque(bloque);
        new MostradorBloqueSimple(nombreBloque, algoLista);

    }
}
