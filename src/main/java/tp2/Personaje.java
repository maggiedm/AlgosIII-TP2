package tp2;

public class Personaje {

    private Posicion posicion = new Posicion();
    private final Lapiz lapiz = new Lapiz();
    private final Dibujo dibujo = new Dibujo();

    public Posicion getPosicion() {
        return posicion;
    }

    public Lapiz getLapiz() {
        return lapiz;
    }

    public Dibujo getDibujo() { return dibujo; }

    public void bajarLapiz() {
        lapiz.bajar();
    }

    public void subirLapiz() {
        lapiz.subir();
    }

    public void mover(Direccion unaDireccion) {
        Posicion posVieja = posicion;
        Posicion posNueva = posicion.obtenerSiguiente(unaDireccion);
        lapiz.dibujarLinea(posVieja, posNueva, dibujo);
        posicion = posNueva;
    }

}
