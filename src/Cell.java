import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Dimitri on 03/11/2015.
 */
public class Cell extends JLabel implements MouseListener {

    int value;

    Cell(int value){
        super("" + value);
        this.value = value;
        setFocusable(true);
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        // JLabel at value: value as been clicked
    }

     public void mouseReleased(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    }

    public void mouseEntered(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){

    }

}
