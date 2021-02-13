package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.MostradorBloqueSimple;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class AlgoritmoPersonalizado implements Bloque {

    String nombre;
    private final List<Bloque> bloques;

    public AlgoritmoPersonalizado (String nom, List<Bloque> lBloques){
        nombre = nom;
        bloques = new ArrayList(lBloques);
    }

    public void ejecutar(Personaje unPersonaje){
        bloques.forEach(bloque -> bloque.ejecutar(unPersonaje));
    }

    public Bloque invertir(){
        List<Bloque> aux = new ArrayList();
        bloques.forEach(bloque -> aux.add(bloque.invertir()));
        return new AlgoritmoPersonalizado(nombre, aux);
    }

    @Override
    public void mostrar(VBox layout) {
        new MostradorBloqueSimple(nombre, layout);
    }

    @Override
    public String getDescripcion(){ return nombre;}
}
