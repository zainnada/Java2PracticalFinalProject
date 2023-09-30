public class Book extends Item{
    private String title;
    private String author;

    public Book(String itemName, String itemNumber, int itemQuantity, double itemPrice, String title, String author) {
        super(itemName, itemNumber, itemQuantity, itemPrice);
        setAuthor(author);
        setTitle(title);
        super.setType("Book");
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

    @Override
    public void itemDetails(){
        super.itemDetails();
        System.out.println(", Title: "+getTitle()+", Author: "+getAuthor());
    }
}