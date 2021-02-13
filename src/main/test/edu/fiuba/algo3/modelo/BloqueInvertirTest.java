package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.BloqueBajarLapiz;
import edu.fiuba.algo3.modelo.bloque.BloqueInvertir;
import edu.fiuba.algo3.modelo.bloque.BloqueMovimiento;
import edu.fiuba.algo3.modelo.bloque.BloqueSubirLapiz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BloqueInvertirTest {

    @Test
    public void test01BloqueInversionInvierteUnMovimiento(){
        BloqueInvertir b1 = new BloqueInvertir();
        Personaje personaje = new Personaje(new Dibujo());

        b1.agregarBloque(BloqueMovimiento.bloqueDerecha());
        b1.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(-1, 0)));
    }

    @Test
    public void test02BloquesInversionBajarLapizYMoverseNoDibujaLinea(){
        Dibujo dibujo = new Dibujo();
        BloqueInvertir b1 = new BloqueInvertir();
        Personaje personaje = new Personaje(dibujo);

        b1.agregarBloque(new BloqueBajarLapiz());
        b1.agregarBloque(BloqueMovimiento.bloqueDerecha());
        b1.ejecutar(personaje);

        assertEquals(0, dibujo.getCantidadLineas());
    }

    @Test
    public void test03BloquesInversionSubirLapizYMoverseDibujaLinea(){
        Dibujo dibujo = new Dibujo();
        BloqueInvertir b1 = new BloqueInvertir();
        Personaje personaje = new Personaje(dibujo);

        b1.agregarBloque(new BloqueSubirLapiz());
        b1.agregarBloque(BloqueMovimiento.bloqueDerecha());
        b1.ejecutar(personaje);

        assertEquals(1, dibujo.getCantidadLineas());
    }

    @Test
    public void test04BloquesInversionAnidadosNoInvierteBloquesInternos(){
        BloqueInvertir b1 = new BloqueInvertir();
        BloqueInvertir b2 = new BloqueInvertir();
        Personaje personaje = new Personaje(new Dibujo());

        b2.agregarBloque(BloqueMovimiento.bloqueDerecha());
        b1.agregarBloque(b2);
        b1.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(1, 0)));
    }

    @Test
    public void test05BloquesInversionAnidadosInvierteBloquesSimplementeInvertidos(){
        BloqueInvertir b1 = new BloqueInvertir();
        BloqueInvertir b2 = new BloqueInvertir();
        Personaje personaje = new Personaje(new Dibujo());

        b2.agregarBloque(BloqueMovimiento.bloqueDerecha());
        b1.agregarBloque(b2);
        b1.agregarBloque(BloqueMovimiento.bloqueDerecha());
        b1.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(0, 0)));
    }

    @Test
    public void test06BloquesInversionAnidadosInvierteBloquesTriplementeInvertidos(){
        BloqueInvertir b1 = new BloqueInvertir();
        BloqueInvertir b2 = new BloqueInvertir();
        BloqueInvertir b3 = new BloqueInvertir();
        Personaje personaje = new Personaje(new Dibujo());

        b3.agregarBloque(BloqueMovimiento.bloqueDerecha());
        b2.agregarBloque(b3);
        b1.agregarBloque(b2);
        b1.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(-1, 0)));
    }
}
