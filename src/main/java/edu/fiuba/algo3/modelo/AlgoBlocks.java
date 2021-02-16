package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.Bloque;
import edu.fiuba.algo3.modelo.bloque.BloquePersonalizado;

public class AlgoBlocks {
    private final Dibujo dibujo;
    private final Personaje personaje;
    private final Algoritmo algoritmo = new Algoritmo();

    public void ejecutarAlgoritmo(){
        // personaje = new Personaje();
        algoritmo.ejecutar(personaje);
    }

    public AlgoBlocks(Dibujo unDibujo){
        dibujo = unDibujo;
        personaje = new Personaje(unDibujo);
    }

    public void agregarBloque(Bloque unBloque) {
        algoritmo.agregarBloque(unBloque);
    }

    public BloquePersonalizado guardarAlgoritmo(){
            return algoritmo.guardar();
    }

    public Boolean personajeEstaEnPosicion(Posicion unaPosicion){
        return personaje.estaEnPosicion(unaPosicion);
    }

    public int cantidadLineasDibujadas() { return dibujo.getCantidadLineas();}

    public int cantidadDeBloquesEnAlgoritmo(){
        return algoritmo.getCantidadDeBloques();
    }
}
