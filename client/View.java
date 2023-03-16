package client;

import common.*;

public class View {

    public View () {

    } // end constructor


    public void mainMenu () {
        System.out.println ("Please select one of the following options:\n1. Customer Login\n2. Admin Login\n3. New Customer Registration\n4. Exit");
    } // end mainMenu ()


    public void customerMenu () {
        System.out.println ("---------------------------------");
        System.out.println ("What do you want to do?");
        System.out.println ("1. Browse items to shop\n2. Add an item to cart\n3. Purchase items in the cart\n4. View your shopping cart\n5. View your past orders\n6. Log Out");
        System.out.println ("---------------------------------");
    } // end customerMenu ()


    public void adminMenu () {
        System.out.println ("---------------------------------");
        System.out.println ("What do you want to do?");
        System.out.println ("1. Add an item\n2. Remove an item\n3. Update an item's price\n4. Update an item's quantity\n5. Update an item's description\n6.View items in the store\n7. Add an admin account\n8.Add a customer account\n9. Remove an admin account\n10.Remove a customer account\n11. View customer accounts\n12. View Admin accounts\n13.Log Out");
        System.out.println ("---------------------------------");
    } // end adminMenu ()

    // method to print an item
    public void print (Item item, int count) {
        System.out.println (count + ". Item ID: " + item.getItemId () + "   |   Type: " + item.getType () + "   |   Description: " + item.getDescription () + "   |   Price: " + item.getPrice () + "   |   Quantity: " + item.getQuantity ());
    } // end print item

    public void printCartItem (Item item, int count) {
        System.out.println (count + ". Item ID: " + item.getItemId () + "   |   Type: " + item.getType () + "   |   Description: " + item.getDescription () + "   |   Price: " + item.getPrice () + "   |   Quantity in cart: " + item.getPurchaseQuantity ());
    } // end print item

    public void print (CustomerAccount customer, int count) {
        System.out.println (count + ". Customer ID: " + customer.getUserId () + "   |   Name: " + customer.getName ());
    } // end print item

    public void print (AdminAccount admin, int count) {
        System.out.println (count + ". Admin ID: " + admin.getUserId () + "   |   Name: " + admin.getName ());
    } // end print item

} // end class def
