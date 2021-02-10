package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    @Test
    public void test01PersonajeNuevoTienePosicionEnElOrigen() {
        Personaje personaje = new Personaje();

        assertTrue(personaje.estaEnPosicion(new Posicion(0,0)));
    }

    @Test
    public void test02MoverADerechaMueveElPersonajeUnaPosicionADerecha() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.derecha());
        assertTrue(personaje.estaEnPosicion(new Posicion(1,0)));
    }

    @Test
    public void test03MoverAIzquierdaMueveElPersonajeUnaPosicionAIzquierda() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.izquierda());
        assertTrue(personaje.estaEnPosicion(new Posicion(-1,0)));
    }

    @Test
    public void test04MoverArribaMueveElPersonajeUnaPosicionArriba() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.arriba());
        assertTrue(personaje.estaEnPosicion(new Posicion(0,1)));
    }

    @Test
    public void test05MoverAbajoMueveElPersonajeUnaPosicionAbajo() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.abajo());
        assertTrue(personaje.estaEnPosicion(new Posicion(0,-1)));
    }

    @Test
    public void test06MoverDosPosicionesEnDireccionesDistintasActualizaPosicionPersonaje() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.abajo());
        personaje.mover(Direccion.izquierda());
        assertTrue(personaje.estaEnPosicion(new Posicion(-1,-1)));
    }

    @Test
    public void test07MoverDosPosicionesEnMismaDireccionActualizaPosicionPersonaje() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.derecha());
        personaje.mover(Direccion.derecha());
        assertTrue(personaje.estaEnPosicion(new Posicion(2,0)));
    }

    @Test
    public void test08MoverDosPosicionesEnDireccionesOpuestasDevuelveALaPosicionOrigen() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.derecha());
        personaje.mover(Direccion.izquierda());
        assertTrue(personaje.estaEnPosicion(new Posicion(0,0)));
    }

    @Test
    public void test09MoverADerechaAUnPersonajeNuevoNoAgregaLineaAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.derecha());

        assertEquals(0, personaje.cantidadLineas());
    }

    @Test
    public void test10MoverADerechaConLapizAbajoAgregaLineaAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());

        assertEquals(1, personaje.cantidadLineas());
    }

    @Test
    public void test11MoverAUnPersonajeConLapizAbajoPorElMismoCaminoMasDeUnaVezAgregaSoloUnaLineaAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());
        personaje.mover(Direccion.izquierda());

        assertEquals(1, personaje.cantidadLineas());
    }

    @Test
    public void test12MoverUnaPosicionConLapizArribaYLuegoMoverOtraPosicionConLapizAbajoAgregaSoloUnaLineaAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.derecha());
        personaje.bajarLapiz();
        personaje.mover(Direccion.arriba());

        assertEquals(1, personaje.cantidadLineas());
    }

    @Test
    public void test13MoverUnaPosicionConLapizAbajoYLuegoMoverOtraPosicionConLapizArribaAgregaSoloUnaLineaAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());
        personaje.subirLapiz();
        personaje.mover(Direccion.arriba());

        assertEquals(1, personaje.cantidadLineas());
    }

    @Test
    public void test14MoverDosPosicionesConLapizAbajoAgregaDosLineasAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());
        personaje.mover(Direccion.arriba());

        assertEquals(2, personaje.cantidadLineas());
    }

    @Test
    public void test15MoverALaDerechasConLapizAbajoYElDibujoTieneEsaLinea() {
        Personaje personaje = new Personaje();
        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());

        Linea linea = new Linea(new Posicion(1,0), new Posicion(0,0) );

        assertTrue(personaje.dibujoTieneLinea(linea));
    }

    @Test
    public void test16MoverALaDerechaConLapizArribaYElDibujoNoTieneEsaLinea() {
        Personaje personaje = new Personaje();
        personaje.subirLapiz();
        personaje.mover(Direccion.derecha());

        Linea linea = new Linea(new Posicion(1,0), new Posicion(0,0) );

        assertFalse(personaje.dibujoTieneLinea(linea));
    }
}
