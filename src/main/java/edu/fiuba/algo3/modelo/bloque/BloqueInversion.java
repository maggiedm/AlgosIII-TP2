package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.MostradorBloqueSimple;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.SecuenciaBloques;
import javafx.scene.layout.VBox;

public class BloqueInversion extends SecuenciaBloques implements Bloque{

    private String descripcion = "Invertir";

    public void ejecutar(Personaje unPersonaje){
        bloques.forEach(bloque -> bloque.invertir().ejecutar(unPersonaje));
    }

    public Bloque invertir() {
        BloqueInversion unBloque = new BloqueInversion();
        bloques.forEach(bloque -> unBloque.agregarBloque(bloque.invertir()));
        return unBloque;
    }

    @Override
    public String getDescripcion() {return descripcion;};

    @Override
    public void mostrar(VBox layout) {
        new MostradorBloqueSimple(descripcion, layout);
    } // Chequear
}
