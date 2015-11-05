import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * A single cell on a sudoku board
 */
public class Cell extends JButton {

    int value;

    Cell(int value){
        super("" + value);
        this.value = value;
        setFocusable(true);

    }




}
