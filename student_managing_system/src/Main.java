import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for the Student Grade Management System
 *
 * This application allows a teacher or administrator to:
 *   1. Add new students
 *   2. Add courses
 *   3. Assign grades to students
 *   4. View all students
 *   5. Search for courses by name or code
 *   6. Calculate and display a student's average grade
 *   7. Display students who passed or failed
 *
 * @author naifas
 */
public class Main {

    // List of all registered students
    static ArrayList<Student> students = new ArrayList<>();

    // List of all registered courses
    static ArrayList<Course> courses = new ArrayList<>();

    // Scanner to read user input from the console
    static Scanner scanner = new Scanner(System.in);

    // Passing threshold for average grade
    static final double PASS_MARK = 60.0;

    /**
     * Program entry point. Displays the menu and dispatches
     * user choices to the appropriate feature method.
     */
    public static void main(String[] args) {

        System.out.println("=== Student Grade Management System ===");

        boolean running = true;

        while (running) {

            // Show menu options
            System.out.println("\n1. Add student");
            System.out.println("2. Add course");
            System.out.println("3. Assign grade");
            System.out.println("4. View all students");
            System.out.println("5. Search course");
            System.out.println("6. View student average");
            System.out.println("7. View passed/failed students");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            // Read user choice safely
            int choice = readInt();

            // Handle user choice using a switch
            switch (choice) {

                case 1:
                    addStudent();           // add new student
                    break;

                case 2:
                    addCourse();            // add new course
                    break;

                case 3:
                    assignGrade();          // assign grade to student
                    break;

                case 4:
                    viewAllStudents();      // display all students
                    break;

                case 5:
                    searchCourse();         // search for a course
                    break;

                case 6:
                    viewStudentAverage();   // show a student's average
                    break;

                case 7:
                    viewPassedFailed();     // show passed / failed students
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    running = false;        // stop the program
                    break;

                default:
                    System.out.println("Invalid choice.. try again");
            }
        }
    }

    // ---- 1. Add a new student ----
    /**
     * Adds a new student by reading an ID and name from the user.
     */
    public static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = readInt();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        Student student = new Student(id, name);
        students.add(student);

        System.out.println("Student added: " + student.getName());
    }

    // ---- 2. Add a new course ----
    /**
     * Adds a new course by reading a course code and name from the user.
     */
    static void addCourse() {
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();

        System.out.print("Enter course name: ");
        String name = scanner.nextLine();

        Course course = new Course(code, name);
        courses.add(course);

        System.out.println("Course added: " + course.getCourseName());
    }

    // ---- 3. Assign a grade to a student ----
    /**
     * Assigns a grade to an existing student for a specific course.
     */
    static void assignGrade() {
        System.out.print("Enter student ID: ");
        int id = readInt();

        System.out.print("Enter course code: ");
        String code = scanner.nextLine();

        System.out.print("Enter score: ");
        double score = readDouble();

        for (Student s : students) {
            if (s.getId() == id) {
                Grade grade = new Grade(id, code, score);
                s.addGrade(grade);
                System.out.println("Grade assigned successfully");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // ---- 4. View all students and their grades ----
    /**
     * Displays every student along with any grades they have received.
     */
    static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        for (Student s : students) {
            System.out.println("\nID: " + s.getId() + " | Name: " + s.getName());

            if (s.getGrades().isEmpty()) {
                System.out.println(" No grades yet");
            } else {
                for (Grade g : s.getGrades()) {
                    System.out.println("Course: " + g.getCourseCode() + " | Score: " + g.getScore());
                }
            }
        }
    }

    // ---- 5. Search for a course by name or code ----
    /**
     * Searches registered courses by a keyword matched against
     * the course code or course name (case-insensitive).
     */
    static void searchCourse() {
        System.out.print("Enter course name or code to search: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;

        for (Course c : courses) {
            if (c.getCourseCode().toLowerCase().contains(keyword)
                    || c.getCourseName().toLowerCase().contains(keyword)) {
                System.out.println("Found: " + c.getCourseCode() + " - " + c.getCourseName());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Course found!");
        }
    }

    // ---- 6. Calculate and display a student's average grade ----
    /**
     * Prints the average grade of a student identified by ID.
     */
    static void viewStudentAverage() {
        System.out.print("Enter student ID: ");
        int id = readInt();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student: " + s.getName());
                System.out.println("Average: " + s.calculateAverage());
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // ---- 7. Display students who passed or failed ----
    /**
     * Lists students whose average meets the pass mark and those who do not.
     * Students without any grades are reported separately.
     */
    static void viewPassedFailed() {
        System.out.println("\n---- Passed Students ----");
        for (Student s : students) {
            if (!s.getGrades().isEmpty() && s.calculateAverage() >= PASS_MARK) {
                System.out.println(s.getName() + " | Average: " + s.calculateAverage());
            }
        }

        System.out.println("\n---- Failed Students ----");
        for (Student s : students) {
            if (!s.getGrades().isEmpty() && s.calculateAverage() < PASS_MARK) {
                System.out.println(s.getName() + " | Average: " + s.calculateAverage());
            }
        }
    }

    // ---- Helper methods for safe numeric input ----

    /**
     * Reads a line from the console and parses it as an int.
     * Re-prompts until a valid integer is entered.
     */
    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid integer: ");
            }
        }
    }

    /**
     * Reads a line from the console and parses it as a double.
     * Re-prompts until a valid number is entered.
     */
    private static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
