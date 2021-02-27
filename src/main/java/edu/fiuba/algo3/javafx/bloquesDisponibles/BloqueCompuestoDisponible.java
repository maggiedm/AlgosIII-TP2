package edu.fiuba.algo3.javafx.bloquesDisponibles;

import edu.fiuba.algo3.javafx.botones.BotonSimple;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public abstract class BloqueCompuestoDisponible implements BloqueDisponible{
    private final String descripcion;
    protected final String rutaImagen;

    public BloqueCompuestoDisponible(String unaDescripcion, String unaRutaImagen) {
        descripcion = unaDescripcion;
        rutaImagen = unaRutaImagen;
    }

    public void agregarBoton(VBox layout, EventHandler<ActionEvent> unEventHandler) {
        layout.getChildren().add(
                new BotonSimple(rutaImagen, descripcion, unEventHandler)
        );
    }
}
