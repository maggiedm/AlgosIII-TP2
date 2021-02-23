package edu.fiuba.algo3.javafx;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.util.Duration;

public abstract class Animacion {
    protected String dirActual;
    public SequentialTransition secuencia;
    protected boolean visibilidadActual = false;

    protected Animacion(String dirInicial){
        dirActual = dirInicial;
        secuencia = new SequentialTransition(new PauseTransition(Duration.seconds(1)));
    }

    public void cargarMovimiento(Tramo tramo){
        if(dirActual.equals(tramo.direccion) && (visibilidadActual != tramo.esVisible)){
            transicionCondicionLapiz(tramo);
            visibilidadActual = tramo.esVisible;
        }else{
            transicionMovimiento(tramo);
            dirActual = tramo.direccion;
        }
    }

    private void transicionMovimiento(Tramo tramo){
        if(tramo.esVisible){
            transicionMovimientoVisible(tramo);
        }else{
            transicionMovimientoNoVisible(tramo);
        }
    }
    protected abstract void transicionCondicionLapiz(Tramo tramo);

    protected abstract void transicionMovimientoVisible(Tramo tramo);

    protected abstract void transicionMovimientoNoVisible(Tramo tramo);
}
