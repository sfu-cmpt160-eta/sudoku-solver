import javax.swing.*;
import java.awt.*;


/**
* A 3x3 Sudoku grid.
        */
class CellGroup extends JPanel {

    // fill cellgroup with cells with their respective values
    CellGroup(int row, int col, Puzzle pzl){
        super(new GridLayout(3,3,1,1));
        for(int i=row; i<row+3; i++) {
            for(int j=col; j<col+3; j++) {
                this.add(new Cell(pzl.valAt(i,j)));
            }
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

