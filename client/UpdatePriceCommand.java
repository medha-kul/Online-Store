package client;

import common.Item;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class UpdatePriceCommand extends Command {
    public UpdatePriceCommand() throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute() throws RemoteException {
        // ask for item ID
        System.out.println ("Enter the item ID:");
        int itemId = input.nextInt ();
        System.out.println ("Set the price to: ");
        double newPrice = input.nextDouble ();
        boolean item_found = false;
        ArrayList<Item> listItems = storeStub.getInventory ();
        int size = listItems.size ();
        for (int i = 0; i < size; i++) {
            if (listItems.get (i).getItemId () == itemId) {
                item_found = true;
                listItems.get (i).setPrice (newPrice);
            } // end if
        } // end for

        if (!item_found) {
            System.out.println ("No item with that item ID was found :(");
        } // end if

        storeStub.setInventory (listItems);
        if (item_found) {
            System.out.println ("Item Price updated...");
        }
    } // end execute ()
}
