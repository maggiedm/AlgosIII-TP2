package tp2;

public class Linea {

    private Posicion origen;
    private Posicion destino;

    public Linea (Posicion inicioLinea, Posicion finLinea) {
        origen = inicioLinea;
        destino = finLinea;
    }

    public boolean esIgual(Posicion inicioLinea, Posicion finLinea) {
        return ((origen.esMisma(inicioLinea) && destino.esMisma(finLinea)) || (origen.esMisma(finLinea) && destino.esMisma(inicioLinea)));
    }
}
