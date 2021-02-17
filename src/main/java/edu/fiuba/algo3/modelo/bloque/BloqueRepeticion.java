package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.MostradorBloqueSimple;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.SecuenciaBloques;
import javafx.scene.layout.VBox;

public class BloqueRepeticion extends SecuenciaBloques implements Bloque{
    private final int cantidad;

    public final String descripcion;

    private BloqueRepeticion(int cant, String unaDescripcion){
        cantidad = cant;
        descripcion = unaDescripcion;
    }

    public static BloqueRepeticion repetirDosVeces(){
        return new BloqueRepeticion(2,"Repeticion doble");
    }

    public static BloqueRepeticion repetirTresVeces(){
        return new BloqueRepeticion(3,"Repeticion triple");
    }

    public void ejecutar(Personaje unPersonaje){
        for (int i = 0; i < cantidad; i++){
            super.ejecutar(unPersonaje);
        }
    }

    public Bloque invertir(){
        BloqueRepeticion nBloque = new BloqueRepeticion(cantidad, descripcion);
        for (int i = bloques.size() - 1; i >= 0 ; i--) {
            nBloque.agregarBloque(bloques.get(i).invertir());
        }
        return nBloque;
    }

    @Override
    public void mostrar(VBox layout) {
        new MostradorBloqueSimple(descripcion, layout);
        //bloques.forEach(bloque -> bloque.mostrar(layout));
    }

    @Override
    public String getDescripcion(){ return descripcion; }
}
