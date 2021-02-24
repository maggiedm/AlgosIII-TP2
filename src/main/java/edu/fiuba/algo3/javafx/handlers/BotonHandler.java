package edu.fiuba.algo3.javafx.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class BotonHandler implements EventHandler<ActionEvent>  {
    private final AudioClip click = new AudioClip("file:recursos/click.mp3");

    public void handle(ActionEvent actionEvent){
        click.play();
    }
}
