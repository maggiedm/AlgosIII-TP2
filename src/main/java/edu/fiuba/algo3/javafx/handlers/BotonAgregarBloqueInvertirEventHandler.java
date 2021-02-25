package edu.fiuba.algo3.javafx.handlers;

import edu.fiuba.algo3.javafx.SeleccionadorBloqueCompuesto;
import edu.fiuba.algo3.modelo.bloque.BloqueInversion;
import javafx.event.ActionEvent;

public class BotonAgregarBloqueInvertirEventHandler extends BotonHandler {
    private final String rutaImagen;

    public BotonAgregarBloqueInvertirEventHandler(String unaRutaImagen) {
        rutaImagen = unaRutaImagen;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        SeleccionadorBloqueCompuesto.agregar(new BloqueInversion(), rutaImagen);
    }
}
