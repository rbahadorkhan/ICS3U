

public class ComparingObjects {
    public static void main(String[] args) {
        // to comparer String(ANY object) we should use the equals method (.equals)

        String str1 = new String( "Hello");
        String str2 = new String ("Hello");
        String str3 = "hello";
        String str4 = str1;

        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str1.equals(str4));


        // equal methods defines how a class compares two instances of an object for equality

        String s1 = "ABCD";
        String s2 = "BCD";
        String s3 = "AACD";

        System.out.println("a".compareTo("g"));






    }
    
}
