// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getter and Setter methods (Encapsulation)
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Concrete method to get item details
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    // Abstract method to get loan duration
    public abstract int getLoanDuration();
}

// Interface Reservable
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Book subclass
class Book extends LibraryItem implements Reservable {
    private int loanDuration; // Loan duration for Book in days

    // Constructor
    public Book(String itemId, String title, String author, int loanDuration) {
        super(itemId, title, author);
        this.loanDuration = loanDuration;
    }

    @Override
    public int getLoanDuration() {
        return loanDuration; // Return loan duration for the book
    }

    @Override
    public void reserveItem() {
        System.out.println("The book \"" + getTitle() + "\" has been reserved.");
    }

    @Override
    public boolean checkAvailability() {
        System.out.println("Checking availability for the book \"" + getTitle() + "\"...");
        return true; // Assuming the book is available for simplicity
    }
}

// Magazine subclass
class Magazine extends LibraryItem implements Reservable {
    private int loanDuration; // Loan duration for Magazine in days

    // Constructor
    public Magazine(String itemId, String title, String author, int loanDuration) {
        super(itemId, title, author);
        this.loanDuration = loanDuration;
    }

    @Override
    public int getLoanDuration() {
        return loanDuration; // Return loan duration for the magazine
    }

    @Override
    public void reserveItem() {
        System.out.println("The magazine \"" + getTitle() + "\" has been reserved.");
    }

    @Override
    public boolean checkAvailability() {
        System.out.println("Checking availability for the magazine \"" + getTitle() + "\"...");
        return true; // Assuming the magazine is available for simplicity
    }
}

// DVD subclass
class DVD extends LibraryItem implements Reservable {
    private int loanDuration; // Loan duration for DVD in days

    // Constructor
    public DVD(String itemId, String title, String author, int loanDuration) {
        super(itemId, title, author);
        this.loanDuration = loanDuration;
    }

    @Override
    public int getLoanDuration() {
        return loanDuration; // Return loan duration for the DVD
    }

    @Override
    public void reserveItem() {
        System.out.println("The DVD \"" + getTitle() + "\" has been reserved.");
    }

    @Override
    public boolean checkAvailability() {
        System.out.println("Checking availability for the DVD \"" + getTitle() + "\"...");
        return true; // Assuming the DVD is available for simplicity
    }
}

// Main class to test the Library Management System
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create instances of LibraryItems (polymorphism)
        LibraryItem book = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", 14);
        LibraryItem magazine = new Magazine("M001", "National Geographic", "Various", 7);
        LibraryItem dvd = new DVD("D001", "Inception", "Christopher Nolan", 3);

        // Array of LibraryItem to demonstrate polymorphism
        LibraryItem[] items = { book, magazine, dvd };

        // Process each item, display details, and handle reservations
        for (LibraryItem item : items) {
            System.out.println("\nItem Details:");
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            // Check availability and reserve the item if available
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                if (reservableItem.checkAvailability()) {
                    reservableItem.reserveItem();
                }
            }
        }
    }
}
