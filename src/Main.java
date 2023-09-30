import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Store store = new Store();

        int quantity, year = 0, size = 0, choice;
        double price;
        String name, number, color="", title = "", author="";
        char type;
        Item item, newItem;
        Customer customer;
        boolean flag;
        int type_no;

        //  virtual data for testing
        {
            // items
            store.addItem(new Book("book1", "i001", 5, 50.2, "title1", "author1"));
            store.addItem(new Shoe("shoe1", "i002", 3, 80.0, "color1", 45));
            store.addItem(new Game("game1", "i003", 35, 10.5, 2020));
            store.addItem(new Book("book2", "i004", 7, 44.7, "title3", "author3"));
            store.addItem(new Game("game2", "i005", 20, 5.3, 2019));
            store.addItem(new Game("game3", "i006", 22, 7.7, 2022));
            // customers
            store.addCustomer(new Customer("c001", "ahmed saeed"));
            store.addCustomer(new Customer("c002", "khaled khaled"));
            store.addCustomer(new Customer("c003", "Sam John"));
        }

        outer:
        while (true) {
            try {
                store.menu();
                System.out.print("Enter Your Choice: ");
                choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1: {
                        System.out.println("* Add Item Operation *");
                        case1:
                        while (true) {
                            type:
                            while (true) {

                                type_no = 0;
                                System.out.print("Enter the type of item (B)Book, (S)Shoes, (G)Game ?: ");
                                type = input.nextLine().charAt(0);
                                switch (type) {
                                    case 'G':
                                    case 'g': {

                                        type_no = 1;

                                        System.out.print("Please enter the game year: ");
                                        year = Integer.parseInt(input.nextLine());


//                                        store.addItem(new Game(name, number, quantity, price, year));


                                        break type;
                                    }
                                    case 'S':
                                    case 's': {

                                        type_no = 2;

                                        System.out.print("Please enter the shoes size: ");
                                        size = Integer.parseInt(input.nextLine());
                                        System.out.print("Please enter the shoes color: ");
                                        color = input.nextLine();


//                                        store.addItem(new Shoe(name, number, quantity, price, color, size));



                                        break type;
                                    }
                                    case 'B':
                                    case 'b': {


                                        type_no = 3;

                                        System.out.print("Please enter the book title: ");
                                        title = input.nextLine();
                                        System.out.print("Please enter the book author name: ");
                                        author = input.nextLine();



//                                        store.addItem(new Book(name, number, quantity, price, title, author));



                                        break type;
                                    }
                                    default:
                                }
                            }

                            flag = true;
                            System.out.print("Please enter the item number: ");
                            number = input.nextLine();
                            if (store.itemExist(number)) {
                                System.out.println("This item number is already exist!, please try again.");
                            } else {
                                System.out.print("Please enter the item name: ");
                                name = input.nextLine();
                                System.out.print("Please enter the item quantity: ");
                                quantity = Integer.parseInt(input.nextLine());
                                if (quantity <= 0) {
                                    if (quantity < 0) {
                                        System.out.println("You can't add a negative quantity!");
                                    } else {
                                        System.out.println("You can't add zero quantity!");
                                    }
                                    flag = false;
                                }
                                if (flag) {
                                    System.out.print("Please enter the item price: ");
                                    price = Double.parseDouble(input.nextLine());
                                    System.out.println("Item added Successfully");

                                    if (type_no == 1) {
                                        store.addItem(new Game(name, number, quantity, price, year));
                                    } else if (type_no == 2) {
                                        store.addItem(new Shoe(name, number, quantity, price, color, size));
                                    } else {
                                        store.addItem(new Book(name, number, quantity, price, title, author));
                                    }
                                }
                            }






                            while (true) {
                                System.out.print("Do you want to add another item (y/n)? ");
                                choice = input.nextLine().charAt(0);
                                switch (choice) {
                                    case 'Y':
                                    case 'y': {
                                        continue case1;
                                    }
                                    case 'N':
                                    case 'n': {
                                        continue outer;
                                    }
                                    default:
                                }
                            }
                        }
                    }   // done
                    case 2: {
                        System.out.println("* Add new Customer Operation *");
                        case2:
                        while (true) {
                            System.out.print("Please enter the customer number: ");
                            number = input.nextLine();
                            if (store.customerExist(number)) {
                                System.out.println("This customer number is already exist!, please try again.");
                                continue;
                            }
                            System.out.print("Please enter the customer name: ");
                            name = input.nextLine();
                            store.addCustomer(new Customer(number, name));
                            System.out.println("Customer added with empty shopping cart Successfully");
                            while (true) {
                                System.out.print("Do you want to add another customer (y/n)? ");
                                choice = input.nextLine().charAt(0);
                                switch (choice) {
                                    case 'Y':
                                    case 'y': {
                                        continue case2;
                                    }
                                    case 'N':
                                    case 'n': {
                                        continue outer;
                                    }
                                    default:
                                }
                            }
                        }
                    }   // done
                    case 3: {
                        System.out.println("* Add Item to Customer Shopping Cart Operation *");
                        if (store.checkItemsAndCustomers()) {
                            continue;
                        }
                        case3:
                        while (true) {
                            System.out.print("Please enter the customer number: ");
                            number = input.nextLine();
                            if (!store.customerExist(number)) {
                                while (true) {
                                    System.out.print("The customer is not exist, Do you want to try again(y/n)? ");
                                    choice = input.nextLine().charAt(0);
                                    switch (choice) {
                                        case 'y':
                                        case 'Y': {
                                            continue case3;
                                        }
                                        case 'n':
                                        case 'N': {
                                            continue outer;
                                        }
                                        default:
                                    }
                                }
                            }
                            customer = store.findCustomerByNo(number);
                            customer.customerInfo();
                            store.itemsList();
                            case3_2:
                            while (true) {
                                System.out.print("Enter your choice item: ");
                                choice = Integer.parseInt(input.nextLine());
                                if (choice == 0) {
                                    continue outer;
                                }
                                if (choice > store.getItems().size() || choice < 0) {
                                    System.out.println("invalid choice!");
                                    continue;
                                }
                                choice--;
                                item = store.findItemByIndex(choice);
                                if (item.getItemQuantity() == 0) {
                                    System.out.println("The item quantity is empty!, we will provide it as soon as possible");
                                    continue;
                                }
                                item.itemDetails();
                                System.out.print("Enter the quantity you need: ");
                                quantity = Integer.parseInt(input.nextLine());
                                if (quantity >= 0) {
                                    if (quantity != 0) {
                                        if (store.checkItemQuantity(choice, quantity)) {
                                            if (store.itemExistInCustomerCart(customer.getCustomerNumber(), item.getItemNumber())) {
                                                newItem = customer.getCart().findCartItemByNumber(item.getItemNumber());
                                                newItem.setItemQuantity(newItem.getItemQuantity() + quantity);
                                                item.setItemQuantity(item.getItemQuantity() - quantity);
                                                System.out.println(newItem.itemInfo() + " updated to shopping cart is success");
                                            } else {
                                                newItem = new Item(item.getItemName(), item.getItemNumber(), quantity, item.getItemPrice());
                                                store.addItemToCustomerCart(newItem, customer);
                                                item.setItemQuantity(item.getItemQuantity() - quantity);
                                                System.out.println(newItem.itemInfo() + " adding to shopping cart is success");
                                            }
                                        } else {
                                            System.out.println("Sorry the required quantity is not available, the available quantity is [" + item.getItemQuantity() + "], try again!");
                                        }
                                    } else {
                                        System.out.println("You can't order zero quantity!");
                                    }
                                } else {
                                    System.out.println("You can't order a negative quantity");
                                }
                                while (true) {
                                    System.out.print("do you want add another item to shopping cart (y/n)? ");
                                    choice = input.nextLine().charAt(0);
                                    switch (choice) {
                                        case 'y':
                                        case 'Y': {
                                            continue case3_2;
                                        }
                                        case 'n':
                                        case 'N': {
                                            continue outer;
                                        }
                                        default:
                                    }
                                }
                            }
                        }

                    }   // done
                    case 4: {
                        System.out.println("* Remove Item From Customer Shopping Cart Operation *");
                        if (store.checkItemsAndCustomers()) {
                            continue;
                        }
                        if (store.checkCustomersCart()) {
                            continue;
                        }
                        System.out.print("Enter customer number: ");
                        number = input.nextLine();
                        if (store.customerExist(number)) {
                            if (!store.findCustomerByNo(number).getCart().getCartItems().isEmpty()) {
                                customer = store.findCustomerByNo(number);
                                customer.customerInfo();//
                                System.out.println("The current items in the shopping cart.");
                                store.customerCartList(number);
                                    System.out.println("What you want to modify?");
                                    System.out.println(">>> R. Remove item from the Shopping Cart.");
                                    System.out.println(">>> M. Return to Main Menu");
                                while (true) {
                                    System.out.print("Enter your choice [R Remove, M main menu]: ");
                                    choice = input.nextLine().charAt(0);
                                    switch (choice) {
                                        case 'R':
                                        case 'r': {
                                            System.out.print("Enter your item option number: ");
                                            choice = Integer.parseInt(input.nextLine());
                                            choice--;

                                            if (choice >= customer.getCart().getCartItems().size() || choice < 0) {
                                                System.out.println("invalid choice!");
                                                continue;
                                            }

                                            item = customer.getCart().findCartItemByIndex(choice);
                                            newItem = store.findItemByNo(item.getItemNumber());
                                            newItem.setItemQuantity(newItem.getItemQuantity() + item.getItemQuantity());
                                            System.out.println(item.itemInfo() + " is removed from shopping cart.");
                                            customer.getCart().removeItemByIndex(choice);
                                            // or
//                                            customer.getCart().removeItemByObject(item);
                                            continue;
                                        }
                                        case 'M':
                                        case 'm': {
                                            continue outer;
                                        }
                                    }
                                }
                            } else {
                                System.out.println("The customer has an empty cart");
                            }

                        } else {
                            System.out.println("The customer is not exist");
                        }
                        continue;
                    }   // done
                    case 5: {
                        System.out.println("* View the items in Customer shopping cart Operation *");
                        if (store.checkItemsAndCustomers()) {
                            continue;
                        }
                        System.out.print("Enter customer number: ");
                        number = input.nextLine();
                        if (store.customerExist(number)) {
                            customer = store.findCustomerByNo(number);
                            customer.customerInfo();
                            double total = 0;

                            System.out.println("Item no \tItem name\t  Quantity\tUnit price\tTotal price");
                            for (Item item11 : customer.getCart().getCartItems()) {
                                System.out.printf(" %s \t\t %s \t\t %4d \t\t %4.2f \t\t %4.2f\n", item11.getItemNumber(), item11.getItemName(), item11.getItemQuantity(), item11.getItemPrice(), item11.getItemPrice() * item11.getItemQuantity());
                                total += item11.getItemPrice() * item11.getItemQuantity();
                            }
                            System.out.printf("      \t\t       \t\t      \t\tTotal price: %.2f\n", total);
                        } else {
                            System.out.println("The customer is not exist");
                            continue;
                        }
                        while (true) {
                            System.out.print("Press (M/m) key to return to the main menu: ");
                            choice = input.nextLine().charAt(0);
                            switch (choice) {
                                case 'm':
                                case 'M': {
                                    continue outer;
                                }
                                default:
                            }
                        }
                    }   // done
                    case 6: {
                        System.out.println("* Modify Customer Data *");
                        if (store.checkCustomers()) {
                            continue;
                        }
                        case6:
                        while (true) {
                            System.out.print("Enter customer number: ");
                            number = input.nextLine();
                            if (store.customerExist(number)) {
                                customer = store.findCustomerByNo(number);
                                customer.customerInfo();
                                System.out.print("Please enter the customer new Number: ");
                                number = input.nextLine();
                                if (!store.customerExist(number)) {
                                    System.out.print("Please enter the customer new Name: ");
                                    name = input.nextLine();
                                    customer.setCustomerNumber(number);
                                    customer.setCustomerName(name);
                                    System.out.println("Customer modified Successfully");
                                } else {
                                    System.out.println("This customer number is already exist");
                                }
                            } else {
                                System.out.println("The customer no: " + number + ", not found.");
                            }
                            while (true) {
                                System.out.print("Do you want modify another customer (y/n)? ");
                                choice = input.nextLine().charAt(0);
                                switch (choice) {
                                    case 'y':
                                    case 'Y': {
                                        continue case6;
                                    }
                                    case 'n':
                                    case 'N': {
                                        System.out.println("Back to main menu");
                                        continue outer;
                                    }
                                    default:
                                }
                            }

                        }

                    }   // done
                    case 7: {
                        System.out.println("* Empty Customer Shopping Cart *");
                        if (store.checkItemsAndCustomers()) {
                            continue;
                        }
                        if (store.checkCustomersCart()) {
                            continue;
                        }
                        System.out.print("Enter customer number: ");
                        number = input.nextLine();
                        if (store.customerExist(number)) {
                            customer = store.findCustomerByNo(number);
                            if (customer.getCart().getCartItems().isEmpty()) {
                                System.out.println("The customer already has an empty cart");
                                continue;
                            }

                            for (Item item11 : customer.getCart().getCartItems()) {
                                item = store.findItemByNo(item11.getItemNumber());
                                item.setItemQuantity(item11.getItemQuantity() + item.getItemQuantity());
                            }
                            customer.emptyCart();
                            System.out.println("Empty cart operation done successfully");
                        } else {
                            System.out.println("The customer is not exist, back to main menu");
                        }
                        continue;
                    }   // done
                    case 8: {
                        System.out.println("* Customer Checkout *");
                        if (store.checkCustomers()) {
                            continue;
                        }
                        System.out.print("Enter customer number: ");
                        number = input.nextLine();
                        if (store.customerExist(number)) {
                            customer = store.findCustomerByNo(number);
                            double total = 0;
                            customer.customerInfo();
                            System.out.println();
                            System.out.println("Item no \tItem name\t  Quantity\t Unit price\t  Total price");
                            for (Item item11 : customer.getCart().getCartItems()) {
                                System.out.printf(" %s \t\t %s \t\t  %4d \t\t  %4.2f \t\t %4.2f\n", item11.getItemNumber(), item11.getItemName(), item11.getItemQuantity(), item11.getItemPrice(), item11.getItemPrice() * item11.getItemQuantity());
                                total += item11.getItemPrice() * item11.getItemQuantity();
                            }
                            System.out.printf("      \t\t       \t\t      \t\t Total price: %.2f\n", total);
                        } else {
                            System.out.println("The customer is not exist");
                            continue;
                        }
                        System.out.println("Thank you for visiting our store");
                        store.removeCustomerByNumber(number);
                        System.out.println("The customer has been deleted");
                        continue;
                    }   // done
                    case 9: {
                        System.out.println("***********************************************************");
                        System.out.println("* Programming 2 - practical: Final Project (Online Store) *");
                        System.out.println("* Student: Zain El-Abidine Hasan AbuNada                  *");
                        System.out.println("* Supervisor: Eng. Tanseem AbuJamea                       *");
                        System.out.println("* Good Bye :)                                             *");
                        System.out.println("***********************************************************");

                        break outer;
                    }   // done
                    default: {
                        System.out.println("Wrong option..!");
                    }
                }
            } catch (Exception e) {
                System.out.println("An Error Occurred: "+e.getMessage()+", Back to Main Menu.");
            }
        }
    }
}
