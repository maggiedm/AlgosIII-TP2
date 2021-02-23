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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import static javafx.scene.paint.Color.LIGHTSLATEGREY;

public class AnimacionDibujado extends Animacion {
    Canvas canvas;

    public AnimacionDibujado(double w, double h, /*Canvas canvas,*/ String dirInicial){
        super(dirInicial);
        this.canvas = new Canvas(w,h);
    }

    protected void transicionCondicionLapiz(Tramo tramo){
        secuencia.getChildren().add(new PauseTransition(Duration.seconds(1)));
    }

    protected void transicionMovimientoVisible(Tramo tramo){
        secuencia.getChildren().add(crearAnimacionTramos(tramo.tramo, Duration.seconds(tramo.tam)));
    }

    protected void transicionMovimientoNoVisible(Tramo tramo){
        secuencia.getChildren().add(new PauseTransition(Duration.seconds(tramo.tam)));
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
