package cl.uchile.dcc.scrabble.gui.operaciones;

import cl.uchile.dcc.scrabble.gui.Scrabbles.SNumbers;

import java.util.Objects;

public class Add implements Operacion{
    private final Operacion addend1;
    private final Operacion addend2;

    public Add(Operacion addend1, Operacion addend2){
        this.addend1 = addend1;
        this.addend2 = addend2;
    }
    @Override
    public Hojas eval() {
        return addend1.eval().add(addend2.eval());
    }
}
