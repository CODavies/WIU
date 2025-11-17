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
        System.out.println("Name of the book: " + name);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("Number of pages: " + pages);
        System.out.println("Price: $" + price);
    }
}

class EBook extends Book {
    double size;

    EBook(String name, String author, String publisher, int pages, double price, double size) {
        super(name, author, publisher, pages, price);
        this.size = size;
    }

    @Override
    void printBookInfo() {
        super.printBookInfo();
        System.out.println("Size: " + size + " MB");
    }
}

public class Book_Assignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name of the book: ");
        String bookName = sc.nextLine();
        System.out.print("Enter the name of the author: ");
        String bookAuthor = sc.nextLine();
        System.out.print("Enter the name of the publisher: ");
        String bookPublisher = sc.nextLine();
        System.out.print("Enter the number of pages of the book: ");
        int bookPages = sc.nextInt();
        System.out.print("Enter the price of the book ($): ");
        double bookPrice = sc.nextDouble();
        sc.nextLine(); 

        Book book = new Book(bookName, bookAuthor, bookPublisher, bookPages, bookPrice);
        System.out.print("Enter the name of the eBook: ");
        String ebookName = sc.nextLine();
        System.out.print("Enter the name of the author: ");
        String ebookAuthor = sc.nextLine();
        System.out.print("Enter the name of the publisher: ");
        String ebookPublisher = sc.nextLine();
        System.out.print("Enter the number of pages of the eBook: ");
        int ebookPages = sc.nextInt();
        System.out.print("Enter the price of the eBook ($): ");
        double ebookPrice = sc.nextDouble();
        System.out.print("Enter the size of the eBook (MB): ");
        double ebookSize = sc.nextDouble();

        EBook ebook = new EBook(ebookName, ebookAuthor, ebookPublisher, ebookPages, ebookPrice, ebookSize);
        System.out.println("\nThe book information:");
        book.printBookInfo();
        System.out.println("\nThe eBook information:");
        ebook.printBookInfo();

        sc.close();
    }
}
