package edu.fiuba.algo3.javafx.botones;

import edu.fiuba.algo3.javafx.handlers.BotonGuardarAlgoritmoEventHandler;
import edu.fiuba.algo3.javafx.layouts.LayoutBloques;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.Algoritmo;
import edu.fiuba.algo3.modelo.Observer;


public class BotonGuardarAlgoritmo  extends BotonSimple implements Observer{

    public BotonGuardarAlgoritmo(AlgoBlocks algoBlocks, LayoutBloques layoutBloques){
        super("recursos/boton-guardar.png", "Guarda el algoritmo ingresado.", new BotonGuardarAlgoritmoEventHandler(algoBlocks, layoutBloques));
        this.setVisible(false);
    }

    @Override
    public void change(Object obj) {
        Algoritmo algoBlocks = (Algoritmo) obj;

        this.setVisible(algoBlocks.getCantidadDeBloques() != 0);
    }
}
