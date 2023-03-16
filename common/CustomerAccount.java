package common;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerAccount implements Serializable {

    protected String type;      // type of user: admin or customer
    protected String username;
    protected String password;
    protected String name;
    protected int userId;
    // specifically for users
    private ArrayList <Item> orders;
    private ArrayList <Item> shoppingCart;

    public CustomerAccount () {
        this.name = "";
        this.type = "";
        this.userId = -1;
        this.username = "";
        this.password = "";
        this.orders = new ArrayList<Item> ();
        this.shoppingCart = new ArrayList<Item> ();
    } // end default constructor

    public CustomerAccount(String name, String type) {
        this.name = name;
        this.type = type;
        this.userId = -1;
        this.username = "";
        this.password = "";
        this.orders = new ArrayList<Item> ();
        this.shoppingCart = new ArrayList<Item> ();
    } // end constructor 1: to set username and password later


    public CustomerAccount(String name, String type, String username, String password) {
        this.name = name;
        this.type = type;
        this.username = username;
        this.password = password;
        this.orders = new ArrayList<Item> ();
        this.shoppingCart = new ArrayList<Item> ();
    } // end constructor 2: to set all the info parameters at once

    public void addItemToCart (Item item) {
        this.shoppingCart.add (item);
    } // end addItemToCart ()

    // getters and setters from the parent class are inherited
    // more for this class
    public ArrayList<Item> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Item> orders) {
        this.orders = orders;
    }

    public ArrayList<Item> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Item> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    // additional getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

} // end class def
