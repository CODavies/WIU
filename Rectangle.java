import java.util.Scanner;

class Rectangle{
    private int length;
    private int breadth;

    public void setData(int lth, int bdth) {
        length = lth;
        breadth = bdth;
    }

    public int calcArea() {
        return length * breadth;
    }
}

public class Rectangle_Assignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Rectangle rect1 = new Recta();
        Rectangle r2 = new Recta();
        
        Recta rect1 = new Recta(); // ✅ Corrected
        Recta r2 = new Recta();
        
        System.out.print("Enter the length of the first rectangle: ");
        int l1 = sc.nextInt();
        System.out.print("Enter the breadth of the first rectangle: ");
        int b1 = sc.nextInt();
        rect1.setData(l1, b1);
        System.out.println("The area of the first rectangle: " + rect1.calcArea());
        System.out.print("Enter the length of the second rectangle: ");
        int l2 = sc.nextInt();
        System.out.print("Enter the breadth of the second rectangle: ");
        int b2 = sc.nextInt();
        r2.setData(l2, b2);
        System.out.println("The area of the second rectangle: " + r2.calcArea());

        sc.close();
        }
  }