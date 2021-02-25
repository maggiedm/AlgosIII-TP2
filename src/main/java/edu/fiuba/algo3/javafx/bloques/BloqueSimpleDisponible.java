package edu.fiuba.algo3.javafx.bloques;

import edu.fiuba.algo3.javafx.bloques.BloqueDisponible;
import edu.fiuba.algo3.javafx.botones.BotonSimple;
import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueEventHandler;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.scene.layout.VBox;

public class BloqueSimpleDisponible  implements BloqueDisponible {

    private final Bloque bloque;
    private final String descripcion;
    private final String rutaImagen;

    public BloqueSimpleDisponible(Bloque unBloque, String unaDescripcion, String unaRutaImagen){
        bloque = unBloque;
        descripcion = unaDescripcion;
        rutaImagen = unaRutaImagen;
    }

    public void agregarBoton(VBox layout) {
        layout.getChildren().add(
                new BotonSimple(rutaImagen, descripcion, new BotonAgregarBloqueEventHandler(bloque, rutaImagen))
        );
    }
}
