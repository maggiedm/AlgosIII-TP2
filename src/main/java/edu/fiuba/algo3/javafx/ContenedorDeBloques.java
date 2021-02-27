package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.modelo.SecuenciaBloques;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.scene.layout.VBox;

public class ContenedorDeBloques {
    private SecuenciaBloques bloqueCompuesto = null;
    protected final String descripcion;
    protected final VBox layout;

    public ContenedorDeBloques(SecuenciaBloques unBloqueCompuesto, String unaDescripcion, VBox unLayout){
        bloqueCompuesto = unBloqueCompuesto;
        descripcion = unaDescripcion;
        layout = unLayout;
    }

    protected ContenedorDeBloques(String unaDescripcion, VBox unLayout){
        descripcion = unaDescripcion;
        layout = unLayout;
    }

    public boolean tieneDescripcion(String unaDescripcion) {
        return descripcion.equals(unaDescripcion);
    }

    public void agregarBloque(Bloque bloque, String rutaImagen) {
        bloqueCompuesto.agregarBloque(bloque);
        new MostradorBloqueSimple(rutaImagen, layout);
    }

    public void agregarBloqueContenedor(Bloque bloque, String descripcion, VBox layoutContenedor) {
        this.agregarBloque(bloque, descripcion);
        layout.getChildren().add(layoutContenedor);
    }
    public void reiniciarLayoutAlgoritmo(SeleccionadorBloqueCompuestoVista seleccionadorBloqueCompuestoVista){
        layout.getChildren().clear();
        layout.getChildren().add(seleccionadorBloqueCompuestoVista);
    }
}
