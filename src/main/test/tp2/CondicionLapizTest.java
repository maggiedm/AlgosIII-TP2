package tp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CondicionLapizTest {

    @Test
    public void test01LapizArribaNoDibujaLinea(){

        CondicionLapiz condicion = new LapizArriba();
        Dibujo dibujo = new Dibujo();

        condicion.dibujarLinea(new Posicion(), new Posicion(), dibujo);

        assertTrue(dibujo.getLineas().isEmpty());
    }

    @Test
    public void test02LapizAbajoDibujaUnaLinea(){

        CondicionLapiz condicion = new LapizAbajo();
        Dibujo dibujo = new Dibujo();

        condicion.dibujarLinea(new Posicion(), new Posicion(), dibujo);

        assertEquals(1, dibujo.getLineas().size());
    }
}
