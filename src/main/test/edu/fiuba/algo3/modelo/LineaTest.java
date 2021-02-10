package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LineaTest {

    @Test
    public void test01DosLineasConMismoOrigenYDestinoSonIguales() {
        Posicion posicion1 = new Posicion();
        Posicion posicion2 = new Posicion(0,1);

        Linea linea = new Linea(posicion1, posicion2);
        Linea linea2 = new Linea(posicion1, posicion2);

        assertTrue(linea.esIgual(linea2));
    }

    @Test
    public void test02DosLineasConOrigenYDestinoInvertidosSonIguales() {
        Posicion posicion1 = new Posicion();
        Posicion posicion2 = new Posicion(0,-1);

        Linea linea = new Linea(posicion1, posicion2);
        Linea linea2 = new Linea(posicion2, posicion1);

        assertTrue(linea.esIgual(linea2));
    }
}

