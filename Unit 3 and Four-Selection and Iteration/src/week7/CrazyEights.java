
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
    private static final int STARTING_CARDS =5;

    public static void main(String[] args) {
      String compHand = "";

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
    

      int p1Points = 0, compOnePoints = 0, compTwoPoints = 0;
      while (!gameOver(p1Points, compOnePoints, compTwoPoints)) {
        String result = playRound();
        int firstDash = result.indexOf("-");
        int secondDash = result.indexOf("-", firstDash + 1);
        p1Points += Integer.parseInt(result.substring(0, firstDash));
        compOneHand += Integer.parseInt(result.substring(firstDash + 1, secondDash));
        compTwoHand += Integer.parseInt(result.substring(secondDash + 1));
        System.out.println("Current Score: " + p1Points + " " + compOnePoints + " " + compTwoPoints);
      }
    }
      private static String getCard(String compOneHand) {
        return null;
      }
      
      private static String playRound() {
        Scanner in = new Scanner (System.in);
        String playerHand = "";
        String compOneHand = "";
        String compTwoHand = "";
        String topCard = ""; // no eights 
        String initTopCard = ""; 

        for(int i= 0; i < STARTING_CARDS; i++){
          playerHand += getCard();
        }
        while(playerHand.length() >= 0 || compOneHand.length() >= 0 || compTwoHand.length() >= 0){
          String temp = processPlayer(in, playerHand, initTopCard);
          playerHand = temp.substring(0, temp.indexOf("-"));
          topCard = temp.substring(temp.indexOf("-")+1);
          
          temp = processComputer(compOneHand, compTwoHand, topCard, playerHand);
          compOneHand = temp.substring(0, temp.indexOf("-"));
          topCard = temp.substring(temp.indexOf("-")+1);

          temp = processComputer(compTwoHand, compOneHand, topCard, playerHand);
          compTwoHand = temp.substring(0, temp.indexOf("-"));
          topCard = temp.substring(temp.indexOf("-")+1);
        }

        return playerTotal(playerHand) + "-" + playerTotal(compOneHand) + playerTotal(compTwoHand);
      
      }

      private static String playerTotal (String playerHand){
        return null;
      }

      private static String processComputer(String compHand, String compOneHand, String compTwoHand, String topCard){
        compHand = validHand(compHand, topCard) + " "; 
        int index = 0; 
        String card = ""; 
        String suit = ""; 
        if (compHand.indexOf(topCard.substring(0, topCard.length() - 1)) != -1 || compHand.indexOf(topCard.substring(topCard.length() - 1)) != -1 || compHand.indexOf("8") != -1) {
          if (compOneHand.indexOf(" ") == -1 || compTwoHand.indexOf(" ") == -1){

            while (compHand.indexOf(topCard.substring(0, topCard.length() - 1), index)!= -1){
              index = compHand.indexOf(topCard.substring(0, topCard.length() - 1), index); 
              card = compHand.substring(compHand.lastIndexOf(" ", index) + 1, compHand.indexOf(" ", index));

              if (!(card.substring(card.length() - 1).equals(topCard.substring(topCard.length() - 1)))){
                return compHand.replaceFirst(card + " ", "").trim() + "-" + card;
              }
              index++;
            }
            if (compHand.indexOf("8")!= -1){
              suit = getHighSuit(compHand);
              return compHand.replaceFirst(compHand.substring(compHand.indexOf("8"), compHand.indexOf("8") + 2), "").trim() + "-8" + suit; 

            }
          }
          if (compHand.indexOf(topCard.substring(topCard.length() - 1)) != -1) {
            index = 0; 
            while (compHand.indexOf(topCard.substring(topCard.length() - 1), index) != -1){
              index = compHand.indexOf(topCard.substring(topCard.length() -1), index); 
              card = compHand.substring(compHand.lastIndexOf(" ", index) + 1, compHand.indexOf(" ", index));
              
              if (card.indexOf("8") == -1){
                return compHand.replaceFirst(card + " ", "").trim() + "-" + card;
              } else {
                index++; 
              }
            }
          } 
          if (compHand.indexOf(topCard.substring(0, topCard.length() - 1)) != -1 && compHand.indexOf("8") == -1 ){
            index = 0; 
            index = compHand.indexOf(topCard.substring(0, topCard.length() - 1), index); 
            card = compHand.substring(index, compHand.indexOf(" ", index)); 
            return compHand.replaceFirst(card + " ", "").trim() + "-" + card; 
          } 
          if (compHand.indexOf("8") != -1){
            suit = getHighSuit(compHand); 
            card = compHand.substring(compHand.indexOf("8"), compHand.indexOf("8") + 2);
            return compHand.replaceFirst(card + " ", "").trim() + "-" + card; 
          }
          
        } else {
          System.out.println("Computer skipped");
          return compHand + "-" + topCard; 
        }
        return " "; //change this 
    }
    
    private static String getHighSuit(String cHand) {
      return null;
    }

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

    private static boolean gameOver(int playerPoints, int compOneHand, int compTwoHand) {
      return playerPoints >= 100 || compOneHand >= 100 || compTwoHand >= 100;
    }

    private static String getCard() {
      String card = getFace() + getSuit();
      return card; 
    }

  
          
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

    private static String processPlayer(Scanner in, String playerHand, String initTopCard){
      boolean validInput = false; 
      playerHand += " ";
      String card = " "; 
      while (!validInput){
        System.out.println(playerHand);
        System.out.println("Enter which card you'd like to play: ");
        card = in.nextLine(); 
        if(playerHand.indexOf(card) >  - 1 && card.indexOf(" ") == -1){
          validInput = true;
        } else {
          System.out.println("Invalid Card");
          System.out.println("Valid cards are: ");         
        }
      }
      return playerHand.replace(card + " ", "").trim(); 
    }
    
        


    

  
  

 //private static String processComputer(String compOneHand, String topCard) {
  // return "-4D";
//}

 //private static String processPlayer(String playerHand, String topCard) {
    //return "7H 3D 4C-2D";
 
//} 
}


 //private static boolean gameOver(int p1Points, String compOneHand, String  compTwoHand) {
   //return p1Points >= 100 || compOneHand >= 100 || compTwoHand >= 100;
 
 
 
     
        

