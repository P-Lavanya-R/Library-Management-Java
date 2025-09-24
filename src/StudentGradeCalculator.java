import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    boolean isAvailable;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter book ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter book title: ");
                String title = sc.nextLine();
                books.add(new Book(id, title));
                System.out.println("Book added!");
            } else if (choice == 2) {
                for (Book b : books) {
                    System.out.println(b.id + " - " + b.title + " (" + (b.isAvailable ? "Available" : "Borrowed") + ")");
                }
            } else if (choice == 3) {
                System.out.print("Enter book ID to borrow: ");
                int id = sc.nextInt();
                boolean found = false;
                for (Book b : books) {
                    if (b.id == id && b.isAvailable) {
                        b.isAvailable = false;
                        found = true;
                        System.out.println("Book borrowed successfully!");
                        break;
                    }
                }
                if (!found) System.out.println("Book not available!");
            } else if (choice == 4) {
                System.out.print("Enter book ID to return: ");
                int id = sc.nextInt();
                boolean found = false;
                for (Book b : books) {
                    if (b.id == id && !b.isAvailable) {
                        b.isAvailable = true;
                        found = true;
                        System.out.println("Book returned!");
                        break;
                    }
                }
                if (!found) System.out.println("Invalid ID or book not borrowed!");
            } else if (choice == 5) {
                System.out.println("Exiting Library...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
