package Week5;

import java.util.Scanner;

public class UsingScanner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //exampleOne(in);
        exampleTwo(in);
        in.close();
    }

    private static void exampleTwo(Scanner in) {
        System.out.print("Please enter a number: ");
        // double num = in.nextDouble();

        //  
        double num = Double.valueOf(in.nextLine());
        double result = Math.pow(num, 2);

        System.out.print(result);
    }

    private static void exampleOne(Scanner input) {
        System.out.print("Please enter your name: ");
        String name = input.nextLine();

        System.out.print("Hello " + name);
        
    }
    
}
