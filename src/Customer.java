public class Customer {
    private String customerName;
    private String customerNumber;
    private ShoppingCart cart;

    public Customer(String customerNumber, String customerName){
        setCustomerName(customerName);
        setCustomerNumber(customerNumber);
        cart = new ShoppingCart();
    }

    public void customerInfo(){
        System.out.println("The customer no: " + getCustomerNumber() + ", The customer name: " + getCustomerName());
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void addAnItem(Item item){
        cart.addItem(item);
    }

    public void emptyCart(){
        cart.emptyCart();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
}
