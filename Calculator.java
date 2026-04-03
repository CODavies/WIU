import java.util.Scanner;

class Calculator<T extends Number> {

    T x;
    T y;

    Calculator(T x, T y) {
        this.x = x;
        this.y = y;
    }

    void calculation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the operation: ");
        char op = sc.next().charAt(0);

        double num1 = x.doubleValue();
        double num2 = y.doubleValue();
        double result;

        if (op == '+') {
            result = num1 + num2;
        } else if (op == '-') {
            result = num1 - num2;
        } else if (op == '*') {
            result = num1 * num2;
        } else if (op == '/') {
            result = num1 / num2;
        } else {
            System.out.println("Invalid operation");
            return;
        }

        System.out.println("The result of the operation is " + result);
    }

    public static void main(String[] args) {

        Calculator<Integer> calc1 = new Calculator<>(5, 7);
        calc1.calculation();

        Calculator<Double> calc2 = new Calculator<>(12.0, 6.0);
        calc2.calculation();
    }
}