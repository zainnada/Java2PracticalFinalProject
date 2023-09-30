public class Shoe extends Item{
    private int size;
    private String color;

    public Shoe(String itemName, String itemNumber, int itemQuantity, double itemPrice, String color, int size) {
        super(itemName, itemNumber, itemQuantity, itemPrice);
        setColor(color);
        setSize(size);
        super.setType("Shoes");
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void itemDetails(){
        super.itemDetails();
        System.out.println(", size: "+getSize()+", color: "+getColor());
    }
}
