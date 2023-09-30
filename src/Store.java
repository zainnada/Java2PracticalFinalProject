import java.util.ArrayList;

public class Store {

    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void menu() {
        System.out.println("*********************");
        System.out.println("* Store System Menu *");
        System.out.println("*********************");
        System.out.println("1. Add a new Item to Store");
        System.out.println("2. Add a new Customer to Store");
        System.out.println("3. Add an item to Customer shopping cart");
        System.out.println("4. Remove an item from Customer shopping cart");
        System.out.println("5. View the items in Customer shopping cart");
        System.out.println("6. Modify customer data");
        System.out.println("7. Empty Customer shopping cart");
        System.out.println("8. End shopping and go to checkout");
        System.out.println("9. Exit the program.");
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addItemToCustomerCart(Item item, Customer customer) {//////////////
        customer.addAnItem(item);
    }

    public Item findItemByIndex(int index) {
        return items.get(index);
    }

    public Item findItemByNo(String no) {
        Item item1 = null;
        for (Item item : items) {
            item1 = item;
            if (item.getItemNumber().equals(no)) {
                break;
            }
        }
        return item1;
    }

    public Customer findCustomerByNo(String number) {
        Customer c = null;
        for (Customer customer : customers) {
            c = customer;
            if (customer.getCustomerNumber().equals(number)) {
                break;
            }
        }
        return c;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public boolean customerExist(String customerNumber) {
        for (Customer customer : customers) {
            if (customer.getCustomerNumber().equals(customerNumber)) {
                return true;
            }
        }
        return false;
    }

    public boolean itemExist(String itemNumber) {
        for (Item item : items) {
            if (item.getItemNumber().equals(itemNumber)) {
                return true;
            }
        }
        return false;
    }

    public void itemsList() {
        int c = 1;
        System.out.println("Items in the store");
        for (Item item : items) {
            System.out.println(">>> " + (c++) + ". " + item.getItemNumber() + " " + item.getItemName() + " " + item.getType() +
                    ". [" + item.getItemQuantity() + "]");
        }
        System.out.println(">>> 0. Return to main menu");
    }

    public String itemInfo(int index) {
        return ("The item is [" + items.get(index).getItemNumber() + " " + items.get(index).getItemName() +
                " [" + items.get(index).getItemQuantity() + "]]");
    }

    public void customerCartList(String no) {
        int c = 1;
        for (Item item : findCustomerByNo(no).getCart().getCartItems()) {
            System.out.println(">>> " + (c++) + ". " + item.getItemNumber() + " " + item.getItemName() + ". [" + item.getItemQuantity() + "]");
        }

    }

    public boolean checkItemQuantity(int index, int quantity) {
        if (items.get(index).getItemQuantity() >= quantity) {
            return true;
        }
        return false;
    }

    public void removeCustomerByNumber(String number) {
        customers.remove(findCustomerByNo(number));
    }

    public boolean itemExistInCustomerCart(String customerNumber, String itemNumber) {
        Customer c = findCustomerByNo(customerNumber);
        for (Item item : c.getCart().getCartItems()) {
            if (item.getItemNumber().equals(itemNumber)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkItemsAndCustomers() {
        if (getItems().isEmpty() && getCustomers().isEmpty()) {
            System.out.println("There is no Customers and Items in the Store yet.");
            return true;
        } else if (getItems().isEmpty()) {
            System.out.println("There is no Items in the store yet.");
            return true;
        } else if (getCustomers().isEmpty()) {
            System.out.println("There is no Customers in the store yet.");
            return true;
        }
        return false;
    }

    public boolean checkCustomersCart() {
        for (Customer customer : getCustomers()) {
            if (!customer.getCart().getCartItems().isEmpty()) {
                return false;
            }
        }
        System.out.println("There is no items in any customer cart!");
        return true;
    }

    public boolean checkCustomers() {
        if (getCustomers().isEmpty()) {
            System.out.println("There is no Customers in the store yet.");
            return true;
        }
        return false;
    }

}
