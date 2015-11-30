/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
/**
 *
 * @author peter
 */
public class Puzzle {
    //[Row][Col], starting from top right
    int[][] puz = new int[9][9];//
    int[][] solved = new int[9][9];

    public Puzzle(){

        for(int i =0;i<9;i++){
            for (int c=0;c<9;c++){
                puz[i][c] = 0;// 0 means the space is blank

            }
        }


    }

    public boolean fill(int n, int row, int col){//fills in a number at the location
        if (this.isValid(n, row, col) &&n>0)//if the number input is not 0 and is valid, put it in the location
        {     puz[row][col] = n;
            return true;
        }
        else
            return false;

    }


    public boolean isValid(int n, int row, int col)
    { int rowStart = (row/3)*3;
        int colStart = (col/3)*3;
        for(int i =0;i<9;i++){
            if(puz[row][i]==n||puz[i][col]==n|| puz[rowStart+(i%3)][colStart+(i/3)] ==n)
                return false;
        }
        return true;
    }

    public boolean  solve(int row, int col)
    {
        int i;
        if(row<9&&col<9 )
        {
            if(puz[row][col]!=0)
            {
                if((col+1)<9) return solve(row, col+1);
                else if((row+1)<9) return solve(row+1, 0);
                else return true;
            }
            else
            {
                for(i=0;i<9;++i)
                {
                    if(this.isValid(i+1,row, col))
                    {
                        this.fill(i+1, row,col);
                        if ((col+1)<9)
                        {
                            if (this.solve(row, col+1))  return true;

                            else this.fill(0, row,col);
                        }
                        else if((row+1)<9){
                            if(this.solve(row+1,0)) return true;

                            else this.fill(0, row,col);
                        }
                        else return true;
                    }
                }
            }
            return false;

        }
        else return true;
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
        if (this.numbersFilled()>16&& uniques>7){
            return true;

        }
        return false;
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
        this.basePuzzle();
        Random rand = new Random();
        int r =rand.nextInt(450)+7;
        for (int i=0;i< r;i++)
        {

            this.randColumns(rand.nextInt(3)+1);
            this.randRows(rand.nextInt(3)+1);
            this.randRBlocks();
            this.randVBlocks();
            this.transpose();
            if(i%2!=0)//more pseudo randomness
                this.rotate();
            else
                this.rotate180();
        }
        solved = puz;
        this.removeNumbers();
    }




    public int[] findNumLoc(int n)
    {
        int temp =0;
        int bar = 0;
        int[] locations = new int[9];
        for (int i =0;i<9;i++)
        {
            for(int c=0;c<9;c++)
            {
                if (puz[i][c]==n){
                    temp =(i*10)+c;
                    locations[bar]=temp;
                    bar++;
                }
            }
        }
        return locations;
    }
    public void basePuzzle()//base puzzle seed for all made puzzles
    {
        int[][] newpuz = {{7,  1,  3,  4,  6,  5,  8,  2,  9},
                {2,  6,  9,  1,  7,  8,  3,  5,  4},
                {5,  8,  4,  3,  9,  2,  1,  6,  7},
                {1,  3,  6,  2,  8,  4,  7,  9,  5},
                {8,  9,  7,  6,  5,  3,  4,  1,  2},
                {4,  2,  5,  7,  1,  9,  6,  8,  3},
                {3,  4,  8,  5,  2,  6,  9,  7,  1},
                {9,  5,  1,  8,  3,  7,  2,  4,  6},
                {6,  7,  2,  9,  4,  1,  5,  3,  8}};
        puz = newpuz;
        solved =puz;
    }

    void randColumns(int max)
    {
        int temp;
        int row1;
        int row2;
        Random rand = new Random();
        if (max <=1)
        {
            row1=rand.nextInt(3);
            row2 = rand.nextInt(3);
        }
        else if (max==2)
        {
            row1=rand.nextInt(3)+3;
            row2=rand.nextInt(3)+3;
        }
        else
        {   row1=rand.nextInt(3)+6;
            row2=rand.nextInt(3)+6;
        }

        for (int i=0;i<9;i++)
        {
            temp = puz[i][row1];
            puz[i][row1] = puz[i][row2];
            puz[i][row2]=temp;
        }
    }

    void randRows(int max)//swaps
    {
        int temp;
        int row1;
        int row2;
        Random rand = new Random();
        if (max <=1)
        {   row1=rand.nextInt(3);
            row2 = rand.nextInt(3);
        }
        else if (max==2)
        {   row1=rand.nextInt(3)+3;
            row2=rand.nextInt(3)+3;
        }
        else
        {   row1=rand.nextInt(3)+6;
            row2=rand.nextInt(3)+6;
        }

        for (int i=0;i<9;i++)
        {
            temp = puz[row1][i];
            puz[row1][i] = puz[row2][i];
            puz[row2][i]=temp;
        }
    }

    public void randVBlocks()
    {Random rand = new Random();
        int temp = 0;
        int row1= 0;
        int row2=rand.nextInt(1)+1*3;
        for(int c = 0;c<3;c++){
            for (int i=0;i<9;i++)
            {
                temp = puz[row1][i];
                puz[row1][i] = puz[row2][i];
                puz[row2][i]=temp;
            }
            row1++;
            row2++;
        }
    }
    public void randRBlocks()
    {Random rand = new Random();
        int temp = 0;
        int row1= 0;
        int row2=rand.nextInt(1)+1*3;
        for(int c = 0;c<3;c++){
            for (int i=0;i<9;i++)
            {
                temp = puz[i][row1];
                puz[i][row1] = puz[i][row2];
                puz[i][row2]=temp;
            }
            row1++;
            row2++;
        }
    }

    void transpose()
    {
        int temp =0;
        for(int i =0;i<9;i++)
        {
            for (int j=i;j<9;j++)
            {
                temp =  puz[i][j];
                puz[i][j]=puz[j][i];
                puz[j][i]=temp;
            }
        }

    }
    void rotate()
    {
        this.transpose();
        this.rotate180();
    }
    void rotate180()
    {int temp = 0;
        for (int i =0;i<9;i++)
        {

            for(int j=0;j<4;j++)
            {   temp = puz[j][i];
                puz[j][i] = puz[8-j][i];
                puz[8-j][i] =temp;

            }
        }
    }

    void removeNumbers()
    {    Random rand = new Random();
        while(this.numbersFilled()>30)
        {
            puz[rand.nextInt(9)][rand.nextInt(9)]=0;
        }
    }
    int hint(int row, int col)
    {
        return solved[row][col];
    }

    public int valAt(int row, int col){
        return puz[row][col];
    }

    public void testPuzzle()
    {
        puz = new int[][]{{0,  1,  0,  4,  6,  0,  0,  2,  9},
                {0,  6,  0,  0,  7,  8,  0,  5,  0},
                {0,  8,  0,  3,  9,  2, 0 ,  0,  0},
                {1,  3,  6,  2,  8,  4, 0 ,  9,  0},
                {0,  9,  7,  6, 0 ,  3,0  ,  1, 0},
                {4,  2,  5,  7,0  ,  9,0  ,  8,  0},
                {0,0  ,  8, 0 ,  2,  6, 0 ,  7, 0 },
                {0,0  ,  1, 0 ,  3,  7, 0 ,  4,  6},
                {6,0  ,  2,0  ,  4, 0 , 0 ,  3,  8}};
    }


}

