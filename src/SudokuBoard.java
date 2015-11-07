/**
 *  GUI for Sudoku Board
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import napkin.NapkinLookAndFeel;
import java.util.Random;

public class SudokuBoard extends JFrame{

   private Puzzle pzl;

    // calculates dimension for preferredSize to be used by sudokuPanel
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle rect = new Rectangle(screenSize.width/4 - screenSize.width/8,
            screenSize.height/4 - screenSize.height/8, screenSize.width/4,
            screenSize.height/4);


    JButton solveButton = new JButton("Solve");

    // layout for 9 cellgroups
    GridLayout sudokuGrid = new GridLayout(3,3,6,6);




    public SudokuBoard(Puzzle pzl, String name){
        super(name);
        setResizable(false);
        this.pzl = pzl;

    }

    public void addComponentsToPane(final Container pane) {

        // panel for the Sudoku Board
        final JPanel sudokuPanel = new JPanel();
        sudokuPanel.setLayout(sudokuGrid);

        // panel for the solve button, possibly other buttons if needed later
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3, 1));

        // Set up preferred size
        sudokuPanel.setPreferredSize(new Dimension(rect.width, rect.height));



        // intialize sudoku panel with 9 cell groups
        for (int i = 0; i < 9; i++)
            sudokuPanel.add(new CellGroup(pzl.getBlockAt(i)));



            // add buttons to set up horizontal and vertical gaps
            buttons.add(new JButton("Return"));
            buttons.add(new JButton("Undo"));
            buttons.add(solveButton);

            solveButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {



                }
            });

            pane.add(sudokuPanel, BorderLayout.WEST);
            pane.add(buttons, BorderLayout.EAST);

        }



    // Create the GUI and show it
    private static void createAndShowGUI(){

       /* Random rn = new Random();//initialize random
        Puzzle pzl = new Puzzle();
        for(int i=0;9>i;i++){
            for(int j=0;9>j;j++)
                pzl.fill(rn.nextInt(9)+1, i, j);
        }*/

        Puzzle pzl = new Puzzle();
        pzl.autoPuzzle();

        // Create and set up the window
        SudokuBoard frame = new SudokuBoard(pzl,"Sudoku Board");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


       /*JMenuBar mBar = new JMenuBar();
        mBar.setOpaque(true);
        mBar.setBackground(new Color(0, 255, 255));
        mBar.setPreferredSize(new Dimension(200, 20));
        */

        //Set up the content pane
        frame.addComponentsToPane(frame.getContentPane());
        frame.setUndecorated(false);

        try
        {
            UIManager.setLookAndFeel(new NapkinLookAndFeel());
            SwingUtilities.updateComponentTreeUI(frame);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        // Display window
        frame.pack();
        frame.setVisible(true);
    }



    public static void main(String[] args) {




        // Schedule a job for the event dispatch thread:
        // creating and showing this applicaiton's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                createAndShowGUI();
            }
        });









    }

}
