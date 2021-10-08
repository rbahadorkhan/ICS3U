package Week5;

    import java.util.Scanner;
    
    public class CrossCountry {
      public static void main(String[] args) {
          Scanner in = new Scanner(System.in);
          processRunner(in);
          processRunner(in);
          processRunner(in);
          in.close();
         
       }

       /**
        *
        * @param in
        */
    
       private static void processRunner(Scanner in) {
          String firstName, lastName;
          String mileOne, mileTwo, finishTime;
          String splitTwo, splitThree;
    
          /**
           * get both the first name and last name from the user
           * get the name and mleOne, mileTwo, finishTime from the user
           */

           System.out.println("Enter Your First Name: ");
           firstName = in.nextLine();
           System.out.println("Enter Your Last Name: ");
           lastName = in.nextLine();
           System.out.println("Enter Your First Mile (mm:ss.sss): ");
           mileOne = in.nextLine();
           System.out.println("Enter Your Second Mile (mm:ss.sss): ");
           mileTwo = in.nextLine(); 
           System.out.println("Enter Your Time Finished (mm:ss.sss): ");
           finishTime = in.nextLine(); 
    
          splitTwo = subtractTimes(mileTwo, mileOne);
          splitThree = subtractTimes(finishTime, mileTwo);
    
          /**
           * Display a summary for the runner
           */
          
          System.out.println(firstName + " " + lastName);
          System.out.println("Split One: " + mileOne);
          System.out.println("Split Two: " + splitTwo);
          System.out.println("Split Three: " + splitThree);
        }

        /**
        * 
        * @param endTime
        * @param startTime
        * @return the time
        */
       
       private static String subtractTime(String endTime, String startTime) {
          double endInSeconds = convertToSeconds (endTime); 
           double startInSeconds = convertToSeconds (startTime); 
           double diffInSeconds = endInSeconds - startInSeconds; 
           return convertToTime(diffInSeconds); 
        }

        /**
         * 
         * @param diffInSeconds
         * @return the time in proper format
         */

        private static String convertToTime(double diffInSeconds) {
           return String.format("%d:%06.3f", getMinutes(diffInSeconds), getSeconds(diffInSeconds));
        }
        /**
         * 
         * @param totalSeconds
         * @return the part of  the time where it is in seconds
         */

        public static double getSeconds(double totalSeconds) {
           double seconds = (totalSeconds % 60);
           return seconds;
        }

        /**
         * 
         * @param totalMinutes
         * @return the part of the time where it is in minutes
         */

        public static int getMinutes(double totalMinutes) {
           int minutes = (int)(totalSeconds/60);
           return minutes;
        }

        /**
         * 
         * @param time
         * @return the whole time (both minutes and seconds)
         */

        private static double convertToSeconds(String time) {
            int getColon = time.indexOf(":");
            double minute = Double.valueOf(time.substring(0 , getColon));
            double second = Double.valueOf(time.substring(0 , getColon));
            return (minute * 60) + second;
        }
}