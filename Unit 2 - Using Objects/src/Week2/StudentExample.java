package Week2;

import Week2.Student;

public class StudentExample {
    public static void main(String[] args) {
        // ritchie is a variable to an instance of the class Student
        // ritchie is an object (instances of a class)
        Student ritchie = new Student("Ritchie", "45646", 10);
        Student yola = new Student("Yola","123456", 10);

        // ritchie and yola are refrences to 2 different students

        Student rastin = ritchie;

        //because rastin and ritchie refer to the same student object it increases the grade for both (still its only 1 object)
        rastin.increaseGrade();

        ritchie  = null;  
        //student tristan; tristan is currently the null reference 

        // ritchie.increaseGrade();  // throws java.long.NullPointerException because ritchie is null

        yola.addTest(87);
        yola.displayAverage();
        yola.addTest(91);
        yola.displayAverage();
        yola.addTest(97);
        yola.displayAverage();
        yola.addTest(67);
        yola.displayAverage();

        Student harrison = new Student("Harrison","547235");
        
        double yolaAverage = yola.getAverage();
        System.out.println(yola.getName() + " has an average of " + yolaAverage);

        







       

    
        
    }
    
}
