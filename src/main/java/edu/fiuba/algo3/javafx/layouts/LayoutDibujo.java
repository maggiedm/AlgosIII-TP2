package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.AnimacionCaminoDibujado;
import edu.fiuba.algo3.javafx.AnimacionCaminoPersonaje;
import edu.fiuba.algo3.javafx.Tramo;
import edu.fiuba.algo3.javafx.Vista;
import edu.fiuba.algo3.modelo.*;
import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.util.*;


public class LayoutDibujo extends StackPane {
    private final Pane pane = new Pane();
    public Slider velocidad;
    static final private String DIR_INICIAL = "Derecha";
    static final private boolean VISIBILIDAD_INICIAL = true;

    public LayoutDibujo(double w, double h){
        HBox layoutTitulo = new HBox();
        layoutTitulo.setPadding(new Insets(10,10,10,10));
        Vista.agregarTitulo(layoutTitulo, "Dibujo");
        layoutTitulo.setStyle("-fx-background-color: lightgray");
        //LAYOUT SLIDER
        BorderPane layoutSlider = new BorderPane();
        layoutSlider.setPadding(new Insets(10,10,10,10));
        this.velocidad = new Slider(0.25, 4, 1);
        layoutSlider.setRight(velocidad);
        layoutSlider.setStyle("-fx-background-color: lightgray");
        //PANEL DELANTERO
        BorderPane panelDelantero = new BorderPane();
        panelDelantero.setTop(layoutTitulo);
        panelDelantero.setCenter(pane);
        panelDelantero.setBottom(layoutSlider);
        //THIS
        pane.setMinSize(w-20, h-40);
        this.getChildren().addAll(pane, panelDelantero);
    }

    public void graficarMovimientos(Dibujo dib) {

        AnimacionCaminoPersonaje secPersonaje = new AnimacionCaminoPersonaje(pane.getMinWidth()/2, pane.getMinHeight()/2, DIR_INICIAL, VISIBILIDAD_INICIAL);
        AnimacionCaminoDibujado secDibujado = new AnimacionCaminoDibujado(pane.getMinWidth()*2,pane.getMinHeight()*2, DIR_INICIAL, VISIBILIDAD_INICIAL);

        List<Tramo> tramos = crearTramos(dib);

        for (Tramo tramo : tramos) {
            secPersonaje.cargarMovimiento(tramo);
            secDibujado.cargarMovimiento(tramo);
        }
        secDibujado.agregarAlLayout(pane);
        secPersonaje.agregarAlLayout(pane);

        ParallelTransition pT = new ParallelTransition();
        pT.getChildren().addAll(secDibujado.secuencia, secPersonaje.secuencia);
        pT.rateProperty().bind(velocidad.valueProperty());
        pT.play();
    }

    private List<Tramo> crearTramos(Dibujo dib) {
        List<Tramo> tramos = new ArrayList<>();

        Path camino = new Path();
        String direccion = DIR_INICIAL;
        boolean visibilidad = VISIBILIDAD_INICIAL;
        int tam = 0;

        for (Linea linea: dib.getLineas()) {
            if(!Objects.equals(direccion, linea.getDireccion())){ //SI DIRECCION CAMBIA
                if(!camino.getElements().isEmpty()){    //SI EL CAMINO NO ESTA VACIO
                    tramos.add(new Tramo(camino, visibilidad, tam, direccion));
                    camino = new Path();
                    tam = 0;
                }
                if(!esMovimientoDeLapiz(linea)){
                    direccion = linea.getDireccion();   //ACTUALIZO DIRECCION TRAMO
                }
            }
            if(!esMovimientoDeLapiz(linea) || visibilidad != linea.esVisible()){
                if(camino.getElements().isEmpty()){ //MUEVO A ORIGEN LINEA
                    camino.getElements().add(new MoveTo(linea.getOrigen().getX()+pane.getMinWidth()/2, linea.getOrigen().getY()+pane.getMinHeight()/2));
                }
                camino.getElements().add(new LineTo(linea.getDestino().getX()+pane.getMinWidth()/2, linea.getDestino().getY()+pane.getMinHeight()/2));  //TRAZO UNA LINEA AL DESTINO
                tam++;
                visibilidad = linea.esVisible();
                if(esMovimientoDeLapiz(linea)){
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

    public boolean esMovimientoDeLapiz(Linea linea){
        return linea.getDireccion() == null;
    }

    public void reiniciar(){
        pane.getChildren().clear();
    }

}