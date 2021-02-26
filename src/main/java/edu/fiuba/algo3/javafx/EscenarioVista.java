package edu.fiuba.algo3.javafx;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EscenarioVista{

    public EscenarioVista(Stage unEscenario,Pane unLayout, String unTitulo){
        unEscenario.setTitle(unTitulo);
        unEscenario.getIcons().add(new Image("file:recursos/imagenes/Logo.png"));
        unEscenario.setScene(new Scene(unLayout));
        unEscenario.setResizable(false);
    }
}
