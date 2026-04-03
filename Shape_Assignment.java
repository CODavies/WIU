import java.util.Scanner;

class Shape {
    void getVal() {
    }

    double calcArea() {
        return 0;
    }
}

class Sphere extends Shape {
    double r;
    final double PI = 3.14159;

    void getVal(double r) {
        this.r = r;
    }

    @Override
    double calcArea() {
        return 4 * PI * r * r;
    }
}

class Pyramid extends Shape {
    double b, s;

    void getVal(double b, double s) {
        this.b = b;
        this.s = s;
    }

    @Override
    double calcArea() {
        return (b * b) + (2 * b * s);
    }
}

class Cylinder extends Shape {
    double r, h;
    final double PI = 3.14159;

    void getVal(double r, double h) {
        this.r = r;
        this.h = h;
    }

    @Override
    double calcArea() {
        return 2 * PI * r * (h + r);
    }
}

public class Shape_Assignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Press 1 for Sphere");
            System.out.println("Press 2 for Pyramid");
            System.out.println("Press 3 for Cylinder");
            System.out.println("Press 4 to quit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Sphere sp = new Sphere();
                    System.out.print("Enter the radius of the sphere (cm): ");
                    double r = sc.nextDouble();
                    sp.getVal(r);
                    System.out.println("The surface area of the sphere is " 
                            + sp.calcArea() + " square cm");
                    break;

                case 2:
                    Pyramid py = new Pyramid();
                    System.out.print("Enter the base of the pyramid (cm): ");
                    double b = sc.nextDouble();
                    System.out.print("Enter the slant height of the pyramid (cm): ");
                    double s = sc.nextDouble();
                    py.getVal(b, s);
                    System.out.println("The surface area of the pyramid is " 
                            + py.calcArea() + " square cm");
                    break;

                case 3:
                    Cylinder cy = new Cylinder();
                    System.out.print("Enter the radius of the cylinder (cm): ");
                    double cr = sc.nextDouble();
                    System.out.print("Enter the height of the cylinder (cm): ");
                    double h = sc.nextDouble();
                    cy.getVal(cr, h);
                    System.out.println("The surface area of the cylinder is " 
                            + cy.calcArea() + " square cm");
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}