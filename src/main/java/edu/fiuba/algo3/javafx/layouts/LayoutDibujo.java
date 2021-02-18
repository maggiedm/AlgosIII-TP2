package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.Tramo;
import edu.fiuba.algo3.modelo.*;
import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.paint.Color.*;

public class LayoutDibujo extends Pane {
    Canvas canvas;

    public LayoutDibujo(int w, int h){
        super.setMinSize(w, h-30);
        Label titulo = new Label("Dibujo");
        titulo.setFont(Font.font(20));
        this.getChildren().add(titulo);
    }

    public void graficarMovimientos(Dibujo dib) { //Por ahora no grafica movimientos de lapiz solos

        canvas = new Canvas(this.getMinWidth()*2,this.getMinHeight()*2);

        Circle personaje = new Circle(0, 0, 4, RED); //ROJO == Lapiz esta arriba
                                                                        // VERDE == Lapiz esta abajo
        List<Tramo> tramos = crearTramos(dib);

        SequentialTransition secDibujo = new SequentialTransition();
        SequentialTransition secPersonaje = new SequentialTransition();
        for (Tramo tramo : tramos) {
            if(tramo.esVisible){
                secDibujo.getChildren().add(crearAnimacionTramos(tramo.tramo, Duration.seconds(tramo.tamano)));
                secPersonaje.getChildren().add(new FillTransition(Duration.ONE, personaje, RED, GREEN));
            }else{
                secDibujo.getChildren().add(new PauseTransition(Duration.seconds(tramo.tamano)));
                secPersonaje.getChildren().add(new FillTransition(Duration.ONE, personaje, GREEN, RED));
            }
            secPersonaje.getChildren().add(new PathTransition(Duration.seconds(tramo.tamano), tramo.tramo, personaje));
        }
        this.getChildren().addAll(canvas, personaje);

        ParallelTransition pT = new ParallelTransition();
        pT.getChildren().addAll(secDibujo, secPersonaje);
        pT.play();
    }

    private List<Tramo> crearTramos(Dibujo dib) {

        List<Tramo> tramos = new ArrayList<>();

        Path camino = new Path();

        camino.setStroke(RED);
        camino.setStrokeWidth(5);
        boolean visibilidad = dib.lineaEsVisible(0);
        int tam = 0;

        for (Linea linea: dib.getLineas()) {
            if(visibilidad != linea.esVisible()){
                tramos.add(new Tramo (camino, visibilidad, tam));
                camino = new Path();
                visibilidad = linea.esVisible();
                tam = 0;
            }
            if(camino.getElements().isEmpty()){
                camino.getElements().add(new MoveTo(linea.getOrigen().getX()+this.getMinWidth()/2, linea.getOrigen().getY()+this.getMinHeight()/2));
            }
            camino.getElements().add(new LineTo(linea.getDestino().getX()+this.getMinWidth()/2, linea.getDestino().getY()+this.getMinHeight()/2));
            tam++;
        }
        tramos.add(new Tramo(camino, visibilidad, tam));

        return tramos;
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

                int x = (int)lapiz.getTranslateX();
                int y = (int)lapiz.getTranslateY();

                if( origen == null) {
                    origen = new Posicion(x, y);
                    return;
                }
                gc.setStroke(Color.BLACK);
                gc.setFill(Color.BLUE);
                gc.setLineWidth(2);
                gc.strokeLine(origen.getX(), origen.getY(), x, y);

                origen = new Posicion(x, y);
            }
        });

        return transicionCamino;
    }
}
