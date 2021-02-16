package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.bloque.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlgoritmoTest {

    @Test
    public void test01AlgoritmoNuevoNoTieneBloques() {
        Algoritmo algoritmo = new Algoritmo();

        assertEquals(0, algoritmo.getCantidadDeBloques());
    }

    @Test
    public void test02AlgoritmoAgregar2BloquesTiene2Bloques() {
        Algoritmo algoritmo = new Algoritmo();

        algoritmo.agregarBloque(BloqueMovimiento.bloqueArriba());
        algoritmo.agregarBloque(BloqueMovimiento.bloqueAbajo());

        assertEquals(2, algoritmo.getCantidadDeBloques());
    }

    @Test
    public void test03DTrasEjecutarAlgoritmoCon2BloquesAlgoritmoTiene2Bloques() {
        Algoritmo algoritmo = new Algoritmo();

        algoritmo.agregarBloque(BloqueMovimiento.bloqueArriba());
        algoritmo.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoritmo.ejecutar(new Personaje(new Dibujo()));

        assertEquals(2, algoritmo.getCantidadDeBloques());
    }

    @Test
    public void test04NoSePuedeGuardarUnAlgoritmoVacio() {

        assertThrows(GuardarAlgoritmoVacioException.class, () -> new Algoritmo().guardar());
    }

    //Ver de agregar tests tieneLinea,agregar distintos Bloques y ejecutar
}
