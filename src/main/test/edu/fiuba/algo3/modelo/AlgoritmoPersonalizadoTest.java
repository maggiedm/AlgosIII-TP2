package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.Bloque;
import edu.fiuba.algo3.modelo.bloque.BloqueBajarLapiz;
import edu.fiuba.algo3.modelo.bloque.BloqueMovimiento;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlgoritmoPersonalizadoTest {

    @Test
    public void test01EjecutarAlgoritoPersonalizadoConUnBloquePosicionEsCorrecta(){
        Personaje personaje = new Personaje(new Dibujo());
        List<Bloque> lista = new ArrayList();
        lista.add(BloqueMovimiento.bloqueDerecha());
        AlgoritmoPersonalizado algoP = new AlgoritmoPersonalizado("test", lista);

        algoP.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(1, 0)));
    }

    @Test
    public void test02EjecutarAlgoritmoPersonalizadoConVariosBloquesPosicionEsCorrecta(){
        Personaje personaje = new Personaje(new Dibujo());
        List<Bloque> lista = new ArrayList();

        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueArriba());
        AlgoritmoPersonalizado algoP = new AlgoritmoPersonalizado("test", lista);

        algoP.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(2, 1)));
    }

    @Test
    public void test03EjecutarInvertirAlgoritmoPersonalizadoConVariosBloquesPosicionEsCorrecta(){
        Personaje personaje = new Personaje(new Dibujo());
        List<Bloque> lista = new ArrayList();

        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueArriba());
        AlgoritmoPersonalizado algoP = new AlgoritmoPersonalizado("test", lista);

        algoP.invertir().ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(-2, -1)));
    }

    @Test
    public void test04AgregarOtroElementoALaListaOriginalNoAfectaAlgoritmoPersonalizado(){
        Personaje personaje = new Personaje(new Dibujo());
        List<Bloque> lista = new ArrayList();

        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueArriba());
        AlgoritmoPersonalizado algoP = new AlgoritmoPersonalizado("test", lista);
        lista.add(BloqueMovimiento.bloqueIzquierda());
        algoP.ejecutar(personaje);

        assertTrue(personaje.estaEnPosicion(new Posicion(2, 1)));
    }

    @Test
    public void test05EjecutarAlgoritmoPersonalizadoConLapizAbajoDibujaLineas(){
        Dibujo dibujo = new Dibujo();
        Personaje personaje = new Personaje(dibujo);
        List<Bloque> lista = new ArrayList();

        lista.add(new BloqueBajarLapiz());
        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueDerecha());
        lista.add(BloqueMovimiento.bloqueArriba());
        AlgoritmoPersonalizado algoP = new AlgoritmoPersonalizado("test", lista);
        algoP.ejecutar(personaje);

        assertEquals(3, dibujo.getCantidadLineas());
    }
}
