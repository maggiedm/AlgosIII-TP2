package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.BloqueBajarLapiz;
import edu.fiuba.algo3.modelo.bloque.BloqueMovimiento;
import edu.fiuba.algo3.modelo.bloque.BloqueRepeticion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class LayoutBloques {
    public static VBox crear(AlgoBlocks algoBlocks, VBox algoritmo){

        VBox layoutBloques = new VBox();
        layoutBloques.setSpacing(10);

        Label etiquetaBloques = new Label();
        etiquetaBloques.setText("Bloques");
        etiquetaBloques.setFont(Font.font(20));
        layoutBloques.getChildren().add(etiquetaBloques);

        new BotonAgregarBloque(
                BloqueMovimiento.bloqueDerecha(), "Derecha",
                algoBlocks, algoritmo, layoutBloques);

        new BotonAgregarBloque(
                BloqueMovimiento.bloqueIzquierda(), "Izquierda",
                algoBlocks, algoritmo, layoutBloques);

        new BotonAgregarBloque(
                new BloqueBajarLapiz(), "Bajar Lapiz",
                algoBlocks, algoritmo, layoutBloques);

        new BotonAgregarBloque(
                BloqueRepeticion.repetirTresVeces(), "Repetir 3 Veces",
                algoBlocks, algoritmo, layoutBloques);


        return layoutBloques;
    }
}
