package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PosicionTest {

    @Test
    public void test01PosicionNuevaEstaEnOrigen() {
        Posicion posicion = new Posicion();

        assertTrue(posicion.esIgualA(new Posicion(0,0)));
    }

    @Test
    public void test02PosicionObtenerSiguienteConMovimientoADerecha() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(Direccion.derecha());

        assertTrue(nuevaPos.esIgualA(new Posicion(1,0)));
    }

    @Test
    public void test03PosicionObtenerSiguienteConMovimientoAIzquierda() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(Direccion.izquierda());

        assertTrue(nuevaPos.esIgualA(new Posicion(-1,0)));
    }

    @Test
    public void test04PosicionObtenerSiguienteConMovimientoArriba() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(Direccion.arriba());

        assertTrue(nuevaPos.esIgualA(new Posicion(0,1)));
    }

    @Test
    public void test05PosicionObtenerSiguienteConMovimientoAbajo() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(Direccion.abajo());

        assertTrue(nuevaPos.esIgualA(new Posicion(0,-1)));
    }
}
