package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.modelo.Posicion;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.io.File;

import static javafx.scene.paint.Color.LIGHTSLATEGREY;

public class AnimacionCaminoDibujado extends AnimacionCamino {
    private final Canvas canvas;
    private final MediaPlayer sonidoLapiz = new MediaPlayer(new Media(new File("recursos/sonidos/sonidoLapiz.mp3").toURI().toString()));

    public AnimacionCaminoDibujado(double w, double h, String dirInicial, boolean visibilidadInicial){
        super(dirInicial, visibilidadInicial);
        sonidoLapiz.setCycleCount(MediaPlayer.INDEFINITE);
        sonidoLapiz.setVolume(0.5);
        this.canvas = new Canvas(w,h);
    }

    protected void transicionCondicionLapiz(Tramo tramo){
        secuencia.getChildren().add(new PauseTransition(Duration.seconds(1)));
    }

    protected void transicionMovimientoVisible(Tramo tramo){
        secuencia.getChildren().get(secuencia.getChildren().size() - 1).setOnFinished(event -> sonidoLapiz.play());
        Animation animacionTramos = crearAnimacionTramos(tramo.getCamino(), Duration.seconds(tramo.getTam()));
        animacionTramos.setOnFinished(event -> sonidoLapiz.stop());
        secuencia.getChildren().add(animacionTramos);
    }

    protected void transicionMovimientoNoVisible(Tramo tramo){
        secuencia.getChildren().add(new PauseTransition(Duration.seconds(tramo.getTam())));
    }

    private Animation crearAnimacionTramos(Path camino, Duration duration) {

        GraphicsContext gc = canvas.getGraphicsContext2D();
        Circle lapiz = new Circle(0, 0, 2);

        PathTransition transicionCamino = new PathTransition( duration, camino, lapiz);
        transicionCamino.currentTimeProperty().addListener( new ChangeListener<>() {

            Posicion origen = null;

            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {

                if( oldValue == Duration.ZERO)
                    return;
                //sumo para que el trazo se dibuje en la punta del lapiz
                int x = (int)lapiz.getTranslateX();
                int y = (int)lapiz.getTranslateY() + 23;

                if( origen == null) {
                    origen = new Posicion(x, y);
                    return;
                }
                gc.setStroke(LIGHTSLATEGREY);
                gc.setFill(Color.BLUE);
                gc.setLineWidth(2);
                gc.strokeLine(origen.getX(), origen.getY(), x, y);

                origen = new Posicion(x, y);
            }
        });

        return transicionCamino;
    }

    public void agregarAlLayout(Pane unLayout){unLayout.getChildren().add(canvas);}
}
