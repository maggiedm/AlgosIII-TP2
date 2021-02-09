package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.BloqueMovimiento;
import edu.fiuba.algo3.modelo.bloque.BloqueRepeticion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BloqueRepiticionTest {
    @Test
    public void test01BloqueRepeticion2Con1Movimiento(){
        Personaje personaje= new Personaje();
        BloqueRepeticion bloque = BloqueRepeticion.repetirDosVeces();

        bloque.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloque.ejecutar(personaje);

        assertTrue(personaje.getPosicion().esIgualA((new Posicion()).desplazar(2, 0)));
    }

    @Test
    public void test02BloqueRepeticion2Con2Movimiento(){
        Personaje personaje= new Personaje();
        BloqueRepeticion bloque = BloqueRepeticion.repetirDosVeces();

        bloque.agregarBloque(BloqueMovimiento.bloqueDerecha());
        bloque.agregarBloque(BloqueMovimiento.bloqueArriba());
        bloque.ejecutar(personaje);

        assertTrue(personaje.getPosicion().esIgualA((new Posicion()).desplazar(2, 2)));
    }

}
