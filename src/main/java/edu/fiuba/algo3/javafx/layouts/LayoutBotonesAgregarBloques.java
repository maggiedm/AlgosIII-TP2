package edu.fiuba.algo3.javafx.layouts;

import edu.fiuba.algo3.javafx.Vista;
import edu.fiuba.algo3.javafx.botones.BotonSimple;
import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueCompuestoEventHandler;
import edu.fiuba.algo3.javafx.handlers.BotonAgregarBloqueEventHandler;
import edu.fiuba.algo3.modelo.bloque.BloqueBajarLapiz;
import edu.fiuba.algo3.modelo.bloque.BloqueMovimiento;
import edu.fiuba.algo3.modelo.bloque.BloqueRepeticion;
import edu.fiuba.algo3.modelo.bloque.BloqueSubirLapiz;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class LayoutBotonesAgregarBloques {
    public static VBox crear() {

        VBox layoutBloques = new VBox();

        Vista.agregarTitulo(layoutBloques, "Bloques");

        LayoutBotonesAgregarBloques.agregarBotonesBloquesSimples(layoutBloques);
        LayoutBotonesAgregarBloques.agregarBotonesBloquesCompuestos(layoutBloques);

        return layoutBloques;
    }

    public static void agregarBotonesBloquesCompuestos(VBox layoutBloques) {

        layoutBloques.getChildren().addAll(

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/4SKh2L3/BTN-Repetir2.png"),
                    new Tooltip("Repite dos veces la secuencia de bloques ingresada."),
                    new BotonAgregarBloqueCompuestoEventHandler(BloqueRepeticion.repetirDosVeces())
            ),

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/SyYPRYH/BTN-Repetir3.png"),
                    new Tooltip("Repite tres veces la secuencia de bloques ingresada."),
                    new BotonAgregarBloqueCompuestoEventHandler(BloqueRepeticion.repetirTresVeces())
            )
        );
    }

    private static void agregarBotonesBloquesSimples(VBox layoutBloques) {

        layoutBloques.getChildren().addAll(

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/pPxr7HK/Arriba.png"),
                    new Tooltip("Mueve al personaje hacia arriba."),
                    new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueArriba())
            ),

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/t4FK0g0/Abajo.png"),
                    new Tooltip("Mueve al personaje hacia abajo."),
                    new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueAbajo())
            ),

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/wYf8j5J/Izquierda.png"),
                    new Tooltip("Mueve al personaje hacia la izquierda."),
                    new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueIzquierda())
            ),

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/WyW7qt9/Derecha.png"),
                    new Tooltip("Mueve al personaje hacia la derecha."),
                    new BotonAgregarBloqueEventHandler(BloqueMovimiento.bloqueDerecha())
            ),

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/0McPTHL/LPZ-Subir.png"),
                    new Tooltip("Sube el lapiz para que el personaje no dibuje."),
                    new BotonAgregarBloqueEventHandler(new BloqueSubirLapiz())
            ),

            BotonSimple.crearBotonSimple(
                    new ImageView("https://i.ibb.co/cJytfST/LPZ-Bajar.png"),
                    new Tooltip("Baja el lapiz para que el personaje dibuje."),
                    new BotonAgregarBloqueEventHandler(new BloqueBajarLapiz())
            )
        );
    }


    public static void reiniciarBloquesCompuestos(VBox layoutBloques) {
        //Eliminar los 2 botones de BloquesCompuestos y volverlos a iniciar
        layoutBloques.getChildren().remove(layoutBloques.getChildren().size()-1);
        layoutBloques.getChildren().remove(layoutBloques.getChildren().size()-1);

        LayoutBotonesAgregarBloques.agregarBotonesBloquesCompuestos(layoutBloques);

    }
}
