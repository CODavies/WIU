import java.util.Scanner;

class Rectangle {
    private int length;
    private int breadth;

    public void setData(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public int calcArea() {
        return length * breadth;
    }
}

public class Q1_Rectangle_SetData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();

        System.out.print("Enter the length of the first rectangle: ");
        int l1 = sc.nextInt();
        System.out.print("Enter the breadth of the first rectangle: ");
        int b1 = sc.nextInt();
        r1.setData(l1, b1);
        System.out.println("The area of the first rectangle: " + r1.calcArea());

        System.out.print("Enter the length of the second rectangle: ");
        int l2 = sc.nextInt();
        System.out.print("Enter the breadth of the second rectangle: ");
        int b2 = sc.nextInt();
        r2.setData(l2, b2);
        System.out.println("The area of the second rectangle: " + r2.calcArea());

        sc.close();
    }
}
   