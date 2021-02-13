package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.BloqueMovimiento;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
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

        VBox layoutAlgoritmo = new VBox();
        AlgoBlocks algoBlocks = new AlgoBlocks(layoutAlgoritmo);
        VBox layoutBloques = LayoutBloques.crear(algoBlocks);

        HBox root = new HBox();
        root.setSpacing(100);
        root.getChildren().addAll(layoutBloques,layoutAlgoritmo);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(1000);
        stage.setWidth(1000);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}