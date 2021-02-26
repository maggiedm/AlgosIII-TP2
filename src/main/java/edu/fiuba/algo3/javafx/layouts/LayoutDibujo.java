package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.*;
import edu.fiuba.algo3.modelo.*;
import javafx.animation.*;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import java.util.*;


public class LayoutDibujo extends BorderPane {
    private final Pane hoja = new Pane();
    public Slider velocidad;
    static final private String DIR_INICIAL = "Derecha";
    static final private boolean VISIBILIDAD_INICIAL = true;

    public LayoutDibujo(double w, double h){
        LayoutTitulo layoutTitulo = new LayoutTitulo("Dibujo");
        //LAYOUT SLIDER
        LayoutSlider layoutSlider = new LayoutSlider();
        velocidad = layoutSlider.getSlider();
        //THIS
        this.setCenter(hoja);
        this.setTop(layoutTitulo);
        this.setBottom(layoutSlider);
        hoja.setMinSize(w-20, h-105);
    }

    public void graficarMovimientos(Dibujo dib) {

        AnimacionCaminoPersonaje secPersonaje = new AnimacionCaminoPersonaje(hoja.getMinWidth()/2, hoja.getMinHeight()/2, DIR_INICIAL, VISIBILIDAD_INICIAL);
        AnimacionCaminoDibujado secDibujado = new AnimacionCaminoDibujado(hoja.getMinWidth(), hoja.getMinHeight(), DIR_INICIAL, VISIBILIDAD_INICIAL);

        List<Tramo> tramos = crearTramos(dib);

        for (Tramo tramo : tramos) {
            secPersonaje.cargarMovimiento(tramo);
            secDibujado.cargarMovimiento(tramo);
        }
        secDibujado.agregarAlLayout(hoja);
        secPersonaje.agregarAlLayout(hoja);

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
                    camino.getElements().add(new MoveTo(linea.getOrigen().getX()+ hoja.getMinWidth()/2, linea.getOrigen().getY()+ hoja.getMinHeight()/2));
                }
                camino.getElements().add(new LineTo(linea.getDestino().getX()+ hoja.getMinWidth()/2, linea.getDestino().getY()+ hoja.getMinHeight()/2));  //TRAZO UNA LINEA AL DESTINO
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
        hoja.getChildren().clear();
    }

}