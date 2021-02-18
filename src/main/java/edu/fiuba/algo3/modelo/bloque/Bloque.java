package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.modelo.Personaje;
import javafx.scene.layout.VBox;

public interface Bloque {

    void ejecutar(Personaje unPersonaje);

    Bloque invertir();
}
