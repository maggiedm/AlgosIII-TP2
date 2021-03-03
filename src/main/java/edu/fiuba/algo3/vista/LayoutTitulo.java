package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class LayoutTitulo extends HBox {
    public LayoutTitulo(String titulo){
        this.setPadding(new Insets(10,10,10,10));
        agregarTitulo(this, titulo);
        this.setStyle("-fx-background-color: lightgray");
    }

    private void agregarTitulo(Pane layout, String descripcion){
        Label etiqueta = new Label(descripcion);
        etiqueta.setFont(Font.font(20));
        etiqueta.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #333333;" +
                        "-fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );" +
                        "-fx-alignment: center");
        layout.getChildren().add(etiqueta);
    }
}
