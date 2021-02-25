package edu.fiuba.algo3.javafx.botones;

import edu.fiuba.algo3.javafx.handlers.BotonGuardarAlgoritmoEventHandler;
import edu.fiuba.algo3.javafx.layouts.LayoutBloques;
import edu.fiuba.algo3.modelo.AlgoBlocks;
import edu.fiuba.algo3.modelo.Algoritmo;
import edu.fiuba.algo3.modelo.Observer;
import javafx.scene.control.Button;


public class BotonGuardarAlgoritmo  extends Button implements Observer{

    public BotonGuardarAlgoritmo(AlgoBlocks algoBlocks, LayoutBloques layoutBloques){
        this.setVisible(false);
        this.setText("Guardar");
        this.setOnAction(new BotonGuardarAlgoritmoEventHandler(algoBlocks, layoutBloques));
    }

    @Override
    public void change(Object obj) {
        Algoritmo algoBlocks = (Algoritmo) obj;

        this.setVisible(algoBlocks.getCantidadDeBloques() != 0);
    }
}
