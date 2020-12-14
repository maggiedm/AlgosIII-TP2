package tp2;

public abstract class Direccion {

    protected Coordenada coordenada;

    public Direccion(int dirHorizontal, int dirVertical){
        coordenada = new Coordenada(dirHorizontal, dirVertical);
    }

    public Coordenada getCoordenada() { return coordenada; }
}
