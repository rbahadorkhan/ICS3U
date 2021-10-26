import java.util.Random;
import java.util.Scanner;

public class CrazyEights {
    private static final int NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final double CARDS_PER_SUIT = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    public static void main(String[] args) {
      String playerHand = "";
      playerHand = getCard(playerHand) + " ";
      playerHand += getCard(playerHand) + " ";
      playerHand += getCard(playerHand) + " ";
      playerHand += getCard(playerHand) + " ";
      playerHand += getCard(playerHand) + " ";
      
      System.out.println(playerHand);

      String compOneHand = "";
      compOneHand = getCard(compOneHand) + " ";
      compOneHand+= getCard(compOneHand) + " ";
      compOneHand += getCard(compOneHand) + " ";
      compOneHand += getCard(compOneHand) + " ";
      compOneHand += getCard(compOneHand) + " ";
      System.out.println(compOneHand);

      String compTwoHand = "";
      compTwoHand = getCard(compTwoHand) + " ";
      compTwoHand+= getCard(compTwoHand) + " ";
      compTwoHand += getCard(compTwoHand) + " ";
      compTwoHand += getCard(compTwoHand) + " ";
      compTwoHand += getCard(compTwoHand) + " ";
      System.out.println(compTwoHand);
      
      int p1Points = 0, c1Points = 0, c2Points = 0;
      while (!gameOver(p1Points, c1Points, c2Points)) {
        String result = playRound();
        int firstDash = result.indexOf("-");
        int secondDash = result.indexOf("-", firstDash + 1);
        p1Points += Integer.parseInt(result.substring(0, firstDash));
        c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
        c2Points += Integer.parseInt(result.substring(secondDash + 1));
        System.out.println("Current Score: " + p1Points + " " + c1Points + " " + c2Points);
      }
      Scanner input = new Scanner(System.in);
      String suits[] = {"J", "Q", "K", "A"};
      String cards[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10"};
      Random random = new Random();
      String topCard = (cards[random.nextInt(cards.length)] + suits[random.nextInt(suits.length)]);
      System.out.println("Top Card: " + topCard);
  }

  private static 

    while(!validInput){
      if(checkFace(playerHand, topCard) == true || checksuit(p1ayerHand, topCard) == true )
      System.out.println("Enter card you would like to play: ");
      String card = in.nextLine().toUpperCase();
      if (playerHand.indexOf(card) < 0) { 
        System.out.println("Invalid Card");
        System.out.println("The top card is: " + topCard);
      } else if(card.equals("8H") || card.equals("8C") || card.equals("8D") || card.equals("8S")){
        System.out.println("Enter new suit(Hearts, Diamonds, Spades or Clubs: ");
        String newSuit = in.nextLine().toUpperCase();
        if(newSuit.equals("HEARTS") == false || newSuit.equals("CLUBS") == false || newSuit.equals("SPADES") == false || newSuit.equals("DIAMONDS") == false) {
          System.out.println("Invalid Input");
          System.out.println("Enter new suit(Hearts, Diamonds, Spades or Clubs: ");
        }else{
          if(newSuit.equals("HEARTS")){
            topCard = "8";
            playerHand = playerHand.substring(0, playerHand.indexOf(card)) + playerHand.substring(playerHand.indexOf(card) + card.length());
             validInput = true;
             System.out.println("Your new suit is: " + newSuit);
             
          }else if (newSuit.equals("CLUBS")){
            topCard = "8C";
            playerHand = playerHand.substring(0, playerHand.indexOf(card)) + playerHand.substring(playerHand.indexOf(card) + card.length());
            validInput = true;
            System.out.printlnt("Your new suit is: " + newSuit);

         }  else if (newSuit.equals("DIAMONDS")){
            topCard = "8D";
            validInput = true;
            System.out.printlnt("Your new suit is: " + newSuit);
         } else {
            topCard = "8S";
            playerHand = playerHand.substring(0, playerHand.indexOf(card)) + playerHand.substring(playerHand.indexOf(card) + card.length());
            validInput = true;
            System.out.println("Your new suit is: " + newSuit);

          }

         }

      }

  
        }



      }



 

    }

    private static String getCard(String usedCards) {
      String card = getFace() + getSuit();
      while (usedCards.indexOf(card) >= 0) {
        card = getFace() + getSuit();
      }
       return card;
    }
          
    private static String getFace() {
      int suit = (int) (Math.random() * CARDS_PER_SUIT);
      if (suit >= 2 && suit <= 10){
      return suit + "";
     }else if (suit == 1){
      return ACE;
     }else if (suit == 11){
      return JACK;
     }else if (suit == 12){
      return QUEEN;
     }else{
      return KING;
     }
    }

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
        
   private static String playRound() {

    String playerHand = "";
    String c1Hand = "";
    String c2Hand = "";

    String topCard = ""; // no eights

    // "7H 3D AC JS-9D"
    String temp = processPlayer(playerHand, topCard);
    playerHand = temp.substring(0, temp.indexOf("-"));
    topCard = temp.substring(temp.indexOf("-") + 1);
    temp = processComputer(c1Hand, topCard);
    c1Hand = temp.substring(0, temp.indexOf("-"));
    topCard = temp.substring(temp.indexOf("-") + 1);
    temp = processComputer(c2Hand, topCard);
    c2Hand = temp.substring(0, temp.indexOf("-"));
    topCard = temp.substring(temp.indexOf("-") + 1);

    return "37-0-12";
  }

 private static String processComputer(String c1Hand, String topCard) {
   return "-4D";
}

 private static String processPlayer(String playerHand, String topCard) {
    return "7H 3D 4C-2D";
 }

 private static boolean gameOver(int p1Points, int c1Points, int c2Points) {
   return p1Points >= 100 || c1Points >= 100 || c2Points >= 100;
 }
 
 
     
        
}
