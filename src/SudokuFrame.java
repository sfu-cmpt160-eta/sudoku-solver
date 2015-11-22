/**
 *  GUI for Sudoku Board
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import napkin.NapkinLookAndFeel;
import java.awt.event.ActionEvent;

class SudokuFrame extends JFrame {

    private Puzzle pzl;
    private Cell[][] cells = new Cell[9][9];
    private JButton[] bottomButtons = new JButton[9];
    private int row, col;

    // calculates dimension for preferredSize to be used by sudokuPanel
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private Rectangle rect = new Rectangle(screenSize.width/4 - screenSize.width/8,
                screenSize.height/4 - screenSize.height/8, screenSize.width/3,
                screenSize.height/3);



    private JButton returnButton = new JButton("Return");
    private JButton undoButton = new JButton("Undo");
    private JButton solveButton = new JButton("Solve");


    // layout for grid
    private GridLayout sudokuGrid = new GridLayout(9,9,2,2);


    private SudokuFrame(){
        super("Sudoku Board");
        JRootPane root = new JRootPane();
        this.setRootPane(root);
        setResizable(false);
        pzl = new Puzzle();
        pzl.autoPuzzle();
        //pzl.testPuzzle();

    }

    private void addComponentsToPane(final Container pane) {

        // panel for the Sudoku Frame
        JPanel sudokuPanel = new JPanel();
        sudokuPanel.setLayout(sudokuGrid);

        // intialize sudoku panel with 9 cell groups
        initCells();
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                sudokuPanel.add(cells[i][j]);
            }
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

        for(int i=0;i<9;i++){
            bottomButtons[i] = new JButton();
            bottomButtons[i].setFont(new Font("Algerian", Font.ITALIC, 20));
            bottomButtons[i].setText(String.valueOf(i+1));
            bottomButtons[i].addActionListener(new btmButtonListener());
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

    private void initCells(){
        cellListener cl = new cellListener();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                cells[i][j] = new Cell(pzl.valAt(i, j),i,j);
                cells[i][j].addActionListener(cl);
            }
        }
    }



    class btmButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            int value = Integer.parseInt(source.getText());
            if (pzl.isValid(value, row, col)) {
                if (value == 1)
                    cells[row][col].setText("1");
                else if (value == 2)
                    cells[row][col].setText("2");
                else if (value == 3)
                    cells[row][col].setText("3");
                else if (value == 4)
                    cells[row][col].setText("4");
                else if (value == 5)
                    cells[row][col].setText("5");
                else if (value == 6)
                    cells[row][col].setText("6");
                else if (value == 7)
                    cells[row][col].setText("7");
                else if (value == 8)
                    cells[row][col].setText("8");
                else if (value == 9)
                    cells[row][col].setText("9");
            }
        }
    }


        class cellListener implements ActionListener {

            public void actionPerformed(ActionEvent e){
                Cell source = (Cell) e.getSource();
                source.setSelected(true);
                row = source.getRow();
                col = source.getCol();
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
