package edu.fiuba.algo3.javafx.bloques;

import edu.fiuba.algo3.javafx.botones.BotonSimple;
import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueInvertirEventHandler;
import javafx.scene.layout.VBox;

public class BloqueInvertirDisponible implements BloqueDisponible {

    private final String descripcion;
    private final String rutaImagen;

    public BloqueInvertirDisponible(String unaDescripcion, String unaRutaImagen) {
        descripcion = unaDescripcion;
        rutaImagen = unaRutaImagen;
    }

    public void agregarBoton(VBox layout) {
        layout.getChildren().add(
                new BotonSimple(rutaImagen, descripcion, new BotonAgregarBloqueInvertirEventHandler(rutaImagen))
        );
    }
}
