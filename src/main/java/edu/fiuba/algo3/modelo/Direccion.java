package edu.fiuba.algo3.modelo;

public class Direccion {

    private final int dx;
    private final int dy;

    private Direccion(int dirHorizontal, int dirVertical){
        dx = dirHorizontal;
        dy = dirVertical;
    }

    public static Direccion derecha(){
        return new Direccion(1,0);
    }

    public static Direccion izquierda(){
        return new Direccion(-1,0);
    }

    public static Direccion arriba(){
        return new Direccion(0,1);
    }

    public static Direccion abajo(){
        return new Direccion(0,-1);
    }

    public Posicion desplazar(Posicion posicion) { return posicion.desplazar(dx, dy); }
}
