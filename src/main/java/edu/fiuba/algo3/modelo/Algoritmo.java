package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bloque.Bloque;
import edu.fiuba.algo3.modelo.bloque.BloquePersonalizado;

import java.util.ArrayList;

public class Algoritmo extends SecuenciaBloques implements Observable {

    private final ArrayList<Observer> observers = new ArrayList<>();

    public int getCantidadDeBloques() { return bloques.size(); }

    @Override
    public void agregarBloque(Bloque unBloque){
        super.agregarBloque(unBloque);
        notifyObservers();
    }

    public BloquePersonalizado guardar() throws GuardarAlgoritmoVacioException{
        if(bloques.isEmpty()){
            throw new GuardarAlgoritmoVacioException();
        }
        return new BloquePersonalizado(bloques);
    }

    public void reiniciar(){
        bloques.clear();
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.change(this));
    }
}
