/**
 *
 * @author peter
 */
//The 3x3 block of numbers
public class Block 
{
   int[] numbers= new int[9];
   int baseNumber =0; // How many numbers are in the Block



    public Block()
        {
            for(int i = 0; i<9; i++)
                {numbers[i]=0;}
        }
   
    public boolean isValid(int n){  
        for(int i = 0; i<9; i++){
            if (n==numbers[i])
                return false;
        }
        return true;
    }
    public boolean addNumber(int n)
    {
        if(this.isValid(n)){
            numbers[baseNumber] =n;
            baseNumber++;
            return true;
        }
        return false;
    }

    public int getNumberAt(int index){
        return numbers[index];
    }
    
}
