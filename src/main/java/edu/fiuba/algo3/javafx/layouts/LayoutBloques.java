package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.BloquesDisponibles;
import edu.fiuba.algo3.javafx.Vista;
import edu.fiuba.algo3.javafx.botones.BotonSimple;
import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueEventHandler;
import edu.fiuba.algo3.modelo.bloque.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class LayoutBloques extends VBox{

    static VBox contenido;

    public LayoutBloques(double altura, BloquesDisponibles bloquesDisponibles) {

        contenido = new VBox(10);
        ScrollPane sP = new ScrollPane(contenido);
        sP.setPrefViewportHeight(altura*3/4);
        sP.setMinViewportWidth(150);

        Vista.agregarTitulo(this, "Bloques");
        this.getChildren().add(sP);

        bloquesDisponibles.agregarBotones(contenido);
    }



}
