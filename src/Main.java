import model.Student;
import service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    handleAddStudent(service, sc);
                    break;
                case 2:
                    handleDeleteStudent(service, sc);
                    break;
                case 3:
                    handleSearchStudent(service, sc);
                    break;
                case 4:
                    handleDisplayAll(service);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                case 6:
                    triggerErrors();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== STUDENT MANAGER PROGRAM =====");
        System.out.println("1. Add student");
        System.out.println("2. Delete student");
        System.out.println("3. Search student");
        System.out.println("4. Display all students");
        System.out.println("5. Exit");
        System.out.println("6. Trigger Snyk Errors");
        System.out.print("Select: ");
    }

    private static void handleAddStudent(StudentService service, Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Enter full name: ");
        String name = sc.nextLine();

        System.out.print("Enter GPA: ");
        double gpa = sc.nextDouble(); sc.nextLine();

        if (gpa < 0 || gpa > 4) {
            System.out.println("Invalid GPA.");
            return;
        }

        boolean added = service.addStudent(new Student(id, name, gpa));
        System.out.println(added ? "Student added." : "ID already exists.");
    }

    private static void handleDeleteStudent(StudentService service, Scanner sc) {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt(); sc.nextLine();
        boolean removed = service.removeStudent(id);
        System.out.println(removed ? "Deleted." : "Not found.");
    }

    private static void handleSearchStudent(StudentService service, Scanner sc) {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();
        List<Student> result = service.searchByName(name);
        if (result.isEmpty()) {
            System.out.println("No student found.");
        } else {
            for (Student s : result) {
                System.out.println(s);
            }
        }
    }

    private static void handleDisplayAll(StudentService service) {
        System.out.printf("%-10s %-30s %-5s\n", "ID", "Full Name", "GPA");
        for (Student s : service.getAllStudents()) {
            System.out.println(s);
        }
    }

    private static void triggerErrors() {
    // Lỗi 1: Null pointer dereference
    String value = null;
    System.out.println(value.length());

    // Lỗi 2: Division by zero
    int a = 10;
    int b = 0;
    int result = a / b;
    System.out.println("Result: " + result);

    // Lỗi 3: Hardcoded sensitive data
    String password = "admin123";
    System.out.println("Password: " + password);
}
}
