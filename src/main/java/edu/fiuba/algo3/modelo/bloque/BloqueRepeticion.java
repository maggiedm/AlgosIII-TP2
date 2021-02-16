package edu.fiuba.algo3.modelo.bloque;

import edu.fiuba.algo3.MostradorBloqueSimple;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.SecuenciaBloques;
import javafx.scene.layout.VBox;

public class BloqueRepeticion extends SecuenciaBloques implements Bloque{
    private final int cantidad;

    private BloqueRepeticion(int cant){
        cantidad = cant;
    }

    public static BloqueRepeticion repetirDosVeces(){
        return new BloqueRepeticion(2);
    }

    public static BloqueRepeticion repetirTresVeces(){
        return new BloqueRepeticion(3);
    }

    public void ejecutar(Personaje unPersonaje){
        for (int i = 0; i < cantidad; i++){
            super.ejecutar(unPersonaje);
        }
    }

    public Bloque invertir(){
        BloqueRepeticion nBloque =new BloqueRepeticion(cantidad);
        for (int i = bloques.size() - 1; i >= 0 ; i--) {
            nBloque.agregarBloque(bloques.get(i).invertir());
        }
        return nBloque;
    }
}
