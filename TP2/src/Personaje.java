public class Personaje {

    private Posicion posicion = new Posicion(0, 0);
    private Lapiz lapiz = new Lapiz();

    public Posicion getPosicion() {
        return posicion;
    }

    public Lapiz getLapiz() {
        return lapiz;
    }

    public void bajarLapiz() {
        lapiz.bajar();
    }

    public void subirLapiz() {
        lapiz.subir();
    }

    public void mover(Direccion unaDireccion) {
        posicion = posicion.obtenerSiguiente(unaDireccion);
    }
}
