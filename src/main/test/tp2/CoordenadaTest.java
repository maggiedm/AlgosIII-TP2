package tp2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordenadaTest {

    @Test
    public void test01CrearCoordenadaEnElOrigen() {
        Coordenada coordenada = new Coordenada(0, 0);

        assertEquals(coordenada.getX(), 0);
        assertEquals(coordenada.getY(), 0);
    }

    @Test
    public void test02CrearCoordenadaPosHorizontal2PosVertical4(){
        Coordenada coordenada = new Coordenada(2, 4);

        assertEquals(coordenada.getX(), 2);
        assertEquals(coordenada.getY(), 4);
    }

    @Test
    public  void test03Sumar2CoordenadasEnElOrigen(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 0);
        Coordenada suma = unaCoordenada.sumar(otraCoordenada);

        assertEquals(suma.getX(), 0);
        assertEquals(suma.getY(), 0);
    }

    @Test
    public  void test04Sumar2CoordenadasConPosicionesOpuestas(){
        Coordenada unaCoordenada = new Coordenada(-1, 7);
        Coordenada otraCoordenada = new Coordenada(1, -7);
        Coordenada suma = unaCoordenada.sumar(otraCoordenada);

        assertEquals(suma.getX(), 0);
        assertEquals(suma.getY(), 0);
    }

    @Test
    public  void test04Sumar2CoordenadasConPosicionesNoOpuestas(){
        Coordenada unaCoordenada = new Coordenada(-1, 7);
        Coordenada otraCoordenada = new Coordenada(19, -6);
        Coordenada suma = unaCoordenada.sumar(otraCoordenada);

        assertEquals(suma.getX(), 18);
        assertEquals(suma.getY(), 1);
    }

}