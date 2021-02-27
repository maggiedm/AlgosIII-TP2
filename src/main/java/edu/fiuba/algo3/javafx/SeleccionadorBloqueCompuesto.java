package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.ContenedorDeBloques;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeleccionadorBloqueCompuesto {
    private static final List<BloqueCompuesto> bloquesCompuestos = new ArrayList<>();
    private static SeleccionadorBloqueCompuestoVista seleccionadorBloqueCompuestoVista = new SeleccionadorBloqueCompuestoVista("Algoritmo");
    private static final HashMap<String, Integer> cantMismoBloqueCompuesto= new HashMap<>();


    public SeleccionadorBloqueCompuesto(AlgoBlocks algoBlocks, VBox layoutAlgoritmo){
        bloquesCompuestos.add(new BloqueCompuestoPrincipal(algoBlocks,"Algoritmo", layoutAlgoritmo));//Guardar Algoritmo como BloqueCompuesto

        cargarDiccionarioBloquesCompuestos();
        layoutAlgoritmo.getChildren().add(seleccionadorBloqueCompuestoVista);
    }

    public static void reiniciar(){
        BloqueCompuestoPrincipal algoblocks = (BloqueCompuestoPrincipal) bloquesCompuestos.get(0);
        bloquesCompuestos.clear();
        bloquesCompuestos.add(algoblocks);

        seleccionadorBloqueCompuestoVista = new SeleccionadorBloqueCompuestoVista("Algoritmo");

        algoblocks.reiniciarLayoutAlgoritmo(seleccionadorBloqueCompuestoVista);

        cantMismoBloqueCompuesto.forEach((s, integer) -> cantMismoBloqueCompuesto.replace(s, 0));
    }

    public static BloqueCompuesto bloqueActual(){
        return bloquesCompuestos.stream()
                .filter(contenedor -> contenedor.tieneDescripcion(seleccionadorBloqueCompuestoVista.getActual()))
                .findAny()
                .orElse(null);
    }

    public static void agregar (Bloque bloque, String rutaImagen) {
        BloqueCompuesto bloqueActual = bloqueActual();

        String aux = nombreBloque(rutaImagen);
        String descripcion = ("Bloque" + aux + " - " + cantMismoBloqueCompuesto.get(aux));
        cantMismoBloqueCompuesto.replace(aux, cantMismoBloqueCompuesto.get(aux) + 1);

        VBox layoutSecuenciaNueva = new VBox();
        layoutSecuenciaNueva.setPadding(new Insets(0,0,0,20));
        VBox layoutContenedorNuevo = Vista.crearLayoutContenedorDeBloques(layoutSecuenciaNueva,rutaImagen);
        Vista.agregarMarcadorFinal(layoutContenedorNuevo,descripcion);

        bloquesCompuestos.add(new BloqueCompuesto((ContenedorDeBloques) bloque,descripcion,layoutSecuenciaNueva));

        bloqueActual.agregarBloqueContenedor(bloque,descripcion, layoutContenedorNuevo);

       seleccionadorBloqueCompuestoVista.agregar(descripcion);
    }

    private void cargarDiccionarioBloquesCompuestos(){
        cantMismoBloqueCompuesto.put("Repetir2", 0);
        cantMismoBloqueCompuesto.put("Repetir3", 0);
        cantMismoBloqueCompuesto.put("Invertir", 0);
    }

    private static String nombreBloque(String rutaImagen){
        for (String key:cantMismoBloqueCompuesto.keySet()
             ) {
            if(rutaImagen.contains(key)){
                return key;
            }
        }
        return null;
    }

}
