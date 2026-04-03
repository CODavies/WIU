import java.time.LocalDate;
import java.util.Scanner;

class Book {
    String name, author, publisher;
    int pages, stockPosition;
    double price;

    Book(String name, String author, String publisher, int pages, double price, int stockPosition) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.price = price;
        this.stockPosition = stockPosition;
    }

    void printBookInfo() {
        System.out.println("Name of the book: " + name);
        System.out.println("Author: " + author);
        System.out.println("Book publisher: " + publisher);
        System.out.println("Number of pages: " + pages);
        System.out.printf("Price: $%.2f%n", price);
        System.out.println("Copies available: " + stockPosition);
    }

    void calcCost(int copies, boolean online) {
        if (copies <= 0 || copies > stockPosition) {
            System.out.println("Sorry, this book is not available.");
            return;
        }

        System.out.printf("Total cost ($): %.2f%n", price * copies);

        if (online) {
            LocalDate d = LocalDate.now();
            LocalDate delivery = d.plusDays(4);
            System.out.println("Date of purchase: " + d.getMonthValue() + "/" + d.getDayOfMonth() + "/" + d.getYear());
            System.out.println("The expected delivery date is " + delivery.getMonthValue() + "/" + delivery.getDayOfMonth() + "/" + delivery.getYear());
        }

        stockPosition -= copies;
        System.out.println("The remaining stock of this book is " + stockPosition);
    }

    boolean match(String title) {
        return name.equalsIgnoreCase(title.trim());
    }
}

class EBook extends Book {
    double size;

    EBook(String name, String author, String publisher, int pages, double price, double size) {
        super(name, author, publisher, pages, price, 0);
        this.size = size;
    }

    @Override
    void printBookInfo() {
        System.out.println("Name of the book: " + name);
        System.out.println("Author: " + author);
        System.out.println("Book publisher: " + publisher);
        System.out.println("Number of pages: " + pages);
        System.out.printf("Price: $%.2f%n", price);
        System.out.printf("Size: %.2f MB%n", size);
    }

    @Override
    void calcCost(int copies, boolean online) {
        if (copies <= 0) copies = 1;
        System.out.printf("Total cost ($): %.2f%n", price * copies);
    }
}

public class BookShopProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name of the book: ");
        String bName = sc.nextLine();
        System.out.print("Enter the name of the author: ");
        String bAuthor = sc.nextLine();
        System.out.print("Enter the name of the publisher: ");
        String bPublisher = sc.nextLine();
        System.out.print("Enter the number of pages of the book: ");
        int bPages = sc.nextInt();
        System.out.print("Enter the price of the book ($): ");
        double bPrice = sc.nextDouble();
        System.out.print("Enter stock of this book: ");
        int bStock = sc.nextInt();
        sc.nextLine();

        Book book = new Book(bName, bAuthor, bPublisher, bPages, bPrice, bStock);

        System.out.print("Enter the name of the eBook: ");
        String eName = sc.nextLine();
        System.out.print("Enter the name of the author: ");
        String eAuthor = sc.nextLine();
        System.out.print("Enter the name of the publisher: ");
        String ePublisher = sc.nextLine();
        System.out.print("Enter the number of pages of the eBook: ");
        int ePages = sc.nextInt();
        System.out.print("Enter the price of the eBook ($): ");
        double ePrice = sc.nextDouble();
        System.out.print("Enter the size of the eBook (MB): ");
        double eSize = sc.nextDouble();
        sc.nextLine();

        EBook ebook = new EBook(eName, eAuthor, ePublisher, ePages, ePrice, eSize);

        Book ref;

        while (true) {
            System.out.println("1. Purchase book from bookshop");
            System.out.println("2. Purchase book online");
            System.out.println("3. Purchase e-Book");
            System.out.println("4. Exit");
            System.out.print("Enter your option: ");
            int opt = sc.nextInt();
            sc.nextLine();

            if (opt == 4) {
                System.out.println("Thank you!");
                break;
            }

            System.out.print("Enter the book name: ");
            String search = sc.nextLine();

            if (opt == 1 || opt == 2) {
                if (!book.match(search) || book.stockPosition == 0) {
                    System.out.println("Sorry, this book is not available.");
                    continue;
                }
                ref = book;
                ref.printBookInfo();
                System.out.print("Enter the number of copies: ");
                int copies = sc.nextInt();
                sc.nextLine();
                ref.calcCost(copies, opt == 2);
                System.out.println();
            } else if (opt == 3) {
                if (!ebook.match(search)) {
                    System.out.println("Sorry, this book is not available.");
                    continue;
                }
                ref = ebook;
                ref.printBookInfo();
                ref.calcCost(1, false);
                System.out.println();
            }
        }

        sc.close();
    }
}