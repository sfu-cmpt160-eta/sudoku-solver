/**
 *  GUI for Sudoku Board
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import napkin.NapkinLookAndFeel;

class SudokuBoard extends JFrame{

   private Puzzle pzl;
   private CellGroup[] cellGroups = new CellGroup[9];

    // calculates dimension for preferredSize to be used by sudokuPanel
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private Rectangle rect = new Rectangle(screenSize.width/4 - screenSize.width/8,
            screenSize.height/4 - screenSize.height/8, screenSize.width/3,
            screenSize.height/3);



    private JButton returnButton = new JButton("Return");
    private JButton undoButton = new JButton("Undo");
    private JButton solveButton = new JButton("Solve");


    // layout for 9 cellgroups
    private GridLayout sudokuGrid = new GridLayout(3,3,12,12);


    private SudokuBoard(Puzzle pzl){
        super("Sudoku Board");
        JRootPane root = new JRootPane();
        this.setRootPane(root);
        setResizable(false);
        this.pzl = pzl;

    }

    private void addComponentsToPane(final Container pane) {

        // panel for the Sudoku Board
        final JPanel sudokuPanel = new JPanel();
        sudokuPanel.setLayout(sudokuGrid);
        // intialize sudoku panel with 9 cell groups
        for (int i = 0; i < 9; i++) {
            sudokuPanel.add(new CellGroup(pzl.getBlockAt(i)));
            cellGroups[i] = new CellGroup(pzl.getBlockAt(i));
        }
        // Set up preferred size
        sudokuPanel.setPreferredSize(new Dimension(rect.width, rect.height));

        // panel for the return, undo, solve buttons
        JPanel rightButtonPanel = new JPanel();
        rightButtonPanel.setLayout(new GridLayout(3, 1, 6, 6));
        // add return, undo and solve buttons
        returnButton.setFont(new Font("Algerian", Font.ITALIC, 20));
        undoButton.setFont(new Font("Algerian", Font.ITALIC, 20));
        solveButton.setFont(new Font("Algerian", Font.ITALIC, 20));
        rightButtonPanel.add(returnButton);
        rightButtonPanel.add(undoButton);
        rightButtonPanel.add(solveButton);

        // panel for number buttons
        JPanel bottomButtonPanel = new JPanel();
        bottomButtonPanel.setLayout(new GridLayout(1,9,20,20));
        // add number buttons
        JButton[] bottomButtons = new JButton[9];
        for(int i=0;9>i;i++){
            bottomButtons[i] = new JButton();
            bottomButtons[i].setFont(new Font("Algerian", Font.ITALIC, 20));
            bottomButtons[i].setText(String.valueOf(i+1));
            bottomButtonPanel.add(bottomButtons[i]);
        }



            // TODO once start menu is created, code this button to go back there
            returnButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            // TODO create mechanism for undo button
            // link to UndoManager example: http://www.java2s.com/Code/Java/Swing-JFC/TheuseofUndoManager.htm
            undoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               }
            });

            pane.add(sudokuPanel, BorderLayout.WEST);
            pane.add(rightButtonPanel, BorderLayout.EAST);
            pane.add(bottomButtonPanel, BorderLayout.SOUTH);

        }





    // Create the GUI and show it
    private static void createAndShowGUI(){

        // Creates a random puzzle, though atm not guaranteed to be valid
        Puzzle pzl = new Puzzle();
        pzl.autoPuzzle();

        // Create and set up the window
        SudokuBoard frame = new SudokuBoard(pzl);
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
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

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
