package tp2;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LapizTest {

    @Test
    public void test01LapizNuevoTieneCondicionArriba() {
        Lapiz lapiz = new Lapiz();

        assertThat(lapiz.getCondicion(), instanceOf(LapizArriba.class));
    }

    @Test
    public void test02BajarLapizCondicionLapizAbajo() {
        Lapiz lapiz = new Lapiz();
        lapiz.bajar();

        assertThat(lapiz.getCondicion(), instanceOf(LapizAbajo.class));
    }
    @Test
    public void test03SubirLapizCondicionLapizArriba() {
        Lapiz lapiz = new Lapiz();
        lapiz.bajar();
        lapiz.subir();

        assertThat(lapiz.getCondicion(), instanceOf(LapizArriba.class));
    }

    @Test
    public void test04LapizArribaSubirLapizCondicionLapizArriba() {
        Lapiz lapiz = new Lapiz();
        lapiz.subir();

        assertThat(lapiz.getCondicion(), instanceOf(LapizArriba.class));
    }

    @Test
    public void test05LapizAbajoBajarCondicionLapizAbajo() {
        Lapiz lapiz = new Lapiz();
        lapiz.bajar();
        lapiz.bajar();

        assertThat(lapiz.getCondicion(), instanceOf(LapizAbajo.class));
    }

    @Test
    public void test06LapizArribaNoDibujaLinea() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.dibujarLinea(new Posicion(), new Posicion(), dibujo);

        assertTrue(dibujo.getLineas().isEmpty());
    }

    @Test
    public void test06LapizAbajoDibujaUnaLinea() {
        Lapiz lapiz = new Lapiz();
        Dibujo dibujo = new Dibujo();

        lapiz.bajar();
        lapiz.dibujarLinea(new Posicion(), new Posicion(), dibujo);

        assertEquals(1, dibujo.getLineas().size());
    }
}
