package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Dibujo;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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


        // PANEL SUPERIOR: BANNER + BOTONES DE EJECUTAR Y REINICIAR
        HBox panelSuperior = new HBox();
        ImageView banner = new ImageView("https://i.ibb.co/Ht7ysNy/New-Project-2.png");
        VBox layoutAlgoritmo = LayoutAlgoritmo.crear();
        HBox layoutEjecutarReinciar = LayoutEjecutarReinciar.crear(layoutAlgoritmo);
        layoutEjecutarReinciar.setAlignment(Pos.CENTER_LEFT);
        panelSuperior.getChildren().addAll(banner, layoutEjecutarReinciar);

        // PANEL INFERIOR: BLOQUES + ALGORITMO + DIBUJO
        HBox panelInferior = new HBox();
        panelInferior.setSpacing(100);
        LayoutDibujo layoutDibujo = new LayoutDibujo(SCREEN_WIDTH/2,SCREEN_HEIGHT);
        VBox layoutBotonesAgregarBloques = LayoutBotonesAgregarBloques.crear();
        panelInferior.getChildren().addAll(layoutBotonesAgregarBloques, layoutAlgoritmo, layoutDibujo);

        // PANEL PRINCIPAL: CONTIENE A panelInferior Y panelSuperior
        VBox panelPrincipal = new VBox();
        panelPrincipal.setSpacing(20);
        panelPrincipal.getChildren().addAll(panelSuperior, panelInferior);

        // ESCENA
        Scene scene = new Scene(panelPrincipal);
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

