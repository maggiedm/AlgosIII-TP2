package tp2;

public class Posicion {

    private Coordenadas coordenadas = new Coordenadas(0, 0);

    public int getX() {
        return coordenadas.getX();
    }

    public int getY() {
        return coordenadas.getY();
    }

    public Posicion obtenerSiguiente(Direccion unaDireccion) {

        Posicion posicion = new Posicion();
        posicion.coordenadas = this.coordenadas.sumar(unaDireccion.getCoordenadas());
        return posicion;
    }
}
