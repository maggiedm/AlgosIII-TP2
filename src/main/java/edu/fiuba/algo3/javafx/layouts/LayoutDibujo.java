package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.Tramo;
import edu.fiuba.algo3.javafx.Vista;
import edu.fiuba.algo3.modelo.*;
import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.util.*;

import static javafx.scene.paint.Color.*;


public class LayoutDibujo extends Pane {
    private Canvas canvas;
    public Slider slider;
    private final HBox hBox;
    static final private String DIR_INICIAL = "Derecha";
    HashMap<String, Image> imgDirLapizArriba = imgDirLapizAbajo = imagenesDireccionPersonaje("https://i.ibb.co/5cGnqmn/ArrLarr.png",
            "https://i.ibb.co/HpgJ4P8/AbLarr.png",
            "https://i.ibb.co/4ZNQrHW/DerLarr.png",
            "https://i.ibb.co/cQNQczb/IzqLarr.png");
    HashMap<String, Image> imgDirLapizAbajo = imagenesDireccionPersonaje("https://i.ibb.co/hFZcDW6/ArrLab.png",
            "https://i.ibb.co/6WvbdxD/AbLab.png",
            "https://i.ibb.co/GspbQb9/DerLab.png",
            "https://i.ibb.co/b6yCRvp/IzqLab.png");

    public LayoutDibujo(double w, double h){
        super.setMinSize(w, h-30);
        hBox = new HBox();
        Vista.agregarTitulo(hBox, "Dibujo");
        this.slider = new Slider(0.25, 4, 1);
        hBox.setSpacing(w-50);
        hBox.getChildren().add(slider);
        this.getChildren().add(hBox);
    }

    public void graficarMovimientos(Dibujo dib) {

        canvas = new Canvas(this.getMinWidth(),this.getMinHeight());

        ImageView personaje = new ImageView();
        personaje.setX(this.getMinWidth()/2);
        personaje.setY(this.getMinHeight()/2);
        personaje.setImage(imgDirLapizArriba.get(DIR_INICIAL));

        List<Tramo> tramos = crearTramos(dib);
        String dirActual = DIR_INICIAL;
        boolean visibilidadActual = false;

        SequentialTransition secDibujo = new SequentialTransition(new PauseTransition(Duration.seconds(1)));
        SequentialTransition secPersonaje = new SequentialTransition(new PauseTransition(Duration.seconds(1)));

        for (Tramo tramo : tramos) {
            if(dirActual.equals(tramo.direccion) && (visibilidadActual != tramo.esVisible)){
                transicionCondicionLapiz(secDibujo, secPersonaje, tramo, personaje);
                visibilidadActual = tramo.esVisible;
            }else{
                transicionMovimiento(secDibujo, secPersonaje, tramo, personaje);
                dirActual = tramo.direccion;
            }
        }
        this.getChildren().addAll(canvas, personaje);

        ParallelTransition pT = new ParallelTransition();
        pT.getChildren().addAll(secDibujo, secPersonaje);
        slider.valueProperty().addListener(
                (observable, oldValue, newValue) -> pT.setRate((Double) newValue));
        pT.play();
    }

    private List<Tramo> crearTramos(Dibujo dib) {

        List<Tramo> tramos = new ArrayList<>();

        Path camino = new Path();
        String direccion = DIR_INICIAL;
        boolean visibilidad = false;
        int tam = 0;

        if(!dib.getLineas().isEmpty()){
            if(dib.getLineas().get(0).getDireccion() != null){
                direccion = dib.getLineas().get(0).getDireccion();
            }
        }
        for (Linea linea: dib.getLineas()) {
            if(!Objects.equals(direccion, linea.getDireccion())){ //SI DIRECCION CAMBIA
                if(!camino.getElements().isEmpty()){    //SI EL CAMINO NO ESTA VACIO
                    tramos.add(new Tramo(camino, visibilidad, tam, direccion));
                    camino = new Path();
                    tam = 0;
                }
                if(linea.getDireccion() != null){ //SI NO ES MOVIMIENTO DE LAPIZ
                    direccion = linea.getDireccion();   //ACTUALIZO DIRECCION TRAMO
                }
            }
            if(linea.getDireccion() != null || visibilidad != linea.esVisible()){   //SI NO ES MOVIMIENTO DE LAPIZ O VISIBILIDAD CAMBIA
                if(camino.getElements().isEmpty()){ //MUEVO A ORIGEN LINEA
                    camino.getElements().add(new MoveTo(linea.getOrigen().getX()+this.getMinWidth()/2, linea.getOrigen().getY()+this.getMinHeight()/2));
                }
                camino.getElements().add(new LineTo(linea.getDestino().getX()+this.getMinWidth()/2, linea.getDestino().getY()+this.getMinHeight()/2));  //TRAZO UNA LINEA AL DESTINO
                tam++;
                visibilidad = linea.esVisible();
                if(linea.getDireccion() == null){   //SI ES MOVIMIENTO DE LAPIZ
                    tramos.add(new Tramo(camino, visibilidad, tam, direccion));
                    camino = new Path();
                    tam = 0;
                }
            }
        }
        if(!camino.getElements().isEmpty()) {
            tramos.add(new Tramo(camino, visibilidad, tam, direccion));
        }

        return tramos;
    }

    private void transicionCondicionLapiz(SequentialTransition secDibujo, SequentialTransition secPersonaje, Tramo tramo, ImageView personaje){
        if(tramo.esVisible) {
            secPersonaje.getChildren().add(transicionLapiz(personaje, imgDirLapizAbajo.get(tramo.direccion)));
        }else{
            secPersonaje.getChildren().add(transicionLapiz(personaje, imgDirLapizArriba.get(tramo.direccion)));
        }
        secPersonaje.getChildren().add(new PauseTransition(Duration.seconds(1)));
        secDibujo.getChildren().add(new PauseTransition(Duration.seconds(1)));
    }

    private void transicionMovimiento(SequentialTransition secDibujo, SequentialTransition secPersonaje, Tramo tramo, ImageView personaje){
        if(tramo.esVisible){
            secDibujo.getChildren().add(crearAnimacionTramos(tramo.tramo, Duration.seconds(tramo.tam)));
            secPersonaje.getChildren().add(transicionLapiz(personaje, imgDirLapizAbajo.get(tramo.direccion)));
        }else{
            secDibujo.getChildren().add(new PauseTransition(Duration.seconds(tramo.tam)));
            secPersonaje.getChildren().add(transicionLapiz(personaje, imgDirLapizArriba.get(tramo.direccion)));
        }
        secPersonaje.getChildren().add(new PathTransition(Duration.seconds(tramo.tam), tramo.tramo, personaje));
    }

    private SequentialTransition transicionLapiz(ImageView personaje, Image condicionLapiz){

        FadeTransition fadeOut = new FadeTransition(Duration.ONE, personaje);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(event -> personaje.setImage(condicionLapiz));

        FadeTransition fadeIn = new FadeTransition(Duration.ONE, personaje);
        fadeIn.setToValue(1);

        return new SequentialTransition(fadeOut, fadeIn);
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

    private HashMap<String, Image> imagenesDireccionPersonaje(String urlImgArriba, String urlImgAbajo, String urlImgDer, String urlImgIzq){
        HashMap<String, Image> hash = new HashMap<>();

        hash.put("Arriba", new Image(urlImgArriba));
        hash.put("Abajo", new Image(urlImgAbajo));
        hash.put("Derecha", new Image(urlImgDer));
        hash.put("Izquierda", new Image(urlImgIzq));

        return hash;
    }

    public void reiniciar(){ this.getChildren().clear();
    this.getChildren().add(hBox);}

}
