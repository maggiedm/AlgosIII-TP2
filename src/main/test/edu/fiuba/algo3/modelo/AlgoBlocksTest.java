package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.*;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Direccion.PASO;
import static org.junit.jupiter.api.Assertions.*;

public class AlgoBlocksTest {

    @Test
    public void test01AlgoBlocksNuevoAlgoritmoVacio() {
        AlgoBlocks algoBlocks = new AlgoBlocks(new Dibujo());

        assertEquals(0, algoBlocks.cantidadDeBloquesEnAlgoritmo());
    }

    @Test
    public void test02AlgoBlocksNuevoPersonajeEnOrigen() {
        AlgoBlocks algoBlocks = new AlgoBlocks(new Dibujo());

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion()));
    }

    @Test
    public void test03AlgoBlocksAgregarBloqueAlgoritmoTieneUnBloque() {
        AlgoBlocks algoBlocks = new AlgoBlocks(new Dibujo());

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());

        assertEquals(1, algoBlocks.cantidadDeBloquesEnAlgoritmo());
    }

    @Test
    public void test04AlgoBlocksAgregarBloqueMovimientoAlgoritmoSinEjecutarPosicionPersonajeNoCambia() {
        AlgoBlocks algoBlocks = new AlgoBlocks(new Dibujo());

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion()));
    }

    @Test
    public void test05AlgoBlocksAgregarBloqueYEjecutarAlgoritmoTieneUnBloque() {
        AlgoBlocks algoBlocks = new AlgoBlocks(new Dibujo());

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.ejecutarAlgoritmo();

        assertEquals(1, algoBlocks.cantidadDeBloquesEnAlgoritmo());
    }

    @Test
    public void test06AlgoBlocksAgregarBloqueMovimientoYEjecutarAlgoritmoPosicionPersonajeSeActualiza() {
        AlgoBlocks algoBlocks = new AlgoBlocks(new Dibujo());

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion(PASO, 0)));
    }
    @Test
    public void test07AlgoBlocksEjecutarMovimientoEnPersonajeNuevoDibujaLinea() {
        Dibujo dibujo = new Dibujo();
        AlgoBlocks algoBlocks = new AlgoBlocks(dibujo);

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.ejecutarAlgoritmo();

        assertEquals(1, dibujo.getCantidadLineas());
    }

    @Test
    public void test08AlgoBlocksEjecutarSecuenciaBajarLapizYMoverPersonajeDibujaLinea() {
        AlgoBlocks algoBlocks = new AlgoBlocks(new Dibujo());

        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.ejecutarAlgoritmo();

        assertEquals(1, algoBlocks.cantidadLineasDibujadas());
    }

    @Test
    public void test09AlgoBlocksEjecutarSecuenciaMoverPersonajeNuevoYBajarLapizDibujaLineaInvisible() {
        AlgoBlocks algoBlocks = new AlgoBlocks(new Dibujo());

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.ejecutarAlgoritmo();

        //assertTrue(algoBlocks);
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
        AlgoBlocks algoBlocks = new AlgoBlocks(new Dibujo());

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());

        assertEquals(3, algoBlocks.cantidadDeBloquesEnAlgoritmo());
    }

    @Test
    public void test11AlgoBlocksEjecutarSecuenciaDe3BloquesMueveAlPersonaje() {
        AlgoBlocks algoBlocks = new AlgoBlocks(new Dibujo());

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion(2 * PASO, PASO)));
    }

    @Test
    public void test12AlgoBlocksEjecutarSecuenciaDe3BloquesConLapizAbajoMueveAlPersonaje() {
        AlgoBlocks algoBlocks = new AlgoBlocks(new Dibujo());

        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion(PASO, PASO)));
    }

    @Test
    public void test13AlgoBlocksEjecutarSecuenciaDe3BloquesConLapizAbajoDibuja2Lineas() {
        AlgoBlocks algoBlocks = new AlgoBlocks(new Dibujo());

        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());
        algoBlocks.ejecutarAlgoritmo();

        assertEquals(2, algoBlocks.cantidadLineasDibujadas());
    }

    @Test
    public void test14AlgoBlocksEjecutarBloqueRepeticionYLuego2BloqueMovimientoMueveCorrectamenteAlPersonaje() {
        AlgoBlocks algoBlocks = new AlgoBlocks(new Dibujo());

        BloqueRepeticion bloqueRepeticion = BloqueRepeticion.repetirTresVeces();
        bloqueRepeticion.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloqueRepeticion.agregarBloque(BloqueMovimiento.bloqueAbajo());

        algoBlocks.agregarBloque(bloqueRepeticion);
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueArriba());
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion(4*PASO, 2*PASO)));
    }

    @Test
    public void test15AlgoBlocksEjecutarBloqueInversionMueveCorrectamenteAlPersonaje() {
        AlgoBlocks algoBlocks = new AlgoBlocks(new Dibujo());

        BloqueInversion bI = new BloqueInversion();
        bI.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bI.agregarBloque(BloqueMovimiento.bloqueAbajo());

        algoBlocks.agregarBloque(bI);
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion(-PASO, -PASO)));
    }

    @Test
    public void test16AlgoBlocksEjecutarBloqueAgregaLineasCorrectasAlDibujo() {
        Dibujo dibujo = new Dibujo();
        AlgoBlocks algoBlocks = new AlgoBlocks(dibujo);

        BloqueInversion bI = new BloqueInversion();
        bI.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bI.agregarBloque(new BloqueSubirLapiz());
        bI.agregarBloque(BloqueMovimiento.bloqueAbajo());

        algoBlocks.agregarBloque(bI);
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(0,0), new Posicion(-PASO, 0), false)) &&
                dibujo.tieneLinea(new Linea(new Posicion(-PASO,0), new Posicion(-PASO, -PASO), true)));
    }

    @Test
    public void test17AlgoBlocksGuardarAlgoritmoVacioLanzaExcepcion() {
        assertThrows(GuardarAlgoritmoVacioException.class, () -> new AlgoBlocks(new Dibujo()).guardarAlgoritmo());
    }

    @Test
    public void test18AlgoBlocksEjecutarAlgoritmoGuardadoPosicionCorrecta() {
        Dibujo dibujo = new Dibujo();
        AlgoBlocks algoBlocks = new AlgoBlocks(dibujo);

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());

        BloquePersonalizado bP = algoBlocks.guardarAlgoritmo();
        algoBlocks = new AlgoBlocks(dibujo);
        algoBlocks.agregarBloque(bP);
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(algoBlocks.personajeEstaEnPosicion(new Posicion(PASO, PASO)));
    }

    @Test
    public void test19AlgoBlocksEjecutarAlgoritmoGuardadoDibujoTieneLineasCorrectas() {
        Dibujo dibujo = new Dibujo();
        AlgoBlocks algoBlocks = new AlgoBlocks(dibujo);

        algoBlocks.agregarBloque(BloqueMovimiento.bloqueDerecha());
        algoBlocks.agregarBloque(new BloqueBajarLapiz());
        algoBlocks.agregarBloque(BloqueMovimiento.bloqueAbajo());

        BloquePersonalizado bP = algoBlocks.guardarAlgoritmo();
        algoBlocks = new AlgoBlocks(dibujo);
        algoBlocks.agregarBloque(bP);
        algoBlocks.ejecutarAlgoritmo();

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(0,0), new Posicion(PASO, 0), false)) &&
                dibujo.tieneLinea(new Linea(new Posicion(PASO,0), new Posicion(PASO, PASO), true)));
    }

    //Test de Invertir y de BloquePersonalizado
}
