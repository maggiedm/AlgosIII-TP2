package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.javafx.MostradorBloqueSimple;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.scene.layout.VBox;

public class BloqueSubirLapiz implements Bloque {

    public void ejecutar(Personaje unPersonaje) { unPersonaje.subirLapiz(); }

    public Bloque invertir(){
        return new BloqueBajarLapiz();
    }


}
