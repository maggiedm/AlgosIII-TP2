package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.javafx.botones.BotonSimple;
import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueCompuestoEventHandler;
import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueEventHandler;
import edu.fiuba.algo3.javafx.layouts.LayoutBloques;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BloqueDisponible {

    private String descripcion;
    private String rutaImagen;
    private Bloque bloque;
    private boolean esSimple;

    public BloqueDisponible(Bloque unBloque, String unaDescripcion, String unaRutaImagen, Boolean esBloqueSimple){

        descripcion = unaDescripcion;
        rutaImagen = unaRutaImagen;
        bloque = unBloque;
        esSimple = esBloqueSimple;
    }

    public void agregarBoton(LayoutBloques layoutBloques) {

        EventHandler<ActionEvent> handler;
        if (esSimple){
            handler = new BotonAgregarBloqueEventHandler(bloque, rutaImagen);
        }
        else{
            handler = new BotonAgregarBloqueCompuestoEventHandler(bloque, rutaImagen, layoutBloques);
        }
        layoutBloques.getChildren().add(
        BotonSimple.crearBotonSimple(rutaImagen, descripcion, handler )
        );
    }

    public void agregarBotonBloqueCompuesto(LayoutBloques layoutBloques) {
        if (! esSimple){
            agregarBoton(layoutBloques);
        }
    }
}
