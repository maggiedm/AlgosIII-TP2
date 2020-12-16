package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        unasCoordenadas.desplazar(otrasCoordenadas);

        assertTrue(unasCoordenadas.sonIgualesA(new Coordenadas(0,0)));

    }

    @Test
    public  void test04Sumar2CoordenadasConPosicionesOpuestas(){
        Coordenadas unasCoordenadas = new Coordenadas(-1, 7);
        Coordenadas otrasCoordenadas = new Coordenadas(1, -7);
        unasCoordenadas.desplazar(otrasCoordenadas);

        assertTrue(unasCoordenadas.sonIgualesA(new Coordenadas(0,0)));
    }

    @Test
    public  void test04Sumar2CoordenadasConPosicionesNoOpuestas(){
        Coordenadas unasCoordenadas = new Coordenadas(-1, 7);
        Coordenadas otrasCoordenadas = new Coordenadas(19, -6);
        unasCoordenadas.desplazar(otrasCoordenadas);

        assertTrue(unasCoordenadas.sonIgualesA(new Coordenadas(18,1)));
    }

}