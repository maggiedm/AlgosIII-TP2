package edu.fiuba.algo3;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MostradorBloqueSimple {
    public MostradorBloqueSimple(String descripcion, VBox layout){
        Rectangle rectangulo = new Rectangle(200, 80);
        rectangulo.setFill(Color.CYAN);

        Label etiqueta = new Label(descripcion);

        StackPane mostrador = new StackPane();
        mostrador.getChildren().addAll(rectangulo, etiqueta);

        layout.getChildren().add(mostrador);
    }
}
