
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.Scanner;


public class Main
{
    
    public static void main(){
        int row1;
        int row2;
        int row3;
        int rowChoice;
        int numberTaken;
        int playerType;
        int compRow;
        int compTake;
        boolean valid;
        int largest;
        
        System.out.println("Welcome to the Game of Nim");
        Random randomInt = new Random();
        row1 = randomInt.nextInt(14)+1;
        row2 = randomInt.nextInt(14)+1;
        row3 = randomInt.nextInt(14)+1;
        playerType = randomInt.nextInt(2);
        System.out.println(playerType);
        
        
        
        int[] rowTotals = {row1, row2, row3};
        NimRound nimRound = new NimRound(rowTotals[0],rowTotals[1],rowTotals[2]);
        
        while ((rowTotals[0] + rowTotals[1] + rowTotals[2])>0){ 
        //Prints out current row amounts
        System.out.println("Row 1 = " + rowTotals[0]);
        System.out.println("Row 2 = " + rowTotals[1]);
        System.out.println("Row 3 = " + rowTotals[2]);
        
        //User enters how many to take
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which row will you select from?");
        
        rowChoice = scanner.nextInt();
        
        System.out.println("How many do you want to take from the row?");
        
        numberTaken = scanner.nextInt();
        
        rowTotals[rowChoice-1] -= numberTaken;
        
        if((rowTotals[0] + rowTotals[1] + rowTotals[2])==0){
         System.out.println("You win!");
        scanner.close();}
        //System.out.println(rowTotals[0] + " " + rowTotals[1] + " " + rowTotals[2]);
        
        //System.out.println(rowChoice + " " + numberTaken);
        
        //Computer makes choice
        
        if (playerType == 1){
        //good player code
        
        nimRound.setRow1(rowTotals[0]);
        nimRound.setRow2(rowTotals[1]);
        nimRound.setRow3(rowTotals[2]);
        int[] row1Binary = nimRound.binaryList(rowTotals[0]);
        int[] row2Binary = nimRound.binaryList(rowTotals[1]);
        int[] row3Binary = nimRound.binaryList(rowTotals[2]);
        //System.out.println(row1Binary[0] + " " + row1Binary[1] + " " + row1Binary[2] + " " +row1Binary[3]);
        //System.out.println(row2Binary[0] + " " + row2Binary[1] + " " + row2Binary[2] + " " +row2Binary[3]);
        //System.out.println(row3Binary[0] + " " + row3Binary[1] + " " + row3Binary[2] + " " +row3Binary[3]);
        int takeAway = nimRound.nimSum(row1Binary, row2Binary, row3Binary);
        
        if ((rowTotals[0] > rowTotals[1])&&(rowTotals[0]>rowTotals[2])){
            largest = 0;
            
            }
         else{
            if(rowTotals[1]>rowTotals[2]){
            largest = 1;
            
            }
            else{
            largest = 2;
            
        }
            }
        System.out.println("The computer takes " + takeAway + " from row " + (largest+1));
        rowTotals[largest] -= takeAway;
        if((rowTotals[0] + rowTotals[1] + rowTotals[2])==0){
         System.out.println("You lose!");   
        }
    }
    else{
    //bad player code
    compRow = randomInt.nextInt(3);
    valid = false;
    while(!valid){
    if (rowTotals[compRow]>0){
        compTake = randomInt.nextInt(rowTotals[compRow])+1;
        rowTotals[compRow] -= compTake;
        valid = true;
        System.out.println("The computer takes " + compTake + " from row " + (compRow+ 1));
        if((rowTotals[0] + rowTotals[1] + rowTotals[2])==0){
         System.out.println("You lose!");}
        
    }
    else {
        compRow = randomInt.nextInt(3);
    }
    }
    
    
    
    }
}
        
        
    }
}
