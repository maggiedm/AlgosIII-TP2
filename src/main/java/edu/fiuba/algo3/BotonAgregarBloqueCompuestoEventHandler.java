package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.event.ActionEvent;

public class BotonAgregarBloqueCompuestoEventHandler extends BotonAgregarBloqueEventHandler{
    public BotonAgregarBloqueCompuestoEventHandler(Bloque unBloque) {
        super(unBloque);
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        SeleccionadorBloqueCompuesto.agregar(bloque);
    }
}
