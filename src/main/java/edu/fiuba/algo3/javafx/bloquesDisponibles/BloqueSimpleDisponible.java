package edu.fiuba.algo3.javafx.bloquesDisponibles;

import edu.fiuba.algo3.javafx.botones.BotonSimple;
import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueSimpleEventHandler;
import edu.fiuba.algo3.modelo.bloque.BloqueSimple;
import javafx.scene.layout.VBox;

public class BloqueSimpleDisponible  extends BloqueDisponible {

    public BloqueSimpleDisponible(BloqueSimple unBloque, String unaDescripcion, String unaRutaImagen){
        super(unBloque, unaDescripcion, unaRutaImagen);
    }

    public void agregarBoton(VBox layout) {
        layout.getChildren().add(
                new BotonSimple(rutaImagen, descripcion, new BotonAgregarBloqueSimpleEventHandler(bloque, rutaImagen))
        );
    }
}
