/**
 *  GUI for Sudoku Board
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import napkin.NapkinLookAndFeel;

class SudokuFrame extends JFrame{

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


    private SudokuFrame(){
        super("Sudoku Board");
        JRootPane root = new JRootPane();
        this.setRootPane(root);
        setResizable(false);
        pzl = new Puzzle();
        pzl.autoPuzzle();

    }

    private void addComponentsToPane(final Container pane) {

        // panel for the Sudoku Frame
        JPanel sudokuPanel = new JPanel();
        sudokuPanel.setLayout(sudokuGrid);

        // intialize sudoku panel with 9 cell groups
        initCellGroups();
        for(int i=0;i<9;i++)
         sudokuPanel.add(cellGroups[i]);

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


        // Create and set up the window
        SudokuFrame frame = new SudokuFrame();
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

    private class ButtonListener implements ActionListener {
        ButtonListener(){
        }

        public void actionPerformed(ActionEvent e){



        }
    }

    public void initCellGroups() {
        for (int i=0; i<9; i=i+3){
            for(int j=0;j<9; j=j+3)
            cellGroups[i + (int) Math.ceil((double)j/3)] = new CellGroup(i,j, pzl);
        }
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
