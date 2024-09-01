import java.util.List;
import java.util.Scanner;

public class Main {
    private static final DatabaseManager dbManager = new DatabaseManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine();
        System.out.print("Enter class: ");
        String className = scanner.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        System.out.print("Enter contact info: ");
        String contactInfo = scanner.nextLine();

        Student student = new Student(name, rollNumber, className, dob, contactInfo);
        dbManager.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void viewAllStudents() {
        List<Student> students = dbManager.getAllStudents();
        for (Student student : students) {
            System.out.println(student.getStudentId() + " | " + student.getName() + " | " + student.getRollNumber() + " | " + student.getClassName() + " | " + student.getDob() + " | " + student.getContactInfo());
        }
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new roll number: ");
        String rollNumber = scanner.nextLine();
        System.out.print("Enter new class: ");
        String className = scanner.nextLine();
        System.out.print("Enter new date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        System.out.print("Enter new contact info: ");
        String contactInfo = scanner.nextLine();

        Student student = new Student(name, rollNumber, className, dob, contactInfo);
        dbManager.updateStudent(id, student);
        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        dbManager.deleteStudent(id);
        System.out.println("Student deleted successfully.");
    }
}