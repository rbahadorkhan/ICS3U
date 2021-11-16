package week7;

import java.util.Scanner;

public class CrazyEights2 {
    private static final int NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final int CARDS_PER_SUIT = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    private static final int NUM_CARDS_TO_START = 5;
    public static void main(String[] args) {

        int playerPoints = 0, c1Points = 0, c2Points = 0; 
          while (!gameOver(playerPoints, c1Points, c2Points)){
             String result = playRound();     
             int firstDash = result.indexOf("-"); 
             int secondDash = result.lastIndexOf("-");
             playerPoints += Integer.parseInt(result.substring(0, firstDash));
             c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
             c2Points += Integer.parseInt(result.substring(secondDash + 1));
  
             System.out.println("Current Score:" + playerPoints + " " + c1Points + " " + c2Points);
             
          }    
      }

      //what card is what (ex. 10S, 4C, 8D, etc)
      private static String getCard() {
        String card = getFace() + getSuit();         
         return card; 
    }

    //the suit of the card (Spades, hearts, clubs, diamonds)
    private static String getSuit() {
        int suit = (int) (Math.random() * NUM_SUITS);
        if (suit == 0)
           return HEARTS;
        else if (suit == 1)
           return DIAMONDS;
        else if (suit == 2)
           return CLUBS;
        else
           return SPADES;
    }

    //the face of the card (Queen, King, Ace, Jack)
    private static String getFace() {
        int suit = (int) (Math.random() * CARDS_PER_SUIT);
        if (suit >= 2 && suit <= 10)
           return suit + "";
        else if (suit == 1)
           return ACE;
        else if (suit == 11)
           return JACK;
        else if (suit == 12)
           return QUEEN;
        else
           return KING;
    }
    //Determines when the game is over 
    private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return playerPoints >= 100 || c1Points >= 100 || c2Points >= 100;
   }
    //Allows the players to play a round 
    private static String playRound() {
      Scanner in = new  Scanner (System.in);
      String playerHand = "";
      String c1Hand = "";
      String c2Hand = "";
      String topCard = "";
      String initialTopCard = ""; 
      topCard = getCard() + " ";
      
      System.out.println("The top card is: " + topCard);

      playerHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard(); 
      System.out.println("Player Hand: " + playerHand);
      playerHand = processPlayer (in, playerHand, topCard); 
      c1Hand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
      System.out.println("Computer 1 Hand: " + c1Hand);
      c2Hand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
      System.out.println("Second Computer Hand: " + c2Hand);

      while (playerHand.length() > 0 && c1Hand.length() > 0 && c2Hand.length() >= 0) {
        String temp = processPlayer(in, playerHand, initialTopCard);
        playerHand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);
  
        temp = processComputer(c1Hand, topCard, playerHand, c2Hand);
        c1Hand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);
  
        temp = processComputer(c2Hand, topCard, playerHand, c1Hand);
        c2Hand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);
      }  
      return playerTotal(playerHand, initialTopCard) + "-" + playerTotal(c1Hand, initialTopCard) + playerTotal(c2Hand, initialTopCard); 
   }
   
   //The total points the player has 
    private static int playerTotal(String hand, String playerHand) {
        int score = 0; 
        for (int i = 0; i < hand.length(); i += 3){
        String face = hand.substring(i, i + 1); 
            if ("10JQK".indexOf(face) >= 0)
                score += 10;
            else if (face.equals("A"))
                score += 1; 
            else if ("2345679".indexOf(face) >= 0)
                score += Integer.parseInt(face);
            else
                score += 50;  
        }
        return score; 
    }

    //how the comuter plays, so like the computers hand and their stuff basically    
    private static String processComputer(String cHand, String topCard, String c1Hand, String c2Hand) {
        cHand = validHand(cHand, topCard) + " "; 
        int index = 0; 
        String card = ""; 
        if (cHand.indexOf(topCard.substring(0, topCard.length() - 1)) != -1 || cHand.indexOf("8") != -1) {
            if (c1Hand.indexOf(" ") == -1 || c2Hand.indexOf(" ") == -1){
                while (cHand.indexOf(topCard.substring()))
            }
        }


    //Determines if the player can put the card
    private static String validHand(String playerHand, String topCard) {
        if (playerHand.length() == 0) {
            return "";
        } 
        int addedCards = 0; 
        while (playerHand.indexOf(topCard.substring(0, topCard.length() - 1)) == 1 && playerHand.indexOf(topCard.substring(topCard.length() - 1)) == -1 && playerHand.indexOf("8") == -1 ){
            playerHand += " " + getCard(); 
            addedCards ++; 
            if (addedCards == 5){
                return playerHand + " ";
            }
        }
        return playerHand + " ";
    }  
    
    private static String processPlayer(Scanner in, String playerHand, String topCard){
        boolean validInput = false; 
        playerHand += " ";
        String card = " ";
        while (!validInput) {
            System.out.println(playerHand);
            System.out.println("Pick a Card from your hand to play: ");
            card = in.nextLine(); 
            if (playerHand.indexOf(card) > - 1 && card.indexOf(" ") == -1){
                if (card.indexOf(topCard.substring(topCard.length() - 1)) >= 0 || card.indexOf(topCard.substring(0, topCard.length() - 1)) >= 0){
                    validInput = true;
                }
                else if (card.indexOf("8") > -1) {
                    String suit = " ";
                    System.out.println("Which suit do you want to change it to? (Please type D, C, H, S)");
                    boolean isSuit = false; 
                    while (!isSuit) {
                        suit = in.nextLine().toUpperCase(); 
                            if (suit.equals("D") || suit.equals("C") || suit.equals("H") || suit.equals("S")){
                                isSuit = true; 
                            }
                            else {
                                System.out.println("Invalid Input, please try again.");
                            }
                    }
                    String newCard = "8" + suit; 
                    return newCard + "-" + playerHand.replace(card + " ", " ").trim(); 

                }
            }
            else {
                System.out.println("Invalid Input, please try again");
            }
        }
        return card + "-" + playerHand.replace(card + " ", " ").trim(); 