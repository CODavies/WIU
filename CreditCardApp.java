import java.util.Scanner;

class CreditCard {
    private String name, number;
    private double limit, balance;

    public CreditCard(String n, String num, double l) {
        name = n;
        number = num;
        limit = l;
        balance = l;
    }

    private boolean pmtApprove(double amt) {
        return amt <= balance;
    }

    public void makePayment(double amt) {
        if (pmtApprove(amt)) {
            balance -= amt;
            System.out.println("Transaction successful. Balance: $" + balance);
        } else {
            System.out.println("Transaction failed. Amount exceeds balance.");
        }
    }

    public void printSummary() {
        System.out.println("Customer: " + name);
        System.out.println("Card number: " + number);
        System.out.println("Credit limit: $" + limit);
        System.out.println("Balance: $" + balance);
    }

    public String getNumber() { return number; }
}

public class CreditCardApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CreditCard[] customers = new CreditCard[2];

        
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter card number: ");
            String num = sc.nextLine();
            System.out.print("Enter credit limit: ");
            double limit = sc.nextDouble();
            sc.nextLine();
            customers[i] = new CreditCard(name, num, limit);
            System.out.println("Customer saved.\n");
        }

        int opt;
        do {
            System.out.println("\n1. Pay fee\n2. Print all\n3. Print one\n4. Exit");
            System.out.print("Option: ");
            opt = sc.nextInt(); sc.nextLine();

            if (opt == 1) {
                System.out.print("Enter card number: ");
                String num = sc.nextLine();
                System.out.print("Enter amount: ");
                double amt = sc.nextDouble(); sc.nextLine();
                for (CreditCard c : customers)
                    if (c.getNumber().equals(num)) c.makePayment(amt);
            } else if (opt == 2) {
                for (CreditCard c : customers) { c.printSummary(); System.out.println(); }
            } else if (opt == 3) {
                System.out.print("Enter card number: ");
                String num = sc.nextLine();
                for (CreditCard c : customers)
                    if (c.getNumber().equals(num)) c.printSummary();
            }
        } while (opt != 4);

        sc.close();
    }
}
