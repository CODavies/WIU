import java.util.Scanner;

class Book {
    String name;
    String author;
    String publisher;
    int pages;
    double price;

    Book(String name, String author, String publisher, int pages, double price) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.price = price;
    }

    void printBookInfo() {
        System.out.println("The book information:");
        System.out.println("Name of the book: " + name);
        System.out.println("Author: " + author);
        System.out.println("Book publisher: " + publisher);
        System.out.println("Number of pages: " + pages);
        System.out.printf("Price: $%.2f%n", price);
    }
}

class EBook extends Book {
    double bookSize;

    EBook(String name, String author, String publisher, int pages, double price, double bookSize) {
        super(name, author, publisher, pages, price);
        this.bookSize = bookSize;
    }

    @Override
    void printBookInfo() {
        System.out.println("The eBook information:");
        System.out.println("Name of the book: " + name);
        System.out.println("Author: " + author);
        System.out.println("Book publisher: " + publisher);
        System.out.println("Number of pages: " + pages);
        System.out.printf("Price: $%.2f%n", price);
        System.out.printf("Size: %.2f MB%n", bookSize);
    }
}

public class Book_Assignment {
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
        sc.nextLine();

        Book book = new Book(bName, bAuthor, bPublisher, bPages, bPrice);

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

        EBook ebook = new EBook(eName, eAuthor, ePublisher, ePages, ePrice, eSize);

        book.printBookInfo();
        ebook.printBookInfo();

        sc.close();
    }
}