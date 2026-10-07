import java.util.ArrayList;
import java.util.Scanner;

// Abstract Student class
abstract class Student {

    // Encapsulation
    private int id;
    private String name;
    private String course;
    private double marks;

    // Constructor
    public Student(int id, String name, String course, double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    // Normal method
    public void displayStudent() {
        System.out.println("----------------------------------");
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Course : " + course);
        System.out.println("Marks  : " + marks);
        System.out.println("Type   : " + getStudentType());
        System.out.println("----------------------------------");
    }

    // Getter and Setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for Course
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // Getter and Setter for Marks
    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Invalid marks! Marks should be between 0 and 100.");
        }
    }

    // Abstract methods
    public abstract String getStudentType();

    public abstract void calculateFee();
}


// Regular Student
class RegularStudent extends Student {

    public RegularStudent(int id, String name, String course, double marks) {
        super(id, name, course, marks);
    }

    @Override
    public String getStudentType() {
        return "Regular Student";
    }

    @Override
    public void calculateFee() {
        System.out.println("Fee : Rs. 1,20,000");
    }
}


// Scholarship Student
class ScholarshipStudent extends Student {

    private double scholarship;

    public ScholarshipStudent(
            int id,
            String name,
            String course,
            double marks,
            double scholarship) {

        super(id, name, course, marks);
        this.scholarship = scholarship;
    }

    public double getScholarship() {
        return scholarship;
    }

    public void setScholarship(double scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public String getStudentType() {
        return "Scholarship Student";
    }

    @Override
    public void calculateFee() {

        double fee = 120000 - scholarship;

        if (fee < 0) {
            fee = 0;
        }

        System.out.println("Original Fee : Rs. 1,20,000");
        System.out.println("Scholarship  : Rs. " + scholarship);
        System.out.println("Final Fee    : Rs. " + fee);
    }
}


// Main class
public class program4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ArrayList stores multiple student objects
        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("\n==========================================");
            System.out.println("       STUDENT MANAGEMENT SYSTEM");
            System.out.println("==========================================");

            System.out.println("1. Add Regular Student");
            System.out.println("2. Add Scholarship Student");
            System.out.println("3. View Students");
            System.out.println("4. Search Student");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Show Fee");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            // Add Regular Student
            if (choice == 1) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                System.out.print("Enter Marks: ");
                double marks = sc.nextDouble();

                Student student =
                        new RegularStudent(id, name, course, marks);

                students.add(student);

                System.out.println("Student added successfully!");

            }

            // Add Scholarship Student
            else if (choice == 2) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                System.out.print("Enter Marks: ");
                double marks = sc.nextDouble();

                System.out.print("Enter Scholarship Amount: ");
                double scholarship = sc.nextDouble();

                Student student =
                        new ScholarshipStudent(
                                id,
                                name,
                                course,
                                marks,
                                scholarship
                        );

                students.add(student);

                System.out.println("Scholarship student added successfully!");

            }

            // View Students
            else if (choice == 3) {

                if (students.isEmpty()) {

                    System.out.println("No students found.");

                } else {

                    System.out.println(
                            "\n============== STUDENT LIST =============="
                    );

                    for (Student student : students) {
                        student.displayStudent();
                    }
                }
            }

            // Search Student
            else if (choice == 4) {

                System.out.print("Enter Student ID to search: ");
                int id = sc.nextInt();

                boolean found = false;

                for (Student student : students) {

                    if (student.getId() == id) {

                        System.out.println("\nStudent Found!");

                        student.displayStudent();

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found.");
                }
            }

            // Update Student
            else if (choice == 5) {

                System.out.print("Enter Student ID to update: ");
                int id = sc.nextInt();
                sc.nextLine();

                boolean found = false;

                for (Student student : students) {

                    if (student.getId() == id) {

                        System.out.print("Enter new name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter new course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter new marks: ");
                        double marks = sc.nextDouble();

                        student.setName(name);
                        student.setCourse(course);
                        student.setMarks(marks);

                        System.out.println(
                                "Student updated successfully!"
                        );

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found.");
                }
            }

            // Delete Student
            else if (choice == 6) {

                System.out.print("Enter Student ID to delete: ");
                int id = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < students.size(); i++) {

                    if (students.get(i).getId() == id) {

                        students.remove(i);

                        System.out.println(
                                "Student deleted successfully!"
                        );

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found.");
                }
            }

            // Show Fee
            else if (choice == 7) {

                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();

                boolean found = false;

                for (Student student : students) {

                    if (student.getId() == id) {

                        student.calculateFee();

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found.");
                }
            }

            // Exit
            else if (choice == 8) {

                System.out.println(
                        "Thank you for using Student Management System!"
                );

                break;

            } else {

                System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}