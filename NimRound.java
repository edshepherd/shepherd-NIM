
/**
 * Write a description of class NimRound here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NimRound
{
    // instance variables - replace the example below with your own
    private int row1;
    private int row2;
    private int row3;
    private int rowChoice;
    private int numberToTake;
    private int[] binaryList;
    private int takeAway;
    private int[] biggest;
    private int largest;

    /**
     * Constructor for objects of class NimRound
     */
    public NimRound()
    {
        row1 = 0;
        row2 = 0;
        row3 = 0;
        rowChoice = 0;
        numberToTake = 0;
        
    }
    
    public NimRound(int row1, int row2, int row3){
     this.row1 = row1;
     this.row2 = row2;
     this.row3 = row3;
     
     
    }
    
    public void setRow1(int a){
        row1 = a;
    }
    public void setRow2(int b){
        row2 = b;
    }
    public void setRow3(int c){
        row3 = c;
    }
    
    public int[] binaryList(int row){
        int[] binaryList = {0,0,0,0};
        if (row>=8){
            binaryList[0] = 1;
            row -=8;}
            else{binaryList[0] = 0;}
        
        if (row>=4){
          binaryList[1] = 1;
            row -=4;}
            else{binaryList[1] = 0;}
        
        if (row>=2){
          binaryList[2] = 1;
            row -=2;}
            else{binaryList[2] = 0;}
        if (row>=1){
          binaryList[3] = 1;
            row -=1;}
            else{binaryList[3] = 0;}
        
        return binaryList;
    }
    public int nimSum(int[] row1, int[] row2, int[] row3){
        takeAway = 0;
        int one = row1[0]*8 + row1[1]*4 + row1[2]*2 + row1[3];
        int two = row2[0]*8 + row2[1]*4 + row2[2]*2 + row2[3];
        int three = row3[0]*8 + row3[1]*4 + row3[2]*2 + row3[3];
        int a = (row1[0] + row2[0] + row3[0])%2;
        int b = (row1[1] + row2[1] + row3[1])%2;
        int c = (row1[2] + row2[2] + row3[2])%2;
        int d = (row1[3] + row2[3] + row3[3])%2;
         if ((one > two)&&(one>three)){
            largest = one;
            biggest = row1;
            //System.out.println("one");
            }
         else{
            if(two>three){
            largest = two;
            biggest = row2;
            //System.out.println("two");
            }
            else{
            largest = three;
            biggest = row3;
            //System.out.println("three");
           
        }
            }
         
        //System.out.println("largest = " + largest);
        int sumNim = 8*a + 4*b + 2*c +d;
        
        
        if (sumNim ==0){
        takeAway = 1;
        }
        else{
            if (a == 1){
                if (biggest[0] == 1){
                    biggest[0]=0;
                    takeAway= 8;
                    
                }
                //else{biggest[0]=1;}
            }
            if (b == 1){
                if (biggest[1] == 1){
                    biggest[1]=0;
                    takeAway+=4;
                    
                }
                else{biggest[1]=1;
                      takeAway -=4;}
                
            }
            if (c == 1){
                if (biggest[2] == 1){
                    biggest[2]=0;
                    takeAway +=2;
                    
                }
                else{biggest[2]=1;
                takeAway -= 2;}
            
            }
            if (d == 1){
                if (biggest[3] == 1){
                    biggest[3]=0;
                    takeAway +=1;
                }
                else{biggest[3]=1;
                takeAway -=1;}
            }
            
            
        
        }
     
        
        return takeAway;
    }
    }
    
        
        

    
    


