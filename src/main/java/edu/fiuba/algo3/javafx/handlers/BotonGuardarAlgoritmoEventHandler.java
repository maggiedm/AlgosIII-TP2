package edu.fiuba.algo3.javafx.handlers;

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

    private final AlgoBlocks algoBlocks;
    private final LayoutBloques layoutBloques;

    public BotonGuardarAlgoritmoEventHandler(AlgoBlocks unAlgoBlocks, LayoutBloques unLayoutBloques) {
        algoBlocks = unAlgoBlocks;
        layoutBloques = unLayoutBloques;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        TextField nombre = new TextField();
        Label nombreAlgoritmo = new Label("NombreBloque:");
        Button botonIngresar = new Button("Ingresar");
        Stage stageGuardar = new Stage();
        stageGuardar.setTitle("Guardar como:");
        stageGuardar.setScene(new Scene(new VBox(new HBox(nombreAlgoritmo, nombre), botonIngresar)));
        stageGuardar.show();

        botonIngresar.setOnAction(internalEvent -> {
            super.handle(actionEvent);
            stageGuardar.close();
            layoutBloques.agregarBloquePersonalizado(nombre.getText(), algoBlocks);
        });

    }
}
