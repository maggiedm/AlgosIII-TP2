package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.lapiz.CondicionLapiz;
import edu.fiuba.algo3.modelo.lapiz.LapizAbajo;
import edu.fiuba.algo3.modelo.lapiz.LapizArriba;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CondicionLapizTest {

    @Test
    public void test01LapizArribaNoDibujaLinea(){

        CondicionLapiz condicion = new LapizArriba();
        Dibujo dibujo = new Dibujo();

        condicion.dibujarLinea(new Posicion(), new Posicion(), dibujo);

        assertEquals(0, dibujo.getCantidadLineas());
    }

    @Test
    public void test02LapizAbajoDibujaUnaLinea(){

        CondicionLapiz condicion = new LapizAbajo();
        Dibujo dibujo = new Dibujo();

        condicion.dibujarLinea(new Posicion(), new Posicion(), dibujo);

        assertEquals(1, dibujo.getCantidadLineas());
    }
}
