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

        Rectangle rectangle_1 = new Rectangle();
        Rectangle rectangle_2 = new Rectangle();
        
        System.out.print("Enter the length of the first rectangle: ");
        int length_of_first_rectangle = sc.nextInt();
        
        System.out.print("Enter the breadth of the first rectangle: ");
        int breadth_of_first_rectangle = sc.nextInt();
        
        rectangle_1.setData(length_of_first_rectangle, breadth_of_first_rectangle);
        System.out.println("The area of the first rectangle: " + rectangle_1.calcArea() + "\n");
        
        System.out.print("Enter the length of the second rectangle: ");
        int length_of_second_rectangle = sc.nextInt();
        
        System.out.print("Enter the breadth of the second rectangle: ");
        int breadth_of_second_rectangle = sc.nextInt();
        
        rectangle_2.setData(length_of_second_rectangle, breadth_of_second_rectangle);
        System.out.println("The area of the second rectangle: " + rectangle_2.calcArea());

        sc.close();
        }
  }