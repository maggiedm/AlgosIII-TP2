package edu.fiuba.algo3;

import edu.fiuba.algo3.javafx.EscenarioVista;
import edu.fiuba.algo3.javafx.botones.BotonGuardarAlgoritmo;
import edu.fiuba.algo3.javafx.layouts.LayoutAlgoritmo;
import edu.fiuba.algo3.javafx.layouts.LayoutBloques;
import edu.fiuba.algo3.javafx.layouts.LayoutDibujo;
import edu.fiuba.algo3.javafx.layouts.LayoutEjecutarReiniciar;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

    static int SCREEN_WIDTH = max ((int) Screen.getPrimary().getVisualBounds().getWidth()*3/4, 1150);
    static int SCREEN_HEIGHT = max((int) Screen.getPrimary().getVisualBounds().getHeight()/4, 950);

    @Override
    public void start(Stage stage) {
        AlgoBlocks algoBlocks = new AlgoBlocks();
        LayoutDibujo layoutDibujo = new LayoutDibujo(SCREEN_WIDTH-420,SCREEN_HEIGHT-150);


        // PANEL PRINCIPAL: CONTIENE A panelSuperior, layoutBloques, layoutAlgoritmo y layoutDibujo
        BorderPane panelPrincipal = this.crearPanelPrincipal(algoBlocks, layoutDibujo);

        // ESCENARIO
        new EscenarioVista(stage, panelPrincipal, "AlgoBlocks v2.0");
        stage.show();
    }

    private BorderPane crearPanelSuperior(AlgoBlocks algoBlocks, LayoutDibujo layoutDibujo) {
        BorderPane panelSuperior = new BorderPane();
        panelSuperior.setPadding(new Insets(0, 25, 0, 0));
        panelSuperior.setStyle("-fx-background-color: rgb(0, 176, 189)");
        HBox layoutEjecutarReiniciar = new LayoutEjecutarReiniciar(algoBlocks, layoutDibujo);
        panelSuperior.setLeft(new ImageView("file:recursos/imagenes/Banner.png"));
        panelSuperior.setRight(layoutEjecutarReiniciar);
        layoutEjecutarReiniciar.setAlignment(Pos.CENTER_RIGHT);
        return panelSuperior;
    }

    private BorderPane crearPanelPrincipal(AlgoBlocks algoBlocks, LayoutDibujo layoutDibujo) {
        BorderPane panelPrincipal = new BorderPane();
        LayoutBloques layoutBloques = new LayoutBloques(SCREEN_HEIGHT - 150);
        BotonGuardarAlgoritmo botonGuardarAlgoritmo = new BotonGuardarAlgoritmo(algoBlocks, layoutBloques );
        LayoutAlgoritmo layoutAlgoritmo = new LayoutAlgoritmo(algoBlocks, SCREEN_HEIGHT - 150);
        VBox layoutAlgoritmoGuardar = new VBox(layoutAlgoritmo, botonGuardarAlgoritmo);
        layoutAlgoritmoGuardar.setStyle("-fx-background-color: lightgray");

        panelPrincipal.setRight(layoutDibujo);
        panelPrincipal.setLeft(layoutBloques);
        panelPrincipal.setCenter(layoutAlgoritmoGuardar);
        panelPrincipal.setTop(this.crearPanelSuperior(algoBlocks, layoutDibujo));

        return panelPrincipal;
    }

    public static void main(String[] args) {
        launch();
    }

}