package edu.fiuba.algo3;

import edu.fiuba.algo3.javafx.botones.BotonGuardarAlgoritmo;
import edu.fiuba.algo3.javafx.layouts.LayoutAlgoritmo;
import edu.fiuba.algo3.javafx.layouts.LayoutBloques;
import edu.fiuba.algo3.javafx.layouts.LayoutDibujo;
import edu.fiuba.algo3.javafx.layouts.LayoutEjecutarReiniciar;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.AlgoBlocks;

import static java.lang.Integer.max;

/**
 * JavaFX App
 */
public class App extends Application {

    static int SCREEN_WIDTH = (int) Screen.getPrimary().getVisualBounds().getWidth()*3/4;
    static int MIN_SCREEN_WIDHT = 1150;
    static int SCREEN_HEIGHT = (int) Screen.getPrimary().getVisualBounds().getHeight();
    static int MIN_SCREEN_HEIGHT = 950;

    @Override
    public void start(Stage stage) {
        AlgoBlocks algoBlocks = new AlgoBlocks();
        LayoutDibujo layoutDibujo = new LayoutDibujo(max(SCREEN_WIDTH, MIN_SCREEN_WIDHT)-410,max(SCREEN_HEIGHT-150, MIN_SCREEN_HEIGHT-150));


        // PANEL PRINCIPAL: CONTIENE A panelSuperior, layoutBloques, layoutAlgoritmo y layoutDibujo
        BorderPane panelPrincipal = this.crearPanelPrincipal(algoBlocks, layoutDibujo);

        // ESCENARIO
        this.configurarEscenario(stage, panelPrincipal);
        stage.show();
    }

    private BorderPane crearPanelSuperior(AlgoBlocks algoBlocks, LayoutDibujo layoutDibujo) {
        BorderPane panelSuperior = new BorderPane();
        panelSuperior.setPadding(new Insets(0, 25, 0, 0));
        panelSuperior.setStyle("-fx-background-color: rgb(0, 176, 189)");
        HBox layoutEjecutarReiniciar = new LayoutEjecutarReiniciar(algoBlocks, layoutDibujo);
        panelSuperior.setLeft(new ImageView("file:recursos/Banner.png"));
        panelSuperior.setRight(layoutEjecutarReiniciar);
        layoutEjecutarReiniciar.setAlignment(Pos.CENTER_RIGHT);
        return panelSuperior;
    }

    private BorderPane crearPanelPrincipal(AlgoBlocks algoBlocks, LayoutDibujo layoutDibujo) {
        BorderPane panelPrincipal = new BorderPane();
        LayoutBloques layoutBloques = new LayoutBloques(max(SCREEN_HEIGHT-150, MIN_SCREEN_HEIGHT-150));
        BotonGuardarAlgoritmo botonGuardarAlgoritmo = new BotonGuardarAlgoritmo(algoBlocks, layoutBloques );
        algoBlocks.getAlgoritmo().addObserver(botonGuardarAlgoritmo);
        LayoutAlgoritmo layoutAlgoritmo = new LayoutAlgoritmo(algoBlocks, max(SCREEN_HEIGHT-150, MIN_SCREEN_HEIGHT-150));
        VBox layoutAlgoritmoGuardar = new VBox(layoutAlgoritmo, botonGuardarAlgoritmo);

        panelPrincipal.setRight(layoutDibujo);
        panelPrincipal.setLeft(layoutBloques);
        panelPrincipal.setCenter(layoutAlgoritmoGuardar);
        panelPrincipal.setTop(this.crearPanelSuperior(algoBlocks, layoutDibujo));

        return panelPrincipal;
    }


    private void configurarEscenario(Stage stage, BorderPane panelPrincipal) {
        Scene scene = new Scene(panelPrincipal);
        stage.setTitle("AlgoBlocks v2.0");
        stage.getIcons().add(new Image("file:recursos/Logo.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setHeight(max(MIN_SCREEN_HEIGHT, SCREEN_HEIGHT));
        stage.setWidth(max(MIN_SCREEN_WIDHT, SCREEN_WIDTH));
    }

    public static void main(String[] args) {
        launch();
    }

}