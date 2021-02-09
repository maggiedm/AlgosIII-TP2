package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class DireccionTest {

    @Test
    public void test01DireccionDerechaCoordenadasDireccionCorrectas() {
        Direccion dir = Direccion.derecha();
        Posicion pos = new Posicion();

        Posicion posDesplazada = dir.desplazar(pos);

        Assertions.assertTrue(posDesplazada.esIgualA(new Posicion(1,0)));
    }

    @Test
    public void test02DireccionIzquierdaCoordenadasDireccionCorrectas() {
        Direccion dir = Direccion.izquierda();
        Posicion pos = new Posicion();

        Posicion posDesplazada = dir.desplazar(pos);

        Assertions.assertTrue(posDesplazada.esIgualA(new Posicion(-1,0)));
    }

    @Test
    public void test03DireccionArribaCoordenadasDireccionCorrectas() {
        Direccion dir = Direccion.arriba();
        Posicion pos = new Posicion();

        Posicion posDesplazada = dir.desplazar(pos);

        Assertions.assertTrue(posDesplazada.esIgualA(new Posicion(0,1)));
    }

    @Test
    public void test04DireccionAbajoCoordenadasDireccionCorrectas() {
        Direccion dir = Direccion.abajo();
        Posicion pos = new Posicion();

        Posicion posDesplazada = dir.desplazar(pos);

        Assertions.assertTrue(posDesplazada.esIgualA(new Posicion(0,-1)));
    }
}
