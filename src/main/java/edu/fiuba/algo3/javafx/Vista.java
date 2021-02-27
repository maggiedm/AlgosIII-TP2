package edu.fiuba.algo3.javafx;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Vista {
    public static void agregarMarcadorFinal(VBox layout, String descripcion) {

        Label etiqueta = new Label(descripcion);
        etiqueta.setStyle(
                "-fx-padding: 10;" +
                "-fx-pref-height: 30;" +
                "-fx-pref-width: 150;" +
                "-fx-background-radius: 5;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #333333;" +
                "-fx-background-color: silver;"+
                "-fx-alignment: center");

        layout.getChildren().add(etiqueta);
    }

    public static VBox crearLayoutContenedorDeBloques(VBox layoutSecuenciaNueva, String rutaImagen) {
        VBox layoutContenedor = new VBox();

        layoutContenedor.getChildren().addAll(new ImageView("file:" + rutaImagen), layoutSecuenciaNueva);

        //Borde para separar secuencias de bloques
        layoutContenedor.setStyle("-fx-padding: 5;" +
                "-fx-border-style: solid inside;" +
                "-fx-background-radius: 5;" +
                "-fx-border-width: 1;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: gray;" +
                "-fx-background-color: rgb(252,205,235)");
        return layoutContenedor;
    }
}
