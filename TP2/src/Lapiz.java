public class Lapiz {
    private CondicionLapiz condicion = new LapizArriba();

    public CondicionLapiz getCondicion() {
        return condicion;
    }

    public void bajar() {
        condicion = new LapizAbajo();
    }

    public void subir() {
        condicion = new LapizArriba();
    }
}
