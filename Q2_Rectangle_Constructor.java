import java.util.Scanner;

class Rectangle {
    private int length;
    private int breadth;

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public int calcArea() {
        return length * breadth;
    }
}

public class Q2_Rectangle_Constructor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the first rectangle: ");
        int l1 = sc.nextInt();
        System.out.print("Enter the breadth of the first rectangle: ");
        int b1 = sc.nextInt();
        Rectangle r1 = new Rectangle(l1, b1);
        System.out.println("The area of the first rectangle: " + r1.calcArea());

        System.out.print("Enter the length of the second rectangle: ");
        int l2 = sc.nextInt();
        System.out.print("Enter the breadth of the second rectangle: ");
        int b2 = sc.nextInt();
        Rectangle r2 = new Rectangle(l2, b2);
        System.out.println("The area of the second rectangle: " + r2.calcArea());

        sc.close();
    }
}
