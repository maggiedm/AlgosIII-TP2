package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public abstract class SecuenciaBloques {

    protected final List<Bloque> bloques = new ArrayList<>();

    public void agregarBloque(Bloque unBloque) { bloques.add(unBloque); }

    public void ejecutar(Personaje unPersonaje){
        bloques.forEach(bloque -> bloque.ejecutar(unPersonaje));
    }

    public void mostrar(VBox layout){ bloques.forEach(bloque -> bloque.mostrar(layout)); }
}
