package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LineaTest {

    @Test
    public void test01DosLineasConMismoOrigenYDestinoSonIguales() {
        Posicion posicion = new Posicion();
        posicion.obtenerSiguiente(Direccion.derecha());
        Linea linea = new Linea(new Posicion(), posicion);
        Linea linea2 = new Linea(new Posicion(), posicion);
        assertTrue(linea.esIgual(linea2));
    }

    @Test
    public void test02DosLineasConOrigenYDestinoInvertidosSonIguales() {
        Posicion posicion = new Posicion();
        posicion.obtenerSiguiente(Direccion.derecha());
        Linea linea = new Linea(new Posicion(), posicion);
        Linea linea2 = new Linea(posicion, new Posicion());
        assertTrue(linea.esIgual(linea2));
    }
}

