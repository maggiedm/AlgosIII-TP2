package tp2;

public class Posicion {

    private Coordenada coordenada = new Coordenada(0, 0);

    public int getX() {
        return coordenada.getX();
    }

    public int getY() {
        return coordenada.getY();
    }

    public Posicion obtenerSiguiente(Direccion unaDireccion) {

        Posicion posicion = new Posicion();
        posicion.coordenada = this.coordenada.sumar(unaDireccion.getCoordenada());
        return posicion;
    }
}
