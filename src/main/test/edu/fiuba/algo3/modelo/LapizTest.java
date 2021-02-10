package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.lapiz.Lapiz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LapizTest {

    @Test
    public void test01LapizNuevoNoDibujaLinea() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.dibujarLinea(new Posicion(), new Posicion(1,0), dibujo);

        assertEquals(0, dibujo.getCantidadLineas());
    }

    @Test
    public void test02BajoLapizYDibujaUnaLinea() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.bajar();
        lapiz.dibujarLinea(new Posicion(), new Posicion(0,1), dibujo);

        assertEquals(1, dibujo.getCantidadLineas());
    }

    @Test
    public void test03SuboLapizYNoDibujaLinea() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.subir();
        lapiz.dibujarLinea(new Posicion(), new Posicion(0,1), dibujo);

        assertEquals(0, dibujo.getCantidadLineas());
    }

    @Test
    public void test04BajoYSuboLapizYNoDibujaLinea() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.bajar();
        lapiz.subir();
        lapiz.dibujarLinea(new Posicion(), new Posicion(0, 1), dibujo);

        assertEquals(0, dibujo.getCantidadLineas());
    }
}