package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.BloqueMovimiento;
import edu.fiuba.algo3.modelo.bloque.BloqueRepeticion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BloqueRepeticionTest {

    @Test
    public void test01BloqueRepeticionVacio(){
        Personaje personaje = new Personaje();
        BloqueRepeticion bloque = BloqueRepeticion.repetirDosVeces();
        bloque.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(0,0))));
    }

    @Test
    public void test02BloqueRepeticion2Con1MovimientoPosicionCorrecta(){
        Personaje personaje = new Personaje();
        BloqueRepeticion bloque = BloqueRepeticion.repetirDosVeces();

        bloque.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloque.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(2,0))));
    }

    @Test
    public void test03BloqueRepeticion2Con2MovimientosPosicionCorrecta(){
        Personaje personaje = new Personaje();
        BloqueRepeticion bloque = BloqueRepeticion.repetirDosVeces();

        bloque.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloque.agregarBloque(BloqueMovimiento.bloqueArriba());
        bloque.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(2,2))));
    }

    @Test
    public void test04BloqueRepeticion3ConMovimiento2MovimientosPosicionCorrecta(){
        Personaje personaje = new Personaje();
        BloqueRepeticion bloque = BloqueRepeticion.repetirTresVeces();

        bloque.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloque.agregarBloque(BloqueMovimiento.bloqueAbajo());
        bloque.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(3,-3))));
    }

    @Test
    public void test05BloquesRepeticionAnidadosPosicionCorrecta(){
        Personaje personaje = new Personaje();
        BloqueRepeticion bloqueExterno = BloqueRepeticion.repetirDosVeces();
        BloqueRepeticion bloqueInterno = BloqueRepeticion.repetirTresVeces();

        bloqueInterno.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloqueInterno.agregarBloque(BloqueMovimiento.bloqueAbajo());
        bloqueExterno.agregarBloque(bloqueInterno);
        bloqueExterno.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(6,-6))));
    }

    @Test
    public void test06BloqueRepeticionConLapizAbajoCantidadLineasCorrecta(){
        Personaje personaje = new Personaje();
        BloqueRepeticion bloque = BloqueRepeticion.repetirTresVeces();

        personaje.bajarLapiz();
        bloque.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloque.agregarBloque(BloqueMovimiento.bloqueAbajo());
        bloque.ejecutar(personaje);

        assertEquals(6,personaje.cantidadLineas());
    }

}
