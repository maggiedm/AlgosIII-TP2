package tp2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordenadasTest {

    @Test
    public void test01CrearCoordenadaEnElOrigen() {
        Coordenadas coordenadas = new Coordenadas(0, 0);

        assertEquals(0, coordenadas.getX());
        assertEquals(0, coordenadas.getY());
    }

    @Test
    public void test02CrearCoordenadaPosHorizontal2PosVertical4(){
        Coordenadas coordenadas = new Coordenadas(2, 4);

        assertEquals(2, coordenadas.getX());
        assertEquals(4, coordenadas.getY());
    }

    @Test
    public  void test03Sumar2CoordenadasEnElOrigen(){
        Coordenadas unasCoordenadas = new Coordenadas(0, 0);
        Coordenadas otrasCoordenadas = new Coordenadas(0, 0);
        Coordenadas suma = unasCoordenadas.sumar(otrasCoordenadas);

        assertEquals(0, suma.getX());
        assertEquals(0, suma.getY());

    }

    @Test
    public  void test04Sumar2CoordenadasConPosicionesOpuestas(){
        Coordenadas unasCoordenadas = new Coordenadas(-1, 7);
        Coordenadas otrasCoordenadas = new Coordenadas(1, -7);
        Coordenadas suma = unasCoordenadas.sumar(otrasCoordenadas);

        assertEquals(0, suma.getX());
        assertEquals(0, suma.getY());
    }

    @Test
    public  void test04Sumar2CoordenadasConPosicionesNoOpuestas(){
        Coordenadas unasCoordenadas = new Coordenadas(-1, 7);
        Coordenadas otrasCoordenadas = new Coordenadas(19, -6);
        Coordenadas suma = unasCoordenadas.sumar(otrasCoordenadas);

        assertEquals(18, suma.getX());
        assertEquals(1, suma.getY());
    }

}