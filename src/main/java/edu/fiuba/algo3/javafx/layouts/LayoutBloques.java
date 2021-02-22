package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.BloquesDisponibles;
import edu.fiuba.algo3.javafx.Vista;
import edu.fiuba.algo3.javafx.botones.BotonSimple;
import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueEventHandler;
import edu.fiuba.algo3.modelo.bloque.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class LayoutBloques extends VBox{

    static int CANTIDAD_BLOQUES_COMPUESTOS = 3;
    static VBox contenido;

    public LayoutBloques(double altura) {

        contenido = new VBox(10);
        ScrollPane sP = new ScrollPane(contenido);
        sP.setPrefViewportHeight(altura*3/4);
        sP.setMinViewportWidth(150);

        Vista.agregarTitulo(this, "Bloques");
        this.getChildren().add(sP);

        BloquesDisponibles bloquesDisponibles = new BloquesDisponibles();
        bloquesDisponibles.agregarBotones(this);
    }



    public void agregarBotonBloque(String rutaArchivo, String descripcion, Bloque unBloque){
        contenido.getChildren().add(
                BotonSimple.crearBotonSimple(
                        rutaArchivo,
                        descripcion,
                        new BotonAgregarBloqueEventHandler(unBloque, descripcion)
                ));
    }


    public  void reiniciarBloquesCompuestos() {
        //Elimina los 3 botones de BloquesCompuestos y los vuelve a iniciar
        for (int i = 0; i < CANTIDAD_BLOQUES_COMPUESTOS; i++) {
            contenido.getChildren().remove(contenido.getChildren().size()-1);
        }

        BloquesDisponibles bloquesDisponibles = new BloquesDisponibles();
        bloquesDisponibles.agregarBotonesBloquesCompuestos(this);
    }
}
