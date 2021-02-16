package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.SecuenciaBloques;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import edu.fiuba.algo3.modelo.bloque.BloqueRepeticion;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class BotonAgregarContenedorDeBloques {

    public static int orden = 0;

    public BotonAgregarContenedorDeBloques(Bloque bloque, List<ContenedorDeBloques> bloquesCompuestos, ChoiceBox<String> choiceBox,
                                           VBox layoutBloques) {
        Button botonAgregarBloque = new Button();
        botonAgregarBloque.setText(bloque.getDescripcion());
        botonAgregarBloque.setOnAction(e -> getChoice(choiceBox, bloquesCompuestos, bloque, layoutBloques));
        layoutBloques.getChildren().add(botonAgregarBloque);
    }

    private void getChoice(ChoiceBox<String> choiceBox, List<ContenedorDeBloques> bloquesCompuestos, Bloque bloque, VBox layoutBloques) {
        ContenedorDeBloques bloqueCompuesto = bloquesCompuestos.stream()
                .filter(contenedor -> contenedor.tieneDescripcion(choiceBox.getValue()))
                .findAny()
                .orElse(null);

        String descripcion = ("Contenedor " + orden++);

        VBox layoutSecuenciaNueva = new VBox();
        Layout.agregarMarcadorFinal(layoutSecuenciaNueva,descripcion);
        HBox layoutContenedorNuevo = Layout.crearLayoutContenedorDeBloques(layoutSecuenciaNueva,descripcion);

        //Borde para separar secuencias de bloques
        layoutContenedorNuevo.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 1;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: black;");

        bloquesCompuestos.add(new ContenedorDeBloques((SecuenciaBloques) bloque,descripcion, layoutSecuenciaNueva ));

        bloqueCompuesto.agregarBloqueContenedor(bloque, layoutContenedorNuevo);

        choiceBox.getItems().add(descripcion);

        Layout.reiniciarBloquesCompuestos(bloquesCompuestos, choiceBox, layoutBloques);
    }
}
