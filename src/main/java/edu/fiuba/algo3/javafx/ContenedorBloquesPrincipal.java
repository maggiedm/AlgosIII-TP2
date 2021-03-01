package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import edu.fiuba.algo3.vista.algoritmo.MostradorBloqueSimple;
import edu.fiuba.algo3.vista.algoritmo.SeleccionadorContenedorBloquesVista;
import javafx.scene.layout.VBox;

public class ContenedorBloquesPrincipal extends ContenedorBloques {
    private final AlgoBlocks contenedorPrincipal;

    public ContenedorBloquesPrincipal(AlgoBlocks unAlgoblocks, String unaDescripcion, VBox unLayout){
        super(unaDescripcion, unLayout);
        contenedorPrincipal = unAlgoblocks;
    }

    @Override
    public void agregarBloque(Bloque bloque, String rutaImagen) {
        contenedorPrincipal.agregarBloque(bloque); //controlador
        new MostradorBloqueSimple(rutaImagen, layout); //vista
    }

    public void reiniciarLayoutAlgoritmo(SeleccionadorContenedorBloquesVista seleccionadorContenedorBloquesVista){ //ChoiceBox no debería estar adentro del ScrollPane
        layout.getChildren().clear();
        layout.getChildren().add(seleccionadorContenedorBloquesVista);
    }
}
