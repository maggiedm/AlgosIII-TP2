package edu.fiuba.algo3.javafx.layouts;

import javafx.geometry.Insets;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LayoutSlider extends BorderPane {
    private Slider slider = new Slider(0.25, 4, 1);
    public LayoutSlider(){
        this.setPadding(new Insets(10,10,10,10));
        this.setStyle("-fx-background-color: lightgray");

        BorderPane imgsSlider = new BorderPane();
        imgsSlider.setLeft(new ImageView(new Image("file:recursos/lento.png")));
        imgsSlider.setRight(new ImageView(new Image("file:recursos/rapido.png")));
        this.setRight(new VBox(imgsSlider, slider));
    }

    public Slider getSlider(){return slider;}
}