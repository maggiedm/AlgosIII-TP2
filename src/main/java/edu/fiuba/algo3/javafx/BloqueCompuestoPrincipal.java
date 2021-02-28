package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.scene.layout.VBox;

public class BloqueCompuestoPrincipal extends BloqueCompuesto {
    private final AlgoBlocks contendorPrincipal;

    public BloqueCompuestoPrincipal(AlgoBlocks unAlgoblocks, String unaDescripcion, VBox unLayout){
        super(unaDescripcion, unLayout);
        contendorPrincipal = unAlgoblocks;
    }

    @Override
    public void agregarBloque(Bloque bloque, String rutaImagen) {
        contendorPrincipal.agregarBloque(bloque); //controlador
        new MostradorBloqueSimple(rutaImagen, layout); //vista
    }

    public void reiniciarLayoutAlgoritmo(SeleccionadorBloqueCompuestoVista seleccionadorBloqueCompuestoVista){ //ChoiceBox no debería estar adentro del ScrollPane
        layout.getChildren().clear();
        layout.getChildren().add(seleccionadorBloqueCompuestoVista);
    }
}
