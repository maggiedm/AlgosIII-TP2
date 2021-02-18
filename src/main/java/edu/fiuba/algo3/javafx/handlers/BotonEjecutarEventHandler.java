package edu.fiuba.algo3.javafx.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonEjecutarEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Ejecutar algoritmo.");
    }
}
