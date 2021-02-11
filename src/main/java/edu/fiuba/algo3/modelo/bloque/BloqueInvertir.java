package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.SecuenciaBloques;

public class BloqueInvertir extends SecuenciaBloques implements Bloque{

    public void ejecutar(Personaje unPersonaje){
        bloques.forEach(bloque -> bloque.invertir().ejecutar(unPersonaje));
    }

    public Bloque invertir() {
        BloqueInvertir nBloque = new BloqueInvertir();
        bloques.forEach(bloque -> nBloque.agregarBloque(bloque.invertir()));
        return nBloque;
    }
}
