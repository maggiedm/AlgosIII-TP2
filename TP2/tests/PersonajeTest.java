import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonajeTest {

    @Test
    public void test01PersonajeNuevoTienePosicion00() {
        Personaje personaje = new Personaje();

        assertEquals(personaje.getPosicion().getX(), 0);
        assertEquals(personaje.getPosicion().getY(), 0);
    }

    @Test
    public void test02PersonajeNuevoTieneLapizArriba() {
        Personaje personaje = new Personaje();

        assertThat(personaje.getLapiz().getCondicion(), instanceOf(LapizArriba.class));
    }

    @Test
    public void test03PersonajeBajaLapizTieneLapizAbajo() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        assertThat(personaje.getLapiz().getCondicion(), instanceOf(LapizAbajo.class));
    }

    @Test
    public void test04PersonajeBajaYSubeLapizTieneLapizArriba() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        personaje.subirLapiz();
        assertThat(personaje.getLapiz().getCondicion(), instanceOf(LapizArriba.class));
    }

    @Test
    public void test05PersonajeConLapizArribaSubeLapizTieneLapizArriba() {
        Personaje personaje = new Personaje();

        personaje.subirLapiz();
        assertThat(personaje.getLapiz().getCondicion(), instanceOf(LapizArriba.class));
    }

    @Test
    public void test06PersonajeConLapizAbajoBajaLapizTieneLapizAbajo() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        personaje.bajarLapiz();
        assertThat(personaje.getLapiz().getCondicion(), instanceOf(LapizAbajo.class));
    }

    @Test
    public void test07PersonajeMoverADerechaMueveElPersonajeUnaPosicionADerecha() {
        Personaje personaje = new Personaje();

        personaje.mover(new Derecha());
        assertEquals(1, personaje.getPosicion().getX());
        assertEquals(0, personaje.getPosicion().getY());
    }

    @Test
    public void test08PersonajeMoverAIzquierdaMueveElPersonajeUnaPosicionAIzquierda() {
        Personaje personaje = new Personaje();

        personaje.mover(new Izquierda());
        assertEquals(-1, personaje.getPosicion().getX());
        assertEquals(0, personaje.getPosicion().getY());
    }

    @Test
    public void test09PersonajeMoverArribaMueveElPersonajeUnaPosicionArriba() {
        Personaje personaje = new Personaje();

        personaje.mover(new Arriba());
        assertEquals(0, personaje.getPosicion().getX());
        assertEquals(1, personaje.getPosicion().getY());
    }

    @Test
    public void test10PersonajeMoverAbajoMueveElPersonajeUnaPosicionAbajo() {
        Personaje personaje = new Personaje();

        personaje.mover(new Abajo());
        assertEquals(0, personaje.getPosicion().getX());
        assertEquals(-1, personaje.getPosicion().getY());
    }

}
