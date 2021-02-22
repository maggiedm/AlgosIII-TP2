package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.Vista;
import edu.fiuba.algo3.javafx.botones.BotonSimple;
import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueCompuestoEventHandler;
import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueEventHandler;
import edu.fiuba.algo3.modelo.bloque.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class LayoutBloques extends VBox{

    static int CANTIDAD_BLOQUES_COMPUESTOS = 3;
    static VBox contenido;
    static final String RUTA_IMAGENES = "recursos/";

    public LayoutBloques(double altura) {

        contenido = new VBox(10);
        ScrollPane sP = new ScrollPane(contenido);
        sP.setPrefViewportHeight(altura*3/4);
        sP.setMinViewportWidth(150);


        Vista.agregarTitulo(this, "Bloques");
        this.getChildren().add(sP);

        this.agregarBotonesBloquesSimples();
        this.agregarBotonesBloquesCompuestos();
    }


    public void agregarBotonesBloquesCompuestos() {

        contenido.getChildren().addAll(

            BotonSimple.crearBotonSimple(
                    RUTA_IMAGENES + "Repetir2.png",
                    "Repite dos veces la secuencia de bloques ingresada.",
                    new BotonAgregarBloqueCompuestoEventHandler(BloqueRepeticion.repetirDosVeces(), this)
            ),


            BotonSimple.crearBotonSimple(
                    RUTA_IMAGENES + "Repetir3.png",
                    "Repite tres veces la secuencia de bloques ingresada.",
                    new BotonAgregarBloqueCompuestoEventHandler(BloqueRepeticion.repetirTresVeces(), this)
            ),

            BotonSimple.crearBotonSimple(
                     RUTA_IMAGENES + "Invertir.png",
                    "Invierte la secuencia de bloques ingresada.",
                    new BotonAgregarBloqueCompuestoEventHandler(new BloqueInversion(), this)
            )
        );
    }

    private void agregarBotonesBloquesSimples() {

        contenido.getChildren().addAll(

            BotonSimple.crearBotonSimple(
                    RUTA_IMAGENES + "Arriba.png",
                    "Mueve al personaje hacia arriba.",
                    new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueArriba(), "Mover Arriba")
            ),


            BotonSimple.crearBotonSimple(
                    RUTA_IMAGENES + "Abajo.png",
                    "Mueve al personaje hacia abajo.",
                    new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueAbajo(), "Mover Arriba")
            ),
                BotonSimple.crearBotonSimple(
                        RUTA_IMAGENES + "Derecha.png",
                        "Mueve al personaje hacia derecha.",
                        new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueDerecha(), "Mover Arriba")
                ),

                BotonSimple.crearBotonSimple(
                        RUTA_IMAGENES + "Izquierda.png",
                        "Mueve al personaje hacia izquierda.",
                        new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueIzquierda(), "Mover Arriba")
                ),


            BotonSimple.crearBotonSimple(
                    RUTA_IMAGENES + "LapizSubir.png",
                    "Sube el lapiz para que el personaje no dibuje.",
                    new BotonAgregarBloqueEventHandler(new BloqueSubirLapiz(), "Subir Lapiz")
            ),

            BotonSimple.crearBotonSimple(
                    RUTA_IMAGENES + "LapizBajar.png",
                    "Baja el lapiz para que el personaje dibuje.",
                    new BotonAgregarBloqueEventHandler(new BloqueBajarLapiz(), "Bajar Lapiz")
            )
        );
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

        this.agregarBotonesBloquesCompuestos();
    }
}
