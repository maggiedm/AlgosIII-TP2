package edu.fiuba.algo3.javafx.botones;

import edu.fiuba.algo3.javafx.handlers.BotonGuardarAlgoritmoEventHandler;
import edu.fiuba.algo3.javafx.layouts.LayoutBloques;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.Observer;


public class BotonGuardarAlgoritmo  extends BotonSimple implements Observer{

    public BotonGuardarAlgoritmo(AlgoBlocks algoBlocks, LayoutBloques layoutBloques){
        super("recursos/imagenes/botones/boton-guardar.png", "Guarda el algoritmo ingresado.",
                new BotonGuardarAlgoritmoEventHandler(algoBlocks, layoutBloques));
        this.setVisible(false);
    }

    @Override
    public void change(Object obj) {
        AlgoBlocks algoBlocks = (AlgoBlocks) obj;

        this.setVisible(algoBlocks.cantidadDeBloquesEnAlgoritmo() != 0);
    }
}
