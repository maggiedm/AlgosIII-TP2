package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.Bloque;
import edu.fiuba.algo3.modelo.bloque.BloquePersonalizado;

public class AlgoBlocks{
    private final Dibujo dibujo = new Dibujo();
    private final Personaje personaje = new Personaje(dibujo);
    private final Algoritmo algoritmo = new Algoritmo();

    public Algoritmo getAlgoritmo(){ return algoritmo; }

    public Dibujo getDibujo(){ return dibujo; }

    public void ejecutarAlgoritmo(){
        algoritmo.ejecutar(personaje);
    }

    public void agregarBloque(Bloque unBloque) {
        algoritmo.agregarBloque(unBloque);
    }

    public BloquePersonalizado guardarAlgoritmo(){ return algoritmo.guardar(); }

    public Boolean personajeEstaEnPosicion(Posicion unaPosicion){ return personaje.estaEnPosicion(unaPosicion); }

    public int cantidadLineasDibujadas() { return dibujo.getCantidadLineas();}

    public int cantidadDeBloquesEnAlgoritmo(){ return algoritmo.getCantidadDeBloques(); }

    public void reiniciar(){
        dibujo.reiniciar();
        algoritmo.reiniciar();
        personaje.reiniciar();
    }
}