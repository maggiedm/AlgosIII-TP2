package edu.fiuba.algo3.javafx.bloques;

import edu.fiuba.algo3.javafx.bloques.BloqueDisponible;
import edu.fiuba.algo3.javafx.botones.BotonSimple;
import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueRepeticionTresVecesEventHandler;
import javafx.scene.layout.VBox;

public class BloqueRepetirTresVecesDisponible implements BloqueDisponible {

    private final String descripcion;
    private final String rutaImagen;

    public BloqueRepetirTresVecesDisponible(String unaDescripcion, String unaRutaImagen) {
        descripcion = unaDescripcion;
        rutaImagen = unaRutaImagen;
    }

    public void agregarBoton(VBox layout) {
        layout.getChildren().add(
                BotonSimple.crearBotonSimple(rutaImagen, descripcion, new BotonAgregarBloqueRepeticionTresVecesEventHandler(rutaImagen))
        );
    }
}