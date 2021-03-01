package edu.fiuba.algo3.vista.bloques.bloquesDisponibles;

import edu.fiuba.algo3.vista.bloques.BotonSimple;
import edu.fiuba.algo3.controlador.handlers.BotonAgregarBloqueCompuestoEventHandler;
import edu.fiuba.algo3.modelo.bloque.BloqueContenedor;
import javafx.scene.layout.VBox;

public class BloqueContenedorDisponible extends BloqueDisponible{

    public BloqueContenedorDisponible(BloqueContenedor unBloque, String unaDescripcion, String unaRutaImagen) {
        super(unBloque, unaDescripcion, unaRutaImagen);
    }

    public void agregarBoton(VBox layout) {
        layout.getChildren().add(
                new BotonSimple(rutaImagen, descripcion, new BotonAgregarBloqueCompuestoEventHandler(bloque, rutaImagen)));
    }
}
