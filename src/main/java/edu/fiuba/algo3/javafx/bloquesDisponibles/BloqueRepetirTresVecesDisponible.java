package edu.fiuba.algo3.javafx.bloquesDisponibles;

import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueRepeticionTresVecesEventHandler;
import javafx.scene.layout.VBox;

public class BloqueRepetirTresVecesDisponible extends BloqueCompuestoDisponible {

    public BloqueRepetirTresVecesDisponible(String unaDescripcion, String unaRutaImagen) {
        super(unaDescripcion, unaRutaImagen);
    }

    public void agregarBoton(VBox layout) {
        super.agregarBoton(layout, new BotonAgregarBloqueRepeticionTresVecesEventHandler(rutaImagen));
    }
}
