package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.Personaje;

public abstract class BloqueMovimiento implements Bloque {

        protected Direccion direccion;

        public BloqueMovimiento(Direccion unaDireccion){ direccion = unaDireccion;}

        public void ejecutar (Personaje unPersonaje){ unPersonaje.mover(direccion);}
}
