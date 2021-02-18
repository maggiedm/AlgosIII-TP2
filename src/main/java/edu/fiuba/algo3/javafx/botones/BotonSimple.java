package edu.fiuba.algo3.javafx.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

public class BotonSimple extends Button{

    public static Button crearBotonSimple(ImageView logo, Tooltip descripcion, EventHandler<ActionEvent> handler){

        Button boton = new Button("", logo);
        boton.setTooltip(descripcion);
        boton.setOnAction(handler);

        return boton;
    }
}
