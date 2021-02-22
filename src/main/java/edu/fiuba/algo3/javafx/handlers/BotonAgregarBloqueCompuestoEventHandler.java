package edu.fiuba.algo3.javafx.handlers;

import edu.fiuba.algo3.javafx.SeleccionadorBloqueCompuesto;
import edu.fiuba.algo3.javafx.layouts.LayoutBloques;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonAgregarBloqueCompuestoEventHandler implements EventHandler<ActionEvent> {
    private final Bloque bloque;
    private final LayoutBloques layoutBloques;
    private final String rutaImagen;

    public BotonAgregarBloqueCompuestoEventHandler(Bloque unBloque, String unaRutaImagen, LayoutBloques unLayoutBloques) {
        bloque = unBloque;
        layoutBloques = unLayoutBloques;
        rutaImagen = unaRutaImagen;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        SeleccionadorBloqueCompuesto.agregar(bloque, layoutBloques);
    }
}
