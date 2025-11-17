import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class PhotoNode {
    String fileName;
    Date date;
    PhotoNode next;
    PhotoNode prev;

    public PhotoNode(String fileName, Date date) {
        this.fileName = fileName;
        this.date = date;
        this.next = null;
        this.prev = null;
    }
}

public class DigitalPhotoFrameApp {
    private PhotoNode head;
    private PhotoNode tail;
    private PhotoNode current;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    private int lastChoice = -1;

    public void insertPhoto(String fileName, Date date) {
        PhotoNode newNode = new PhotoNode(fileName, date);

        if (head == null) {
            head = tail = newNode;
        } else if (date.before(head.date)) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            PhotoNode temp = head;
            while (temp.next != null && !date.before(temp.next.date)) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newNode;
            } else {
                tail = newNode;
            }
            temp.next = newNode;
        }

        System.out.println("The photo has been added successfully.");
    }

    public void viewNextPhoto() {
        if (head == null) {
            System.out.println("No more photo to show.");
            return;
        }

        if (lastChoice == 1 || lastChoice == 4 || current == null) {
            current = head;
        } else if (current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more photo to show.");
            return;
        }

        System.out.println("The photo file name: " + current.fileName);
        System.out.println("The photo date: " + sdf.format(current.date));
    }

    public void viewPreviousPhoto() {
        if (tail == null) {
            System.out.println("No more photo to show.");
            return;
        }

        if (lastChoice == 1 || lastChoice == 4 || current == null) {
            current = tail;
        } else if (current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more photo to show.");
            return;
        }

        System.out.println("The photo file name: " + current.fileName);
        System.out.println("The photo date: " + sdf.format(current.date));
    }

    public boolean deletePhotoByDate(Date targetDate) {
        if (head == null) return false;

        PhotoNode temp = head;
        while (temp != null && !temp.date.equals(targetDate)) {
            temp = temp.next;
        }

        if (temp == null) return false;

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else {
            temp.prev.next = temp.next;
        }

        if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (current == temp) current = null;

        return true;
    }

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        DigitalPhotoFrameApp app = new DigitalPhotoFrameApp();

        int choice;
        do {
            System.out.println("Press 1 to insert a photo");
            System.out.println("Press 2 to view the next photo");
            System.out.println("Press 3 to view the previous photo");
            System.out.println("Press 4 to delete a photo");
            System.out.println("Press 5 to close the app");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Enter your choice: ");
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the photo file: ");
                    String fileName = sc.nextLine();

                    System.out.print("Enter the photo date: ");
                    String dateStr = sc.next();
                    sc.nextLine();

                    try {
                        Date date = app.sdf.parse(dateStr);
                        app.insertPhoto(fileName, date);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use MM/dd/yyyy.");
                    }
                    app.lastChoice = 1;
                    break;

                case 2:
                    app.viewNextPhoto();
                    app.lastChoice = 2;
                    break;

                case 3:
                    app.viewPreviousPhoto();
                    app.lastChoice = 3;
                    break;

                case 4:
                    System.out.print("Enter the photo date: ");
                    String delDateStr = sc.next();
                    sc.nextLine();

                    try {
                        Date date = app.sdf.parse(delDateStr);
                        if (app.deletePhotoByDate(date)) {
                            System.out.println("The photo has been deleted successfully.");
                        } else {
                            System.out.println("Photo with the given date not found.");
                        }
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use MM/dd/yyyy.");
                    }
                    app.lastChoice = 4;
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
