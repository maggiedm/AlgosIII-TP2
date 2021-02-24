package edu.fiuba.algo3.javafx.handlers;

import edu.fiuba.algo3.javafx.SeleccionadorBloqueCompuesto;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.event.ActionEvent;

public class BotonAgregarBloqueEventHandler extends BotonHandler{
    private final Bloque bloque;
    private final String rutaImagen;

    public BotonAgregarBloqueEventHandler(Bloque unBloque, String unaRutaImagen){
        bloque = unBloque;
        rutaImagen = unaRutaImagen;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        SeleccionadorBloqueCompuesto.bloqueActual().agregarBloque(bloque, rutaImagen);
    }
}

