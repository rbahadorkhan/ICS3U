package Week1;

/**
 * More of the same Integer Vs Double Math
 * Modulus - remainder
 */
public class ExampleFive {
public static void main(String[] args) {
    int markOne = 75, markTwo = 80, markThree = 87; // declared and intialized on the same line.

    double average = (markOne + markTwo + markThree)/3; // Integer division  242/3 = 80 no decimal
    average=  (markOne + markTwo + markThree)/3.0; //double divison 242/3.0 = 80.6667
    System.out.println("The average is:" +average);

    System.out.println(4/3); // 1
    System.out.println(4/3.0); // 1.3333
    System.out.println(3/4); // 0
    System.out.println(3.0/4); // 0.75
    
    
}
    
}
