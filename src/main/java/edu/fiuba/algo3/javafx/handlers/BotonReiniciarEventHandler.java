package edu.fiuba.algo3.javafx.handlers;

import edu.fiuba.algo3.javafx.SeleccionadorBloqueCompuesto;
import edu.fiuba.algo3.javafx.layouts.LayoutDibujo;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class BotonReiniciarEventHandler extends BotonHandler{
    private final AlgoBlocks algoBlocks;
    private final LayoutDibujo layoutDibujo;
    Button botonEjecutar;

    public BotonReiniciarEventHandler(AlgoBlocks unAlgoBlocks, LayoutDibujo unLayoutDibujo){
        algoBlocks = unAlgoBlocks;
        layoutDibujo = unLayoutDibujo;
    }

    public void activarBoton(Button unBotonEjecutar) { botonEjecutar = unBotonEjecutar; }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        algoBlocks.reiniciar();
        layoutDibujo.reiniciar();
        SeleccionadorBloqueCompuesto.reiniciar();
        botonEjecutar.setDisable(false);
    }

}
