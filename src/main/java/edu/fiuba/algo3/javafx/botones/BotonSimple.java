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

        Image image = null;
        try {
            image = new Image(new FileInputStream(rutaImagen));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView(image);

        Button boton = new Button("");
        boton.setTooltip(new Tooltip(descripcion));
        boton.setOnAction(handler);
        boton.setGraphic(imageView);

        return boton;
    }
}
