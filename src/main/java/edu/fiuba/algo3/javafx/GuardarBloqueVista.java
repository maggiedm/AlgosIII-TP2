package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.javafx.layouts.LayoutBloques;
import edu.fiuba.algo3.javafx.layouts.LayoutBotonesGuardarCancelar;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuardarBloqueVista {

    public GuardarBloqueVista(AlgoBlocks unAlgoblocks, LayoutBloques unLayoutBloques){
        Stage escenarioGuardar = new Stage();

        TextField ingresoNombre = new TextField();
        Label nombreAlgoritmo = new Label("NombreBloque:");
        nombreAlgoritmo.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 14px");
        new EscenarioVista(escenarioGuardar, new VBox(new HBox(10, nombreAlgoritmo, ingresoNombre),
                new LayoutBotonesGuardarCancelar(unAlgoblocks, unLayoutBloques, ingresoNombre.getText(), escenarioGuardar)), "Guardar como");
        escenarioGuardar.show();
    }
}
