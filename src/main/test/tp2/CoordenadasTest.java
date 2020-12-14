package tp2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordenadasTest {

    @Test
    public void test01CrearCoordenadaEnElOrigen() {
        Coordenadas coordenadas = new Coordenadas(0, 0);

        assertEquals(coordenadas.getX(), 0);
        assertEquals(coordenadas.getY(), 0);
    }

    @Test
    public void test02CrearCoordenadaPosHorizontal2PosVertical4(){
        Coordenadas coordenadas = new Coordenadas(2, 4);

        assertEquals(coordenadas.getX(), 2);
        assertEquals(coordenadas.getY(), 4);
    }

    @Test
    public  void test03Sumar2CoordenadasEnElOrigen(){
        Coordenadas unasCoordenadas = new Coordenadas(0, 0);
        Coordenadas otrasCoordenadas = new Coordenadas(0, 0);
        Coordenadas suma = unasCoordenadas.sumar(otrasCoordenadas);

        assertEquals(suma.getX(), 0);
        assertEquals(suma.getY(), 0);
    }

    @Test
    public  void test04Sumar2CoordenadasConPosicionesOpuestas(){
        Coordenadas unasCoordenadas = new Coordenadas(-1, 7);
        Coordenadas otrasCoordenadas = new Coordenadas(1, -7);
        Coordenadas suma = unasCoordenadas.sumar(otrasCoordenadas);

        assertEquals(suma.getX(), 0);
        assertEquals(suma.getY(), 0);
    }

    @Test
    public  void test04Sumar2CoordenadasConPosicionesNoOpuestas(){
        Coordenadas unasCoordenadas = new Coordenadas(-1, 7);
        Coordenadas otrasCoordenadas = new Coordenadas(19, -6);
        Coordenadas suma = unasCoordenadas.sumar(otrasCoordenadas);

        assertEquals(suma.getX(), 18);
        assertEquals(suma.getY(), 1);
    }

}