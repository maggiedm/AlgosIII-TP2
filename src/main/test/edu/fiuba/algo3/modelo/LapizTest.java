package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.lapiz.Lapiz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LapizTest {

    @Test
    public void test01LapizNuevoNoDibujaLinea() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.dibujarLinea(new Posicion(), new Posicion(), dibujo);

        assertEquals(0, dibujo.getCantidadLineas());
    }

    @Test
    public void test02BajoLapizYDibujaUnaLinea() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.bajar();
        lapiz.dibujarLinea(new Posicion(), new Posicion(), dibujo);

        assertEquals(1, dibujo.getCantidadLineas());
    }

    @Test
    public void test03SuboLapizYNoDibujaLinea() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.subir();
        lapiz.dibujarLinea(new Posicion(), new Posicion(), dibujo);

        assertEquals(0, dibujo.getCantidadLineas());
    }

    @Test
    public void test04BajoYSuboLapizYNoDibujaLinea() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.bajar();
        lapiz.subir();
        lapiz.dibujarLinea(new Posicion(), new Posicion(), dibujo);

        assertEquals(0, dibujo.getCantidadLineas());
    }
}