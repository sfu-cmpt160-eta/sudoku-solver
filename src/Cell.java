import javax.swing.*;

/**
 * A single cell on a sudoku board
 */
public class Cell extends JButton {

    int value;

    Cell(int value){
        super("" + value);
        this.value = value;
        setFocusable(true);

        if(value == 0){
            this.setText("");
        }

    }




}
