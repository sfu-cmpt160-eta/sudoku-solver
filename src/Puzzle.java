import java.util.Random;
/**
 *
 * @author peter
 */
public class Puzzle {
    //[Column][Row], starting from bottom left
int[][] puz = new int[9][9];// 

Block[] blocks;
  

    public Puzzle(){
            blocks = new Block[9];//generates an array of blocks, which are the 3x3 squares
        for(int i =0;i<9;i++){ 
            for (int c=0;c<9;c++){
            puz[i][c] = 0;// 0 means the space is blank
           
            }
        blocks[i]=new Block();
        }
    
   //	square = w/3 +3(h/3)
    }
    
    public boolean fill(int n, int row, int col){//fills in a number at the location
        int location = (col/3)+3*(row/3);//derived attribute, to organize blocks
      System.out.println(location);
        if( this.isValid(n, row, col)){
            blocks[location].addNumber(n);//add the number to the related block
            puz[col][row] = n;
            return true;
           }
    return false;
    }
    
    
    public boolean isValid(int n, int row, int col)
    {int location = (col/3)+3*(row/3);
        for(int i =0;i<9;i++){
           if(puz[col][i]==n||puz[i][row]==n||!blocks[location].isValid(n)||puz[col][row]!=0)
                return false;}
        return true;
      }
    
    public void  solve()
    {
    
    
    }
    
@Override
    public String toString()//creates a 9x9 string of numbers
        {
            String puzzle ="";
            for (int i=0; i<9;i++){
                for (int c=0;c<9;c++){
                    puzzle+=puz[i][c]+"  ";
                }
                puzzle+="\n";
        }        
        return puzzle;
    }
    
  
    public boolean solvable()//checks to see if program is theoretically solvable
    {  int uniques = this.UniqueNumbers();
        return this.numbersFilled() > 16 && uniques > 7;
    }
   public int numbersFilled()//returns amount of spots filled in grid
    {int count = 0;
    for (int i =0;i<9;i++){
        for (int c =0;c<9;c++){
            if(puz[i][c]!=0)
            count++;
            }
        }
        return count;}
   
   int UniqueNumbers(){//returns number of unique numbers in puzzle
    int totalNum = 0;
     boolean[] uniqueNum = {false, false, false, false, false, false, false, false, false };//each false corresponds to a number

   
    for (int i =0;i<9;i++){
        for (int c =0;c<9;c++){
            if(puz[i][c]!=0){
                if(!uniqueNum[puz[i][c]-1]){//if the number is false
                        totalNum++;//increase the number of uniques
                        uniqueNum[puz[i][c]-1] = true;//the location is now true
                        }
                }        
            }
   }
       return totalNum;
   }
   
   public void autoPuzzle()
   {
   Random rn = new Random();//initialize random
      int rCol,rRow, count =0;
   int temp;
   
       while (!this.solvable()){// while the puzzle is not solvable
       
           temp =rn.nextInt(9);
           rCol = temp;
           temp =rn.nextInt(9);
           rRow = temp;//randomizes next location for number
           temp = rn.nextInt(9) + 1;
       if(this.fill(temp, rRow, rCol))
           count++;//checks to see if is a viable location, and if it is/ add it
         
       }
   
   }

    public int[][] getPuz(){
        return puz;
    }

    public Block[] getBlocks(){
        return blocks;
    }

    public Block getBlockAt(int index){
        return blocks[index];
    }
}
