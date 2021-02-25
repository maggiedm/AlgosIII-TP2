package edu.fiuba.algo3.javafx;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.HashMap;

public class AnimacionCaminoPersonaje extends AnimacionCamino {

    private final ImageView personaje = new ImageView();
    static final String RUTA_IMAGENES = "recursos/personaje/";
    private final HashMap<String, Image> imgDirLapizArriba = imagenesDireccionPersonaje(
            "lArr");
    private final HashMap<String, Image> imgDirLapizAbajo = imagenesDireccionPersonaje(
            "Lab");


    public AnimacionCaminoPersonaje(double posX, double posY, String dirInicial, boolean visibilidadInicial){
        super(dirInicial, visibilidadInicial);
        personaje.setX(posX);
        personaje.setY(posY);
        personaje.setImage(imgDirLapizAbajo.get(dirInicial));
    }

    public void agregarAlLayout(Pane unLayout){unLayout.getChildren().add(personaje);}

    protected void transicionCondicionLapiz(Tramo tramo){
        if(tramo.esVisible()) {
            secuencia.getChildren().add(transicionImagenCondicionLapiz(imgDirLapizAbajo.get(tramo.getDireccion())));
        }else{
            secuencia.getChildren().add(transicionImagenCondicionLapiz(imgDirLapizArriba.get(tramo.getDireccion())));
        }
        secuencia.getChildren().add(new PauseTransition(Duration.seconds(1)));
    }

    protected void transicionMovimientoVisible(Tramo tramo){
        secuencia.getChildren().add(transicionImagenCondicionLapiz(imgDirLapizAbajo.get(tramo.getDireccion())));
        secuencia.getChildren().add(new PathTransition(Duration.seconds(tramo.getTam()), tramo.getCamino(), personaje));
    }

    protected void transicionMovimientoNoVisible(Tramo tramo){
        secuencia.getChildren().add(transicionImagenCondicionLapiz(imgDirLapizArriba.get(tramo.getDireccion())));
        secuencia.getChildren().add(new PathTransition(Duration.seconds(tramo.getTam()), tramo.getCamino(), personaje));
    }

    protected SequentialTransition transicionImagenCondicionLapiz(Image condicionLapiz){
        FadeTransition fadeOut = new FadeTransition(Duration.ONE, personaje);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(event -> personaje.setImage(condicionLapiz));

        FadeTransition fadeIn = new FadeTransition(Duration.ONE, personaje);
        fadeIn.setToValue(1);

        return new SequentialTransition(fadeOut, fadeIn);
    }

    private HashMap<String, Image> imagenesDireccionPersonaje(String condicionLapiz){
        HashMap<String, Image> hash = new HashMap<>();

        hash.put("Arriba", new Image("file:" + RUTA_IMAGENES + "Arr" + condicionLapiz + ".png"));
        hash.put("Abajo", new Image("file:" + RUTA_IMAGENES + "Ab" + condicionLapiz + ".png"));
        hash.put("Derecha", new Image("file:" + RUTA_IMAGENES + "Der" + condicionLapiz + ".png"));
        hash.put("Izquierda", new Image("file:" + RUTA_IMAGENES + "Izq" + condicionLapiz + ".png"));

        return hash;
    }
}