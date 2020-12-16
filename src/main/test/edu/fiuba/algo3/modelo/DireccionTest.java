package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direccion.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class DireccionTest {

    @Test
    public void test01DireccionDerechaCoordenadasDireccionCorrectas() {
        Direccion dir = new Derecha();

        Assertions.assertTrue(dir.getCoordenadas().sonIgualesA(new Coordenadas(1,0)));
    }

    @Test
    public void test02DireccionIzquierdaCoordenadasDireccionCorrectas() {
        Direccion dir = new Izquierda();

        Assertions.assertTrue(dir.getCoordenadas().sonIgualesA(new Coordenadas(-1,0)));
    }

    @Test
    public void test03DireccionArribaCoordenadasDireccionCorrectas() {
        Direccion dir = new Arriba();

        Assertions.assertTrue(dir.getCoordenadas().sonIgualesA(new Coordenadas(0,1)));
    }

    @Test
    public void test04DireccionAbajoCoordenadasDireccionCorrectas() {
        Direccion dir = new Abajo();

        Assertions.assertTrue(dir.getCoordenadas().sonIgualesA(new Coordenadas(0,-1)));
    }
}
