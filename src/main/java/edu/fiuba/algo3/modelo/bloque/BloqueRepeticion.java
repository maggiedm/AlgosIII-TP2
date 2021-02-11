package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.SecuenciaBloques;

import java.util.ArrayList;
import java.util.List;

public class BloqueRepeticion extends SecuenciaBloques implements Bloque{
    private final int cantidad;

    private BloqueRepeticion(int cant){
        cantidad = cant;
    }

    public static BloqueRepeticion repetirDosVeces(){
        return new BloqueRepeticion(2);
    }

    public static BloqueRepeticion repetirTresVeces(){
        return new BloqueRepeticion(3);
    }

    public void ejecutar(Personaje unPersonaje){
        for (int i = 0; i < cantidad; i++){
            super.ejecutar(unPersonaje);
        }
    }

    public Bloque invertir(){
        return null;
    }
}
