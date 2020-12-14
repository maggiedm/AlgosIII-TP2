package tp2;

public class Coordenada {

    private int x;
    private int y;

    public Coordenada(int  posHorizontal, int posVertical){
        x = posHorizontal;
        y = posVertical;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordenada sumar (Coordenada unaCoordenada){
        return new Coordenada(this.x + unaCoordenada.getX(), this.y + unaCoordenada.getY());
    }

}
