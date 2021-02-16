package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LineaTest {

    @Test
    public void test01DosLineasConMismoOrigenDestinoYVisibilidadSonIguales() {
        Linea linea = new Linea(new Posicion(), new Posicion(0,1), true);
        Linea linea2 = new Linea(new Posicion(), new Posicion(0,1), true);
        assertTrue(linea.esIgual(linea2));
    }

    @Test
    public void test02DosLineasConOrigenYDestinoInvertidosYMismaVisibilidadNoSonIguales() {
        Linea linea = new Linea(new Posicion(), new Posicion(0,1), true);
        Linea linea2 = new Linea(new Posicion(0,1), new Posicion(), true);
        assertFalse(linea.esIgual(linea2));
    }

    @Test
    public void test03DosLineasConOrigenDestinoYVisibilidadInvertidosNoSonIguales() {
        Linea linea = new Linea(new Posicion(), new Posicion(0,1), true);
        Linea linea2 = new Linea(new Posicion(0,1), new Posicion(), false);
        assertFalse(linea.esIgual(linea2));
    }

    @Test
    public void test04DosLineasConMismoOrigenYDestinoYVisibilidadInvertidaNoSonIguales() {
        Linea linea = new Linea(new Posicion(), new Posicion(0,1), true);
        Linea linea2 = new Linea(new Posicion(), new Posicion(0,1), false);
        assertFalse(linea.esIgual(linea2));
    }

    @Test
    public void test03LineaConOrigenyDestinoIgualesEsInvalida() {
        assertThrows(LineaInvalidaException.class, () -> new Linea(new Posicion(0, 0), new Posicion(0, 0), true));
    }
}