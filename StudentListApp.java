import java.util.Scanner;

class StudentNode {
    String name;
    double dsGrade;
    double calculusGrade;
    double englishGrade;
    double finalGrade;
    StudentNode next;

    public StudentNode(String name, double ds, double calc, double eng) {
        this.name = name;
        this.dsGrade = ds;
        this.calculusGrade = calc;
        this.englishGrade = eng;
        this.finalGrade = (ds + calc + eng) / 3.0;
        this.next = null;
    }
}

public class StudentListApp {
    private StudentNode head;

    public void insertInDescendingOrder(StudentNode newNode) {
        if (head == null || newNode.finalGrade > head.finalGrade) {
            newNode.next = head;
            head = newNode;
        } else {
            StudentNode current = head;
            while (current.next != null && current.next.finalGrade >= newNode.finalGrade) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records to display.");
            return;
        }

        StudentNode current = head;
        int count = 1;
        while (current != null) {
            System.out.printf(
                "Student %d: Name: %s, DS: %.0f, Calculus: %.0f, English: %.0f, Final grade: %.2f%%%n",
                count,
                current.name,
                current.dsGrade,
                current.calculusGrade,
                current.englishGrade,
                current.finalGrade
            );
            current = current.next;
            count++;
        }
    }

    public boolean deleteByName(String name) {
        if (head == null) return false;

        if (head.name.equalsIgnoreCase(name)) {
            head = head.next;
            return true;
        }

        StudentNode current = head;
        while (current.next != null && !current.next.name.equalsIgnoreCase(name)) {
            current = current.next;
        }

        if (current.next == null) return false;

        current.next = current.next.next;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentListApp list = new StudentListApp();

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("\n Enter the name of student " + i + ": ");
            String name = sc.nextLine();

            System.out.print("\n Enter the Data Structure grade: ");
            double ds = sc.nextDouble();

            System.out.print("\n Enter the Calculus grade: ");
            double calc = sc.nextDouble();

            System.out.print("\n Enter the English grade: ");
            double eng = sc.nextDouble();
            sc.nextLine();

            list.insertInDescendingOrder(new StudentNode(name, ds, calc, eng));
        }

        int choice;
        do {
            System.out.println("Press 1 to display all records");
            System.out.println("Press 2 to delete a student record");
            System.out.println("Press 3 to close the application");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Enter your choice: ");
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    list.displayAll();
                    break;

                case 2:
                    System.out.print("Enter the student’s name to delete: ");
                    String delName = sc.nextLine();
                    if (list.deleteByName(delName)) {
                        System.out.println("The record has been deleted successfully!");
                    } else {
                        System.out.println("Student record not found.");
                    }
                    break;

                case 3:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 3);

       
    }
}
