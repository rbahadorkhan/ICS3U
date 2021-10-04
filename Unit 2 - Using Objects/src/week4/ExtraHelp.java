package week4;

public class ExtraHelp {
    public static void main(String[] args) {
        String str = "HelloWorld";
        String strTwo = str.substring(3,5);
        System.out.println(strTwo);
        int len = str.length();
        System.out.println(len);
        int midIndex = len / 2;
        System.out.println(midIndex);
        String backHalf = str.substring(5,10);
        System.out.println(backHalf);
        String midThree = str.substring(midIndex-1, midIndex +2);
        System.out.println(midThree);
        String firstFour = str.substring(0,4);
        System.out.println(firstFour);
        String lastTwo = str.substring(str.length()-4);
        System.out.println(lastTwo);

        String str2 = "romina";
        int mid = str.length() /2;
        String firstHalf = str2.substring(0,mid);
        String lastHalf = str2.substring(mid);
        System.out.println(firstHalf.equals(lastHalf));


    }
}
