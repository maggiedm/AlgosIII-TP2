package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.MostradorBloqueSimple;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.scene.layout.VBox;

public class BloqueBajarLapiz implements Bloque {

    private String descripcion = "Bajar Lapiz";

    public void ejecutar(Personaje unPersonaje) { unPersonaje.bajarLapiz(); }

    public Bloque invertir(){
        return new BloqueSubirLapiz();
    }

    @Override
    public void mostrar(VBox layout) { new MostradorBloqueSimple(descripcion, layout); }

    public String getDescripcion(){return descripcion;}

}
