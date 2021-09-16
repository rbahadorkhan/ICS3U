package Week2;

import week2.Student;

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

        




       

    
        
    }
    
}
