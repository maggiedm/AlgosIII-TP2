package tp2;

import java.util.ArrayList;
import java.util.List;

public class Dibujo {
    List<Linea> lineas = new ArrayList<>();

    public void dibujarLinea(Posicion origen, Posicion destino) {
        if(!this.lineaYaExiste(origen, destino)){
            lineas.add(new Linea(origen, destino));
        }
    }

    private boolean lineaYaExiste(Posicion origen, Posicion destino){
        for (Linea linea: lineas) {
            if(linea.esIgual(origen, destino)){
                 return true;
            }
        }
        return false;
    }

    public List<Linea> getLineas() { return lineas; }
}
