package edu.fiuba.algo3.controlador.handlers;

import edu.fiuba.algo3.javafx.SeleccionadorContenedorBloques;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.event.ActionEvent;

public class BotonAgregarBloqueSimpleEventHandler extends BotonAgregarBloqueEventHandler{

    public BotonAgregarBloqueSimpleEventHandler(Bloque unBloque, String unaRutaImagen){
        super(unBloque, unaRutaImagen);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        SeleccionadorContenedorBloques.layoutContenedorBloqueActual().agregarBloque(bloque, rutaImagen);
    }
}

