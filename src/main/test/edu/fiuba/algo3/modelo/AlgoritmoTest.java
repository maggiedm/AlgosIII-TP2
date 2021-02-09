package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.bloque.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoritmoTest {

    @Test
    public void test01AlgoritmoNuevoNoTieneBloques() {
        Algoritmo algoritmo = new Algoritmo();

        assertEquals(0, algoritmo.getSecuenciaDeBloques().size());
    }

    @Test
    public void test02AlgoritmoAgregar2BloquesTieneSecuenciaDeLargo2() {
        Algoritmo algoritmo = new Algoritmo();

        algoritmo.agregarBloque(BloqueMovimiento.bloqueArriba());
        algoritmo.agregarBloque(BloqueMovimiento.bloqueAbajo());

        assertEquals(2, algoritmo.getSecuenciaDeBloques().size());
    }

    @Test
    public void test03DTrasEjecutarAlgoritmoCon2BloquesAlgoritmoTiene2Bloques() {
        Algoritmo algoritmo = new Algoritmo();

        algoritmo.agregarBloque(BloqueMovimiento.bloqueArriba());
        algoritmo.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoritmo.ejecutar(new Personaje());

        assertEquals(2, algoritmo.getSecuenciaDeBloques().size());
    }

}
