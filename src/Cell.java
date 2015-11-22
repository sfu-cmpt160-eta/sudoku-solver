import javax.swing.*;
import java.awt.*;


/**
 * A single cell on a sudoku board
 */
class Cell extends JButton {

    private int value;
    private int row, col;


    Cell(int value,int row,int col){
        super("" + value);
        this.setFont(new Font("Algerian", Font.ITALIC, 20));
        this.value = value;
        this.row = row;
        this.col = col;
        setFocusable(true);
        if(value == 0) {
            this.setText("");
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }











}
