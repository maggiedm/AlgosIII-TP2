package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DibujoTest {

    @Test
    public void test01DibujoNuevoEstaVacio(){
        Dibujo dibujo = new Dibujo();

        assertEquals(0, dibujo.getCantidadLineas());
    }

    @Test
    public void test02DibujoGuardaVariasLineas() {
        Dibujo dibujo = new Dibujo();

        dibujo.dibujarLinea(new Posicion(), new Posicion(0, 1));
        dibujo.dibujarLinea(new Posicion(0, 1), new Posicion(1, 2));
        dibujo.dibujarLinea(new Posicion(2, 3), new Posicion(2, 5));

        assertEquals(3, dibujo.getCantidadLineas());
    }

    @Test
    public void test03DibujoNoGuardaDosLineasIguales() {
        Dibujo dibujo = new Dibujo();
        Posicion posicion1 = new Posicion();
        Posicion posicion2 = new Posicion(0,1);

        dibujo.dibujarLinea(posicion1, posicion2);
        dibujo.dibujarLinea(posicion2, posicion1);

        assertEquals(1, dibujo.getCantidadLineas());
    }

    @Test
    public void test04ExcepcionDibujarLineaConInicioYFinIguales(){
        Dibujo dibujo = new Dibujo();

        assertThrows(LineaInvalidaException.class, () -> dibujo.dibujarLinea(new Posicion(0, 0), new Posicion(0, 0)));
    }

    @Test
    public void test05DibujoUnaLineaYElDibujoLaTiene(){
        Dibujo dibujo = new Dibujo();
        dibujo.dibujarLinea(new Posicion(3,2), new Posicion(2,2));
        Linea linea = new Linea(new Posicion(3,2), new Posicion(2,2));

        assertTrue(dibujo.tieneLinea(linea));
    }

    @Test
    public void test06DibujoUnaLineaYElDibujoNoTieneOtraDistinta(){
        Dibujo dibujo = new Dibujo();
        dibujo.dibujarLinea(new Posicion(3,2), new Posicion(2,2));
        Linea linea = new Linea(new Posicion(3,2), new Posicion(0,2));

        assertFalse(dibujo.tieneLinea(linea));
    }
}