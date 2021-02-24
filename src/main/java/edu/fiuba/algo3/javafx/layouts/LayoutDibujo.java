package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.AnimacionCaminoDibujado;
import edu.fiuba.algo3.javafx.AnimacionCaminoPersonaje;
import edu.fiuba.algo3.javafx.Tramo;
import edu.fiuba.algo3.javafx.Vista;
import edu.fiuba.algo3.modelo.*;
import javafx.animation.*;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.shape.*;

import java.util.*;


public class LayoutDibujo extends Pane {
    public Slider slider;
    private final HBox hBox;
    static final private String DIR_INICIAL = "Derecha";
    static final private boolean VISIBILIDAD_INICIAL = true;

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

        AnimacionCaminoPersonaje secPersonaje = new AnimacionCaminoPersonaje(this.getMinWidth()/2, this.getMinHeight()/2, DIR_INICIAL, VISIBILIDAD_INICIAL);
        AnimacionCaminoDibujado secDibujado = new AnimacionCaminoDibujado(this.getMinWidth(),this.getMinHeight(), DIR_INICIAL, VISIBILIDAD_INICIAL);

        List<Tramo> tramos = crearTramos(dib);

        for (Tramo tramo : tramos) {
            secPersonaje.cargarMovimiento(tramo);
            secDibujado.cargarMovimiento(tramo);
        }
        secDibujado.agregarAlLayout(this);
        secPersonaje.agregarAlLayout(this);

        ParallelTransition pT = new ParallelTransition();
        pT.getChildren().addAll(secDibujado.secuencia, secPersonaje.secuencia);
        slider.valueProperty().addListener(
                (observable, oldValue, newValue) -> pT.setRate((Double) newValue));
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
                    camino.getElements().add(new MoveTo(linea.getOrigen().getX()+this.getMinWidth()/2, linea.getOrigen().getY()+this.getMinHeight()/2));
                }
                camino.getElements().add(new LineTo(linea.getDestino().getX()+this.getMinWidth()/2, linea.getDestino().getY()+this.getMinHeight()/2));  //TRAZO UNA LINEA AL DESTINO
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

    public void reiniciar(){ this.getChildren().clear();
    this.getChildren().add(hBox);}

}
