

/**
 *
 * @author peter
 */
class SudokuSolver {

    /**args) {
        
    
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    Puzzle grid = new Puzzle();

     
 grid.autoPuzzle();

   
    System.out.println(grid.toString() + "\n"+grid.numbersFilled());
  //while(grid.numbersFilled()<81)
  //{
  
  //}  
    
    
}
}