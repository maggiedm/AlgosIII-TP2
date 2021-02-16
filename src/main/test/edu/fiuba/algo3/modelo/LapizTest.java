package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.lapiz.Lapiz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class LapizTest {

    @Test
    public void test01LapizNuevoDibujaLineaInvisible() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.dibujarLinea(new Posicion(), new Posicion(1,0), dibujo);

        assertFalse(dibujo.lineaEsVisible(0));
    }

    @Test
    public void test02BajoLapizYDibujaUnaLineaVisible() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.bajar();
        lapiz.dibujarLinea(new Posicion(), new Posicion(0,1), dibujo);

        assertTrue(dibujo.lineaEsVisible(0));
    }

    @Test
    public void test03SuboLapizYDibujaLineaInvisible() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.subir();
        lapiz.dibujarLinea(new Posicion(), new Posicion(0,1), dibujo);

        assertFalse(dibujo.lineaEsVisible(0));
    }

    @Test
    public void test04BajoYSuboLapizYDibujaLineaNoVisible() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.bajar();
        lapiz.subir();
        lapiz.dibujarLinea(new Posicion(), new Posicion(0, 1), dibujo);

        assertFalse(dibujo.lineaEsVisible(0));
    }

    @Test
    public void test05LapizArribaDibujaLineaCorrecta() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.bajar();
        lapiz.subir();
        lapiz.dibujarLinea(new Posicion(), new Posicion(0, 1), dibujo);

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(), new Posicion(0, 1), false)));
    }

    @Test
    public void test06LapizAbajoDibujaLineaCorrecta() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.bajar();
        lapiz.dibujarLinea(new Posicion(), new Posicion(0, 1), dibujo);

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(), new Posicion(0, 1), true)));
    }
}