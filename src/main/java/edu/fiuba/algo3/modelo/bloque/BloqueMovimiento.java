package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.MostradorBloqueSimple;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.scene.layout.VBox;

public class BloqueMovimiento implements Bloque {

        private final Direccion direccion;

        private BloqueMovimiento(Direccion unaDireccion){ direccion = unaDireccion;}

        public static BloqueMovimiento bloqueDerecha(){
                return new BloqueMovimiento(Direccion.derecha());
        }

        public static BloqueMovimiento bloqueIzquierda(){
                return new BloqueMovimiento(Direccion.izquierda());
        }

        public static BloqueMovimiento bloqueArriba(){
                return new BloqueMovimiento(Direccion.arriba());
        }

        public static BloqueMovimiento bloqueAbajo(){
                return new BloqueMovimiento(Direccion.abajo());
        }

        public void ejecutar(Personaje unPersonaje) {
                unPersonaje.mover(direccion);
        }

        public Bloque invertir(){
                return new BloqueMovimiento(direccion.invertir());
        }

        @Override
        public void mostrar(VBox layout) {
                new MostradorBloqueSimple("Mover a la " /*+direccion.getDescripcion()*/, layout);
        }

        @Override
        public String getDescripcion(){ return "Mover a la "; /*+direccion.getDescripcion()*/};
}
