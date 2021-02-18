package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.modelo.SecuenciaBloques;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ContenedorDeBloques {
    private SecuenciaBloques bloqueCompuesto;
    private String descripcion;
    private VBox layout;

    public ContenedorDeBloques(SecuenciaBloques unBloqueCompuesto, String unaDescripcion, VBox unLayout){
        bloqueCompuesto = unBloqueCompuesto;
        descripcion = unaDescripcion;
        layout = unLayout;
    }

    public boolean tieneDescripcion(String unaDescripcion) {
        return descripcion == unaDescripcion;
    }

    public void agregarBloque(Bloque bloque) {
        bloqueCompuesto.agregarBloque(bloque);
        bloque.mostrar(layout);
    }

    public void agregarBloqueContenedor(Bloque bloque, HBox layoutContenedor) {
        this.agregarBloque(bloque);
        layout.getChildren().add((layout.getChildren().size() - 1), layoutContenedor);//Agregar antes del marcador
    }
    public void reiniciarLayoutAlgoritmo(ChoiceBox<String> choiceBox){
        layout.getChildren().clear();

        Vista.agregarTitulo(layout,"Algoritmo");

        layout.getChildren().add(choiceBox);

        Vista.agregarMarcadorFinal(layout,"Algoritmo");
    }
}
