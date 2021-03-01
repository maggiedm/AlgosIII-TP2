package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.ContenedorDeBloques;
import edu.fiuba.algo3.modelo.bloque.Bloque;
import edu.fiuba.algo3.vista.Vista;
import edu.fiuba.algo3.vista.algoritmo.SeleccionadorContenedorBloquesVista;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeleccionadorContenedorBloques {
    private static final List<ContenedorBloques> contenedoresDeBloques = new ArrayList<>();
    private static SeleccionadorContenedorBloquesVista seleccionadorContenedorBloquesVista = new SeleccionadorContenedorBloquesVista("Algoritmo");
    private static final HashMap<String, Integer> cantMismoBloqueCompuesto= new HashMap<>();


    public SeleccionadorContenedorBloques(AlgoBlocks algoBlocks, VBox layoutAlgoritmo){
        contenedoresDeBloques.add(new ContenedorBloquesPrincipal(algoBlocks,"Algoritmo", layoutAlgoritmo));

        cargarDiccionarioBloquesCompuestos();
        layoutAlgoritmo.getChildren().add(seleccionadorContenedorBloquesVista);
    }

    public static void reiniciar(){
        ContenedorBloquesPrincipal algoblocks = (ContenedorBloquesPrincipal) contenedoresDeBloques.get(0);
        contenedoresDeBloques.clear();
        contenedoresDeBloques.add(algoblocks);

        seleccionadorContenedorBloquesVista = new SeleccionadorContenedorBloquesVista("Algoritmo");

        algoblocks.reiniciarLayoutAlgoritmo(seleccionadorContenedorBloquesVista);

        cantMismoBloqueCompuesto.forEach((s, integer) -> cantMismoBloqueCompuesto.replace(s, 0));
    }

    public static ContenedorBloques bloqueActual(){
        return contenedoresDeBloques.stream()
                .filter(contenedor -> contenedor.tieneDescripcion(seleccionadorContenedorBloquesVista.getActual()))
                .findAny()
                .orElse(null);
    }

    public static void agregar (Bloque bloque, String rutaImagen) {
        ContenedorBloques bloqueActual = bloqueActual();

        String aux = nombreBloque(rutaImagen);
        String descripcion = ("Bloque" + aux + " - " + cantMismoBloqueCompuesto.get(aux));
        cantMismoBloqueCompuesto.replace(aux, cantMismoBloqueCompuesto.get(aux) + 1);

        VBox layoutSecuenciaNueva = new VBox();
        layoutSecuenciaNueva.setPadding(new Insets(0,0,0,20));
        VBox layoutContenedorNuevo = Vista.crearLayoutContenedorDeBloques(layoutSecuenciaNueva,rutaImagen);
        Vista.agregarMarcadorFinal(layoutContenedorNuevo,descripcion);

        contenedoresDeBloques.add(new ContenedorBloques((ContenedorDeBloques) bloque,descripcion,layoutSecuenciaNueva));

        bloqueActual.agregarBloqueContenedor(bloque,descripcion, layoutContenedorNuevo);

       seleccionadorContenedorBloquesVista.agregar(descripcion);
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
