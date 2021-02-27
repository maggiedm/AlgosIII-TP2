package edu.fiuba.algo3.javafx.bloquesDisponibles;

import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueRepeticionDosVecesEventHandler;
import javafx.scene.layout.VBox;

public class BloqueRepetirDosVecesDisponible extends BloqueCompuestoDisponible{

    public BloqueRepetirDosVecesDisponible(String unaDescripcion, String unaRutaImagen) {
        super(unaDescripcion, unaRutaImagen);
    }

    public void agregarBoton(VBox layout) {
        super.agregarBoton(layout, new BotonAgregarBloqueRepeticionDosVecesEventHandler(rutaImagen));
    }
}
