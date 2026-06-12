import java.util.*;

abstract class Publication{
    private int noofpages;
    private double price;
    private String publishername;

    public Publication(int noofpages, double price, String publishername){
        this.noofpages = noofpages;
        this.price = price;
        this.publishername = publishername;
    }

    public int getNoofpages() { return noofpages; }
    public double getPrice() { return price; }
    public String getPublishername() { return publishername; }

    public abstract void display();
}

class Book extends Publication{
    private String title;

    public Book(String title, int pages, double price, String publisher){
        super(pages, price, publisher);
        this.title = title;
    }

    public void display(){
        System.out.println("Book: " + title +
                ", Pages: " + getNoofpages() +
                ", Price: " + getPrice() +
                ", Publisher: " + getPublishername());
    }
}

class Journal extends Publication{
    private int issuenumber;

    public Journal(int issuenumber, int pages, double price, String publisher){
        super(pages, price, publisher);
        this.issuenumber = issuenumber;
    }

    public void display(){
         System.out.println("Journal Issue: " + issuenumber +
                ", Pages: " + getNoofpages() +
                ", Price: " + getPrice() +
                ", Publisher: " + getPublishername());
    }
}

class Library{
    private List<Publication> publications = new ArrayList<>();

    public void addPublication(Publication p){
        publications.add(p);
    }
    public void displayAll(){
        for(Publication p: publications){
            p.display();
        }
    }
}

public class Books {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addPublication(new Book("Java Basics", 300, 500, "ABC"));
        lib.addPublication(new Book("DSA", 450, 700, "XYZ"));
        lib.addPublication(new Book("OOP Concepts", 350, 600, "PQR"));

        lib.addPublication(new Journal(101, 120, 200, "SciencePub"));
        lib.addPublication(new Journal(102, 150, 250, "TechPub"));

        lib.displayAll();
    }
}

