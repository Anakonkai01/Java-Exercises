import java.util.Scanner;

public class Exercise1 {

    public static void getAndDisplayInfo() {
        // input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        System.out.print("Enter your student ID: ");
        String studentId = scanner.nextLine();
        scanner.close();
        // output
        System.out.println("\nStudent Information:");
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Student ID: " + studentId);
    }
    public static void main(String[] args) {
        getAndDisplayInfo();
    }
}