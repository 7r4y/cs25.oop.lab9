import java.util.*;
import java.util.stream.Collectors;

// Book class
class Book {
    private String title;
    private int year;

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}

// Library class
public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(String title, int year) {
        books.add(new Book(title, year));
    }

    // Inner class: BookShelf
    class BookShelf implements Iterable<Book> {
        private int minYear;

        public BookShelf(int minYear) {
            this.minYear = minYear;
        }

        @Override
        public Iterator<Book> iterator() {
            // minYear-с хойшхи номнуудыг буцаах
            return books.stream()
                    .filter(b -> b.getYear() > minYear)
                    .iterator();
        }
    }

    public BookShelf getRecentBooks(int minYear) {
        return new BookShelf(minYear);
    }

    // Туршилтын main
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook("Suun zam", 2020);
        lib.addBook("Huuchin nom", 1995);

        for (Book b : lib.getRecentBooks(2000)) {
            System.out.println(b.getTitle() + ": " + b.getYear());
        }
    }
}