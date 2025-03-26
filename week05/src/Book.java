public class Book extends Item implements Reservable {
    private String author;
    private String ISBN;

    public Book(String title, String author, String ISBN) {
        super(title);
        this.author = author;
        this.ISBN = ISBN;
        System.out.println("Book constructor called.");
    }

    @Override
    public void borrow() {
        System.out.println("Borrowing the book: " + getTitle());
    }

    @Override
    public void returnItem() {
        System.out.println("Returning the book: " + getTitle());
    }

    @Override
    public Book getItemDetails() {
        System.out.println("Book: " + getTitle() + ", Author: " + author + ", ISBN: " + ISBN);
        return this;
    }

    @Override
    public void reserve() {
        System.out.println("Reserving the book: " + getTitle());
    }

    public String getISBN() {
        return ISBN;
    }
}