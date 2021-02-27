package edu.fiuba.algo3.javafx.bloquesDisponibles;
import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueInvertirEventHandler;
import javafx.scene.layout.VBox;

public class BloqueInvertirDisponible extends BloqueCompuestoDisponible{

    public BloqueInvertirDisponible(String unaDescripcion, String unaRutaImagen) {
        super(unaDescripcion, unaRutaImagen);
    }

    public void agregarBoton(VBox layout) {
        super.agregarBoton(layout, new BotonAgregarBloqueInvertirEventHandler(rutaImagen));
    }
}
