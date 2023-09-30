public class Item {
    private String itemName;
    private String itemNumber;
    private int itemQuantity;
    private double itemPrice;
    private String type;

    public Item(String itemName, String itemNumber, int itemQuantity, double itemPrice){
        setItemName(itemName);
        setItemNumber(itemNumber);
        setItemPrice(itemPrice);
        setItemQuantity(itemQuantity);
        type="Item";
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String itemInfo(){
        return ("The item is ["+getItemNumber() +" "+getItemName()+ " "+ getType() +
                " ["+getItemQuantity()+"]]");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void itemDetails(){
        System.out.print("The item is ["+getItemNumber() +" "+getItemName()+ " "+ getType() + " ["+getItemQuantity()+"]]");
    }
}

