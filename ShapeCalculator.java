import java.util.Scanner;

abstract class Shape {
    abstract void getValues(Scanner scanner);
    abstract double calculateArea();
}

class Sphere extends Shape {
    private double radius;

    @Override
    void getValues(Scanner scanner) {
        radius = scanner.nextDouble();
    }

    @Override
    double calculateArea() {
        return 4 * Math.PI * radius * radius;
    }
}

class Pyramid extends Shape {
    private double base;
    private double slantHeight;

    @Override
    void getValues(Scanner scanner) {
        base = scanner.nextDouble();
        slantHeight = scanner.nextDouble();
    }

    @Override
    double calculateArea() {
        return base * base + 2 * base * slantHeight;
    }
}

class Cylinder extends Shape {
    private double radius;
    private double height;

    @Override
    void getValues(Scanner scanner) {
        radius = scanner.nextDouble();
        height = scanner.nextDouble();
    }

    @Override
    double calculateArea() {
        return 2 * Math.PI * radius * (height + radius);
    }
}

public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Surface Area Calculator ---");
            System.out.println("1. Sphere");
            System.out.println("2. Pyramid");
            System.out.println("3. Cylinder");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            Shape shape = null;

            switch (choice) {
                case 1:
                    System.out.print("Enter radius: ");
                    shape = new Sphere();
                    shape.getValues(scanner);
                    break;
                case 2:
                    System.out.print("Enter base and slant height: ");
                    shape = new Pyramid();
                    shape.getValues(scanner);
                    break;
                case 3:
                    System.out.print("Enter radius and height: ");
                    shape = new Cylinder();
                    shape.getValues(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the calculator!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (shape != null) {
                System.out.printf("The surface area is %.2f square cm%n", shape.calculateArea());
            }

        } while (choice != 4);

        scanner.close();
    }
}
