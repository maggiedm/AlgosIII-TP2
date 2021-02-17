package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Dibujo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.AlgoBlocks;


/**
 * JavaFX App
 */
public class App extends Application {

    static int SCREEN_WIDTH = 1000;
    static int SCREEN_HEIGHT = 1000;

    @Override
    public void start(Stage stage) {

        Dibujo dibujo = new Dibujo();
        AlgoBlocks algoBlocks = new AlgoBlocks(dibujo);

        LayoutDibujo layoutDibujo = new LayoutDibujo(SCREEN_WIDTH/2,SCREEN_HEIGHT);

        HBox layoutPpal = new HBox();

        HBox root = new HBox();
        root.setSpacing(100);

        Layout.crear(root);

        layoutPpal.getChildren().addAll(root, layoutDibujo);//principal

        Scene scene = new Scene(layoutPpal);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setHeight(SCREEN_HEIGHT);
        stage.setWidth(SCREEN_WIDTH);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

