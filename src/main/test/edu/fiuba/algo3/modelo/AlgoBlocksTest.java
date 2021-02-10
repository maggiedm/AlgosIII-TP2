package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlgoBlocksTest {

    @Test
    public void test01AlgoBlocksNuevoAlgoritmoVacio() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        assertEquals(0, algoBlocks.getAlgoritmo().getCantidadDeBloques());
    }

    @Test
    public void test02AlgoBlocksNuevoPersonajeEnOrigen() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        assertTrue(algoBlocks.getPersonaje().estaEnPosicion(new Posicion()));
    }

    @Test
    public void test03AlgoBlocksAgregarBloqueAlgoritmoTieneUnBloque() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());

        assertEquals(1, algoBlocks.getAlgoritmo().getCantidadDeBloques());
    }

    @Test
    public void test04AlgoBlocksAgregarBloqueMovimientoAlgoritmoSinEjecutarPosicionPersonajeNoCambia() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());

        assertTrue(algoBlocks.getPersonaje().estaEnPosicion(new Posicion()));
    }

    @Test
    public void test05AlgoBlocksAgregarBloqueYEjecutarAlgoritmoTieneUnBloque() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.ejecutarAlgoritmo();

        assertEquals(1, algoBlocks.getAlgoritmo().getCantidadDeBloques());
    }

    @Test
    public void test06AlgoBlocksAgregarBloqueMovimientoYEjecutarAlgoritmoPosicionPersonajeSeActualiza() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.getPersonaje().estaEnPosicion(new Posicion(1, 0)));
    }
    @Test
    public void test07AlgoBlocksEjecutarMovimientoEnPersonajeNuevoNoDibujaLinea() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.ejecutarAlgoritmo();

        assertEquals(0, algoBlocks.getPersonaje().getDibujo().getCantidadLineas());
    }

    @Test
    public void test08AlgoBlocksEjecutarSecuenciaBajarLapizYMoverPersonajeDibujaLinea() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.ejecutarAlgoritmo();

        assertEquals(1, algoBlocks.getPersonaje().getDibujo().getCantidadLineas());
    }

    @Test
    public void test09AlgoBlocksEjecutarSecuenciaMoverPersonajeNuevoYBajarLapizNoDibujaLinea() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.ejecutarAlgoritmo();

        assertEquals(0, algoBlocks.getPersonaje().getDibujo().getCantidadLineas());
    }

/*    @Test
    public void test07AlgoBlocksAgregarBloqueMovimientoYEjecutar2VecesAlgoritmoPosicionPersonajeEsMismaQueEjecutarUnaVezElAlgoritmo() {
        AlgoBlocks algoBlocks = new AlgoBlocks();
        Posicion posicion;

        algoBlocks.agregarBloque(new BloqueDerecha());
        algoBlocks.ejecutarAlgoritmo();
        posicion = algoBlocks.getPersonaje().getPosicion();
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.getPersonaje().estaEnPosicion(posicion));
    }*/

    @Test
    public void test10AlgoBlocksAgregar3BloquesAlgoritmoTiene3Bloques() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());

        assertEquals(3, algoBlocks.getAlgoritmo().getCantidadDeBloques());
    }

    @Test
    public void test11AlgoBlocksEjecutarSecuenciaDe3BloquesMueveAlPersonaje() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.getPersonaje().estaEnPosicion(new Posicion(2, -1)));
    }

    @Test
    public void test12AlgoBlocksEjecutarSecuenciaDe3BloquesConLapizAbajoMueveAlPersonaje() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.getPersonaje().estaEnPosicion(new Posicion(1, -1)));
    }

    @Test
    public void test13AlgoBlocksEjecutarSecuenciaDe3BloquesConLapizAbajoDibuja2Lineas() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.ejecutarAlgoritmo();

        assertEquals(2, algoBlocks.getPersonaje().getDibujo().getCantidadLineas());
    }
}
