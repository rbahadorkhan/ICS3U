package week2;
/**
 * Romina Bahadorkhan 
 * Mr. DesLauriers
 * September 14, 2021
 * Create a program that obtains two integers, one for the amount a test is out of and another indicating what a student received. Display what percentage the student received on the test.
 */

public class HW2 {
    public static void main(String[] args) {
        int test = 80;
        int mark = 80;

        int percent1 = mark / test;
        int percent = percent1 * 100;  
    

        System.out.println("If the test is out of " + test +(", and the student got "+ mark));
        System.out.println("The percent mark would be " + percent + ("%."));
       



        
    }
    
}
