
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

    
 
     private static String getPoints(String hand){
        int points = 0;
        String str = "";
        while(hand.length() > 0){
           if(hand.indexOf("A") >= 0){
              points += 1;
              hand = hand.substring(0, hand.indexOf("A")) +  hand.substring(hand.indexOf("A") + 3);
           }if(hand.indexOf("2") >= 0){
              points += 2;
              hand = hand.substring(0, hand.indexOf("2")) +  hand.substring(hand.indexOf("2") + 3);
           }if(hand.indexOf("3") >= 0){
              points += 3;
              hand = hand.substring(0, hand.indexOf("3")) +  hand.substring(hand.indexOf("3") + 3);
           }if(hand.indexOf("4") >= 0){
              points += 4;
              hand = hand.substring(0, hand.indexOf("4")) +  hand.substring(hand.indexOf("4") + 3);
           }if(hand.indexOf("5") >= 0){
              points += 5;
              hand = hand.substring(0, hand.indexOf("5")) +  hand.substring(hand.indexOf("5") + 3);
           }if(hand.indexOf("6") >= 0){
              points += 6;
              hand = hand.substring(0, hand.indexOf("6")) +  hand.substring(hand.indexOf("6") + 3);
           }if(hand.indexOf("7") >= 0){
              points += 7;
              hand = hand.substring(0, hand.indexOf("7")) +  hand.substring(hand.indexOf("7") + 3);
           }if(hand.indexOf("8") >= 0){
              points += 8;
              hand = hand.substring(0, hand.indexOf("8")) +  hand.substring(hand.indexOf("8") + 3);
           }if(hand.indexOf("9") >= 0){
              points += 9;
              hand = hand.substring(0, hand.indexOf("9")) +  hand.substring(hand.indexOf("9") + 3);
           }if(hand.indexOf("10") >= 0){
              points += 10;
              hand = hand.substring(0, hand.indexOf("10")) +  hand.substring(hand.indexOf("10") + 4);
           }if(hand.indexOf("J") >= 0){
              points += 10;
              hand = hand.substring(0, hand.indexOf("J")) +  hand.substring(hand.indexOf("J") + 3);
           }if(hand.indexOf("Q") >= 0){
              points += 10;
              hand = hand.substring(0, hand.indexOf("Q")) +  hand.substring(hand.indexOf("Q") + 3);
           }if(hand.indexOf("K") >= 0){
              points += 10;
              hand = hand.substring(0, hand.indexOf("K")) +  hand.substring(hand.indexOf("K") + 3);
           }
        }
        return str + points;
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
     private static String processComputer(String compHand, String topCard, String compOneHand, String compTwoHand) {
      
      String topNum = topCard.substring(0, topCard.length()-1); //gets the rank of the top card
      String topSuit = topCard.substring(topCard.length()-1);  //gets the suit of the top card
      String cardPlayed = "";
      int count = 0;
      int index = 0;
      String card = "";
      Boolean pickup = true;
    
      while(pickup && count <5){
         Boolean canPlay = (compHand.indexOf(topCard.substring(topCard.length()-1)) >=0) || (compHand.indexOf(topCard.substring(0,1))>=0)|| (compHand.indexOf(topCard.substring(0,2))>=0) || (compHand.indexOf("8")>=0);
         if(canPlay){
            pickup = false;
         }
         else{
            compHand += getCard() + " ";
            count++;
         }
      }
      if(count == 5){
         System.out.println("Turn was skipped");
         return topCard + "|" + compHand;
      }


         if(compOneHand.length() <= 4 || compTwoHand.length() <= 4){ 
            
            while(compHand.indexOf(topNum, index) >= 0){
               index = compHand.indexOf(topNum, index);
               card = compHand.substring(index, compHand.indexOf(" ", index));
               //will a card of the same rank if it doesnt have the same suit. 
               if(!card.equals(topCard)){
                  String cardReplace = card + " ";
                  return card + "|" +  compHand.replace(cardReplace, "");
               }
               index ++;   
            }
            if(compHand.indexOf("8") >= 0){
               compHand = compHand.substring(0, compHand.indexOf("8")) + compHand.substring(compHand.indexOf("8") + 3); //removes the 8 from the player hand
          
               if(compHand.indexOf("H") >= 0 && !"H".equals(topSuit)){
                  return "8H" + "|" + compHand;
               }if(compHand.indexOf("C") >= 0 && !"C".equals(topSuit)){
                  return "8C" + "|" + compHand;
               }if(compHand.indexOf("D") >= 0 && !"D".equals(topSuit)){
                  return "8D" + "|" + compHand;
               }if(compHand.indexOf("S") >= 0 && !"S".equals(topSuit)){
                  return "8S" + "|" + compHand;
               }
              return "8" + topSuit + "|" + compHand; 
            }
      
         if (compHand.indexOf(topSuit) >= 0){ 
           if(!compHand.substring(compHand.indexOf(topSuit) -1, compHand.indexOf(topSuit)).equals("8")){
              if(compHand.substring(compHand.indexOf(topSuit) - 1, compHand.indexOf(topSuit)).equals("0")){ //will be 10 because the only time 0 will be before the suit is 10
                 cardPlayed = compHand.substring(compHand.indexOf("10"), compHand.indexOf("10") + 3);
                 compHand = compHand.substring(0, compHand.indexOf("10")) + compHand.substring(compHand.indexOf("10") + 4);
                 return cardPlayed + "|" + compHand;
              }
               cardPlayed = compHand.substring(compHand.indexOf(topSuit)-1, compHand.indexOf(topSuit)+1);
               compHand = compHand.substring(0, compHand.indexOf(cardPlayed)) + compHand.substring(compHand.indexOf(cardPlayed) + 3);
               return cardPlayed + "|" + compHand;
          }
        }
    
         if(compHand.indexOf(topNum)>= 0){
            if(topNum.equals("10")){
              cardPlayed = compHand.substring(compHand.indexOf("10"), compHand.indexOf("10")+3);
              compHand = compHand.substring(0, compHand.indexOf("10")) + compHand.substring(compHand.indexOf("10") + 4);
              return cardPlayed + "|" + compHand;
           }

            if (!compHand.substring(compHand.indexOf(topNum), compHand.indexOf(topNum) + 1).equals("8")){
             cardPlayed = compHand.substring(compHand.indexOf(topNum), compHand.indexOf(topNum) + 2);
             compHand = compHand.substring(0, compHand.indexOf(cardPlayed)) + compHand.substring(compHand.indexOf(cardPlayed) + 3);
             return cardPlayed + "|" + compHand;
           }

        }

        if(compHand.indexOf("8") >= 0){
         compHand = compHand.substring(0, compHand.indexOf("8")) + compHand.substring(compHand.indexOf("8") + 3);
         if(compHand.indexOf("H") >= 0 && !"H".equals(topSuit)){
            return "8H" + "|" + compHand;
         }if(compHand.indexOf("C") >= 0 && !"C".equals(topSuit)){
            return "8C" + "|" + compHand;
         }if(compHand.indexOf("D") >= 0 && !"D".equals(topSuit)){
            return "8D" + "|" + compHand;
         }if(compHand.indexOf("S") >= 0 && !"S".equals(topSuit)){
            return "8S" + "|" + compHand;
         }
            return "8" + topSuit + "|" + compHand;
      }
      return topCard + "|" + compHand; 

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
 
        


  
        

