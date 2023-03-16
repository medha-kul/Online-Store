package client;

import common.CustomerAccount;
import common.Item;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class PurchaseItemCommand extends Command {

    public PurchaseItemCommand() throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute () throws RemoteException {
        // add the items from the cart to the orders list
        // the items that are purchased should also decrease in quantity

        int purchase_quantity = 0;
        int quantity = 0;

        int cart_size = customer.getShoppingCart ().size ();
        if (cart_size > 0) {
            Item cur_item;
            for (int i = 0; i < cart_size; i++) {
                // just for reference
                cur_item = customer.getShoppingCart().get (i);
                purchase_quantity = cur_item.getPurchaseQuantity ();
                quantity = cur_item.getQuantity ();

                // update the quantity
                storeStub.updateItemQuantity (cur_item.getItemId ());
                // add the item to order
                customer.getOrders().add ( cur_item );
                // decrease the quantity of this item in the onlineStore
                // storeStub.purchase (cur_item.getItemId (), quantity);
            } // end for

            // new removing logic
            while (cart_size > 0) {
                customer.getShoppingCart().remove (0);
                cart_size --;
            } // end while
        } else {
            System.out.println ("No items in your shopping cart to purchase :(");
        } // end if-else

    } // end execute ()

} // end class def
