public abstract class Item {
    private String title;

    public Item(String title) {
        this.title = title;
        System.out.println("Item constructor called.");
    }

    public abstract void borrow();
    public abstract void returnItem();

    public Item getItemDetails() {
        return this;
    }

    public final String getIdentifier() {
        return "Item Identifier: " + title;
    }

    public String getTitle() {
        return title;
    }
}