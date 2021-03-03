package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.controlador.ControladorContenedorPrincipalDeBloques;
import edu.fiuba.algo3.controlador.ControladorContenedorInternoDeBloques;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.BloqueContenedor;
import edu.fiuba.algo3.vista.VistaScrollPane;
import edu.fiuba.algo3.vista.algoritmo.*;
import java.util.HashMap;

public class SeleccionadorContenedorBloques {
    private static final HashMap<String, LayoutContenedorDeBloques>  layoutsContenedoresDeBloques = new HashMap<>();
    private static SelectorContenedorDeBloquesActual selectorContenedorDeBloquesActual;
    private static final HashMap<String, Integer> cantMismoBloqueCompuesto = new HashMap<>();
    private static final String descripcionAlgoritmo = "Algoritmo";

    public SeleccionadorContenedorBloques(AlgoBlocks algoBlocks, VistaScrollPane layoutAlgoritmo, SelectorContenedorDeBloquesActual unSelector){
        layoutsContenedoresDeBloques.put(descripcionAlgoritmo, new LayoutContenedorPrincipalDeBloques(descripcionAlgoritmo, new ControladorContenedorPrincipalDeBloques(algoBlocks)));
        selectorContenedorDeBloquesActual = unSelector;
        cargarDiccionarioBloquesCompuestos();
        layoutAlgoritmo.setContent(layoutsContenedoresDeBloques.get(descripcionAlgoritmo));
    }

    public static void reiniciar(){
        LayoutContenedorPrincipalDeBloques layoutAlgoblocks = (LayoutContenedorPrincipalDeBloques)layoutsContenedoresDeBloques.get(descripcionAlgoritmo);
        layoutsContenedoresDeBloques.clear();
        layoutAlgoblocks.reiniciarLayout();
        layoutsContenedoresDeBloques.put(descripcionAlgoritmo, layoutAlgoblocks);

        cantMismoBloqueCompuesto.forEach((s, integer) -> cantMismoBloqueCompuesto.replace(s, 0));
    }

    public static LayoutContenedorDeBloques layoutContenedorBloqueActual(){
        return layoutsContenedoresDeBloques.get(selectorContenedorDeBloquesActual.getActual());
    }

    public static void agregar (BloqueContenedor bloque, String rutaImagen) {
        String aux = nombreBloque(rutaImagen);
        String descripcion = ("Bloque" + aux + " - " + cantMismoBloqueCompuesto.get(aux));
        cantMismoBloqueCompuesto.replace(aux, cantMismoBloqueCompuesto.get(aux) + 1);

        LayoutContenedorInternoDeBloques layoutContenedorNuevo =
                new LayoutContenedorInternoDeBloques(descripcion,new ControladorContenedorInternoDeBloques(bloque), rutaImagen);
        layoutsContenedoresDeBloques.put(descripcion, layoutContenedorNuevo);
        layoutContenedorBloqueActual().agregarBloqueContenedor(bloque, descripcion, layoutContenedorNuevo);
       selectorContenedorDeBloquesActual.agregar(descripcion);
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
