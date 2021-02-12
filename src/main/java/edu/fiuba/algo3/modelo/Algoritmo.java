package edu.fiuba.algo3.modelo;


public class Algoritmo extends SecuenciaBloques{

    public int getCantidadDeBloques() { return bloques.size(); }

    public AlgoritmoPersonalizado guardar(String nombre) throws GuardarAlgoritmoVacioException{
        if(bloques.isEmpty()){
            throw new GuardarAlgoritmoVacioException();
        }
        return new AlgoritmoPersonalizado(nombre, bloques);
    }

}
