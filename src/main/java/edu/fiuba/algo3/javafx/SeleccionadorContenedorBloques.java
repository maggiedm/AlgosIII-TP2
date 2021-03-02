package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.controlador.ControladorContenedorPrincipalDeBloques;
import edu.fiuba.algo3.controlador.ControladorContenedorInternoDeBloques;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.BloqueContenedor;
import edu.fiuba.algo3.vista.ScrollPaneVista;
import edu.fiuba.algo3.vista.algoritmo.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeleccionadorContenedorBloques {
    private static final List<LayoutContenedorDeBloques> layoutContenedorDeBloques = new ArrayList<>();
    private static SeleccionadorContenedorBloquesVista seleccionadorContenedorBloquesVista;
    private static final HashMap<String, Integer> cantMismoBloqueCompuesto= new HashMap<>();


    public SeleccionadorContenedorBloques(AlgoBlocks algoBlocks, ScrollPaneVista layoutAlgoritmo, SeleccionadorContenedorBloquesVista unSeleccionador){
        layoutContenedorDeBloques.add(new LayoutContenedorPrincipalDeBloques("Algoritmo", new ControladorContenedorPrincipalDeBloques(algoBlocks)));
        seleccionadorContenedorBloquesVista = unSeleccionador;
        cargarDiccionarioBloquesCompuestos();
        layoutAlgoritmo.setContent(layoutContenedorDeBloques.get(0));
    }

    public static void reiniciar(){
        LayoutContenedorPrincipalDeBloques layoutAlgoblocks = (LayoutContenedorPrincipalDeBloques)layoutContenedorDeBloques.get(0);
        layoutContenedorDeBloques.clear();
        layoutAlgoblocks.reiniciarLayout();
        layoutContenedorDeBloques.add(layoutAlgoblocks);

        cantMismoBloqueCompuesto.forEach((s, integer) -> cantMismoBloqueCompuesto.replace(s, 0));
    }

    public static LayoutContenedorDeBloques bloqueActual(){
        return layoutContenedorDeBloques.stream()
                .filter(contenedor -> contenedor.tieneDescripcion(seleccionadorContenedorBloquesVista.getActual()))
                .findAny()
                .orElse(null);
    }

    public static void agregar (BloqueContenedor bloque, String rutaImagen) {
        String aux = nombreBloque(rutaImagen);
        String descripcion = ("Bloque" + aux + " - " + cantMismoBloqueCompuesto.get(aux));
        cantMismoBloqueCompuesto.replace(aux, cantMismoBloqueCompuesto.get(aux) + 1);

        LayoutContenedorInternoDeBloques layoutContenedorNuevo =
                new LayoutContenedorInternoDeBloques(descripcion,new ControladorContenedorInternoDeBloques(bloque), rutaImagen);
        layoutContenedorDeBloques.add(layoutContenedorNuevo);
        bloqueActual().agregarBloqueContenedor(bloque, descripcion, layoutContenedorNuevo);
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
