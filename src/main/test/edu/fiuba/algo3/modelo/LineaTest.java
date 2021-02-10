package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LineaTest {

    @Test
    public void test01DosLineasConMismoOrigenYDestinoSonIguales() {
        Linea linea = new Linea(new Posicion(), new Posicion(0,1));
        Linea linea2 = new Linea(new Posicion(), new Posicion(0,1));
        assertTrue(linea.esIgual(linea2));
    }

    @Test
    public void test02DosLineasConOrigenYDestinoInvertidosSonIguales() {
        Linea linea = new Linea(new Posicion(), new Posicion(0,1));
        Linea linea2 = new Linea(new Posicion(0,1), new Posicion());
        assertTrue(linea.esIgual(linea2));
    }

    @Test
    public void test03LineaConOrigenyDestinoIgualesEsInvalida() {
        assertThrows(LineaInvalidaException.class, () -> new Linea(new Posicion(0, 0), new Posicion(0, 0)));
    }
}