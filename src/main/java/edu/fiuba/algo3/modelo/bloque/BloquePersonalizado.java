package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.javafx.MostradorBloqueSimple;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BloquePersonalizado implements Bloque {

    private String descripcion = "Algoritmo Personalizado";

    private final List<Bloque> bloques;

    public BloquePersonalizado(List<Bloque> lBloques){
        bloques = new ArrayList<>(lBloques);
    }

    public void ejecutar(Personaje unPersonaje){
        bloques.forEach(bloque -> bloque.ejecutar(unPersonaje));
    }

    public Bloque invertir(){
        List<Bloque> aux = new ArrayList<>();
        bloques.forEach(bloque -> aux.add(bloque.invertir()));
        return new BloquePersonalizado(aux);
    }

    @Override
    public String getDescripcion() {return descripcion;};

    @Override
    public void mostrar(VBox layout) {
        new MostradorBloqueSimple(descripcion, layout);
    } // Chequear
}
