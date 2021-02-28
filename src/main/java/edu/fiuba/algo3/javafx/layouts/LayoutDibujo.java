package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.*;
import edu.fiuba.algo3.modelo.*;
import javafx.animation.*;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import java.util.*;


public class LayoutDibujo extends BorderPane {
    private final Slider velocidad;
    private final Pane hoja = new Pane();
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
        this.setStyle("-fx-border-width: 2px;" + "-fx-border-color: lightgray");
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
        pT.getChildren().addAll(secDibujado.getSecuencia(), secPersonaje.getSecuencia());
        pT.rateProperty().bind(velocidad.valueProperty());
        pT.play();
    }

    private List<Tramo> crearTramos(Dibujo dib) {
        List<Tramo> tramos = new ArrayList<>();
        Tramo tramo = new Tramo(VISIBILIDAD_INICIAL, DIR_INICIAL);

        for (Linea linea: dib.getLineas()) {
            if(!Objects.equals(tramo.getDireccion(), linea.getDireccion())){ //SI DIRECCION CAMBIA
                if(tramo.getTam() != 0){
                    tramos.add(tramo);
                    tramo = new Tramo(tramo.esVisible(), tramo.getDireccion());
                }
                if(!esMovimientoDeLapiz(linea)){
                    tramo.actualizarDireccion(linea.getDireccion());
                }
            }
            if(!esMovimientoDeLapiz(linea) || tramo.esVisible() != linea.esVisible()){
                tramo.agregarDesplazamiento( linea.getOrigen().desplazar((int)hoja.getMinWidth()/2, (int)hoja.getMinHeight()/2),
                        linea.getDestino().desplazar((int)hoja.getMinWidth()/2, (int)hoja.getMinHeight()/2));
                tramo.actualizarVisibilidad(linea.esVisible());
                if(esMovimientoDeLapiz(linea)){
                    tramos.add(tramo);
                    tramo = new Tramo(tramo.esVisible(), tramo.getDireccion());
                }
            }
        }
        if(tramo.getTam() != 0) {
            tramos.add(tramo);
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