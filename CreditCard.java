import java.util.Scanner;

class Card {
    private String customerName;
    private String cardNumber;
    private double creditLimit;
    private double currentBalance;

    public Card(String customerName, String cardNumber, double creditLimit) {
        this.customerName = customerName;
        this.cardNumber = cardNumber;
        this.creditLimit = creditLimit;
        this.currentBalance = creditLimit;
    }

    private boolean pmtApprove(double transactionAmount) {
        return transactionAmount <= currentBalance;
    }

    public void makePayment(double transactionAmount) {
        if (pmtApprove(transactionAmount)) {
            currentBalance -= transactionAmount;
            System.out.println("The transaction is successful. The card balance is $" + currentBalance + ".");
        } else {
            System.out.println("The transaction is unsuccessful. The transaction balance exceeds the card balance.");
        }
    }

    public void printSummary() {
        System.out.println("Customer name: " + customerName);
        System.out.println("Card number: " + cardNumber);
        System.out.println("Credit limit ($): " + creditLimit);
        System.out.println("Card balance ($): " + currentBalance);
    }

    public String getCardNumber() {
        return cardNumber;
    }
}

public class CreditCard {
    private static final int SIZE = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Card[] customers = new Card[SIZE];

        customers[0] = readCustomer(sc, "first");
        System.out.println("The customer information is saved successfully.");
        customers[0].printSummary();

        customers[1] = readCustomer(sc, "second");
        System.out.println("The customer information is saved successfully.");
        customers[1].printSummary();

        while (true) {
            System.out.println("1. Pay the transaction fee");
            System.out.println("2. Print all customers’ information");
            System.out.println("3. Print individual customer’s information");
            System.out.println("4. Exit");
            System.out.print("Enter your option: ");
            int option = Integer.parseInt(sc.nextLine());

            if (option == 1) {
                System.out.print("Enter the card number: ");
                String cardNum = sc.nextLine();

                Card cc = findByCardNumber(customers, cardNum);
                if (cc == null) {
                    System.out.println("Card not found.");
                    continue;
                }

                System.out.print("Enter the transaction fee ($): ");
                double fee = Double.parseDouble(sc.nextLine());
                cc.makePayment(fee);

            } else if (option == 2) {
                for (Card c : customers) {
                    c.printSummary();
                }

            } else if (option == 3) {
                System.out.print("Enter the card number: ");
                String cardNum = sc.nextLine();

                Card cc = findByCardNumber(customers, cardNum);
                if (cc == null) {
                    System.out.println("Card not found.");
                } else {
                    cc.printSummary();
                }

            } else if (option == 4) {
                System.out.println("Thank you!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        sc.close();
    }

    private static Card readCustomer(Scanner sc, String which) {
        System.out.print("Enter the name of " + which + " customer: ");
        String name = sc.nextLine();

        System.out.print("Enter the card number: ");
        String cardNum = sc.nextLine();

        System.out.print("Enter the credit limit ($): ");
        double limit = Double.parseDouble(sc.nextLine());

        return new Card(name, cardNum, limit);
    }

    private static Card findByCardNumber(Card[] customers, String cardNumber) {
        for (Card c : customers) {
            if (c != null && c.getCardNumber().equals(cardNumber))
                return c;
        }
        return null;
    }
}
