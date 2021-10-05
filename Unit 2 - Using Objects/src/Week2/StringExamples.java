package Week2;

public class StringExamples {
    public static void main(String[] args) {
        String s1 = "This is a String Literal";
        String s2 = "This is a String Literal";
        String s3 = new String("This is a String Literal"); // it is not a string literal but a string object

        System.out.println(s1.length());
        System.out.println(s1.equals(s2));
        System.out.println(s1.indexOf("in"));
        System.out.println(s1.indexOf("ins")); // returns -1 if not there
        System.out.println(s3.substring(0,8));
  
        String s4 = "0123456789";
        String s5 = "ABCDEFGHIJ";
        System.out.println(s4.substring(3));
        System.out.println(s4.substring(3, 7));
  
        System.out.println(s5.substring(3));
        System.out.println(s5.substring(3, 7));
  

        
    }
    
}
