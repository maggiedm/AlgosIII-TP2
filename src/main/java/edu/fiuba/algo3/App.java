package edu.fiuba.algo3;

import edu.fiuba.algo3.javafx.BloquesDisponibles;
import edu.fiuba.algo3.javafx.botones.BotonGuardarAlgoritmo;
import edu.fiuba.algo3.javafx.layouts.LayoutAlgoritmo;
import edu.fiuba.algo3.javafx.layouts.LayoutBloques;
import edu.fiuba.algo3.javafx.layouts.LayoutDibujo;
import edu.fiuba.algo3.javafx.layouts.LayoutEjecutarReiniciar;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.AlgoBlocks;

/**
 * JavaFX App
 */
public class App extends Application {

    static double SCREEN_WIDTH = Screen.getPrimary().getVisualBounds().getWidth()*3/4;
    static double SCREEN_HEIGHT = Screen.getPrimary().getVisualBounds().getHeight();

    @Override
    public void start(Stage stage) {
        AlgoBlocks algoBlocks = new AlgoBlocks();
        LayoutDibujo layoutDibujo = new LayoutDibujo(SCREEN_WIDTH/2,SCREEN_HEIGHT-(new HBox()).getHeight());

        // PANEL SUPERIOR: BANNER + BOTONES DE EJECUTAR Y REINICIAR
        HBox panelSuperior = this.crearPanelSuperior(algoBlocks, layoutDibujo);

        // PANEL INFERIOR: BLOQUES + ALGORITMO + DIBUJO
        HBox panelInferior = this.crearPanelInferior(algoBlocks, layoutDibujo);

        // PANEL PRINCIPAL: CONTIENE A panelInferior Y panelSuperior
        VBox panelPrincipal = this.crearPanelPrincipal(panelSuperior, panelInferior);

        // ESCENARIO
        this.configurarEscenario(stage, panelPrincipal);
        stage.show();
    }

    private HBox crearPanelSuperior(AlgoBlocks algoBlocks, LayoutDibujo layoutDibujo) {
        HBox panelSuperior = new HBox();
        ImageView banner = new ImageView("https://i.ibb.co/Ht7ysNy/New-Project-2.png");
        HBox layoutEjecutarReiniciar = LayoutEjecutarReiniciar.crear(algoBlocks, layoutDibujo);
        layoutEjecutarReiniciar.setAlignment(Pos.CENTER_LEFT);
        panelSuperior.getChildren().addAll(banner, layoutEjecutarReiniciar);
        return panelSuperior;
    }

    private HBox crearPanelInferior(AlgoBlocks algoBlocks, LayoutDibujo layoutDibujo) {
        HBox panelInferior = new HBox();
        panelInferior.setSpacing(10);
        BloquesDisponibles bloquesDisponibles = new BloquesDisponibles();
        LayoutBloques layoutBloques = new LayoutBloques(SCREEN_HEIGHT, bloquesDisponibles);
        BotonGuardarAlgoritmo botonGuardarAlgoritmo = new BotonGuardarAlgoritmo(bloquesDisponibles, algoBlocks, layoutBloques );
        algoBlocks.getAlgoritmo().addObserver(botonGuardarAlgoritmo);
        VBox layoutAlgoritmo = LayoutAlgoritmo.crear(algoBlocks, SCREEN_HEIGHT);

        VBox aux = new VBox(layoutAlgoritmo, botonGuardarAlgoritmo);
        panelInferior.getChildren().addAll(layoutBloques, aux, layoutDibujo);
        return panelInferior;
    }

    private VBox crearPanelPrincipal(HBox panelSuperior, HBox panelInferior) {
        VBox panelPrincipal = new VBox();
        panelPrincipal.setMaxSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        panelPrincipal.setSpacing(20);
        panelPrincipal.getChildren().addAll(panelSuperior, panelInferior);
        return panelPrincipal;
    }

    private void configurarEscenario(Stage stage, VBox panelPrincipal) {
        Scene scene = new Scene(panelPrincipal);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setHeight(SCREEN_HEIGHT);
        stage.setWidth(SCREEN_WIDTH);
    }

    public static void main(String[] args) {
        launch();
    }
    
}

