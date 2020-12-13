package tp2;

import java.util.ArrayList;
import java.util.List;

public class Dibujo {
    List<Linea> lineas = new ArrayList<>();

    public void dibujarLinea(Posicion origen, Posicion destino) {
        lineas.add(new Linea(origen, destino));
    }

    public List<Linea> getLineas() { return lineas; }
}
