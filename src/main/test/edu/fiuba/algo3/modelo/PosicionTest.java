package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PosicionTest {

    @Test
    public void test01CompararPosiciones() {
        Posicion posicion = new Posicion(3,0);
        Posicion nuevaPosicion = new Posicion (3,0);

        assertTrue(posicion.esIgualA(nuevaPosicion));
    }

    @Test
    public void test02PosicionNuevaEstaEnOrigen() {
        Posicion posicion = new Posicion();

        assertTrue(posicion.esIgualA(new Posicion(0,0)));
    }

    @Test
    public void test03ObtenerSiguientePosicionConMovimientoADerecha() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(Direccion.derecha());

        assertTrue(nuevaPos.esIgualA(new Posicion(1,0)));
    }

    @Test
    public void test04ObtenerSiguientePosicionConMovimientoAIzquierda() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(Direccion.izquierda());

        assertTrue(nuevaPos.esIgualA(new Posicion(-1,0)));
    }

    @Test
    public void test05ObtenerSiguientePosicionConMovimientoArriba() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(Direccion.arriba());

        assertTrue(nuevaPos.esIgualA(new Posicion(0,1)));
    }

    @Test
    public void test06ObtenerSiguientePosicionConMovimientoAbajo() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(Direccion.abajo());

        assertTrue(nuevaPos.esIgualA(new Posicion(0,-1)));
    }

    @Test
    public void test07DesplazarPosicion() {
        Posicion posicion = new Posicion();
        posicion = posicion.desplazar(3, 0);

        assertTrue(posicion.esIgualA(new Posicion(3,0)));
    }

    @Test
    public void test08DesplazarPosicionMasDeUnaVez() {
        Posicion posicion = new Posicion();
        posicion = posicion.desplazar(3, -1);
        posicion = posicion.desplazar(-2, 4);

        assertTrue(posicion.esIgualA(new Posicion(1, 3)));
    }
}
