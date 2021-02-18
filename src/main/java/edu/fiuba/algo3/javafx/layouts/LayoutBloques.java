package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.Vista;
import edu.fiuba.algo3.javafx.botones.BotonSimple;
import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueCompuestoEventHandler;
import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueEventHandler;
import edu.fiuba.algo3.modelo.bloque.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
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

        this.agregarBotonesBloquesSimples();
        this.agregarBotonesBloquesCompuestos();
    }

    public void agregarBotonBloque(String url, String nombre, Bloque unBloque){
        contenido.getChildren().add(
                BotonSimple.crearBotonSimple(
                        new ImageView(url),
                        new Tooltip(nombre),
                        new BotonAgregarBloqueEventHandler(unBloque, nombre)
                ));
    }

    public void agregarBotonesBloquesCompuestos() {

        contenido.getChildren().addAll(

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/4SKh2L3/BTN-Repetir2.png"),
                    new Tooltip("Repite dos veces la secuencia de bloques ingresada."),
                    new BotonAgregarBloqueCompuestoEventHandler(BloqueRepeticion.repetirDosVeces(), contenido)
            ),

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/SyYPRYH/BTN-Repetir3.png"),
                    new Tooltip("Repite tres veces la secuencia de bloques ingresada."),
                    new BotonAgregarBloqueCompuestoEventHandler(BloqueRepeticion.repetirTresVeces(), contenido)
            ),

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/wwHw1P2/BTN-Invertir.png"),
                    new Tooltip("Invierte la secuencia de bloques ingresada."),
                    new BotonAgregarBloqueCompuestoEventHandler(new BloqueInversion(), contenido)
            )
        );
    }

    private void agregarBotonesBloquesSimples() {

        contenido.getChildren().addAll(

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/pPxr7HK/Arriba.png"),
                    new Tooltip("Mueve al personaje hacia arriba."),
                    new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueArriba(), "Mover Arriba")
            ),

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/t4FK0g0/Abajo.png"),
                    new Tooltip("Mueve al personaje hacia abajo."),
                    new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueAbajo(), "Mover Abajo")
            ),

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/wYf8j5J/Izquierda.png"),
                    new Tooltip("Mueve al personaje hacia la izquierda."),
                    new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueIzquierda(), "Mover a Izquierda")
            ),

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/WyW7qt9/Derecha.png"),
                    new Tooltip("Mueve al personaje hacia la derecha."),
                    new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueDerecha(), "Mover a Derecha")
            ),

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/0McPTHL/LPZ-Subir.png"),
                    new Tooltip("Sube el lapiz para que el personaje no dibuje."),
                    new BotonAgregarBloqueEventHandler(new BloqueSubirLapiz(), "Subir Lapiz")
            ),

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/cJytfST/LPZ-Bajar.png"),
                    new Tooltip("Baja el lapiz para que el personaje dibuje."),
                    new BotonAgregarBloqueEventHandler(new BloqueBajarLapiz(), "Bajar Lapiz")
            )
        );
    }


    public static void reiniciarBloquesCompuestos(VBox layoutBloques) {
        //Elimina los 3 botones de BloquesCompuestos y los vuelve a iniciar
        for (int i = 0; i < CANTIDAD_BLOQUES_COMPUESTOS; i++) {
            layoutBloques.getChildren().remove(layoutBloques.getChildren().size()-1);
        }

        (new LayoutBloques(1000)).agregarBotonesBloquesCompuestos();
    }
}
