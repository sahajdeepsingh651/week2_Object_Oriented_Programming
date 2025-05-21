import java.util.ArrayList;

class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library {
    String libraryName;
    ArrayList<Book> books;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        System.out.println("Books in " + libraryName + ":");
        for (Book book : books) {
            book.displayBook();
        }
    }
}

class LibraryAggregationDemo {
    public static void main(String[] args) {
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book b3 = new Book("The Great Gatsby", "F. Scott Fitzgerald");

        Library cityLibrary = new Library("City Library");
        Library schoolLibrary = new Library("School Library");

        cityLibrary.addBook(b1);
        cityLibrary.addBook(b2);

        schoolLibrary.addBook(b2); // shared book
        schoolLibrary.addBook(b3);

        cityLibrary.showBooks();
        System.out.println();
        schoolLibrary.showBooks();
    }
}
