package edu.fiuba.algo3.modelo;

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

    public void desplazar (Coordenadas unasCoordenadas) {
        x = x + unasCoordenadas.x;
        y = y + unasCoordenadas.y;
    }

    public boolean sonIgualesA(Coordenadas unasCoordenadas) {
        return (x == unasCoordenadas.x && y == unasCoordenadas.y);
    }

}
