package edu.fiuba.algo3.javafx.handlers;

import edu.fiuba.algo3.javafx.BloquesDisponibles;
import edu.fiuba.algo3.javafx.layouts.LayoutBloques;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonGuardarAlgoritmoEventHandler extends BotonHandler {

    private final BloquesDisponibles bloquesDisponibles;
    private final AlgoBlocks algoBlocks;
    private final LayoutBloques layoutBloques;

    public BotonGuardarAlgoritmoEventHandler(BloquesDisponibles losBloquesDisponibles, AlgoBlocks unAlgoBlocks, LayoutBloques unLayoutBloques) {
        bloquesDisponibles = losBloquesDisponibles;
        algoBlocks = unAlgoBlocks;
        layoutBloques = unLayoutBloques;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        TextField nombre = new TextField();
        Label nombreAlgoritmo = new Label("Guardar como:");
        Button botonIngresar = new Button("Ingresar");
        Stage stage2 = new Stage();
        stage2.setScene(new Scene(new VBox(new HBox(nombreAlgoritmo, nombre), botonIngresar)));
        stage2.show();

        botonIngresar.setOnAction(internalEvent -> {
            super.handle(actionEvent);
            stage2.close();
            bloquesDisponibles.agregarBloquePersonalizado(nombre.getText(), algoBlocks, layoutBloques);
        });

    }
}
