package tp2;

public class AlgoBlocks {
    private Personaje personaje = new Personaje();
    private Algoritmo algoritmo = new Algoritmo();

    public void ejecutar() {
        // personaje = new Personaje();
        algoritmo.ejecutar(personaje);
    }

    public void agregarBloque(Bloque unBloque) {
        algoritmo.agregarBloque(unBloque);
    }

    public Personaje getPersonaje() { return personaje; }

    public Algoritmo getAlgoritmo() { return algoritmo; }
}