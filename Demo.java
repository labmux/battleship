package battleship;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Eliran Assaraf ID# 40025843
 * Comp 249
 * Assignment #1
 * 25 September 2017
 */
public class Demo {
 
    public static void main(String[] args) {
       
        String input;
        int row = 0, col = 0;
        boolean OutOfBounds = false, Called = false;
        
        Scanner kb = new Scanner(System.in);
        Random rn = new Random();
        
        Battleship b = new Battleship();
        Battleship grid[][] = new Battleship[8][8];
        Battleship hiddengrid[][] = new Battleship[8][8];
        
        
        //instantiate all objects
        for (row = 0; row < 8; row++) {
            
            for (col = 0; col < 8; col++) {
                grid[row][col] = new Battleship();
                hiddengrid[row][col] = new Battleship();
            }
        }
        
        System.out.println("Heyy, let's play some Battleship yo!!");
        System.out.println("");      //add line for readability
        
         
        //Set coordinates of 6 ships
        for (int i = 1; i < 7; i++) 
        {
            do
            {   //booleans to make sure coordinates arent Out of bounds or already used
                //take input from user
                System.out.println("Enter the coordinates of your ship #"+i);
                input = kb.nextLine();
                 
                //get grid's row and col array equivalences
                row = b.getRowInt(input);
                col = b.getColInt(input);
                
                //checks if coordinates are out of bounds or used 
                OutOfBounds = b.CoordinatesOutOfBounds(row, col);
                
                //avoid array index out of bounds exception
                if (OutOfBounds == false)
                Called = hiddengrid[row][col].getCalled(); 
                
                if(Called == true)
                {
                    System.out.println("Sorry, coordinates already used. Try again");
                }
                if(OutOfBounds == true)
                {
                    System.out.println("Sorry, coordinates outside the grid. Try again");
                }
                
            } while (OutOfBounds == true || Called == true);
            
            hiddengrid[row][col].setShip();
        }
        
        System.out.println("");     //line for readability
        
        //set 4 grenades
        for (int i = 1; i < 5; i++) 
        {
            do {
            System.out.println("Enter the coordinates of your grenade #"+i);
            input = kb.nextLine();
            
            row = b.getRowInt(input);
            col = b.getColInt(input);
            
                //checks if coordinates are out of bounds or used 
                OutOfBounds = b.CoordinatesOutOfBounds(row, col);
                
                //avoid array index out of bounds exception
                if (OutOfBounds == false)
                Called = hiddengrid[row][col].getCalled(); 
                
                if(Called == true)
                {
                    System.out.println("Sorry, coordinates already used. Try again");
                }
                if(OutOfBounds == true)
                {
                    System.out.println("Sorry, coordinates outside the grid. Try again");
                }
                
            } while (OutOfBounds == true || Called == true);
            
            hiddengrid[row][col].setGrenade();
        }
        
        //place pc ships
        for (int i = 1; i < 7; i++) {
            do {
                row = rn.nextInt(8);
                col = rn.nextInt(8);
                
                } while(hiddengrid[row][col].getCalled() == true);
            
            hiddengrid[row][col].setShip(true);
        }
          
        //place pc grenades
        for (int i = 1; i < 5; i++) {
            do {
                row = rn.nextInt(8);
                col = rn.nextInt(8);
            
                } while(hiddengrid[row][col].getCalled() == true);
            
            hiddengrid[row][col].setGrenade(true);
        }
        
        System.out.println("Okay the computer placed its ships and grenades, lets play! \n");
        
        /*
        All the Ships and Grenades have been placed
        
        Let the games begin!
        */
        
        //create hit counters
        int playerHit = 0;
        int pcHit = 0;
        
        //create turn skip counters
        int skipPlayer = 1;
        int skipPc = 1;

  //keep going until theres a winner
  do {
        
        //USERS TURN
      
        //reset counter
        skipPlayer = 1;
        for (int i = 0; i < skipPc; i++) {
         
         do{    
            System.out.println("Position of your rocket: ");
            input = kb.nextLine();
        
            row = b.getRowInt(input);
            col = b.getColInt(input);
        
            if (b.CoordinatesOutOfBounds(row, col) == true)
            System.out.println("Coordinates out of bounds. Try again");
        
            } while(b.CoordinatesOutOfBounds(row, col) == true);    //make sure user doesnt type in 
                                                                    //coordinates off the grid
        
        //make sure coordinates have been assigned a value and position hasnt already been called
        if (hiddengrid[row][col].getCalled() == true && grid[row][col].getCalled() == false) {
            
            if (hiddengrid[row][col].isShip() == true)
            {
                System.out.println("Ship! Its a hit!");
                
                if(hiddengrid[row][col].getPc() == true)
                pcHit++;
                
                else
                    playerHit++;
            }
            
            else if (hiddengrid[row][col].isGrenade() == true)
            {
                System.out.println("BOOM! grenade");
                skipPlayer++;
                i++;
            }
            
            grid[row][col].setElement(hiddengrid[row][col].getElement());
        }
        
        else {
            System.out.println("nothing.");
            grid[row][col].setNothing();
             }
        
        //display board
        b.toString(grid);
        
        }
        
        //PC'S TURN
        
        skipPc = 1;
        for (int i = 0; i < skipPlayer; i++) {
            
            
        //generate random coordinates
        for (int j = 1; j < 7; j++) 
        {
            do {
                row = rn.nextInt(8);
                col = rn.nextInt(8);
                } while(grid[row][col].getCalled() == true); //makes sure it doesnt get a coordinate
        }                                                     //that has already been called
        
        //display coordinates called by pc
        System.out.println("Computer called: "+b.getCoordinatesString(row, col));
        
        //make sure coordinates have been assigned a value and position hasnt already been called
        if (hiddengrid[row][col].getCalled() == true && grid[row][col].getCalled() == false)  
        {
            if (hiddengrid[row][col].isShip() == true)
            {
                System.out.println("Ship! Its a hit!");
                
                if(hiddengrid[row][col].getPc() == true)
                pcHit++;
                
                else
                    playerHit++;
            }
            
            else if (hiddengrid[row][col].isGrenade() == true)
            {
                System.out.println("BOOM! grenade");
                skipPc++;
                i++;
            }
            
            grid[row][col].setElement(hiddengrid[row][col].getElement());
        }
        else 
        {
            System.out.println("nothing.");
            grid[row][col].setNothing();
        }
            
        //display board
        b.toString(grid);
        
        }
        
        
    } while (playerHit < 6 && pcHit < 6);
    
  
    if(pcHit == 6)
        System.out.println("The computer lost all his ships! \nPLAYER WINS!");
    
    else if (playerHit == 6)
            System.out.println("The player lost all his ships! \nPC WINS!");
        
        hiddengrid.toString();
       
        }
    
    
}
    

