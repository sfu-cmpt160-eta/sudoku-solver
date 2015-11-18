import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A single cell on a sudoku board
 */
class Cell extends JButton implements ActionListener{

    // --Commented out by Inspection (17/11/2015 10:51 PM):private Color pressedBackgroundColor;
    private int value;



    Cell(int value){
        super("" + value);
        this.setFont(new Font("Algerian", Font.ITALIC, 20));
        this.value = value;
        setFocusable(true);
        if(value == 0){
            this.setText("");
        }

        addActionListener(this);



    }

// --Commented out by Inspection START (17/11/2015 11:17 PM):
//    public int getValue(){
//        return value;
//    }
// --Commented out by Inspection STOP (17/11/2015 11:17 PM)

    public void actionPerformed(ActionEvent e){
       this.requestFocusInWindow();
    }






}
