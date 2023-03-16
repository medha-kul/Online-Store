package common;

import java.io.Serializable;

public class Item implements Serializable {

    private int itemId;
    private String type;
    private String description;
    private double price;
    private int quantity;
    private int purchaseQuantity;

    public Item (String type, String description, double price, int quantity) {
        this.type = type;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.purchaseQuantity = 0;
    } // end parametrized constructor

    public void updateQuantity () {
        this.quantity = this.quantity - this.purchaseQuantity;
    }

    // getters and setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }
} // end class def
