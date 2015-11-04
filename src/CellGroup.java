import javax.swing.*;
import java.awt.*;

/**
 * Created by Dimitri on 03/11/2015.
 */
public class CellGroup extends JPanel {

    CellGroup(){
        super(new GridLayout(3,3,2,2));
        for(int i=0; i<9; i++)
            add(new Cell(i));
    }
}

