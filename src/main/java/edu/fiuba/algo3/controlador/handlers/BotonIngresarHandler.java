package edu.fiuba.algo3.controlador.handlers;

import edu.fiuba.algo3.vista.bloques.LayoutBloques;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class BotonIngresarHandler extends BotonHandler{
    Stage escenarioGuardar;
    String nombreBloque;
    AlgoBlocks algoBlocks;
    LayoutBloques layoutBloques;

    public BotonIngresarHandler(Stage unEscenario, String unNombre, AlgoBlocks unAlgoblocks, LayoutBloques unLayoutBloques){
        escenarioGuardar = unEscenario;
        nombreBloque = unNombre;
        algoBlocks = unAlgoblocks;
        layoutBloques = unLayoutBloques;
    }

    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        escenarioGuardar.close();
        layoutBloques.agregarBloquePersonalizado(nombreBloque, algoBlocks);
    }
}