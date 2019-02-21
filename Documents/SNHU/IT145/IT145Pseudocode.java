package it145pseudocode;
import java.util.Scanner;
/**
 *
 * @author Paul Hale
 */
public class IT145Pseudocode {

    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scnr = new Scanner(System.in);
        int applesOnHand = 0;
        int applesStk = 0;
        int orangesOnHand = 0;
        int orangesStk = 0;
        
        System.out.println("How many apples are on hand?");
        applesOnHand = scnr.nextInt();
        System.out.println("How many apples should be in stock?");
        applesStk = scnr.nextInt();
        System.out.println("How many oranges are on hand?");
        orangesOnHand = scnr.nextInt();
        System.out.println("How many oranges should be in stock?");
        orangesStk = scnr.nextInt();
        
        int applesNeeded = applesStk - applesOnHand;
        int orangesNeeded = orangesStk - orangesOnHand;
        
        System.out.println("Number of apples needed to replenish inventory: " + applesNeeded);
        System.out.println("Number of oranges needed to replenish inventory: " + orangesNeeded);
    }
    
}