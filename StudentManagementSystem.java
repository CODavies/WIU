import java.util.Scanner;

class Student {

    private String name;
    private int age;
    private double test1;
    private double test2;
    private double test3;

    public void setStudentData(String name, int age, double test1, double test2, double test3) {
        this.name = name;
        this.age = age;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
    }

    public void calculateAndDisplayAverage() {
        double average = (test1 + test2 + test3) / 3.0;

        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Test1 Grade: " + test1);
        System.out.println("Test2 Grade: " + test2);
        System.out.println("Test3 Grade: " + test3);
        System.out.printf("Average: %.1f\n", average);
        System.out.println();
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Student[] studentList = new Student[3];

        for (int i = 0; i < studentList.length; i++) {

            studentList[i] = new Student();

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student age: ");
            int age = scanner.nextInt();

            System.out.print("Enter test1 grade: ");
            double test1 = scanner.nextDouble();

            System.out.print("Enter test2 grade: ");
            double test2 = scanner.nextDouble();

            System.out.print("Enter test3 grade: ");
            double test3 = scanner.nextDouble();
            scanner.nextLine(); 

            studentList[i].setStudentData(name, age, test1, test2, test3);
        }

        System.out.println();

        for (Student student : studentList) {
            student.calculateAndDisplayAverage();
        }

        scanner.close();
    }
}
