package tp2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoBlocksTest {

    @Test
    public void test01AlgoBlocksNuevoCreaPersonajeYAlgoritmo() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        assertThat(algoBlocks.getPersonaje(), instanceOf(Personaje.class));
        assertThat(algoBlocks.getAlgoritmo(), instanceOf(Algoritmo.class));
    }

    @Test
    public void test02AlgoBlocksCrearSecuenciaDe3BloquesMueveAlPersonaje() {
        AlgoBlocks algoBlocks = new AlgoBlocks();

        algoBlocks.agregarBloque(new BloqueDerecha());
        algoBlocks.agregarBloque(new BloqueDerecha());
        algoBlocks.agregarBloque(new BloqueAbajo());
        algoBlocks.ejecutar();

        assertEquals(2, algoBlocks.getPersonaje().getPosicion().getX());
        assertEquals(-1, algoBlocks.getPersonaje().getPosicion().getY());

    }
}
