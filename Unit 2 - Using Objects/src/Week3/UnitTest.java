package Week3;

public class UnitTest {
    public static void main(String[] args) {
        System.out.println(threeCopies("Happy", 1));
        System.out.println(threeCopies("Computer", 3));
        System.out.println(removeChars("Computer Science", 3, 4));
        System.out.println( removeChars("Happy", 1, 2));

        System.out.println(sqrtSum(9999));


        
    }
    /**
     * Write a fuction that accepts a string and a and int that represents an index. 
     * Obtains two characters at that index and return 3 copies of that string. 
     */
    public static String threeCopies(String str, int index) {
        String s = str.substring(index, index+ 2 );  //gets two characters starting at index.
        return s+s+s; 


    
       /**
        * removeChars("Happy", 1, 2) -> "Hpy"
        * removeChars("Computer Science", 0, 3) -> "puter Science"
        * removeChars("Computer Science", 3, 4) -> "Comr Science"
        */

    public static String removeChars (String str, int index, int n) {
        String front = str.substring(0, index);
        String last = str.substring(index+n);

        return front + last; 

    public static sqrtSum() {
        int n1 = number / 1000; // ex
        

        }
        } 

    }



}
