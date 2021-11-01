
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
    private static final int STARTING_CARDS= 5;

    public static void main(String[] args) {
      int p1Points = 0, compOnePoints = 0, compTwoPoints = 0;
      while (!gameOver(p1Points, compOnePoints, compTwoPoints)) {
        String result = playRound();
        int firstDash = result.indexOf("-");
        int secondDash = result.indexOf("-", firstDash + 1);
        p1Points += Integer.parseInt(result.substring(0, firstDash));
        compOnePoints += Integer.parseInt(result.substring(firstDash + 1, secondDash));
        compTwoPoints += Integer.parseInt(result.substring(secondDash + 1));
        System.out.println("Current Score: " + p1Points + " " + compOnePoints + " " + compTwoPoints);
      }
    }
    // To know which card is which
    private static String getCard() {
      String card = getFace() + getSuit();
      return card;
      
      }

      // The suit of cards( SPADES, HEARTS, CLUBS, DIAMONDS)
    private static String getFace(){
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

      // The face of the card (if it is a Queen, King, Ace or Jack)
    private static String getSuit() {
        int suit = (int) (Math.random() * NUM_SUITS);
        if (suit == 0){
          return HEARTS;
        }else if (suit == 1){
          return DIAMONDS;
        }else if (suit == 2){
          return CLUBS;
        }else{
          return SPADES;
        }
       }

       // Tells us when the game is over 
    private static boolean gameOver(int playerPoints, int compOneHand, int compTwoHand) {
        return playerPoints >= 100 || compOneHand >= 100 || compTwoHand >= 100;
      }



      // Allows the players to play a round
    private static String playRound() {
        Scanner in = new Scanner (System.in);
        String playerHand = "";
        String compOneHand = "";
        String compTwoHand = "";
        String topCard = ""; // no eights 
        String initTopCard = ""; 
        topCard = getCard() + " ";
      
        System.out.println("The top card is: " + topCard);
  
        playerHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard(); 
        System.out.println("Player Hand: " + playerHand);
        playerHand = processPlayer (in, playerHand, topCard); 
        compOneHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
        System.out.println("Computer 1 Hand: " + compOneHand);
        compTwoHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
        System.out.println("Second Computer Hand: " + compTwoHand);
  
        while (playerHand.length() > 0 && compOneHand.length() > 0 && compTwoHand.length() >= 0) {
          String temp = processPlayer(in, playerHand, initTopCard);
          playerHand = temp.substring(0, temp.indexOf("-"));
          topCard = temp.substring(temp.indexOf("-") + 1);
    
          temp = processComputer(compOneHand, topCard, playerHand, compTwoHand);
          compOneHand = temp.substring(0, temp.indexOf("-"));
          topCard = temp.substring(temp.indexOf("-") + 1);
    
          temp = processComputer(compTwoHand, topCard, playerHand, compOneHand);
          compTwoHand = temp.substring(0, temp.indexOf("-"));
          topCard = temp.substring(temp.indexOf("-") + 1);
        }  
        return playerTotal(playerHand, initTopCard) + "-" + playerTotal(compOneHand, initTopCard) + playerTotal(compTwoHand, initTopCard); 
     }

     // The total points the player has
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
    
      

     // How the computer plays 
    private static String processComputer(String compHand, String compOneHand, String compTwoHand, String topCard){
        compHand = validHand(compHand, topCard) + " "; 
        int index = 0; 
        String card = "";  
        if (compHand.indexOf(topCard.substring(0, topCard.length() - 1)) != -1 || compHand.indexOf("8") != -1) {
          if (compOneHand.indexOf(" ") == -1 || compTwoHand.indexOf(" ") == -1){
            while (compHand.indexOf(topCard.substring(0, topCard.length() - 1), index)!= -1){
            index = compHand.indexOf(topCard.substring(0, topCard.length() - 1), index); 
            card = compHand.substring(compHand.lastIndexOf(" ", index) + 1, compHand.indexOf(" ", index));
            if (!(card.substring(card.length() - 1).equals(topCard.substring(topCard.length() - 1)))){
              return compHand.replaceFirst(card + " ", "").trim() + "-" + card;
            }
            index++;
            if (compHand.indexOf("8") > - 1){
            //sees if its 8
            return compHand.replaceFirst(compHand.substring(compHand.indexOf("8"), compHand.indexOf("8") + 2), "").trim() + "-8";
          
             if (compHand.indexOf(topCard.substring(topCard.length() - 1)) > -1)
                return compHand.replaceFirst(card + " ", "").trim() + "-" + card;
            }
            index++;
            if (card.indexOf(topCard.substring(0, topCard.length() -1), 0 > -1))
            index = 0;
            while (compHand.indexOf(topCard.substring(topCard.length() - 1), index) != -1){
              index = compHand.indexOf(topCard.substring(topCard.length() -1), index); 
              card = compHand.substring(compHand.lastIndexOf(" ", index) + 1, compHand.indexOf(" ", index));
              if (card.indexOf("8") == -1){
                return compHand.replaceFirst(card + " ", "").trim() + "-" + card;
              } else {
                index++;
            } if (compHand.indexOf(topCard.substring(0, topCard.length() - 1)) != -1 && compHand.indexOf("8") == -1 ){
              index = 0; 
              index = compHand.indexOf(topCard.substring(0, topCard.length() - 1), index); 
              card = compHand.substring(index, compHand.indexOf(" ", index)); 
              return compHand.replaceFirst(card + " ", "").trim() + "-" + card; 
            } 
            if (compHand.indexOf("8") != -1){ 
            card = compHand.substring(compHand.indexOf("8"), compHand.indexOf("8") + 2);
            return compHand.replaceFirst(card + " ", "").trim() + "-" + card; 
           }else {
          System.out.println("Computer skipped");
          return compHand + "-" + topCard; 
        }
        return compHand.replace( topCard+ " ", "").trim();
      }
    }
  }
  }
  }
        
    
    //Determines if the player is able to put a card
    private static String validHand(String playerHand, String topCard) {
      if (playerHand.length() == 0) {
        return "";
      }
      int pickedUpCards = 0;
      while (playerHand.indexOf(topCard.substring(0, topCard.length() - 1)) == 1 && playerHand.indexOf(topCard.substring(topCard.length() - 1)) == -1 && playerHand.indexOf("8") == -1 ){
        playerHand += " " + getCard(); 
        pickedUpCards++; 
        if (pickedUpCards == 5){
          return playerHand + " ";
        }
      }
      return playerHand + " "; 
    }

    // How the player should play
    private static String processPlayer(Scanner in, String playerHand, String topCard){
      boolean validInput = false; 
      playerHand += " ";
      String card = " ";
      while (!validInput) {
        System.out.println(playerHand);
        System.out.println("Enter which card you'd like to play: ");
        card = in.nextLine(); 
        if (playerHand.indexOf(card) > - 1 && card.indexOf(" ") == -1){
          if (card.indexOf(topCard.substring(topCard.length() - 1)) >= 0 || card.indexOf(topCard.substring(0, topCard.length() - 1)) >= 0){
            validInput = true;
          }else if (card.indexOf("8") > -1) {
            String suit = " ";
            System.out.println("Which suit do you want to change it to? (Please type D, C, H, S)");
            boolean isSuit = false; 
            while (!isSuit) {
              suit = in.nextLine().toUpperCase(); 
              if (suit.equals("D") || suit.equals("C") || suit.equals("H") || suit.equals("S")){
                isSuit = true; 
              }else {
                System.out.println("Card isn't playable, please try again.");
              }
            }
            String newCard = "8" + suit; 
            return newCard + "-" + playerHand.replace(card + " ", " ").trim(); 

          }
        }else {
          System.out.println("Card isn't playable, please try again");
        }
      }
      return card + "-" + playerHand.replace(card + " ", " ").trim();

    }
}
 
        


  
        

