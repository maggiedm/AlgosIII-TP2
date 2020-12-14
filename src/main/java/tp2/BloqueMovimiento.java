package tp2;

public abstract class BloqueMovimiento implements Bloque {

        protected Direccion direccion;

        public BloqueMovimiento(Direccion unaDireccion){ direccion = unaDireccion;}

        public void ejecutar (Personaje unPersonaje){ unPersonaje.mover(direccion);}
}
