package tp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DireccionTest {

    @Test
    public void test01DireccionDerechaCoordenadasDireccionCorrectas() {
        Direccion dir = new Derecha();

        assertEquals(1, dir.getCoordenadas().getX());
        assertEquals(0, dir.getCoordenadas().getY());
    }

    @Test
    public void test02DireccionIzquierdaCoordenadasDireccionCorrectas() {
        Direccion dir = new Izquierda();

        assertEquals(-1, dir.getCoordenadas().getX());
        assertEquals(0, dir.getCoordenadas().getY());
    }

    @Test
    public void test03DireccionArribaCoordenadasDireccionCorrectas() {
        Direccion dir = new Arriba();

        assertEquals(0, dir.getCoordenadas().getX());
        assertEquals(1, dir.getCoordenadas().getY());
    }

    @Test
    public void test04DireccionAbajoCoordenadasDireccionCorrectas() {
        Direccion dir = new Abajo();

        assertEquals(0, dir.getCoordenadas().getX());
        assertEquals(-1, dir.getCoordenadas().getY());
    }
}
