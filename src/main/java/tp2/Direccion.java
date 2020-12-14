package tp2;

public abstract class Direccion {

    protected Coordenadas coordenadas;

    public Direccion(int dirHorizontal, int dirVertical){
        coordenadas = new Coordenadas(dirHorizontal, dirVertical);
    }

    public Coordenadas getCoordenadas() { return coordenadas; }
}
