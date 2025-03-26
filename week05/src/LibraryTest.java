public class LibraryTest {
    public static void processItem(Item item) {
        item.borrow();
        item.getItemDetails();
        item.returnItem();

        if (item instanceof Reservable) {
            ((Reservable) item).reserve();
        }

        System.out.println(item.getIdentifier());
    }

    public static void main(String[] args) {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890");
        Magazine magazine = new Magazine("National Geographic", "2022-09", "September 2022");

        System.out.println("\nProcessing Book:");
        processItem(book);

        System.out.println("\nProcessing Magazine:");
        processItem(magazine);

        System.out.println("\nIdentifier of the book: " + book.getIdentifier());
        System.out.println("Identifier of the magazine: " + magazine.getIdentifier());
    }
}