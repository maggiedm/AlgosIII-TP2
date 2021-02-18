package edu.fiuba.algo3.javafx.handlers;

import edu.fiuba.algo3.javafx.SeleccionadorBloqueCompuesto;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonAgregarBloqueCompuestoEventHandler implements EventHandler<ActionEvent> {
    private final Bloque bloque;
    private final VBox layoutBloques;

    public BotonAgregarBloqueCompuestoEventHandler(Bloque unBloque, VBox unLayoutBloques) {
        bloque = unBloque;
        layoutBloques = unLayoutBloques;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        SeleccionadorBloqueCompuesto.agregar(bloque, layoutBloques);
    }
}
