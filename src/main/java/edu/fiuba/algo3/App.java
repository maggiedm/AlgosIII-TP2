package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.BloqueMovimiento;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        VBox layoutBloques = new VBox();
        Scene scene = new Scene(layoutBloques);
        stage.setScene(scene);

        Label etiquetaBloques = new Label();
        etiquetaBloques.setText("Bloques");
        etiquetaBloques.setFont(Font.font(20));
        layoutBloques.getChildren().add(etiquetaBloques);


        Button botonAgregarBloqueMomientoDerecha = new BotonAgregarBloque(
                BloqueMovimiento.bloqueDerecha(),
                "Mover a la Derecha",
                layoutBloques,
                algoBlocks);

        Button botonAgregarBloqueMomientoIzquierda = new BotonAgregarBloque(
                BloqueMovimiento.bloqueIzquierda(),
                "Mover a la Izquierda",
                layoutBloques,
                algoBlocks);


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}