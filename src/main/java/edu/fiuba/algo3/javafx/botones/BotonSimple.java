package edu.fiuba.algo3.javafx.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BotonSimple extends Button{

    public static Button crearBotonSimple(String rutaImagen, String descripcion, EventHandler<ActionEvent> handler){

        Button boton = new Button("");
        boton.setTooltip(new Tooltip(descripcion));
        boton.setOnAction(handler);

        ImageView imagen = new ImageView("file:" + rutaImagen);
        boton.setGraphic(imagen);

        return boton;
    }
}
