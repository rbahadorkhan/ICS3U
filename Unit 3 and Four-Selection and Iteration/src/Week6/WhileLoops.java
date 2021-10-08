public class WhileLoops {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
        int numVowels = countVowels("This is a sentence with vowels");
        System.out.println(numVowels);
        
        
    }

    private static int countVowels(String str) {
        int numVowels= 0;
        String vowels = "AEIOUaeiou";
        int index = 0;

        while(index <str.length()) {
            String nextChar = str.substring(index, index + 1);
            if (vowels.indexOf(nextChar)> 0 )
            numVowels++;
            index++;
        }
    }

    private static void exampleTwo() {
        // add the number from 1- 100
        
        int sum = 0;
        int numAdd = 1;

        while(numAdd <= 100){
            numAdd += sum;
            numAdd++;
     }
    }

    private static void exampleOne() {
        //purpose of a loop is to repeat code
        
        int num = 1;

        while(num < 10){
            System.out.println(num);
            num++;
        }
    }
    
}
