
package QuickMatch;
import java.util.Scanner;


public class Menu {
    
    /* 
    Creating an object of the class Menu to always first display a message
    as the first thing whenever the class is being called, the message is the
    game instruction. It tells the user the scope of the game
    */
    public Menu(){
        System.out.println("The first player to collect five cards of the same unit"
                + " wins the game");
        
        
        
        
    }
    
    public void trans(){
        System.out.print("\n\nEnter the number of players (2-4):    ");
        Scanner sc = new Scanner(System.in);
        
        /*
        Creating a switch case to transfer the players to the players 
        choice the player wants to play
        */
        
        try{
           int nPlay;
           nPlay = sc.nextInt();
           
           switch(nPlay){
               case 2: 
                   new two();
                   break;
               case 3: 
                   new three();
                   break;
               case 4: 
                   new four();
                   break;
               default:
                   System.out.println("Enter at least a player mode between 2-4");
                   trans();
                   
                   
           }
        }
        catch(Exception e){
            
        }
        
    }


//    If the player inputed 2, it takes them here
  
    public class two extends Two{
        public two(){
            super.userInfo();
        }
    }
    
//    If the player inputed 3, it takes them here
    public class three extends Three{
        public three(){
            super.userInfo();
        }
    }
    
//    If the player inputed 4, it takes them here
    
    public class four extends Four{
        public four(){
            super.userInfo();
        }
    }
    
    

    
    public static void main(String[] args) {
        Menu mn = new Menu();
        mn.trans();
    }
    
}
