package client;

import common.*;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ChooseItemCommand extends Command {

    public ChooseItemCommand() throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    public void execute () throws RemoteException {
        // ask about the itemId
        // add item to cart

        System.out.println ("Enter the item ID:");
        int itemId = input.nextInt ();
        System.out.println ("Enter the quantity:");
        int quantity = input.nextInt ();
        Item item = storeStub.findItem (itemId);
        if (item != null) {
            if (item.getQuantity () >= quantity) {
                // add to the user's shopping cart
                item.setPurchaseQuantity (quantity);
                storeStub.findItem (itemId).setPurchaseQuantity (quantity);
                customer.addItemToCart (item);
                System.out.println ("Item added to cart successfully...... ");
            } // end if
            else {
                System.out.println ("Not enough quantity of this item is available!");
            } // end
        } else {
            System.out.println ("Item with provided item ID not found!");
        } // end if-else
    } // end execute ()

} // end class def