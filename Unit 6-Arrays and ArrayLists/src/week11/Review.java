public class Review {
    public static void main(String[] args) {
        int[] nums={3,6,7,8,9,1,5,10,19,13};

        for(int i=0; i< nums.length; i++){
            System.out.println(nums[i]);
        }
        int numEven= 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] % 2 == 0){
                numEven++; 
            }

        }
    }   String[] str = {"word", "bob", "figs", "mugs", "tugs", "lungs", "dogs"};
     
        int letters = 0;
        for(int i=0; i< str.length; i++){
           letters += str[i].length();
           System.out.println(letters);
        }
        String vowels = "aeiouAEIOU";

        numVowels=0;
        for(int i=0; i< str[i].length; i++){
            for(int j=0; i< str[i].length(); j++){
                String letter = str[i].substring(j,j+1);
                if(vowels.indexOf(letters)>= 0){
                    numVowels++
                }
}
