package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.bloque.BloqueBajarLapiz;
import edu.fiuba.algo3.modelo.bloque.BloqueMovimiento;
import edu.fiuba.algo3.modelo.bloque.BloqueRepeticion;
import edu.fiuba.algo3.modelo.bloque.BloqueSubirLapiz;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class LayoutBotonesAgregarBloques {
    public static VBox crear() {

        VBox layoutBloques = new VBox();

        Vista.agregarTitulo(layoutBloques, "Bloques");

        LayoutBotonesAgregarBloques.agregarBotonesBloquesSimples(layoutBloques);
        LayoutBotonesAgregarBloques.agregarBotonesBloquesCompuestos(layoutBloques);

        return layoutBloques;
    }

    public static void agregarBotonesBloquesCompuestos(VBox layoutBloques) {
        new BotonAgregarBloque(BloqueRepeticion.repetirDosVeces(), layoutBloques, new BotonAgregarBloqueCompuestoEventHandler(BloqueRepeticion.repetirDosVeces()));
        new BotonAgregarBloque(BloqueRepeticion.repetirTresVeces(), layoutBloques, new BotonAgregarBloqueCompuestoEventHandler(BloqueRepeticion.repetirTresVeces()));
    }

    private static void agregarBotonesBloquesSimples(VBox layoutBloques) {

        new BotonAgregarBloque(BloqueMovimiento.bloqueAbajo(), layoutBloques, new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueAbajo()));
        new BotonAgregarBloque(BloqueMovimiento.bloqueArriba(), layoutBloques, new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueArriba()));
        new BotonAgregarBloque(BloqueMovimiento.bloqueIzquierda(), layoutBloques, new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueIzquierda()));
        new BotonAgregarBloque(BloqueMovimiento.bloqueDerecha(), layoutBloques, new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueDerecha()));

        new BotonAgregarBloque(new BloqueBajarLapiz(), layoutBloques, new BotonAgregarBloqueEventHandler(new BloqueBajarLapiz()));
        new BotonAgregarBloque(new BloqueSubirLapiz(), layoutBloques, new BotonAgregarBloqueEventHandler(new BloqueSubirLapiz()));

    }

    /*public static void reiniciarBloquesCompuestos(VBox layoutBloques) {
        //Eliminar los 2 botones de BloquesCompuestos y volverlos a iniciar
        layoutBloques.getChildren().remove(layoutBloques.getChildren().size()-1);
        layoutBloques.getChildren().remove(layoutBloques.getChildren().size()-1);

        LayoutBotonesAgregarBloques.agregarBotonesBloquesCompuestos(layoutBloques);

    }*/
}
