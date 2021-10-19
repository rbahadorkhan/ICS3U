

/**
 * Hangman
 */
public class Hangman {

    public static void main(String[] args) {
        boolean playAgain = true;
        Scanner in = new Scanner (System.in);
        while(playAgain) {
            play("READY TO USE SURFACE CLEANER", in);
            playAgain = playAgain(in);

        }
    }
    private static boolean playAgain(Scanner in) {
        boolean validInput = false;
        while (!validInput) {
           System.out.print("Do you want to play again? ([Y]es or [N]o)");
           String answer = in.nextLine().toUpperCase();
           if (answer.equals("Y") || answer.equals("YES"))
              return true;
           else if (answer.equals("N") || answer.equals("NO"))
              return false;
           else {
              System.out.println("Invalid Choice!");
           }
        }
  
        return false;
    }

    // _ _ _ _ _ / _ _ / _ _ _ / _ _ _ _ _ _ _ / _ _ _ _ _ _ _
    /**
      0
    --|--
     /\
     */


    private static void play(String hint, Scanner in) {
      String usedLetters = "";
      int numPieces = 0;
      String availableLetters = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
      boolean gameOver = false;

      while (!gameOver) {
         String encryptedHint = encryptHint(hint, usedLetters);
         System.out.println(encryptedHint);
         String letter = getLetter(availableLetters, in);

         // update availableLetters
         availableLetters = availableLetters.replace(letter, "_");
         // update lettersUsed
         usedLetters += letter;

         if (hint.indexOf(letter) < 0)
            numPieces++;

         drawHangman(numPieces);

         if (numPieces == 7) {
            gameOver = true;
            System.out.println("You Lose!!!");
         } else if (encryptedHint.indexOf("_") < 0) {
            gameOver = true;
            System.out.println("You Win!!!");
         }
      }
   }
        
    
    private static String getLetter( String avaialbleletters, Scanner in) {
        boolean validInput = false;
        String letter = "";

        while(!validInput){
            System.out.println("Available Letters:\n"+ availableLetters);
            System.out.println("Please enter a letter: ");
            letter = in.NextLine().toUpperCase();

            if(avaialbleletters)
        }
        
        
    }
    private static String encryptHint( String hint, String usedLetters){
        String result = " ";

        for(int i= 0; i < hint.length();i++){
            String letter = hint.substring(i, i+1);

            if(letter.equals(" ")){
                result += " / ";
            }else if(usedLetters.indexOf(letter) <0){
                // its not guessed yet
                result += "_ ";
            }else{
                result+= letter + " ";
            }
        }
        return result;
    }
    private static void drawHangman(int numPieces){
        if (numPieces == 7) {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|   --|--");
            System.out.println("|     |");
            System.out.println("|    / \\");
            System.out.println("-----------");
         } else if (numPieces == 6) {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|   --|--");
            System.out.println("|     |");
            System.out.println("|    / ");
            System.out.println("-----------");
         } else if (numPieces == 5) {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|   --|--");
            System.out.println("|     |");
            System.out.println("|");
            System.out.println("-----------");
         } else if (numPieces == 4) {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|   --|--");
            System.out.println("|     ");
            System.out.println("|");
            System.out.println("-----------");
         } else if (numPieces == 3) {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|   --|");
            System.out.println("|     ");
            System.out.println("|");
            System.out.println("-----------");
         } else if (numPieces == 2) {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|     |");
            System.out.println("|     ");
            System.out.println("|");
            System.out.println("-----------");
         } else if (numPieces == 1) {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|");
            System.out.println("|     ");
            System.out.println("|");
            System.out.println("-----------");
         } else {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("-----------");
         }
        }
        }
        }
        }
        
        
    }
}
