package edu.fiuba.algo3.javafx.handlers;

import edu.fiuba.algo3.javafx.SeleccionadorBloqueCompuesto;
import edu.fiuba.algo3.modelo.bloque.BloqueRepeticion;
import javafx.event.ActionEvent;

public class BotonAgregarBloqueRepeticionTresVecesEventHandler extends BotonHandler {
    private final String rutaImagen;

    public BotonAgregarBloqueRepeticionTresVecesEventHandler(String unaRutaImagen) {
        rutaImagen = unaRutaImagen;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        SeleccionadorBloqueCompuesto.agregar(BloqueRepeticion.repetirTresVeces(), rutaImagen);
    }
}
