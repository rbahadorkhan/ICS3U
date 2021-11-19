import java.util.Arrays;

public class SearchingAlgorthims {
    public static void main(String[] args) {
        int[]arr ={5,91,34,83,384,49,10,31};
        
        int index = linearSearch(arr, 83);
        index = linearSearch(arr, 84);


        int[]nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[1] =(int) (Math.random()* 1000);
        }
        Arrays.sort(nums);
        index = binarySearch(arr,84);
    }
    
    private static int binarySearch(int[] arr, int i) {
      int

          
      }
    }

    private static int linearSearch(int[] arr, int findMe){
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]==findMe)
                return j;
            
        }
        return -1;
    }
     
}
