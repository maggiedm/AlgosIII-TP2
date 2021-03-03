package edu.fiuba.algo3.controlador.handlers;

import edu.fiuba.algo3.javafx.AdministradorContenedoresDeBloques;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import edu.fiuba.algo3.modelo.bloque.BloqueContenedor;
import javafx.event.ActionEvent;

public class BotonAgregarBloqueCompuestoEventHandler extends BotonAgregarBloqueEventHandler {

    private final String nombreBloque;

    public BotonAgregarBloqueCompuestoEventHandler(Bloque unBloque, String unaRutaImagen, String unNombreBloque) {
        super(unBloque, unaRutaImagen);
        nombreBloque = unNombreBloque;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        AdministradorContenedoresDeBloques.agregar((BloqueContenedor) bloque.clone(), rutaImagen, nombreBloque);
    }
}
