package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

import java.util.List;


public class BotonAgregarBloque extends Button{

    public BotonAgregarBloque(Bloque bloque, List<ContenedorDeBloques> bloquesCompuestos, ChoiceBox<String> choiceBox,
                              VBox layoutBloques){

        Button botonAgregarBloque = new Button();
        botonAgregarBloque.setText(bloque.getDescripcion());
        botonAgregarBloque.setOnAction(e -> getChoice(choiceBox, bloquesCompuestos, bloque));
        layoutBloques.getChildren().add(botonAgregarBloque);
    }

    private void getChoice(ChoiceBox<String> choiceBox, List<ContenedorDeBloques> bloquesCompuestos, Bloque bloque) {
        ContenedorDeBloques bloqueCompuesto = bloquesCompuestos.stream()
                .filter(contenedor -> contenedor.tieneDescripcion(choiceBox.getValue()))
                .findAny()
                .orElse(null);
        bloqueCompuesto.agregarBloque(bloque);
    }
}
