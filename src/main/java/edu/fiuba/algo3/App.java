package edu.fiuba.algo3;

import edu.fiuba.algo3.javafx.botones.BotonGuardarAlgoritmo;
import edu.fiuba.algo3.javafx.layouts.LayoutAlgoritmo;
import edu.fiuba.algo3.javafx.layouts.LayoutBloques;
import edu.fiuba.algo3.javafx.layouts.LayoutDibujo;
import edu.fiuba.algo3.javafx.layouts.LayoutEjecutarReiniciar;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
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

        // PANEL SUPERIOR: BANNER + BOTONES DE EJECUTAR Y REINICIAR
        BorderPane panelSuperior = this.crearPanelSuperior(algoBlocks, layoutDibujo);

        // PANEL INFERIOR: BLOQUES + ALGORITMO + DIBUJO
        SplitPane panelInferior = this.crearPanelInferior(algoBlocks, layoutDibujo);

        // PANEL PRINCIPAL: CONTIENE A panelInferior Y panelSuperior
        VBox panelPrincipal = this.crearPanelPrincipal(panelSuperior, panelInferior);

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

    private SplitPane crearPanelInferior(AlgoBlocks algoBlocks, LayoutDibujo layoutDibujo) {
        HBox panelInferior = new HBox();
        SplitPane aux = new SplitPane();
        LayoutBloques layoutBloques = new LayoutBloques(max(SCREEN_HEIGHT-150, MIN_SCREEN_HEIGHT-150));
        BotonGuardarAlgoritmo botonGuardarAlgoritmo = new BotonGuardarAlgoritmo(algoBlocks, layoutBloques );
        algoBlocks.getAlgoritmo().addObserver(botonGuardarAlgoritmo);
        VBox layoutAlgoritmo = new LayoutAlgoritmo(algoBlocks, max(SCREEN_HEIGHT-150, MIN_SCREEN_HEIGHT-150));

        VBox layoutAlgoritmoGuardar = new VBox(layoutAlgoritmo, botonGuardarAlgoritmo);

        panelInferior.getChildren().addAll(layoutBloques, new Separator(Orientation.VERTICAL), layoutAlgoritmoGuardar);
        aux.getItems().addAll(panelInferior, layoutDibujo);
        panelInferior.setPrefWidth(340);
        return aux;
    }

    private VBox crearPanelPrincipal(BorderPane panelSuperior, SplitPane panelInferior) {
        VBox panelPrincipal = new VBox();
        panelPrincipal.getChildren().addAll(panelSuperior, panelInferior);
        return panelPrincipal;
    }

    private void configurarEscenario(Stage stage, VBox panelPrincipal) {
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