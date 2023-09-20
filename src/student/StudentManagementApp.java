
package student;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private int age;
    private String email;
    private String course;

    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }
    @Override
    public String toString() {
        return "Student ID: " + id + "\nStudent Name: " + name + "\nStudent Age: " + age +
                "\nStudent Email: " + email + "\nStudent Course: " + course + "\n";
    }
}

public class StudentManagementApp {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagementApp app = new StudentManagementApp();
        app.run();
    }

    public void run() {
        while (true) {
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("*****************************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            System.out.println("                                             ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                displayMainMenu();
            } else {
                System.out.println("Exiting application. Goodbye!");
                break;
            }
        }
    }

    private static void displayMainMenu() {
        while (true) {
             System.out.println("                                             ");
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new student.");
            System.out.println("(2) Search for a student.");
            System.out.println("(3) Delete a student.");
            System.out.println("(4) Print student report.");
            System.out.println("(5) Exit Application");
             System.out.println("                                             ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    captureNewStudent();
                    break;
                case 2:
                    searchForStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    printStudentReport();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Exiting the application.");
                    System.exit(0);
            }
        }
    }

    static void captureNewStudent() {
        System.out.println("                                             ");
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("*********************************");
        
        System.out.print("Enter the student id: ");
        String id = scanner.nextLine();

        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();

        int age;
        while (true) {
            System.out.print("Enter the student age: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 16) {
                    break;
                } else {
                    System.out.println("Invalid age. Please enter an age greater than or equal to 16.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for age.");
            }
        }

        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        students.add(new Student(id, name, age, email, course));
        System.out.println("Student details have been successfully saved.");
    }

    static void searchForStudent() {
        System.out.println("                                             ");
        System.out.println("Enter the student id to search:");
        System.out.println("                                             ");
        String searchId = scanner.nextLine();

        for (Student student : students) {
            if (student.getId().equals(searchId)) {
                System.out.println("---------------------------------------");
                System.out.println("Student ID: " + student.getId());
                System.out.println("Student Name: " + student.getName());
                System.out.println("Student Age: " + student.getAge());
                System.out.println("Student Email: " + student.getEmail());
                System.out.println("Student Course: " + student.getCourse());
                System.out.println("---------------------------------------");
                System.out.println("                                             ");
                return;
            }
        }

        System.out.println("Student with student ID " + searchId + " was not found.");
        System.out.println("                                             ");
    }

    static void deleteStudent() {
        System.out.println("Enter the student id to delete:");
        System.out.println("                                             ");
        String deleteId = scanner.nextLine();

        for (Student student : students) {
            if (student.getId().equals(deleteId)) {
                System.out.println("Are you sure you want to delete student " + student.getName() + " from the system? (Yes/No)");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("Yes") || confirmation.equalsIgnoreCase("Y")) {
                    students.remove(student);
                    System.out.println("Student with student ID " + deleteId + " was deleted!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                return;
            }
        }

        System.out.println("Student with student ID " + deleteId + " was not found.");
    }

    static void printStudentReport() {
        System.out.println("STUDENT REPORT");
        System.out.println("*****************************************");

        for (Student student : students) {
            System.out.println("Student ID: " + student.getId());
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student Age: " + student.getAge());
            System.out.println("Student Email: " + student.getEmail());
            System.out.println("Student Course: " + student.getCourse());
            System.out.println("---------------------------------------");
        }
    }

}
