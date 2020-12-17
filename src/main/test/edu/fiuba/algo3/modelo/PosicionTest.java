package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direccion.Abajo;
import edu.fiuba.algo3.modelo.direccion.Arriba;
import edu.fiuba.algo3.modelo.direccion.Derecha;
import edu.fiuba.algo3.modelo.direccion.Izquierda;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PosicionTest {

    @Test
    public void test01PosicionNuevaEstaEnOrigen() {
        Posicion posicion = new Posicion();

        assertTrue(posicion.esIgualA(Posicion.crearConCoordenadas(new Coordenadas(0, 0))));
    }

    @Test
    public void test02PosicionObtenerSiguienteConMovimientoADerecha() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(new Derecha());

        assertTrue(posicion.esIgualA(Posicion.crearConCoordenadas(new Coordenadas(0, 0))));
        assertTrue(nuevaPos.esIgualA(Posicion.crearConCoordenadas(new Coordenadas(1, 0))));
    }

    @Test
    public void test03PosicionObtenerSiguienteConMovimientoAIzquierda() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(new Izquierda());

        assertTrue(posicion.esIgualA(Posicion.crearConCoordenadas(new Coordenadas(0, 0))));
        assertTrue(nuevaPos.esIgualA(Posicion.crearConCoordenadas(new Coordenadas(-1, 0))));
    }

    @Test
    public void test04PosicionObtenerSiguienteConMovimientoArriba() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(new Arriba());

        assertTrue(posicion.esIgualA(Posicion.crearConCoordenadas(new Coordenadas(0, 0))));
        assertTrue(nuevaPos.esIgualA(Posicion.crearConCoordenadas(new Coordenadas(0, 1))));
    }

    @Test
    public void test05PosicionObtenerSiguienteConMovimientoAbajo() {
        Posicion posicion = new Posicion();
        Posicion nuevaPos = posicion.obtenerSiguiente(new Abajo());

        assertTrue(posicion.esIgualA(Posicion.crearConCoordenadas(new Coordenadas(0, 0))));
        assertTrue(nuevaPos.esIgualA(Posicion.crearConCoordenadas(new Coordenadas(0, -1))));
    }
}
