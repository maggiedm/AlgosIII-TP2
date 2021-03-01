package edu.fiuba.algo3.javafx.handlers;

import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.event.ActionEvent;

public abstract class BotonAgregarBloqueEventHandler extends BotonHandler{
    protected final Bloque bloque;
    protected final String rutaImagen;

    protected BotonAgregarBloqueEventHandler(Bloque unBloque, String unaRutaImagen){
        bloque = unBloque;
        rutaImagen = unaRutaImagen;
    }
    public void handle(ActionEvent actionEvent){
        super.handle(actionEvent);
    }
}
