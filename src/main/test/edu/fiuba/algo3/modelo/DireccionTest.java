package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static edu.fiuba.algo3.modelo.Direccion.PASO;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DireccionTest {

    @Test
    public void test01DesplazarDireccionDerechaPosicionCorrecta() {
        Direccion dir = Direccion.derecha();
        Posicion pos = new Posicion();

        pos = dir.desplazar(pos);

        Assertions.assertTrue(pos.esIgualA(new Posicion(PASO,0)));
    }

    @Test
    public void test02DesplazarDireccionIzquierdaPosicionCorrecta() {
        Direccion dir = Direccion.izquierda();
        Posicion pos = new Posicion();

        pos = dir.desplazar(pos);

        Assertions.assertTrue(pos.esIgualA(new Posicion(-PASO,0)));
    }

    @Test
    public void test03DesplazarDireccionArribaPosicionCorrecta() {
        Direccion dir = Direccion.arriba();
        Posicion pos = new Posicion();

        pos = dir.desplazar(pos);

        Assertions.assertTrue(pos.esIgualA(new Posicion(0,-PASO)));
    }

    @Test
    public void test04DesplazarDireccionAbajoPosicionCorrecta() {
        Direccion dir = Direccion.abajo();
        Posicion pos = new Posicion();

        pos = dir.desplazar(pos);

        Assertions.assertTrue(pos.esIgualA(new Posicion(0,PASO)));
    }

    @Test
    public void test05DesplazarDireccionAbajoYLuegoDerechaPosicionCorrecta() {
        Direccion dirAbajo = Direccion.abajo();
        Direccion dirDerecha = Direccion.derecha();
        Posicion pos = new Posicion();

        pos = dirAbajo.desplazar(pos);
        pos = dirDerecha.desplazar(pos);

        Assertions.assertTrue(pos.esIgualA(new Posicion(PASO,PASO)));
    }
}
