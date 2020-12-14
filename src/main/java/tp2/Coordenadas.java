package tp2;

public class Coordenadas {

    private int x;
    private int y;

    public Coordenadas(int  posHorizontal, int posVertical){
        x = posHorizontal;
        y = posVertical;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordenadas sumar (Coordenadas unasCoordenadas){
        return new Coordenadas(this.x + unasCoordenadas.getX(), this.y + unasCoordenadas.getY());
    }

}
