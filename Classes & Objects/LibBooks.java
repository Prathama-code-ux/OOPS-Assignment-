import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LibBooks {
    static class Book {
        private String title;
        private String[] authors;
        private int numpages;
        private double price;
        private String publisher;
        private String ISBN;

        public Book(String title, String[] authors, int numpages, double price, String publisher, String ISBN) {
            this.title = title;
            this.authors = authors;
            this.numpages = numpages;
            this.price = price;
            this.publisher = publisher;
            this.ISBN = ISBN;
        }

        public String getTitle() { return title; }
        public String[] getAuthors() { return authors; }
        public int getNumpages() { return numpages; }
        public double getPrice() { return price; }
        public String getPublisher() { return publisher; }
        public String getISBN() { return ISBN; }

        public void setTitle(String title) { this.title = title; }
        public void setAuthors(String[] authors) { this.authors = authors; }
        public void setNumpages(int numpages) { this.numpages = numpages; }
        public void setPrice(double price) { this.price = price; }
        public void setPublisher(String publisher) { this.publisher = publisher; }
        public void setISBN(String ISBN) { this.ISBN = ISBN; }
    }

    static class Library {
        private ArrayList<Book> books = new ArrayList<>();

        public void addBook(Book b) {
            books.add(b);
        }

        public void removeBook(String isbn) {
            books.removeIf(b -> b.getISBN().equals(isbn));
        }

        public double getTotalPrice() {
            double total = 0;
            for (Book b : books) {
                total += b.getPrice();
            }
            return total;
        }

        public void printCopiesAvailable() {
            Map<String, Integer> countMap = new HashMap<>();
            Map<String, String> isbnToTitle = new HashMap<>();
            for (Book b : books) {
                countMap.put(b.getISBN(), countMap.getOrDefault(b.getISBN(), 0) + 1);
                isbnToTitle.put(b.getISBN(), b.getTitle());
            }
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                System.out.println("Book: " + isbnToTitle.get(entry.getKey()) + " (ISBN: " + entry.getKey() + ") - Copies: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new Book("Book A", new String[]{"Author 1"}, 200, 25.5, "Publisher X", "1111"));
        lib.addBook(new Book("Book B", new String[]{"Author 2"}, 350, 45.0, "Publisher Y", "2222"));
        lib.addBook(new Book("Book A", new String[]{"Author 1"}, 200, 25.5, "Publisher X", "1111"));

        System.out.println("Total Price: " + lib.getTotalPrice());
        lib.printCopiesAvailable();
    }
}
