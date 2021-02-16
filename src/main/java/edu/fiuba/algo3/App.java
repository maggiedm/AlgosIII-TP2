package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Dibujo;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import edu.fiuba.algo3.modelo.bloque.BloqueBajarLapiz;
import edu.fiuba.algo3.modelo.bloque.BloqueMovimiento;
import edu.fiuba.algo3.modelo.bloque.BloqueSubirLapiz;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.AlgoBlocks;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        Dibujo dib = new Dibujo();
        AlgoBlocks algoBlocks = new AlgoBlocks(dib);

        //esto es solo para probar dibujarCamino
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueArriba());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueIzquierda());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(new BloqueSubirLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.ejecutarAlgoritmo();

        SplitPane splitPane = new SplitPane();

        LayoutDibujo dibujo = new LayoutDibujo(500,500);
        VBox algoritmo = new VBox(new Label("Algoritmo"));
        VBox bloques  = LayoutBloques.crear(algoBlocks, algoritmo);

        dibujo.graficarMovimientos(dib);


        splitPane.getItems().addAll(bloques, dibujo, algoritmo);

        Scene scene = new Scene(splitPane);

        stage.setScene(scene);
        stage.setHeight(1000);
        stage.setWidth(1000);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

