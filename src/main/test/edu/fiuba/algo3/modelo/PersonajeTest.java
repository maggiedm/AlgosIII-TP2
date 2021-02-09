package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonajeTest {

    @Test
    public void test01PersonajeNuevoTienePosicion00() {
        Personaje personaje = new Personaje();

        assertTrue(personaje.getPosicion().esIgualA(new Posicion(0,0)));
    }

    @Test
    public void test02PersonajeMoverADerechaMueveElPersonajeUnaPosicionADerecha() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.derecha());
        assertTrue(personaje.getPosicion().esIgualA(new Posicion(1,0)));
    }

    @Test
    public void test03PersonajeMoverAIzquierdaMueveElPersonajeUnaPosicionAIzquierda() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.izquierda());
        assertTrue(personaje.getPosicion().esIgualA(new Posicion(-1,0)));
    }

    @Test
    public void test04PersonajeMoverArribaMueveElPersonajeUnaPosicionArriba() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.arriba());
        assertTrue(personaje.getPosicion().esIgualA(new Posicion(0,1)));
    }

    @Test
    public void test05PersonajeMoverAbajoMueveElPersonajeUnaPosicionAbajo() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.abajo());
        assertTrue(personaje.getPosicion().esIgualA(new Posicion(0,-1)));
    }

    @Test
    public void test06PersonajeMoverDosPosicionesEnDireccionesDistintasActualizaPosicionPersonaje() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.abajo());
        personaje.mover(Direccion.izquierda());
        assertTrue(personaje.getPosicion().esIgualA(new Posicion(-1,-1)));
    }

    @Test
    public void test07PersonajeMoverDosPosicionesEnMismaDireccionActualizaPosicionPersonaje() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.derecha());
        personaje.mover(Direccion.derecha());
        assertTrue(personaje.getPosicion().esIgualA(new Posicion(2,0)));
    }

    @Test
    public void test08PersonajeMoverDosPosicionesEnDireccionesOpuestasPosicionPersonajeOriginal() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.derecha());
        personaje.mover(Direccion.izquierda());
        assertTrue(personaje.getPosicion().esIgualA(new Posicion(0,0)));
    }

    @Test
    public void test09PersonajeNuevoMoverADerechaNoAgregaLineaAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.derecha());

        assertEquals(0, personaje.getDibujo().getLineas().size());
    }

    @Test
    public void test10PersonajeMoverADerechaConLapizAbajoAgregaLineaAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());

        assertEquals(1, personaje.getDibujo().getLineas().size());
    }

    @Test
    public void test11PersonajeMoverYVolverAPosicionAnteriorConLapizAbajoAgregaUnaLineaAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());
        personaje.mover(Direccion.izquierda());

        assertEquals(1, personaje.getDibujo().getLineas().size());
    }

    @Test
    public void test12PersonajeMoverUnaPosicionConLapizArribaBajarLapizYMoverOtraPosicionAgregaUnaLineaAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.mover(Direccion.derecha());
        personaje.bajarLapiz();
        personaje.mover(Direccion.arriba());

        assertEquals(1, personaje.getDibujo().getLineas().size());
    }

    @Test
    public void test13PersonajeMoverUnaPosicionConLapizAbajoSubirLapizYMoverOtraPosicionAgregaUnaLineaAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());
        personaje.subirLapiz();
        personaje.mover(Direccion.arriba());

        assertEquals(1, personaje.getDibujo().getLineas().size());
    }

    @Test
    public void test14PersonajeMoverDosPosicionesConLapizAbajoAgregaDosLineasAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        personaje.mover(Direccion.derecha());
        personaje.mover(Direccion.arriba());

        assertEquals(2, personaje.getDibujo().getLineas().size());
    }

}
