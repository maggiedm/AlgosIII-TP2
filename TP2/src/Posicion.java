public class Posicion {

    private int x;
    private int y;

    public Posicion (int posHorizontal, int posVertical) {
        x = posHorizontal;
        y = posVertical;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Posicion obtenerSiguiente(Direccion unaDireccion) {

        return new Posicion(unaDireccion.desplazarHorizontal(x), unaDireccion.desplazarVertical(y));
    }
}
