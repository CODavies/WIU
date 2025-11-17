import java.util.Scanner;

class Rectangle{
    private int length;
    private int breadth;

    
    public Rectangle(int lth, int bdth) {
        length = lth;
        breadth = bdth;
    }

    public int calcArea() {
        return length * breadth;
    }
}

public class Rectangle_Assignment_with_constructor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the length of the first rectangle: ");
        int length_of_first_rectangle = sc.nextInt();
        
        System.out.print("Enter the breadth of the first rectangle: ");
        int breadth_of_first_rectangle = sc.nextInt();
        
        Rectangle rectangle_1 = new Rectangle(length_of_first_rectangle, breadth_of_first_rectangle);

        System.out.println("The area of the first rectangle: " + rectangle_1.calcArea() + "\n");
        
        System.out.print("Enter the length of the second rectangle: ");
        int length_of_second_rectangle = sc.nextInt();
        
        System.out.print("Enter the breadth of the second rectangle: ");
        int breadth_of_second_rectangle = sc.nextInt();
        Rectangle rectangle_2 = new Rectangle(length_of_second_rectangle, breadth_of_second_rectangle);
        
        System.out.println("The area of the second rectangle: " + rectangle_2.calcArea());

        sc.close();
        }
  }