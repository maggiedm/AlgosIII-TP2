package edu.fiuba.algo3.javafx.handlers;

import edu.fiuba.algo3.javafx.SeleccionadorBloqueCompuesto;
import edu.fiuba.algo3.modelo.bloque.BloqueRepeticion;
import javafx.event.ActionEvent;

public class BotonAgregarBloqueRepeticionDosVecesEventHandler extends BotonHandler {
    private final String rutaImagen;

    public BotonAgregarBloqueRepeticionDosVecesEventHandler(String unaRutaImagen) {
        rutaImagen = unaRutaImagen;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        SeleccionadorBloqueCompuesto.agregar(BloqueRepeticion.repetirDosVeces(), rutaImagen);
    }
}
