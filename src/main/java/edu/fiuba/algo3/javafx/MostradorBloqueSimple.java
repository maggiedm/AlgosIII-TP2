package edu.fiuba.algo3.javafx;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MostradorBloqueSimple {
    public MostradorBloqueSimple(String rutaImagen, VBox layout){
        ImageView imagen = new ImageView("file:" + rutaImagen);

        layout.getChildren().add((layout.getChildren().size() - 1), imagen); //Agregar antes del marcador y checkbox
    }
}
