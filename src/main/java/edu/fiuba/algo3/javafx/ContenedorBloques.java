package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.modelo.ContenedorDeBloques;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import edu.fiuba.algo3.vista.algoritmo.MostradorBloqueSimple;
import javafx.scene.layout.VBox;

public class ContenedorBloques {
    private ContenedorDeBloques contenedor = null;
    protected final String descripcion;
    protected final VBox layout;

    public ContenedorBloques(ContenedorDeBloques unBloqueCompuesto, String unaDescripcion, VBox unLayout){
        contenedor = unBloqueCompuesto;
        descripcion = unaDescripcion;
        layout = unLayout;
    }

    protected ContenedorBloques(String unaDescripcion, VBox unLayout){
        descripcion = unaDescripcion;
        layout = unLayout;
    }

    public boolean tieneDescripcion(String unaDescripcion) {
        return descripcion.equals(unaDescripcion);
    }

    public void agregarBloque(Bloque bloque, String rutaImagen) {
        contenedor.agregarBloque(bloque);  //esto es controlador
        new MostradorBloqueSimple(rutaImagen, layout); //esto es vista
    }

    public void agregarBloqueContenedor(Bloque bloque, String descripcion, VBox layoutContenedor) {
        this.agregarBloque(bloque, descripcion);
        layout.getChildren().add(layoutContenedor); //vista
    }
}
