package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.javafx.layouts.LayoutBloques;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.*;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BloquesDisponibles {

    private List<BloqueDisponible> bloques = new ArrayList<>();
    static final String RUTA_IMAGENES = "recursos/";


    public BloquesDisponibles() {
        bloques.add(new BloqueDisponible(BloqueMovimiento.bloqueArriba(),
                "Mueve al personaje hacia arriba.",
                RUTA_IMAGENES + "Arriba.png",
                true));

        bloques.add(new BloqueDisponible(BloqueMovimiento.bloqueAbajo(),
                "Mueve al personaje hacia abajo.",
                RUTA_IMAGENES + "Abajo.png",
                true));

        bloques.add(new BloqueDisponible(BloqueMovimiento.bloqueIzquierda(),
                "Mueve al personaje hacia Izquierda.",
                RUTA_IMAGENES + "Izquierda.png",
                true));

        bloques.add(new BloqueDisponible(BloqueMovimiento.bloqueDerecha(),
                "Mueve al personaje hacia derecha.",
                RUTA_IMAGENES + "Derecha.png",
                true));

        bloques.add(new BloqueDisponible(new BloqueBajarLapiz(),
                "Baja el lapiz para que el personaje dibuje.",
                RUTA_IMAGENES + "LapizBajar.png",
                true));

        bloques.add(new BloqueDisponible(new BloqueSubirLapiz(),
                "Sube el lapiz para que el personaje dibuje.",
                RUTA_IMAGENES + "LapizSubir.png",
                true));

        bloques.add(new BloqueDisponible(BloqueRepeticion.repetirDosVeces(),
                "Repite dos veces la secuencia de bloques ingresada.",
                RUTA_IMAGENES + "Repetir2.png",
                false));

        bloques.add(new BloqueDisponible(BloqueRepeticion.repetirTresVeces(),
                "Repite tres veces la secuencia de bloques ingresada.",
                RUTA_IMAGENES + "Repetir3.png",
                false));

        bloques.add(new BloqueDisponible(new BloqueInversion(),
                "Invierte la secuencia de bloques ingresada.",
                RUTA_IMAGENES + "Invertir.png",
                false));
    }

    public void agregarBotones(VBox layoutBloques) {
        bloques.forEach(bloque -> bloque.agregarBoton(layoutBloques));
    }

    private void agregarBotonesBloquesCompuestos(VBox layoutBloques) {
        bloques.forEach(bloque -> bloque.agregarBotonBloqueCompuesto(layoutBloques));
    }

    public void agregarBloquePersonalizado(String nombre, AlgoBlocks algoBlocks, VBox layoutBloques) {
        BloqueDisponible bloque = new BloqueDisponible(algoBlocks.guardarAlgoritmo(),
                nombre,
                RUTA_IMAGENES + "BloquePersonalizado.png",
                true
                );

        bloque.agregarBoton(layoutBloques);
    }

    public void reiniciarBloquesCompuestos(VBox layout) {

        int cantidadBloquesCompuestos = 3; //Si dejamos este metedo, este numero lo tendria que conseguir de otra forma

        //Elimina los botones de BloquesCompuestos y los vuelve a iniciar
        for (int i = 0; i < cantidadBloquesCompuestos; i++) {
            layout.getChildren().remove(layout.getChildren().size()-1);
        }

        //Hay que crear una instancia nueva para que se creen de nuevo los bloques
        BloquesDisponibles bloquesDisponibles = new BloquesDisponibles();
        bloquesDisponibles.agregarBotonesBloquesCompuestos(layout);
    }
}

