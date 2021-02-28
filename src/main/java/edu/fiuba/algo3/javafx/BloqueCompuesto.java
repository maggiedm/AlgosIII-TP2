package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.modelo.ContenedorDeBloques;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.scene.layout.VBox;

public class BloqueCompuesto {
    private ContenedorDeBloques bloqueCompuesto = null;
    protected final String descripcion;
    protected final VBox layout;

    public BloqueCompuesto(ContenedorDeBloques unBloqueCompuesto, String unaDescripcion, VBox unLayout){
        bloqueCompuesto = unBloqueCompuesto;
        descripcion = unaDescripcion;
        layout = unLayout;
    }

    protected BloqueCompuesto(String unaDescripcion, VBox unLayout){
        descripcion = unaDescripcion;
        layout = unLayout;
    }

    public boolean tieneDescripcion(String unaDescripcion) {
        return descripcion.equals(unaDescripcion);
    }

    public void agregarBloque(Bloque bloque, String rutaImagen) {
        bloqueCompuesto.agregarBloque(bloque);  //esto es controlador
        new MostradorBloqueSimple(rutaImagen, layout); //esto es vista
    }

    public void agregarBloqueContenedor(Bloque bloque, String descripcion, VBox layoutContenedor) {
        this.agregarBloque(bloque, descripcion);
        layout.getChildren().add(layoutContenedor); //vista
    }
}
