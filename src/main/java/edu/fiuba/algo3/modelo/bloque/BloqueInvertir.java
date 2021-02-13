package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.SecuenciaBloques;

public class BloqueInvertir extends SecuenciaBloques implements Bloque{

    private String descripcion = "Invertir";

    public void ejecutar(Personaje unPersonaje){
        bloques.forEach(bloque -> bloque.invertir().ejecutar(unPersonaje));
    }

    public Bloque invertir() {
        BloqueInvertir unBloque = new BloqueInvertir();
        bloques.forEach(bloque -> unBloque.agregarBloque(bloque.invertir()));
        return unBloque;
    }

    @Override
    public String getDescripcion() {return descripcion;};
}
