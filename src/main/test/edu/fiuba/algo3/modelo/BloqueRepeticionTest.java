package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.BloqueMovimiento;
import edu.fiuba.algo3.modelo.bloque.BloqueRepeticion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BloqueRepeticionTest {
    @Test
    public void test01BloqueRepeticion2Con1MovimientoDerechaPosicionCorrecta(){
        Personaje personaje = new Personaje();
        BloqueRepeticion bloque = BloqueRepeticion.repetirDosVeces();

        bloque.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloque.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(2,0))));
    }

    @Test
    public void test02BloqueRepeticion2ConMovimientoDerechaYArribaPosicionCorrecta(){
        Personaje personaje = new Personaje();
        BloqueRepeticion bloque = BloqueRepeticion.repetirDosVeces();

        bloque.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloque.agregarBloque(BloqueMovimiento.bloqueArriba());
        bloque.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(2,2))));
    }

    @Test
    public void test03BloqueRepeticion3ConMovimientoDerechaYAbajoPosicionCorrecta(){
        Personaje personaje = new Personaje();
        BloqueRepeticion bloque = BloqueRepeticion.repetirTresVeces();

        bloque.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloque.agregarBloque(BloqueMovimiento.bloqueAbajo());
        bloque.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(3,-3))));
    }

    @Test
    public void test04BloqueRepeticion3DentroDeBloqueRepeticion2ConMovimientoDerechaYAbajoPosicionCorrecta(){
        Personaje personaje = new Personaje();
        BloqueRepeticion bloqueExterno = BloqueRepeticion.repetirDosVeces();
        BloqueRepeticion bloqueInterno = BloqueRepeticion.repetirTresVeces();

        bloqueInterno.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloqueInterno.agregarBloque(BloqueMovimiento.bloqueAbajo());
        bloqueExterno.agregarBloque(bloqueInterno);
        bloqueExterno.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion((new Posicion(6,-6))));
    }
}
