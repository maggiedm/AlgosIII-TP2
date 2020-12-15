package tp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonajeTest {

    @Test
    public void test01PersonajeNuevoTienePosicion00() {
        Personaje personaje = new Personaje();

        assertEquals(0, personaje.getPosicion().getX());
        assertEquals(0, personaje.getPosicion().getY());
    }

    @Test
    public void test02PersonajeMoverADerechaMueveElPersonajeUnaPosicionADerecha() {
        Personaje personaje = new Personaje();

        personaje.mover(new Derecha());
        assertEquals(1, personaje.getPosicion().getX());
        assertEquals(0, personaje.getPosicion().getY());
    }

    @Test
    public void test03PersonajeMoverAIzquierdaMueveElPersonajeUnaPosicionAIzquierda() {
        Personaje personaje = new Personaje();

        personaje.mover(new Izquierda());
        assertEquals(-1, personaje.getPosicion().getX());
        assertEquals(0, personaje.getPosicion().getY());
    }

    @Test
    public void test04PersonajeMoverArribaMueveElPersonajeUnaPosicionArriba() {
        Personaje personaje = new Personaje();

        personaje.mover(new Arriba());
        assertEquals(0, personaje.getPosicion().getX());
        assertEquals(1, personaje.getPosicion().getY());
    }

    @Test
    public void test05PersonajeMoverAbajoMueveElPersonajeUnaPosicionAbajo() {
        Personaje personaje = new Personaje();

        personaje.mover(new Abajo());
        assertEquals(0, personaje.getPosicion().getX());
        assertEquals(-1, personaje.getPosicion().getY());
    }

    @Test
    public void test06PersonajeMoverDosPosicionesEnDireccionesDistintasActualizaPosicionPersonaje() {
        Personaje personaje = new Personaje();

        personaje.mover(new Abajo());
        personaje.mover(new Izquierda());
        assertEquals(-1, personaje.getPosicion().getX());
        assertEquals(-1, personaje.getPosicion().getY());
    }

    @Test
    public void test07PersonajeMoverDosPosicionesEnMismaDireccionActualizaPosicionPersonaje() {
        Personaje personaje = new Personaje();

        personaje.mover(new Derecha());
        personaje.mover(new Derecha());
        assertEquals(2, personaje.getPosicion().getX());
        assertEquals(0, personaje.getPosicion().getY());
    }

    @Test
    public void test08PersonajeMoverDosPosicionesEnDireccionesOpuestasPosicionPersonajeOriginal() {
        Personaje personaje = new Personaje();

        personaje.mover(new Derecha());
        personaje.mover(new Izquierda());
        assertEquals(0, personaje.getPosicion().getX());
        assertEquals(0, personaje.getPosicion().getY());
    }

    @Test
    public void test09PersonajeNuevoMoverADerechaNoAgregaLineaAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.mover(new Derecha());

        assertEquals(0, personaje.getDibujo().getLineas().size());
    }

    @Test
    public void test10PersonajeMoverADerechaConLapizAbajoAgregaLineaAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        personaje.mover(new Derecha());

        assertEquals(1, personaje.getDibujo().getLineas().size());
    }

    @Test
    public void test11PersonajeMoverYVolverAPosicionAnteriorConLapizAbajoAgregaUnaLineaAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        personaje.mover(new Derecha());
        personaje.mover(new Izquierda());

        assertEquals(1, personaje.getDibujo().getLineas().size());
    }

    @Test
    public void test12PersonajeMoverUnaPosicionConLapizArribaBajarLapizYMoverOtraPosicionAgregaUnaLineaAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.mover(new Derecha());
        personaje.bajarLapiz();
        personaje.mover(new Arriba());

        assertEquals(1, personaje.getDibujo().getLineas().size());
    }

    @Test
    public void test13PersonajeMoverUnaPosicionConLapizAbajoSubirLapizYMoverOtraPosicionAgregaUnaLineaAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        personaje.mover(new Derecha());
        personaje.subirLapiz();
        personaje.mover(new Arriba());

        assertEquals(1, personaje.getDibujo().getLineas().size());
    }

    @Test
    public void test14PersonajeMoverDosPosicionesConLapizAbajoAgregaDosLineasAlDibujo() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        personaje.mover(new Derecha());
        personaje.mover(new Arriba());

        assertEquals(2, personaje.getDibujo().getLineas().size());
    }

}
