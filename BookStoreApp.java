import java.util.Scanner;
import java.time.LocalDate;

class Book {
    private String title;
    private String author;
    private String publisher;
    private int pages;
    private int stock;
    protected double price;

    Book(String title, String author, String publisher, int pages, double price, int stock) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.price = price;
        this.stock = stock;
    }

    String getTitle() {
        return title;
    }

    void printBookInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("Number of Pages: " + pages);
        System.out.println("Price: $" + price);
        System.out.println("Copies Available: " + stock);
    }

    void calculateCost(int copies, boolean isOnlinePurchase) {
        if (copies <= stock) {
            double totalCost = copies * price;
            System.out.println("Total Cost ($): " + totalCost);
            stock -= copies;
            System.out.println("Remaining Stock: " + stock);
            if (isOnlinePurchase) {
                LocalDate purchaseDate = LocalDate.now();
                LocalDate deliveryDate = purchaseDate.plusDays(4);
                System.out.println("Date of Purchase: " + purchaseDate);
                System.out.println("Expected Delivery Date: " + deliveryDate);
            }
        } else {
            System.out.println("Sorry, insufficient stock available.");
        }
    }
}

class EBook extends Book {
    private double sizeMB;

    EBook(String title, String author, String publisher, int pages, double price, double sizeMB) {
        super(title, author, publisher, pages, price, Integer.MAX_VALUE);
        this.sizeMB = sizeMB;
    }

    @Override
    void printBookInfo() {
        super.printBookInfo();
        System.out.println("File Size: " + sizeMB + " MB");
    }

    @Override
    void calculateCost(int copies, boolean isOnlinePurchase) {
        double totalCost = copies * price;
        System.out.println("Total Cost ($): " + totalCost);
    }
}

public class BookStoreApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the book: ");
        String bookTitle = scanner.nextLine();
        System.out.print("Enter the author: ");
        String bookAuthor = scanner.nextLine();
        System.out.print("Enter the publisher: ");
        String bookPublisher = scanner.nextLine();
        System.out.print("Enter the number of pages: ");
        int bookPages = scanner.nextInt();
        System.out.print("Enter the price ($): ");
        double bookPrice = scanner.nextDouble();
        System.out.print("Enter stock: ");
        int bookStock = scanner.nextInt();
        scanner.nextLine();
        Book book = new Book(bookTitle, bookAuthor, bookPublisher, bookPages, bookPrice, bookStock);

        System.out.print("Enter the name of the eBook: ");
        String ebookTitle = scanner.nextLine();
        System.out.print("Enter the author: ");
        String ebookAuthor = scanner.nextLine();
        System.out.print("Enter the publisher: ");
        String ebookPublisher = scanner.nextLine();
        System.out.print("Enter the number of pages: ");
        int ebookPages = scanner.nextInt();
        System.out.print("Enter the price ($): ");
        double ebookPrice = scanner.nextDouble();
        System.out.print("Enter the size (MB): ");
        double ebookSize = scanner.nextDouble();
        EBook ebook = new EBook(ebookTitle, ebookAuthor, ebookPublisher, ebookPages, ebookPrice, ebookSize);

        int option;
        do {
            System.out.println("\n--- Book Store Menu ---");
            System.out.println("1. Purchase Book (In-store)");
            System.out.println("2. Purchase Book (Online)");
            System.out.println("3. Purchase eBook");
            System.out.println("4. Exit");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                case 2:
                    System.out.print("Enter the book title: ");
                    String searchBook = scanner.nextLine();
                    if (searchBook.equalsIgnoreCase(book.getTitle())) {
                        book.printBookInfo();
                        System.out.print("Enter number of copies: ");
                        int copies = scanner.nextInt();
                        book.calculateCost(copies, option == 2);
                    } else {
                        System.out.println("Sorry, this book is not available.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the eBook title: ");
                    String searchEBook = scanner.nextLine();
                    if (searchEBook.equalsIgnoreCase(ebook.getTitle())) {
                        ebook.printBookInfo();
                        System.out.print("Enter number of copies: ");
                        int copies = scanner.nextInt();
                        ebook.calculateCost(copies, true);
                    } else {
                        System.out.println("Sorry, this eBook is not available.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for visiting the Book Store!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);

        scanner.close();
    }
}
