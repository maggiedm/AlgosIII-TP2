package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;


public class BloqueMovimientoTest {

        @Test
        public void test01EjecutarMovimientoALaDerecha(){
            Personaje personaje = new Personaje();
            BloqueMovimiento movimiento = new BloqueDerecha();

            movimiento.ejecutar(personaje);

            assertTrue(personaje.getPosicion().esIgualA(Posicion.crearConCoordenadas(new Coordenadas(1, 0))));
        }

    @Test
    public void test02EjecutarMovimientoALaIzquierda(){
        Personaje personaje = new Personaje();
        BloqueMovimiento movimiento = new BloqueIzquierda();

        movimiento.ejecutar(personaje);

        assertTrue(personaje.getPosicion().esIgualA(Posicion.crearConCoordenadas(new Coordenadas(-1, 0))));
    }

    @Test
    public void test03EjecutarMovimientoAbajo(){
        Personaje personaje = new Personaje();
        BloqueMovimiento movimiento = new BloqueAbajo();

        movimiento.ejecutar(personaje);

        assertTrue(personaje.getPosicion().esIgualA(Posicion.crearConCoordenadas(new Coordenadas(0, -1))));
    }

    @Test
    public void test04EjecutarMovimientoArriba(){
        Personaje personaje = new Personaje();
        BloqueMovimiento movimiento = new BloqueArriba();

        movimiento.ejecutar(personaje);

        assertTrue(personaje.getPosicion().esIgualA(Posicion.crearConCoordenadas(new Coordenadas(0, 1))));
    }
}
