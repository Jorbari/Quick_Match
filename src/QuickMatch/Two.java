package QuickMatch;

import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Two implements Runnable {
//        This variable holds the name of the game winner

    String winner;

    Scanner sc = new Scanner(System.in);

//    An arraylist to hold the cards of players
//     **** this is the pile arraylist ****
//     The arraylist which holds all the values of the cards
    ArrayList<String> al = new ArrayList<>(25);

//    This is the first player arraylist, its primary function
//    is to just hold the cards of the first player
    ArrayList<String> fPlay = new ArrayList<>(6);

//    This is the first player arraylist, its primary function
//    is to just hold the cards of the first player
    ArrayList<String> sPlay = new ArrayList<>(6);

//    A variable to hold the names of players
//    The names of players are displayed for the players to know the player 
//    whose turn it is to play
    String Player1, Player2;

//    This are the cards, and they are all in strings because of the values
//    which they hold... 
//    The cards are 25 in total, each sectioned in 5-places... and each section
//    containes the same value because of the structure of the game
    String Queen1 = "The Queen of Hearts";
    String Queen2 = "The Queen of Hearts";
    String Queen3 = "The Queen of Hearts";
    String Queen4 = "The Queen of Hearts";
    String Queen5 = "The Queen of Hearts";

    String Ace1 = "The Ace of Hearts";
    String Ace2 = "The Ace of Hearts";
    String Ace3 = "The Ace of Hearts";
    String Ace4 = "The Ace of Hearts";
    String Ace5 = "The Ace of Hearts";

    String Five1 = "The Five of Clubs";
    String Five2 = "The Five of Clubs";
    String Five3 = "The Five of Clubs";
    String Five4 = "The Five of Clubs";
    String Five5 = "The Five of Clubs";

    String Spade1 = "The King of Spades";
    String Spade2 = "The King of Spades";
    String Spade3 = "The King of Spades";
    String Spade4 = "The King of Spades";
    String Spade5 = "The King of Spades";

    String Diamond1 = "The King of Diamonds";
    String Diamond2 = "The King of Diamonds";
    String Diamond3 = "The King of Diamonds";
    String Diamond4 = "The King of Diamonds";
    String Diamond5 = "The King of Diamonds";

    public void userInfo() {
//    This section primary function is to collect the name of the players as of the first time
//    running the game and it stores the name for further proccess

        System.out.print("Player 1 Name:    ");
        Player1 = sc.nextLine();
        System.out.print("Player 2 Name:    ");
        Player2 = sc.nextLine();

        gamePlay();
    }

    public void run() {
        userInfo();
    }

//    ***** A Constructor *****
    public Two() {


        /* 
        Creating a arraylist to hold all the values
        this arraylist is the pile which holds all the cards
         */
        al.add(Queen1);
        al.add(Queen2);
        al.add(Queen3);
        al.add(Queen4);
        al.add(Queen5);

        al.add(Ace1);
        al.add(Ace2);
        al.add(Ace3);
        al.add(Ace4);
        al.add(Ace5);

        al.add(Five1);
        al.add(Five2);
        al.add(Five3);
        al.add(Five4);
        al.add(Five5);

        al.add(Spade1);
        al.add(Spade2);
        al.add(Spade3);
        al.add(Spade4);
        al.add(Spade5);

        al.add(Diamond1);
        al.add(Diamond2);
        al.add(Diamond3);
        al.add(Diamond4);
        al.add(Diamond5);

    }

    private void gamePlay() {

        for (int i = 0; i < 5; i++) {
            int rand = rm.nextInt(al.size());
            fPlay.add(al.get(rand));
            al.remove(rand);

        }

        for (int i = 0; i < 5; i++) {
            int rand = rm.nextInt(al.size());
            sPlay.add(al.get(rand));
            al.remove(rand);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {

        }

        first();

//         for(int i=0; i<5; i++){
//             System.out.println(fPlay.get(i));
//         }
//         
//          for(int i=0; i<5; i++){
//             System.out.println(sPlay.get(i));
//         }
    }
    Random rm = new Random();
    ArrayList<String> holdCard = new ArrayList<>(1);
    ArrayList<String> holdCard2 = new ArrayList<>(1);

    void first() {
        String in;

        System.out.println("\n\n");

        System.out.println(Player1 + "'s turn \n");

        System.out.println(Player1 + " Card\n");

//        Displaying the cards of the first player
        for (int i = 0; i < 5; i++) {
            System.out.println(i + ". " + fPlay.get(i));
        }

        /*
        To withdraw from the pile, the player have to Press 'D' and 
        the pile will automatically emit a card and add it to the players
        card
         */
        System.out.print("\nPress D to draw a card from the pile:   ");
        in = sc.next();

        /*
        Using try catch to hold the next procedure as to control error...
        what this section does is to check if the input from the user is
        'D' and if it is, it displays the card of the player and add the 
        emmitted card from the pile to the players collection and at the same
        time removes the card from the pile collection
        
         */
        if (in.equalsIgnoreCase("d")) {

            try {
                int rand = rm.nextInt(al.size());

                fPlay.add(al.get(rand));
                al.remove(al.get(rand));

                for (int i = 0; i < fPlay.size(); i++) {
                    System.out.println(i + " " + fPlay.get(i));
                }

                boolean check = false;

                while (check == false) {

                    System.out.print("Enter the card number to be discarded (0-5) ");
                    int num = sc.nextInt();

                    switch (num) {
                        case 0:
                            check = true;
                            holdCard.add(fPlay.get(0));
                            fPlay.remove(0);
                            break;

                        case 1:
                            check = true;
                            holdCard.add(fPlay.get(1));
                            fPlay.remove(1);
                            break;

                        case 2:
                            check = true;
                            holdCard.add(fPlay.get(2));
                            fPlay.remove(2);
                            break;

                        case 3:
                            check = true;
                            holdCard.add(fPlay.get(3));
                            fPlay.remove(3);
                            break;

                        case 4:
                            check = true;
                            holdCard.add(fPlay.get(4));
                            fPlay.remove(4);
                            break;

                        case 5:
                            check = true;
                            holdCard.add(fPlay.get(5));
                            fPlay.remove(5);
                            break;

                        default:
                            System.out.println("\nPick between (0-5)\n");
                            break;
                    }
                }

                System.out.println("\nCard discarded is the " + holdCard.get(0));

                if (fPlay.get(0) == fPlay.get(1) && fPlay.get(0) == fPlay.get(2)
                        && fPlay.get(0) == fPlay.get(3)
                        && fPlay.get(0) == fPlay.get(4)) {

                    System.out.println("\nYou have won the Game");
                    System.out.println(Player1 + " won");
                    winner = Player1;
                    save();

                }
                second();

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } //        ********* end of if statement ************
        else {
            System.out.print("\nPress 'D' to draw a card from the Pile\n    ");
            first();
        }

//        second();
    }

    void second() {
        Scanner sc = new Scanner(System.in);
        String take;

        System.out.println("\n\n");

        System.out.println(Player2 + "'s turn \n");

        System.out.println(Player2 + " Card\n");

//        Displaying the cards of the second player
        for (int i = 0; i < 5; i++) {
            System.out.println(i + ". " + sPlay.get(i));
        }

        /*
        To withdraw from the pile, the player have to Press 'D' and 
        the pile will automatically emit a card and add it to the players
        card
         */
        System.out.print("\nPress 1 to pick " + Player1 + " card or press D to draw a card from the pile:   ");
        take = sc.nextLine();

        /*
        Using try catch to hold the next procedure as to control error...
        what this section does is to check if the input from the user is
        'D' and if it is, it displays the card of the player and add the 
        emmitted card from the pile to the players collection and at the same
        time removes the card from the pile collection
        
         */
        if (take.equals("1")) {
            int ncard;

            sPlay.add(holdCard.get(0));
            System.out.println("Card picked is: " + holdCard.get(0));
            holdCard.remove(0);

            for (int i = 0; i < sPlay.size(); i++) {
                System.out.println(i + ". " + sPlay.get(i));
            }

            boolean pass = false;

            while (pass == false) {
                System.out.print("Enter the card number to be discarded (0-5) ");
                ncard = sc.nextInt();
                switch (ncard) {
                    case 0:
                        pass = true;
                        holdCard2.add(sPlay.get(0));
                        sPlay.remove(0);
                        break;

                    case 1:
                        pass = true;
                        holdCard2.add(sPlay.get(1));
                        sPlay.remove(1);
                        break;

                    case 2:
                        pass = true;
                        holdCard2.add(sPlay.get(2));
                        sPlay.remove(2);
                        break;

                    case 3:
                        pass = true;
                        holdCard2.add(sPlay.get(3));
                        sPlay.remove(3);
                        break;

                    case 4:
                        pass = true;
                        holdCard2.add(sPlay.get(4));
                        sPlay.remove(4);
                        break;

                    case 5:
                        pass = true;
                        holdCard2.add(sPlay.get(5));
                        sPlay.remove(5);
                        break;

                    default:
                        System.out.println("\nPick between (0-5)\n");
                        break;

                }
            }
            System.out.println("\nCard discarded is the " + holdCard2.get(0));
            holdCard2.remove(0);

            if (sPlay.get(0) == sPlay.get(1) && sPlay.get(0) == sPlay.get(2)
                    && sPlay.get(0) == sPlay.get(3)
                    && sPlay.get(0) == sPlay.get(4)) {

                System.out.println("You have won the Game");
                System.out.println(Player2 + " won");

                winner = Player2;
                save();

            } else {
                first();
            }

        }

        if (take.equalsIgnoreCase("D")) {
            al.add(holdCard.get(0));
            holdCard.remove(0);

            try {
                int rand = rm.nextInt(al.size());

                sPlay.add(al.get(rand));
                al.remove(al.get(rand));

                for (int i = 0; i < sPlay.size(); i++) {
                    System.out.println(i + " " + sPlay.get(i));
                }

                boolean check = false;

                while (check == false) {

                    System.out.println("Enter the card number to be discarded (0-5) ");
                    int num2 = sc.nextInt();

                    switch (num2) {
                        case 0:
                            check = true;
                            holdCard2.add(sPlay.get(0));
                            sPlay.remove(0);
                            break;

                        case 1:
                            check = true;
                            holdCard2.add(sPlay.get(1));
                            sPlay.remove(1);
                            break;

                        case 2:
                            check = true;
                            holdCard2.add(sPlay.get(2));
                            sPlay.remove(2);
                            break;

                        case 3:
                            check = true;
                            holdCard2.add(sPlay.get(3));
                            sPlay.remove(3);
                            break;

                        case 4:
                            check = true;
                            holdCard2.add(sPlay.get(4));
                            sPlay.remove(4);
                            break;

                        case 5:
                            check = true;
                            holdCard2.add(sPlay.get(5));
                            sPlay.remove(5);
                            break;

                        default:
                            System.out.println("\nPick between (0-5)\n");
                            break;
                    }

                }
                System.out.println("\nCard withdrawn is the " + holdCard2.get(0));
                holdCard2.remove(0);
                if (sPlay.get(0) == sPlay.get(1) && sPlay.get(0) == sPlay.get(2)
                        && sPlay.get(0) == sPlay.get(3)
                        && sPlay.get(0) == sPlay.get(4)) {

                    System.out.println("You have won the Game");
                    System.out.println(Player2 + " won");

                    winner = Player2;
                    save();

                } else {
                    first();
                }

//                
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } else {
            al.add(holdCard.get(0));
            holdCard.remove(0);
            System.out.println("\nPress 'D' to draw a card from the Pile or '1' to collect " + Player1 + " card\n");
            second();
        }

    }

    public void save() {

        try (FileWriter f = new FileWriter("winner.txt", true)) {
            String[] names = {
                winner
            };

            f.write("Names Of Winners: \t");

            for (int i = 0; i < names.length; i++) {
                f.write(names[i] + "\t");
            }
            

        } catch (IOException ex) {
            System.out.println(ex);
        }

        System.exit(0);

    }

}
