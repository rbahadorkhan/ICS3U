package Week5;

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        processRunner(in);
        processRunner(in);
        processRunner(in);
        in.close();
    

        
    }
    private static void processRunner() {
        String firstName, lastName
        String mileOne, mileTwo, finishTime; 
        String splitTwo, splitThree;
        
        /**
         * get the name of mileOne, mileTwo, finishTime from the user
         * 
         */
        
         splitTwo = subtractTimes(mileTwo, mileOne);
         splitThree = subtractTimes(finishTime, mileTwo);
   
         /**
          * Display a summary for the runner
          */
      }   

}
    private static String subtractTimes(String endTime, String startTime ) {
        double endInSeconds = convertToSeconds(endTime);
        double startInSeconds = convertToSeconds(startTime);
        double diffInSeconds = endInSeconds = startInSeconds; 
        return convertToTime(diffInSeconds);


        
    }
    private static String convertToTime(double diffInSeconds) {

    ]
    }
    private static double convertToSeconds(String endTime) {
        
    }
