package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.SecuenciaBloques;

public class BloqueInversion extends SecuenciaBloques implements Bloque{

    public void ejecutar(Personaje unPersonaje){
        bloques.forEach(bloque -> bloque.invertir().ejecutar(unPersonaje));
    }

    public Bloque invertir() {
        BloqueInversion unBloque = new BloqueInversion();
        bloques.forEach(bloque -> unBloque.agregarBloque(bloque.invertir()));
        return unBloque;
    }
}
