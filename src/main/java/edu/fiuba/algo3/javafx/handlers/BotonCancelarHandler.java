package edu.fiuba.algo3.javafx.handlers;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class BotonCancelarHandler extends BotonHandler{
    Stage escenario;

    public BotonCancelarHandler(Stage unEscenario){
        escenario = unEscenario;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        escenario.close();
    }
}
