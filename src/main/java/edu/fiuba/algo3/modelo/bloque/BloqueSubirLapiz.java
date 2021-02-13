package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.MostradorBloqueSimple;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.scene.layout.VBox;

public class BloqueSubirLapiz implements Bloque {

    private String descripcion = "Subir lapiz";

    public void ejecutar(Personaje unPersonaje) { unPersonaje.subirLapiz(); }

    public Bloque invertir(){
        return new BloqueBajarLapiz();
    }

    @Override
    public void mostrar(VBox layout) { new MostradorBloqueSimple(descripcion, layout); }

    @Override
    public String getDescripcion(){ return descripcion;}

}
