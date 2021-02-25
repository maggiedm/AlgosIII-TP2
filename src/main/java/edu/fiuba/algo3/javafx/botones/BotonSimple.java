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

    public BotonSimple(String rutaImagen, String descripcion, EventHandler<ActionEvent> handler){
        super();
        this.setTooltip(new Tooltip(descripcion));
        this.setOnAction(handler);

        ImageView imagen = new ImageView("file:" + rutaImagen);
        this.setGraphic(imagen);
    }
}
