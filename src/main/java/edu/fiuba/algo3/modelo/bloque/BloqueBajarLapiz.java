package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.MostradorBloqueSimple;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.scene.layout.VBox;

public class BloqueBajarLapiz implements Bloque {

    public void ejecutar(Personaje unPersonaje) { unPersonaje.bajarLapiz(); }

    public Bloque invertir(){
        return new BloqueSubirLapiz();
    }

}
