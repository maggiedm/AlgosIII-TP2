package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.javafx.bloques.*;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.*;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BloquesDisponibles {

    private final List<BloqueDisponible> bloques = new ArrayList<>();
    static final String RUTA_IMAGENES = "recursos/";


    public BloquesDisponibles() {
        bloques.add(new BloqueSimpleDisponible(BloqueMovimiento.bloqueArriba(),
                "Mueve al personaje hacia arriba.",
                RUTA_IMAGENES + "Arriba.png"));

        bloques.add(new BloqueSimpleDisponible(BloqueMovimiento.bloqueAbajo(),
                "Mueve al personaje hacia abajo.",
                RUTA_IMAGENES + "Abajo.png"));

        bloques.add(new BloqueSimpleDisponible(BloqueMovimiento.bloqueIzquierda(),
                "Mueve al personaje hacia Izquierda.",
                RUTA_IMAGENES + "Izquierda.png"));

        bloques.add(new BloqueSimpleDisponible(BloqueMovimiento.bloqueDerecha(),
                "Mueve al personaje hacia derecha.",
                RUTA_IMAGENES + "Derecha.png"));

        bloques.add(new BloqueSimpleDisponible(new BloqueBajarLapiz(),
                "Baja el lapiz para que el personaje dibuje.",
                RUTA_IMAGENES + "LapizBajar.png"));

        bloques.add(new BloqueSimpleDisponible(new BloqueSubirLapiz(),
                "Sube el lapiz para que el personaje dibuje.",
                RUTA_IMAGENES + "LapizSubir.png"));

        bloques.add(new BloqueRepetirDosVecesDisponible("Repite dos veces la secuencia de bloques ingresada.",
                RUTA_IMAGENES + "Repetir2.png"));

        bloques.add(new BloqueRepetirTresVecesDisponible("Repite tres veces la secuencia de bloques ingresada.",
                RUTA_IMAGENES + "Repetir3.png"));

        bloques.add(new BloqueInvertirDisponible("Invierte la secuencia de bloques ingresada.",
                RUTA_IMAGENES + "Invertir.png"));
    }

    public void agregarBotones(VBox layoutBloques) {
        bloques.forEach(bloque -> bloque.agregarBoton(layoutBloques));
    }

    public void agregarBloquePersonalizado(String nombre, AlgoBlocks algoBlocks, VBox layoutBloques) {
        BloqueSimpleDisponible bloque = new BloqueSimpleDisponible(algoBlocks.guardarAlgoritmo(),
                nombre,
                RUTA_IMAGENES + "BloquePersonalizado.png");

        bloque.agregarBoton(layoutBloques);
    }
}

