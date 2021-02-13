package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class AlgoBlocks {
    private final Dibujo dibujo = new Dibujo();
    private final Personaje personaje = new Personaje(dibujo);
    private final Algoritmo algoritmo = new Algoritmo();
    private final VBox layout;

    public AlgoBlocks(VBox unLayout){ layout = unLayout; }

    public void ejecutarAlgoritmo(){
        // personaje = new Personaje();
        algoritmo.ejecutar(personaje);
    }

    public void agregarBloque(Bloque unBloque) {
        algoritmo.agregarBloque(unBloque);
    }

    public void guardarAlgoritmo(String nombre){
        try{
            algoritmo.guardar(nombre);
        }catch (GuardarAlgoritmoVacioException e){
            System.out.println("No puede guardar un Algoritmo vacio");
        }
        //donde guardamos los algoritmos personalizados?
    }

    public Boolean personajeEstaEnPosicion(Posicion unaPosicion){
        return personaje.estaEnPosicion(unaPosicion);
    }

    public void mostrarAlgoritmo(){
        layout.getChildren().clear();
        layout.setSpacing(10);

        Label etiqueta = new Label("Algoritmo");
        etiqueta.setFont(Font.font(20));
        layout.getChildren().add(etiqueta);
        
        algoritmo.mostrar(layout);
    }

    public int cantidadLineasDibujadas() { return dibujo.getCantidadLineas();}

    public int cantidadDeBloquesEnAlgoritmo(){
        return algoritmo.getCantidadDeBloques();
    }
}
