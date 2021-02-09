package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class DireccionTest {

    @Test
    public void test01DireccionDerechaCoordenadasDireccionCorrectas() {
        Direccion dir = Direccion.derecha();

        Assertions.assertTrue();
    }

    @Test
    public void test02DireccionIzquierdaCoordenadasDireccionCorrectas() {
        Direccion dir = Direccion.izquierda();

        Assertions.assertTrue();
    }

    @Test
    public void test03DireccionArribaCoordenadasDireccionCorrectas() {
        Direccion dir = Direccion.arriba();

        Assertions.assertTrue();
    }

    @Test
    public void test04DireccionAbajoCoordenadasDireccionCorrectas() {
        Direccion dir = Direccion.abajo();

        Assertions.assertTrue();
    }
}
