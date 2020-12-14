package tp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PosicionTest {

    @Test
    public void test01PosicionNuevaEstaEnOrigen() {
        Posicion posicion = new Posicion();

        assertEquals(0,posicion.getX());
        assertEquals(0, posicion.getY());

    }

    @Test
    public void test02PosicionObtenerSiguienteConMovimientoADerechaCreaNuevaPosicion() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(new Derecha());

        assertEquals(0,posicion.getX());
        assertEquals(0, posicion.getY());
        assertEquals(1,nuevaPos.getX());
        assertEquals(0, nuevaPos.getY());

    }

    @Test
    public void test03PosicionObtenerSiguienteConMovimientoAIzquierdaCreaNuevaPosicion() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(new Izquierda());

        assertEquals(0,posicion.getX());
        assertEquals(0, posicion.getY());
        assertEquals(-1,nuevaPos.getX());
        assertEquals(0, nuevaPos.getY());

    }

    @Test
    public void test04PosicionObtenerSiguienteConMovimientoArribaCreaNuevaPosicion() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(new Arriba());

        assertEquals(0,posicion.getX());
        assertEquals(0, posicion.getY());
        assertEquals(0,nuevaPos.getX());
        assertEquals(1, nuevaPos.getY());

    }

    @Test
    public void test05PosicionObtenerSiguienteConMovimientoAbajoCreaNuevaPosicion() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(new Abajo());

        assertEquals(0,posicion.getX());
        assertEquals(0, posicion.getY());
        assertEquals(0,nuevaPos.getX());
        assertEquals(-1, nuevaPos.getY());

    }
}
