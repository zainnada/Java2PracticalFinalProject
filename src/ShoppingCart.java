import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Item> cartItems = new ArrayList<>();

    public void addItem(Item item) {
        cartItems.add(item);
    }

    public void removeItemByObject(Item item) {
        cartItems.remove(item);
    }

    public void removeItemByIndex(int index) {
        cartItems.remove(index);
    }

    public void emptyCart(){
        cartItems.clear();
    }

    public Item findCartItemByIndex(int index){
        return cartItems.get(index);
    }

    public Item findCartItemByNumber(String number){
        Item item = null;
        for (Item item11: getCartItems()) {
            item = item11;
            if (item11.getItemNumber().equals(number)){
                break;
            }
        }
        return item;
    }

    public ArrayList<Item> getCartItems() {
        return cartItems;
    }

}
