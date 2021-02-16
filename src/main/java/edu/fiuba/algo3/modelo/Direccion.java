package edu.fiuba.algo3.modelo;

public class Direccion {

    static int PASO = 30;

    private final int dx;
    private final int dy;
    private final String descripcion;

    private Direccion(int dirHorizontal, int dirVertical, String unaDescripcion){
        dx = dirHorizontal;
        dy = dirVertical;
        descripcion = unaDescripcion;
    }

    public static Direccion derecha(){
        return new Direccion(PASO,0,"derecha");
    }

    public static Direccion izquierda(){
        return new Direccion(-PASO,0,"izquierda");
    }

    public static Direccion arriba(){
        return new Direccion(0,-PASO,"arriba");
    }

    public static Direccion abajo(){
        return new Direccion(0,PASO,"abajo");
    }

    public Posicion desplazar(Posicion posicion) { return posicion.desplazar(dx, dy); }

    public Direccion invertir(){
        return new Direccion(-dx, -dy, descripcion);
    }

    public String getDescripcion() { return descripcion; }
}
