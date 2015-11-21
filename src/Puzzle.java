import java.util.Random;
/**
 *
 * @author peter
 */
@SuppressWarnings("unused")
public class Puzzle {
    //[Row][Col], starting from top right
    private int[][] puz = new int[9][9];//


    public Puzzle(){

        for(int i =0;i<9;i++){
            for (int c=0;c<9;c++){
                puz[i][c] = 0;// 0 means the space is blank

            }
        }

        //	square = w/3 +3(h/3)
    }

    private void fill(int n, int row, int col){//fills in a number at the location

        puz[row][col] = n;


    }


    private boolean isValid(int n, int row, int col)
    { int rowStart = (row/3)*3;
        int colStart = (col/3)*3;
        for(int i =0;i<9;i++){
            if(puz[row][i]==n||puz[i][col]==n|| puz[rowStart+(i%3)][colStart+(i/3)] ==n)
                return false;
        }
        return true;
    }

    public boolean solve(int row, int col)
    {
        int i;
        if(row<9&&col<9 )
        {
            if(puz[row][col]!=0)
            {
                if ((col + 1) < 9) return solve(row, col + 1);
                else
                    return (row + 1) >= 9 || solve(row + 1, 0);
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

    private int UniqueNumbers(){//returns number of unique numbers in puzzle
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
        int r =rand.nextInt(11)+2;
        for (int i=0;i< r;i++)
        {

            this.randColumns(rand.nextInt(3)+1);
            this.randRows(rand.nextInt(3)+1);
            this.randRBlocks();
            this.randVBlocks();
        }

    }




    public int[] findNumLoc(int n)
    {
        int temp;
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
    private void basePuzzle()
    {
        puz = new int[][]{{7,  1,  3,  4,  6,  5,  8,  2,  9},
                {2,  6,  9,  1,  7,  8,  3,  5,  4},
                {5,  8,  4,  3,  9,  2,  1,  6,  7},
                {1,  3,  6,  2,  8,  4,  7,  9,  5},
                {8,  9,  7,  6,  5,  3,  4,  1,  2},
                {4,  2,  5,  7,  1,  9,  6,  8,  3},
                {3,  4,  8,  5,  2,  6,  9,  7,  1},
                {9,  5,  1,  8,  3,  7,  2,  4,  6},
                {6,  7,  2,  9,  4,  1,  5,  3,  8}};
    }

    private void randColumns(int max)
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

    private void randRows(int max)//swaps
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

    private void randVBlocks()
    {Random rand = new Random();
        int temp;
        int row1= 0;
        int row2=rand.nextInt(1)+ 3;
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
    private void randRBlocks()
    {Random rand = new Random();
        int temp;
        int row1= 0;
        int row2=rand.nextInt(1)+ 3;
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

    public int valAt(int row, int col){
        return puz[row][col];
    }

    // test method
    public static void main(String[] args){
        Puzzle pTest = new Puzzle();
        pTest.autoPuzzle();
        /*for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(Integer.toString(pTest.valAt(i, j)));
                if(j+1%2==0)
                    System.out.print(" ");
            }
            System.out.print("\n");
        }*/
        System.out.print(pTest.toString());
    }
}
