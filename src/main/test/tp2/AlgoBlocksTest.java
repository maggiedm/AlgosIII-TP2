package tp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlgoBlocksTest {

    @Test
    public void test01AlgoBlocksNuevoAlgoritmoVacio() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        assertTrue(algoBlocks.getAlgoritmo().getSecuenciaDeBloques().isEmpty());
    }

    @Test
    public void test02AlgoBlocksNuevoPersonajeEnOrigen() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        assertTrue(algoBlocks.getPersonaje().getPosicion().esMisma(new Posicion()));
    }

    @Test
    public void test03AlgoBlocksAgregarBloqueAlgoritmoTieneUnBloque() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(new BloqueDerecha());

        assertEquals(1, algoBlocks.getAlgoritmo().getSecuenciaDeBloques().size());
    }

    @Test
    public void test04AlgoBlocksAgregarBloqueMovimientoAlgoritmoSinEjecutarPosicionPersonajeNoCambia() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(new BloqueDerecha());

        assertTrue(algoBlocks.getPersonaje().getPosicion().esMisma(new Posicion()));
    }

    @Test
    public void test05AlgoBlocksAgregarBloqueYEjecutarAlgoritmoTieneUnBloque() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(new BloqueDerecha());
        algoBlocks.ejecutar();

        assertEquals(1, algoBlocks.getAlgoritmo().getSecuenciaDeBloques().size());
    }

    @Test
    public void test06AlgoBlocksAgregarBloqueMovimientoYEjecutarAlgoritmoPosicionPersonajeSeActualiza() {
        AlgoBlocks algoBlocks = new AlgoBlocks();
        Posicion posicion = new Posicion();

        posicion = posicion.obtenerSiguiente(new Derecha());
        algoBlocks.agregarBloque(new BloqueDerecha());
        algoBlocks.ejecutar();

        assertTrue(algoBlocks.getPersonaje().getPosicion().esMisma(posicion));
    }

/*    @Test
    public void test07AlgoBlocksAgregarBloqueMovimientoYEjecutar2VecesAlgoritmoPosicionPersonajeEsMismaQueEjecutarUnaVezElAlgoritmo() {
        AlgoBlocks algoBlocks = new AlgoBlocks();
        Posicion posicion;

        algoBlocks.agregarBloque(new BloqueDerecha());
        algoBlocks.ejecutar();
        posicion = algoBlocks.getPersonaje().getPosicion();
        algoBlocks.ejecutar();

        assertTrue(algoBlocks.getPersonaje().getPosicion().esMisma(posicion));
    }*/

    @Test
    public void test07AlgoBlocksAgregar3BloquesAlgoritmoTiene3Bloques() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(new BloqueDerecha());
        algoBlocks.agregarBloque(new BloqueDerecha());
        algoBlocks.agregarBloque(new BloqueAbajo());

        assertEquals(3, algoBlocks.getAlgoritmo().getSecuenciaDeBloques().size());
    }

    @Test
    public void test08AlgoBlocksCrearSecuenciaDe3BloquesMueveAlPersonaje() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(new BloqueDerecha());
        algoBlocks.agregarBloque(new BloqueDerecha());
        algoBlocks.agregarBloque(new BloqueAbajo());
        algoBlocks.ejecutar();

        assertEquals(2, algoBlocks.getPersonaje().getPosicion().getX());
        assertEquals(-1, algoBlocks.getPersonaje().getPosicion().getY());
    }
}
