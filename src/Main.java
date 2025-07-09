import model.Student;
import service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add student");
            System.out.println("2. Delete student");
            System.out.println("3. Search student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            System.out.println("6. Trigger errors for Snyk test"); // thêm case lỗi
            System.out.print("Select: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt(); sc.nextLine();

                    System.out.print("Enter full name: ");
                    String name = sc.nextLine();
                    if (name.length() > 1000) { // ❌ Lỗi 3: Không giới hạn độ dài hợp lý
                        System.out.println("Warning: Very long name not rejected!");
                    }

                    System.out.print("Enter GPA: ");
                    double gpa = sc.nextDouble(); sc.nextLine();

                    if (gpa < 0 || gpa > 4) {
                        System.out.println("Invalid GPA!");
                        break;
                    }

                    boolean added = service.addStudent(new Student(id, name, gpa));
                    if (added) {
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Student ID already exists!");
                    }
                    break;

                case 2:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt(); sc.nextLine();
                    boolean removed = service.removeStudent(deleteId);
                    System.out.println(removed ? "Student deleted." : "Student not found.");
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    List<Student> results = service.searchByName(searchName);
                    if (results.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : results) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 4:
                    System.out.printf("%-10s %-30s %-5s\n", "ID", "Full Name", "GPA");
                    for (Student s : service.getAllStudents()) {
                        System.out.println(s);
                    }
                    String test = null;
                    System.out.println(test.length()); // cố tình gây lỗi null
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                case 6:
                    
                    int a = 10;
                    int b = 0;
                    int c = a / b; // chia cho 0
                    System.out.println("Result: " + c);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
