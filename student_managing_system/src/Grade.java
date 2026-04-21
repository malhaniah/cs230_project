/**
 *
 * @author naifas
 */
public class Grade {
    

/**
 * Represents a grade assigned to a student for a specific course
 * Links a student (by ID) to a course (by code) with a numeric score
 */


    // The ID of the student who received this grade
    private int studentId;

    // The code of the course this grade belongs to
    private String courseCode;

    // The numeric score (0–100)
    private double score;

    /**
     * Constructs a new Grade with the given student ID, course code, and score.
     *
     * @param studentId  the ID of the student
     * @param courseCode the code of the course
     * @param score      the numeric score (expected range: 0–100)
     */
    public Grade(int studentId, String courseCode, double score) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.score = score;
    }

    // Getters and Setters

    /**
     * Returns the student ID associated with this grade
     * @return student ID
     */
    public int getStudentId() {
        return studentId;
    }
    
     /**
     * Update the student ID associated with this grade
     * @param studentId
     */
    
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    /**
     * Returns the course code associated with this grade
     *
     * @return course code string
     */
    public String getCourseCode() {
        return courseCode;
    }
    
     /**
     * Update the course code associated with this grade
     *
     * @param courseCode
     */
    public void setCourseCode(String courseCode){
        this.courseCode = courseCode;
    }

    /**
     * Returns the numeric score of this grade
     *
     * @return score as a double
     */
    public double getScore() {
        return score;
    }
    
     /**
     * Update the numeric score of this grade
     *
     * @param score
     */
     public void setScore(double score){
        this.score = score;
    }


    /**
     * Returns a formatted string representation of this grade
     *
     * @return grade info string
     */
    @Override
    public String toString() {
        return "Grade [StudentID: " + studentId + ", CourseCode: " + courseCode + ", Score: " + score + "]";
    }
}