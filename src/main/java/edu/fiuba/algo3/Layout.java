package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.Algoritmo;
import edu.fiuba.algo3.modelo.bloque.BloqueBajarLapiz;
import edu.fiuba.algo3.modelo.bloque.BloqueMovimiento;
import edu.fiuba.algo3.modelo.bloque.BloqueRepeticion;
import edu.fiuba.algo3.modelo.bloque.BloqueSubirLapiz;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class Layout {
    private static List<ContenedorDeBloques> bloquesCompuestos = new ArrayList();

    public static void crear(HBox root) {

        Algoritmo algoritmo = new Algoritmo();
        AlgoBlocks algoBlocks = new AlgoBlocks(algoritmo);//se utilizará en ejecutar y guardarAlgoritmo

        VBox layoutBloques = new VBox();
        VBox layoutAlgoritmo = new VBox();

        root.getChildren().addAll(layoutBloques, layoutAlgoritmo);

        Layout.iniciarTitulo(layoutBloques,"Bloques");
        Layout.iniciarTitulo(layoutAlgoritmo,"Algoritmo");

        Layout.agregarMarcadorFinal(layoutAlgoritmo,"Algoritmo");//Puntero final de Algoritmo

        bloquesCompuestos.add(new ContenedorDeBloques(algoritmo,"Algoritmo", layoutAlgoritmo));//Guardar Algoritmo como BloqueCompuesto

        //Inicializar selector de bloques
        ChoiceBox<String> choiceBox = new ChoiceBox();
        choiceBox.getItems().add("Algoritmo");
        choiceBox.setValue("Algoritmo");
        layoutBloques.getChildren().add(choiceBox);

        Layout.agregarBloques(bloquesCompuestos, choiceBox, layoutBloques);

        Layout.agregarBloquesCompuestos(bloquesCompuestos, choiceBox, layoutBloques);

    }

    public static void reiniciarBloquesCompuestos(List<ContenedorDeBloques> bloquesCompuestos,
                                                  ChoiceBox<String> choiceBox, VBox layoutBloques) {
        //Eliminar los 2 botones de BloquesCompuestos y volverlos a iniciar
        layoutBloques.getChildren().remove(layoutBloques.getChildren().size()-1);
        layoutBloques.getChildren().remove(layoutBloques.getChildren().size()-1);

        Layout.agregarBloquesCompuestos(bloquesCompuestos, choiceBox, layoutBloques);

    }

    private static void agregarBloquesCompuestos(List<ContenedorDeBloques> bloquesCompuestos, ChoiceBox<String> choiceBox, VBox layoutBloques) {
        new BotonAgregarContenedorDeBloques(
                BloqueRepeticion.repetirDosVeces(),
                bloquesCompuestos,
                choiceBox,
                layoutBloques);

        new BotonAgregarContenedorDeBloques(BloqueRepeticion.repetirTresVeces(), bloquesCompuestos, choiceBox, layoutBloques);
    }

    private static void agregarBloques(List<ContenedorDeBloques> bloquesCompuestos,
                                       ChoiceBox<String> choiceBox, VBox layoutBloques) {
        new BotonAgregarBloque(
                BloqueMovimiento.bloqueAbajo(),
                bloquesCompuestos,
                choiceBox,
                layoutBloques);

        new BotonAgregarBloque(BloqueMovimiento.bloqueArriba(), bloquesCompuestos, choiceBox, layoutBloques);

        new BotonAgregarBloque(BloqueMovimiento.bloqueDerecha(), bloquesCompuestos, choiceBox, layoutBloques);

        new BotonAgregarBloque(BloqueMovimiento.bloqueIzquierda(), bloquesCompuestos, choiceBox, layoutBloques);

        new BotonAgregarBloque(new BloqueBajarLapiz(), bloquesCompuestos, choiceBox, layoutBloques);

        new BotonAgregarBloque(new BloqueSubirLapiz(), bloquesCompuestos, choiceBox, layoutBloques);
    }

    public static void iniciarTitulo(VBox layout, String descripcion){
        layout.setSpacing(10);

        Label etiqueta = new Label(descripcion);
        etiqueta.setFont(Font.font(20));
        layout.getChildren().add(etiqueta);
    }
    public static void agregarMarcadorFinal(VBox layout, String descripcion) {
        Rectangle rectangulo = new Rectangle(200, 40);
        rectangulo.setFill(Color.GREY);

        Label etiqueta = new Label(descripcion);

        StackPane mostrador = new StackPane();
        mostrador.getChildren().addAll(rectangulo, etiqueta);

        layout.getChildren().add(mostrador);
    }

    public static HBox crearLayoutContenedorDeBloques(VBox layoutSecuenciaNueva, String descripcion) {
        HBox layoutContenedor = new HBox();

        StackPane mostrador = new StackPane();
        mostrador.getChildren().add(new Label(descripcion));

        layoutContenedor.getChildren().addAll(mostrador, layoutSecuenciaNueva);
        return layoutContenedor;
    }
}
