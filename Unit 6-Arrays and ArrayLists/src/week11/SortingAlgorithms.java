public class SortingAlgorithms {
    public static void main(String[] args) {
        int [] arr = {80,70,10,15, 5, 90, 85};

    }
    private static voice selectionSort() {
        for(int i = 0; i< arr.length -1; i++){
            int smallestIndex = i;
            for(int j =i+1; j<arr.length; j++){
                if(arr[j] < arr[smallestIndex])
                    smallestIndex = j;

            }
        }
        int temp = arr[i];
        arr[i] = arr[smallestIndex];
        
        
    }
}
