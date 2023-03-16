package client;

import common.Item;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class UpdateQuantityCommand extends Command {

    public UpdateQuantityCommand() throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute() throws RemoteException {
        // ask for item ID
        System.out.println ("Enter the item ID:");
        int itemId = input.nextInt ();
        System.out.println ("Set the quantity to: ");
        int newQuantity = input.nextInt ();
        boolean item_found = false;
        ArrayList<Item> listItems = storeStub.getInventory ();
        int size = listItems.size ();
        for (int i = 0; i < size; i++) {
            if (listItems.get (i).getItemId () == itemId) {
                listItems.get (i).setQuantity (newQuantity);
                item_found = true;
            } // end if
        } // end for
        storeStub.setInventory (listItems);

        if (item_found) {
            System.out.println ("Item Quantity updated...");
        }

    } // end execute ()

} // end class def
