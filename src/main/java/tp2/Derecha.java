package tp2;

public class Derecha extends Direccion{

    @Override
    public int desplazarHorizontal(int PosHorizontal) {
        return (PosHorizontal + 1);
    }

}
