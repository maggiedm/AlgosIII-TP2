package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DibujoTest {

    @Test
    public void test01DibujarDosLineas() {
        Dibujo dibujo = new Dibujo();
        Posicion posicion1 = new Posicion();
        Posicion posicion2 = new Posicion(0,1);
        Posicion posicion3 = new Posicion(1,1);

        dibujo.dibujarLinea(posicion1, posicion2);
        dibujo.dibujarLinea(posicion2, posicion3);

        assertEquals(2, dibujo.getCantidadLineas());
    }

    @Test
    public void test02DetectarLineaYaDibujadaYNoLaDibujaDeNuevo() {
        Dibujo dibujo = new Dibujo();
        Posicion posicion1 = new Posicion();
        Posicion posicion2 = new Posicion(0,1);

        dibujo.dibujarLinea(posicion1, posicion2);
        dibujo.dibujarLinea(posicion2, posicion1);

        assertEquals(1, dibujo.getCantidadLineas());
    }
}