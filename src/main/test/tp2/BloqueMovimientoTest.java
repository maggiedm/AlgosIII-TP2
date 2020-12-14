package tp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BloqueMovimientoTest {

        @Test
        public void test01EjecutarMovimientoALaDerecha(){
            Personaje personaje = new Personaje();
            BloqueMovimiento movimiento = new BloqueDerecha();

            movimiento.ejecutar(personaje);

            assertEquals(1, personaje.getPosicion().getX());
            assertEquals(0, personaje.getPosicion().getY());
        }

    @Test
    public void test02EjecutarMovimientoALaIzquierda(){
        Personaje personaje = new Personaje();
        BloqueMovimiento movimiento = new BloqueIzquierda();

        movimiento.ejecutar(personaje);

        assertEquals(-1, personaje.getPosicion().getX());
        assertEquals(0, personaje.getPosicion().getY());
    }

    @Test
    public void test03EjecutarMovimientoAbajo(){
        Personaje personaje = new Personaje();
        BloqueMovimiento movimiento = new BloqueAbajo();

        movimiento.ejecutar(personaje);

        assertEquals(0, personaje.getPosicion().getX());
        assertEquals(-1, personaje.getPosicion().getY());
    }

    @Test
    public void test04EjecutarMovimientoArriba(){
        Personaje personaje = new Personaje();
        BloqueMovimiento movimiento = new BloqueArriba();

        movimiento.ejecutar(personaje);

        assertEquals(0, personaje.getPosicion().getX());
        assertEquals(1, personaje.getPosicion().getY());
    }
}
