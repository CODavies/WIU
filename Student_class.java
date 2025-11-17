import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private double std_test_1;
    private double std_test_2;
    private double std_test_3;

    public void setData(String std_name, int std_age, double std_test1, double std_test2, double std_test3) {
        name = std_name;
        age = std_age;
        std_test_1 = std_test1;
        std_test_2 = std_test2;
        std_test_3 = std_test3;
    }

    public void calcAverage() {
        double avg = (std_test_1 + std_test_2 + std_test_3) / 3.0;
        System.out.println("Student name: " + name);
        System.out.println("Student age: " + age);
        System.out.println("Test1 grade: " + std_test_1);
        System.out.println("Test2 grade: " + std_test_2);
        System.out.println("Test3 grade: " + std_test_3);
        System.out.printf("Average: %.1f%n", avg);
    }
}

public class Student_class {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[3];

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();

            System.out.print("\n" + "Enter student name: ");
            String std_name = sc.next();
            System.out.print("Enter student age: ");
            int std_age = sc.nextInt();
            System.out.print("Enter test1 grade: ");
            double std_test1 = sc.nextDouble();
            System.out.print("Enter test2 grade: ");
            double std_test2 = sc.nextDouble();
            System.out.print("Enter test3 grade: ");
            double std_test3 = sc.nextDouble();

            students[i].setData(std_name, std_age, std_test1, std_test2, std_test3);
        }

        for (Student s : students) {
            s.calcAverage();
        }

        sc.close();
    }
}
