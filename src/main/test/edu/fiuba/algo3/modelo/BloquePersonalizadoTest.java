package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static edu.fiuba.algo3.modelo.Direccion.PASO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BloquePersonalizadoTest {

    @Test
    public void test01EjecutarBloquePersonalizadoConUnBloquePosicionEsCorrecta(){
        Personaje personaje = new Personaje(new Dibujo());
        List<Bloque> lista = new ArrayList<>();
        lista.add(BloqueMovimiento.bloqueDerecha());
        BloquePersonalizado bP = new BloquePersonalizado(lista);

        bP.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(PASO, 0)));
    }

    @Test
    public void test02EjecutarBloquePersonalizadoConVariosBloquesPosicionEsCorrecta(){
        Personaje personaje = new Personaje(new Dibujo());
        List<Bloque> lista = new ArrayList<>();

        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueArriba());
        BloquePersonalizado bP = new BloquePersonalizado(lista);

        bP.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(2 * PASO, -PASO)));
    }

    @Test
    public void test03AgregarOtroElementoALaListaOriginalNoAfectaBloquePersonalizado(){
        Personaje personaje = new Personaje(new Dibujo());
        List<Bloque> lista = new ArrayList<>();

        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueArriba());
        BloquePersonalizado bP = new BloquePersonalizado(lista);
        lista.add(BloqueMovimiento.bloqueIzquierda());
        bP.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(2*PASO, -PASO)));
    }

    @Test
    public void test04EjecutarBloquePersonalizadoDibujaLineas(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);
        List<Bloque> lista = new ArrayList<>();

        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueArriba());
        BloquePersonalizado bP = new BloquePersonalizado(lista);
        bP.ejecutar(personaje);

        assertEquals(3, dibujo.getCantidadLineas());
    }

    @Test
    public void test05EjecutarBloquePersonalizadoConBloqueRepeticionPosicionCorrecta(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);
        BloqueRepeticion bR = BloqueRepeticion.repetirDosVeces();
        List<Bloque> lista = new ArrayList<>();
        bR.agregarBloque(BloqueMovimiento.bloqueDerecha());
        lista.add(bR);
        BloquePersonalizado bP = new BloquePersonalizado(lista);
        bP.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(2*PASO, 0)));
    }

    @Test
    public void test06EjecutarBloquePersonalizadoConBloqueRepeticionTieneLineasCorrectas(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);
        BloqueRepeticion bR = BloqueRepeticion.repetirDosVeces();
        List<Bloque> lista = new ArrayList<>();

        bR.agregarBloque(BloqueMovimiento.bloqueDerecha());
        lista.add(bR);
        BloquePersonalizado bP = new BloquePersonalizado(lista);
        bP.ejecutar(personaje);

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(0, 0), new Posicion(PASO, 0), false)) &&
                dibujo.tieneLinea(new Linea(new Posicion(PASO, 0), new Posicion(2*PASO, 0), false)));
    }

    @Test
    public void test06EjecutarBloquePersonalizadoConBloqueInversionPosicionCorrecta(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);
        BloqueInversion bI = new BloqueInversion();
        List<Bloque> lista = new ArrayList<>();

        bI.agregarBloque(BloqueMovimiento.bloqueDerecha());
        lista.add(bI);
        BloquePersonalizado bP = new BloquePersonalizado(lista);
        bP.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(-PASO, 0)));
    }

    @Test
    public void test06EjecutarAlgoritmoPersonalizadoConBloqueInversionTieneLineaCorrecta(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);
        BloqueInversion bI = new BloqueInversion();
        List<Bloque> lista = new ArrayList<>();

        bI.agregarBloque(BloqueMovimiento.bloqueDerecha());
        lista.add(bI);
        BloquePersonalizado bP = new BloquePersonalizado(lista);
        bP.ejecutar(personaje);

        assertTrue(dibujo.tieneLinea(new Linea(new Posicion(0, 0), new Posicion(-PASO, 0), false)));
    }
}
