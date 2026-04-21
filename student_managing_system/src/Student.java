
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author naifas
 */
public class Student {
    
/**
   Represents a student in the grade management system
   Stores student details and their associated grades
 */


    // Unique identifier for the student
    private int id;

    // Full name of the student
    private String name;

    // List of grades associated with this student
    private List<Grade> grades;

    
    //Constructs a new Student with the given id and name
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    // Getters and Setters

    //Returns the student's unique ID
    public int getId() {
        return id;
    }
    
    //Update student's ID
     public void setId(int id){
        
     this.id = id;
                
    }
    
    //Returns the student's name
    public String getName() {
        return name;
    }
    
    //Update the student's name
    public void setName(String name){
        this.name = name;
    }
   

    /**
     Returns the list of grades for this student
     * @return 
     */
    public List<Grade> getGrades() {
        return grades;
    }

    /**
     Adds a grade to this student's grade list
     by receive parameter grade and then add it to Grade object
     * @param grade
     */
    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    /**
     Calculates the average score across all grades for this student
     and return the average grade as a double or 0.0 if no grades exist
     * @return 
     */
    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double total = 0;
        for (Grade grade : grades) {
            total += grade.getScore();
        }

        return total / grades.size();
    }

    /**
      Determines whether the student has passed based on average grade
     * A passing average is 60.0 or above
     * @return true if the student passed otherwise false 
     */
    public boolean hasPassed() {
        return calculateAverage() >= 60.0;
    }

    /**
     Returns a formatted string representation of the student
     * @return student info string
     */
    @Override
    public String toString() {
        return "Student [ID: " + id + ", Name: " + name + "]";
    }
}