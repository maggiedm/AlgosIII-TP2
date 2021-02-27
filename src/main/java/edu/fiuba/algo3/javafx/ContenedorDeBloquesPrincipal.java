package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.scene.layout.VBox;

public class ContenedorDeBloquesPrincipal extends ContenedorDeBloques{
    private final AlgoBlocks contendorPrincipal;

    public ContenedorDeBloquesPrincipal(AlgoBlocks unAlgoblocks, String unaDescripcion, VBox unLayout){
        super(unaDescripcion, unLayout);
        contendorPrincipal = unAlgoblocks;
    }

    @Override
    public void agregarBloque(Bloque bloque, String rutaImagen) {
        contendorPrincipal.agregarBloque(bloque);
        new MostradorBloqueSimple(rutaImagen, layout);
    }

    public void reiniciarLayoutAlgoritmo(SeleccionadorBloqueCompuestoVista seleccionadorBloqueCompuestoVista){
        layout.getChildren().clear();
        layout.getChildren().add(seleccionadorBloqueCompuestoVista);
    }
}
