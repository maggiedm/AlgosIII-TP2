package edu.fiuba.algo3.javafx.handlers;

import edu.fiuba.algo3.javafx.SeleccionadorBloqueCompuesto;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAgregarBloqueEventHandler implements EventHandler<ActionEvent> {
    private final Bloque bloque;
    private final String rutaImagen;

    public BotonAgregarBloqueEventHandler(Bloque unBloque, String unaRutaImagen){
        bloque = unBloque;
        rutaImagen = unaRutaImagen;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        SeleccionadorBloqueCompuesto.bloqueActual().agregarBloque(bloque, rutaImagen);
    }
}

