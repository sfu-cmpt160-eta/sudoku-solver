import javax.swing.*;
import java.awt.*;

/**
 * A 3x3 Sudoku grid.
 */
public class CellGroup extends JPanel {

    // default constructor simply sets all cells to position number
    CellGroup(){
        super(new GridLayout(3,3,1,1));
        for(int i=0; i<9; i++)
            add(new Cell(i));
    }


    // constructor uses block object to copy numbers from
    CellGroup(Block block){
        super(new GridLayout(3,3,1,1));
        for(int i=0; i<9; i++)
            add(new Cell(block.getNumberAt(i)));
    }
}

