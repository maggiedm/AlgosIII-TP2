package edu.fiuba.algo3.javafx;

import edu.fiuba.algo3.controlador.ControladorContenedorPrincipalDeBloques;
import edu.fiuba.algo3.controlador.ControladorContenedorInternoDeBloques;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.bloque.BloqueContenedor;
import edu.fiuba.algo3.vista.VistaScrollPane;
import edu.fiuba.algo3.vista.algoritmo.*;
import edu.fiuba.algo3.vista.bloques.BloquesDisponibles;

import java.util.HashMap;

public class AdministradorContenedoresDeBloques {
    private static final HashMap<String, LayoutContenedorDeBloques>  layoutsContenedoresDeBloques = new HashMap<>();
    private static SelectorContenedorDeBloquesParaAgregar selectorContenedorDeBloquesParaAgregar;
    private static final ContadorBloquesCompuestos contadorBloquesCompuestos = new ContadorBloquesCompuestos();
    private static final String descripcionAlgoritmo = "Algoritmo";

    public AdministradorContenedoresDeBloques(AlgoBlocks algoBlocks, VistaScrollPane layoutAlgoritmo, SelectorContenedorDeBloquesParaAgregar unSelector){
        layoutsContenedoresDeBloques.put(descripcionAlgoritmo, new LayoutContenedorPrincipalDeBloques(descripcionAlgoritmo, new ControladorContenedorPrincipalDeBloques(algoBlocks)));
        selectorContenedorDeBloquesParaAgregar = unSelector;
        layoutAlgoritmo.setContent(layoutsContenedoresDeBloques.get(descripcionAlgoritmo));
    }

    public static void reiniciar(){
        LayoutContenedorPrincipalDeBloques layoutAlgoblocks = (LayoutContenedorPrincipalDeBloques)layoutsContenedoresDeBloques.get(descripcionAlgoritmo);
        layoutsContenedoresDeBloques.clear();
        layoutAlgoblocks.reiniciarLayout();
        layoutsContenedoresDeBloques.put(descripcionAlgoritmo, layoutAlgoblocks);

        contadorBloquesCompuestos.reiniciar();
    }

    public static LayoutContenedorDeBloques layoutContenedorBloqueActual(){
        return layoutsContenedoresDeBloques.get(selectorContenedorDeBloquesParaAgregar.getActual());
    }

    public static void agregar (BloqueContenedor bloque, String rutaImagen, String nombreBloque) {
        contadorBloquesCompuestos.agregar(nombreBloque);
        String descripcion = ("Bloque" + nombreBloque + " - " + contadorBloquesCompuestos.getCantidad(nombreBloque));

        LayoutContenedorInternoDeBloques layoutContenedorNuevo =
                new LayoutContenedorInternoDeBloques(descripcion,new ControladorContenedorInternoDeBloques(bloque), rutaImagen);
        layoutsContenedoresDeBloques.put(descripcion, layoutContenedorNuevo);
        layoutContenedorBloqueActual().agregarBloqueContenedor(bloque, descripcion, layoutContenedorNuevo);
       selectorContenedorDeBloquesParaAgregar.agregar(descripcion);
    }
}
