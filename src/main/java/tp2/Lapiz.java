package tp2;

public class Lapiz {
    private CondicionLapiz condicion = new LapizArriba();

    public void bajar() {
        condicion = new LapizAbajo();
    }

    public void subir() {
        condicion = new LapizArriba();
    }

    public void dibujarLinea(Posicion origen, Posicion destino, Dibujo dibujo) {
        condicion.dibujarLinea(origen, destino, dibujo);
    }
}
