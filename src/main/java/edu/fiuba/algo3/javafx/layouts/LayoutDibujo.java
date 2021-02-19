package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.Tramo;
import edu.fiuba.algo3.javafx.Vista;
import edu.fiuba.algo3.modelo.*;
import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.paint.Color.*;

public class LayoutDibujo extends Pane {
    Canvas canvas;

    public LayoutDibujo(double w, double h){
        super.setMinSize(w, h-30);
        Vista.agregarTitulo(this, "Dibujo");
    }

    public void graficarMovimientos(Dibujo dib) { //Por ahora no grafica movimientos de lapiz solos
        canvas = new Canvas(this.getMinWidth()*2,this.getMinHeight()*2);

        Image imgLapizAbajo = new Image("https://slack-imgs.com/?c=1&o1=ro&url=https%3A%2F%2Fi.ibb.co%2FFH5Tnyt%2FAvatar.png");
        Image imgLapizArriba = new Image("https://i.ibb.co/tPh04RJ/Avatar-Lapiz-Alto.png");

        ImageView personaje = new ImageView();
        personaje.setX(this.getMinWidth()/2);
        personaje.setY(this.getMinHeight()/2);

        personaje.setImage(imgLapizArriba);
        List<Tramo> tramos = crearTramos(dib);

        SequentialTransition secDibujo = new SequentialTransition();
        SequentialTransition secPersonaje = new SequentialTransition();
        for (Tramo tramo : tramos) {
            if(tramo.esVisible){
                secDibujo.getChildren().add(crearAnimacionTramos(tramo.tramo, Duration.seconds(tramo.tamano)));
                secPersonaje.getChildren().add(TransicionLapiz(personaje, imgLapizAbajo));
            }else{
                secDibujo.getChildren().add(new PauseTransition(Duration.seconds(tramo.tamano)));
                secPersonaje.getChildren().add(TransicionLapiz(personaje, imgLapizArriba));
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
        boolean visibilidad = false;
        if(!dib.getLineas().isEmpty()){
            visibilidad = dib.lineaEsVisible(0);
        }
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
        if(!camino.getElements().isEmpty()) {
            tramos.add(new Tramo(camino, visibilidad, tam));
        }

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
                //sumo para que el trazo se dibuje en la punta del lapiz
                int x = (int)lapiz.getTranslateX() + 13;
                int y = (int)lapiz.getTranslateY() + 19;

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

    private SequentialTransition TransicionLapiz(ImageView personaje, Image condicionLapiz){

        FadeTransition fadeOut = new FadeTransition(Duration.ONE, personaje);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(event -> personaje.setImage(condicionLapiz));

        FadeTransition fadeIn = new FadeTransition(Duration.ONE, personaje);
        fadeIn.setToValue(1);

        return new SequentialTransition(fadeOut, fadeIn);
    }

    public void reiniciar(){ this.getChildren().clear();}
}
