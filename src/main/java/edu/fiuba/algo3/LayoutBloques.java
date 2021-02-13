package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.BloqueBajarLapiz;
import edu.fiuba.algo3.modelo.bloque.BloqueMovimiento;
import edu.fiuba.algo3.modelo.bloque.BloqueRepeticion;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class LayoutBloques {
    public static VBox crear(AlgoBlocks algoBlocks){

        VBox layoutBloques = new VBox();
        layoutBloques.setSpacing(10);

        Label etiquetaBloques = new Label();
        etiquetaBloques.setText("Bloques");
        etiquetaBloques.setFont(Font.font(20));
        layoutBloques.getChildren().add(etiquetaBloques);

        new BotonAgregarBloque(
                BloqueMovimiento.bloqueDerecha(),
                algoBlocks,
                layoutBloques);

        new BotonAgregarBloque(
                BloqueMovimiento.bloqueIzquierda(),
                algoBlocks,
                layoutBloques);

        new BotonAgregarBloque(
                new BloqueBajarLapiz(),
                algoBlocks,
                layoutBloques);

        new BotonAgregarBloque(
                BloqueRepeticion.repetirTresVeces(),
                algoBlocks,
                layoutBloques);

        return layoutBloques;
    }
}
