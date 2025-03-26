public class Magazine extends Item {
    private String issueNumber;
    private String publicationDate;

    public Magazine(String title, String issueNumber, String publicationDate) {
        super(title);
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
        System.out.println("Magazine constructor called.");
    }

    @Override
    public void borrow() {
        System.out.println("Borrowing the magazine: " + getTitle());
    }

    @Override
    public void returnItem() {
        System.out.println("Returning the magazine: " + getTitle());
    }

    @Override
    public Magazine getItemDetails() {
        System.out.println("Magazine: " + getTitle() + ", Issue Number: " + issueNumber + ", Publication Date: " + publicationDate);
        return this;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getIssueNumber() {
        return issueNumber;
    }
}