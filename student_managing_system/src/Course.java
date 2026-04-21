

/**
 *
 * @author naifas
 */
public class Course {
    

/**
 * Represents a course in the grade management system
 * Stores the course code and course name
 */


    // Unique code that identifies the course (e.g., "CS230")
    private String courseCode;

    // Full descriptive name of the course (e.g., "Object-Oriented Programming")
    private String courseName;

    /**
     * Constructs a new Course with the specified code and name
     *
     * @param courseCode the unique course code
     * @param courseName the full name of the course
     */
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    // Getters and Setters

    /**
     * Returns the course code
     *
     * @return course code string
     */
    public String getCourseCode() {
        return courseCode;
    }
    
     /**
     * Update the course code
     *
     * @param courseCode
     */
    public void setCourseCode(String courseCode){
        this.courseCode = courseCode;
    }

    /**
     * Returns the course name
     *
     * @return course name string
     */
    public String getCourseName() {
        return courseName;
    }
    
     /**
     * Update the course name
     *
     * @param courseName
     */
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }


    /**
     * Returns a formatted string representation of the course
     *
     * @return course info string
     */
    @Override
    public String toString() {
        return "Course [Code: " + courseCode + ", Name: " + courseName + "]";
    }
}