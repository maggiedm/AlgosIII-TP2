public class Personaje {

    private Posicion posicion = new Posicion(0, 0);
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
        Posicion pos_vieja = posicion;
        Posicion pos_nueva = posicion.obtenerSiguiente(unaDireccion);
        lapiz.dibujarLinea(pos_vieja, pos_nueva, dibujo);
        posicion = posicion.obtenerSiguiente(unaDireccion);
    }

}
