package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    @Test
    public void test01PersonajeNuevoTienePosicionEnElOrigen() {
        Personaje personaje = new Personaje(new Dibujo());

        assertTrue(personaje.estaEnPosicion(new Posicion(0,0)));
    }

    @Test
    public void test02MoverADerechaMueveElPersonajeUnaPosicionADerecha() {
        Personaje personaje = new Personaje(new Dibujo());

        personaje.mover(Direccion.derecha());
        assertTrue(personaje.estaEnPosicion(new Posicion(1,0)));
    }

    @Test
    public void test03MoverAIzquierdaMueveElPersonajeUnaPosicionAIzquierda() {
        Personaje personaje = new Personaje(new Dibujo());

        personaje.mover(Direccion.izquierda());
        assertTrue(personaje.estaEnPosicion(new Posicion(-1,0)));
    }

    @Test
    public void test04MoverArribaMueveElPersonajeUnaPosicionArriba() {
        Personaje personaje = new Personaje(new Dibujo());

        personaje.mover(Direccion.arriba());
        assertTrue(personaje.estaEnPosicion(new Posicion(0,1)));
    }

    @Test
    public void test05MoverAbajoMueveElPersonajeUnaPosicionAbajo() {
        Personaje personaje = new Personaje(new Dibujo());

        personaje.mover(Direccion.abajo());
        assertTrue(personaje.estaEnPosicion(new Posicion(0,-1)));
    }

    @Test
    public void test06MoverDosPosicionesEnDireccionesDistintasActualizaPosicionPersonaje() {
        Personaje personaje = new Personaje(new Dibujo());

        personaje.mover(Direccion.abajo());
        personaje.mover(Direccion.izquierda());
        assertTrue(personaje.estaEnPosicion(new Posicion(-1,-1)));
    }

    @Test
    public void test07MoverDosPosicionesEnMismaDireccionActualizaPosicionPersonaje() {
        Personaje personaje = new Personaje(new Dibujo());

        personaje.mover(Direccion.derecha());
        personaje.mover(Direccion.derecha());
        assertTrue(personaje.estaEnPosicion(new Posicion(2,0)));
    }

    @Test
    public void test08MoverDosPosicionesEnDireccionesOpuestasDevuelveALaPosicionOrigen() {
        Personaje personaje = new Personaje(new Dibujo());

        personaje.mover(Direccion.derecha());
        personaje.mover(Direccion.izquierda());
        assertTrue(personaje.estaEnPosicion(new Posicion(0,0)));
    }

    @Test
    public void test09MoverADerechaAUnPersonajeNuevoNoAgregaLineaAlDibujo() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.mover(Direccion.derecha());

        assertEquals(0, dibujo.getCantidadLineas());
    }

    @Test
    public void test10MoverADerechaConLapizAbajoAgregaLineaAlDibujo() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());

        assertEquals(1, dibujo.getCantidadLineas());
    }

    @Test
    public void test11MoverAUnPersonajeConLapizAbajoPorElMismoCaminoMasDeUnaVezAgregaSoloUnaLineaAlDibujo() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());
        personaje.mover(Direccion.izquierda());

        assertEquals(1, dibujo.getCantidadLineas());
    }

    @Test
    public void test12MoverUnaPosicionConLapizArribaYLuegoMoverOtraPosicionConLapizAbajoAgregaSoloUnaLineaAlDibujo() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.mover(Direccion.derecha());
        personaje.bajarLapiz();
        personaje.mover(Direccion.arriba());

        assertEquals(1, dibujo.getCantidadLineas());
    }

    @Test
    public void test13MoverUnaPosicionConLapizAbajoYLuegoMoverOtraPosicionConLapizArribaAgregaSoloUnaLineaAlDibujo() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());
        personaje.subirLapiz();
        personaje.mover(Direccion.arriba());

        assertEquals(1, dibujo.getCantidadLineas());
    }

    @Test
    public void test14MoverDosPosicionesConLapizAbajoAgregaDosLineasAlDibujo() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());
        personaje.mover(Direccion.arriba());

        assertEquals(2, dibujo.getCantidadLineas());
    }

    @Test
    public void test15MoverALaDerechasConLapizAbajoYElDibujoTieneEsaLinea() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());
        Linea linea = new Linea(new Posicion(1,0), new Posicion(0,0) );

        assertTrue(dibujo.tieneLinea(linea));
    }

    @Test
    public void test16MoverALaDerechaConLapizArribaYElDibujoNoTieneEsaLinea() {
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);

        personaje.subirLapiz();
        personaje.mover(Direccion.derecha());

        Linea linea = new Linea(new Posicion(1,0), new Posicion(0,0) );

        assertFalse(dibujo.tieneLinea(linea));
    }
}
