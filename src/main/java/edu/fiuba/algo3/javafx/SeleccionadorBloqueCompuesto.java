package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.javafx.layouts.LayoutBotonesAgregarBloques;
import edu.fiuba.algo3.modelo.SecuenciaBloques;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class SeleccionadorBloqueCompuesto {
    private static List<ContenedorDeBloques> bloquesCompuestos = new ArrayList();
    private static ChoiceBox<String> choiceBox;
    public static int orden = 0;


    public SeleccionadorBloqueCompuesto(SecuenciaBloques algoritmo, VBox layoutAlgoritmo){
        bloquesCompuestos.add(new ContenedorDeBloques(algoritmo,"Algoritmo", layoutAlgoritmo));//Guardar Algoritmo como BloqueCompuesto

        choiceBox = new ChoiceBox();
        choiceBox.getItems().add("Algoritmo");
        choiceBox.setValue("Algoritmo");
        layoutAlgoritmo.getChildren().add(choiceBox);
    }

    public static void reiniciar(){
        ContenedorDeBloques algoritmo = bloquesCompuestos.get(0);
        bloquesCompuestos.clear();
        bloquesCompuestos.add(algoritmo);

        choiceBox.getItems().clear();
        choiceBox.getItems().add("Algoritmo");
        choiceBox.setValue("Algoritmo");

        algoritmo.reiniciarLayoutAlgoritmo(choiceBox);

        orden = 0;
    }

    public static ContenedorDeBloques bloqueActual(){
        ContenedorDeBloques bloqueCompuesto = bloquesCompuestos.stream()
                .filter(contenedor -> contenedor.tieneDescripcion(choiceBox.getValue()))
                .findAny()
                .orElse(null);
        return bloqueCompuesto;
    }

    public static void agregar (Bloque bloque, VBox layoutBloques) {
        ContenedorDeBloques bloqueActual = SeleccionadorBloqueCompuesto.bloqueActual();

        String descripcion = ("Contenedor " + orden++);

        VBox layoutSecuenciaNueva = new VBox();
        Vista.agregarMarcadorFinal(layoutSecuenciaNueva,descripcion);
        HBox layoutContenedorNuevo = Vista.crearLayoutContenedorDeBloques(layoutSecuenciaNueva,descripcion);

        bloquesCompuestos.add(new ContenedorDeBloques((SecuenciaBloques) bloque,descripcion, layoutSecuenciaNueva ));

        bloqueActual.agregarBloqueContenedor(bloque, layoutContenedorNuevo);

        choiceBox.getItems().add(descripcion);

        LayoutBotonesAgregarBloques.reiniciarBloquesCompuestos(layoutBloques);
    }

}
