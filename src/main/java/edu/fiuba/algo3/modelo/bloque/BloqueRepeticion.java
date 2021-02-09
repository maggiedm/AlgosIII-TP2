package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.modelo.Personaje;

import java.util.ArrayList;
import java.util.List;

public class BloqueRepeticion implements Bloque {
    private final int cantidad;
    private final List<Bloque> bloques = new ArrayList<>();

    private BloqueRepeticion(int cant){
        cantidad = cant;
    }

    public static BloqueRepeticion repetirDosVeces(){
        return new BloqueRepeticion(2);
    }

    public static BloqueRepeticion repetirTresVeces(){
        return new BloqueRepeticion(3);
    }

    public void agregarBloque(Bloque unBloque){
        bloques.add(unBloque);
    }

    public void ejecutar(Personaje unPersonaje) {
        for (int i = 0; i < cantidad; i++) {
            for (Bloque bloque: bloques){
                bloque.ejecutar(unPersonaje);
            }
        }
    }
}
