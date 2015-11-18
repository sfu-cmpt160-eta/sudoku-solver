import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
* A 3x3 Sudoku grid.
        */
class CellGroup extends JPanel {

    private Cell[] cells = new Cell[9];
    private int numberOfCells;

    // constructor uses block object to copy numbers from
    CellGroup(Block block){
        super(new GridLayout(3,3,1,1));
        for(int i=0; i<9; i++) {
            add(new Cell(block.getNumberAt(i)));
            cells[i] = new Cell(block.getNumberAt(i));
            numberOfCells++;
        }
    }

// --Commented out by Inspection START (17/11/2015 10:52 PM):
//    public Cell getCellAt(int index){
//        Cell c = new Cell(cells[index].getValue());
//        return c;
//    }
// --Commented out by Inspection STOP (17/11/2015 10:52 PM)

// --Commented out by Inspection START (17/11/2015 10:52 PM):
//    public Cell[] getCells(){
//        return cells;
//    }
// --Commented out by Inspection STOP (17/11/2015 10:52 PM)



}

