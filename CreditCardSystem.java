import java.util.Scanner;

class CreditCard {
    private String customerName;
    private String cardNumber;
    private double creditLimit;
    private double currentBalance;

    public CreditCard(String customerName, String cardNumber, double creditLimit) {
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
            System.out.println("The transaction is successful. The card balance is $" + formatMoney(currentBalance) + ".");
        } else {
            System.out.println("The transaction is unsuccessful. The transaction balance exceeds the card balance.");
        }
    }

    public void printSummary() {
        System.out.println("Customer name: " + customerName);
        System.out.println("Card number: " + cardNumber);
        System.out.println("Credit limit ($): " + formatMoney(creditLimit));
        System.out.println("Card balance ($): " + formatMoney(currentBalance));
    }

    public String getCardNumber() {
        return cardNumber;
    }

    private String formatMoney(double value) {
        if (value == Math.rint(value)) return String.format("%.0f", value);
        return String.format("%.2f", value);
    }
}

public class Main {
    private static final int SIZE = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CreditCard[] customers = new CreditCard[SIZE];

        customers[0] = readCustomer(sc, "first");
        System.out.println("The customer information is saved successfully.");
        customers[0].printSummary();

        customers[1] = readCustomer(sc, "second");
        System.out.println("The customer information is saved successfully.");
        customers[1].printSummary();

        while (true) {
            printMenu();
            System.out.print("Enter your option: ");
            int option = readIntSafe(sc);

            if (option == 1) {
                System.out.print("Enter the card number: ");
                String cardNum = sc.nextLine().trim();

                CreditCard cc = findByCardNumber(customers, cardNum);
                if (cc == null) {
                    System.out.println("Card not found.");
                    continue;
                }

                System.out.print("Enter the transaction fee ($): ");
                double fee = readDoubleSafe(sc);
                cc.makePayment(fee);

            } else if (option == 2) {
                for (CreditCard c : customers) {
                    c.printSummary();
                }

            } else if (option == 3) {
                System.out.print("Enter the card number: ");
                String cardNum = sc.nextLine().trim();

                CreditCard cc = findByCardNumber(customers, cardNum);
                if (cc == null) {
                    System.out.println("Card not found.");
                } else {
                    cc.printSummary();
                }

            } else if (option == 4) {
                System.out.println("Thank you!");
                break;

            } else {
                System.out.println("Invalid option. Please enter 1-4.");
            }
        }

        sc.close();
    }

    private static CreditCard readCustomer(Scanner sc, String which) {
        System.out.print("Enter the name of " + which + " customer: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter the card number: ");
        String cardNum = sc.nextLine().trim();

        System.out.print("Enter the credit limit ($): ");
        double limit = readDoubleSafe(sc);

        return new CreditCard(name, cardNum, limit);
    }

    private static void printMenu() {
        System.out.println("1. Pay the transaction fee");
        System.out.println("2. Print all customers’ information");
        System.out.println("3. Print individual customer’s information");
        System.out.println("4. Exit");
    }

    private static CreditCard findByCardNumber(CreditCard[] customers, String cardNumber) {
        for (CreditCard c : customers) {
            if (c != null && c.getCardNumber().equals(cardNumber)) return c;
        }
        return null;
    }

    private static int readIntSafe(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid integer: ");
            }
        }
    }

    private static double readDoubleSafe(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
