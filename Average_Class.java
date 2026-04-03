import java.util.Scanner;

class Average {

    void avrge(int a, int b, int c) {
        double avg = (a + b + c) / 3.0;
        System.out.printf("The average of three integer numbers: %.2f\n", avg);
    }

    void avrge(double a, double b, double c) {
        double avg = (a + b + c) / 3.0;
        System.out.printf("The average of three decimal numbers: %.1f\n", avg);
    }
}

public class Average_Class {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Average obj = new Average();

        System.out.print("Enter the first integer number: ");
        int int1 = sc.nextInt();

        System.out.print("Enter the second integer number: ");
        int int2 = sc.nextInt();

        System.out.print("Enter the third integer number: ");
        int int3 = sc.nextInt();

        obj.avrge(int1, int2, int3);

        System.out.print("Enter the first decimal number: ");
        double d1 = sc.nextDouble();

        System.out.print("Enter the second decimal number: ");
        double d2 = sc.nextDouble();

        System.out.print("Enter the third decimal number: ");
        double d3 = sc.nextDouble();

        obj.avrge(d1, d2, d3);

        sc.close();
    }
}