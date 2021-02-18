package edu.fiuba.algo3.javafx;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Vista {
    public static void agregarTitulo(Pane layout, String descripcion){

        Label etiqueta = new Label(descripcion);
        etiqueta.setFont(Font.font(20));
        layout.getChildren().add(etiqueta);
    }
    public static void agregarMarcadorFinal(VBox layout, String descripcion) {
        Rectangle rectangulo = new Rectangle(200, 40);
        rectangulo.setFill(Color.GREY);

        Label etiqueta = new Label(descripcion);

        StackPane mostrador = new StackPane();
        mostrador.getChildren().addAll(rectangulo, etiqueta);

        layout.getChildren().add(mostrador);
    }

    public static HBox crearLayoutContenedorDeBloques(VBox layoutSecuenciaNueva, String descripcion) {
        HBox layoutContenedor = new HBox();

        StackPane mostrador = new StackPane();
        mostrador.getChildren().add(new Label(descripcion));

        layoutContenedor.getChildren().addAll(mostrador, layoutSecuenciaNueva);

        //Borde para separar secuencias de bloques
        layoutContenedor.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 1;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: black;");
        return layoutContenedor;
    }
}
