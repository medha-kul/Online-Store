package client;

import common.Item;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class RemoveItemCommand extends Command {

    public RemoveItemCommand() throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute() throws RemoteException {
        // ask about the itemId
        System.out.println ("Enter the item ID:");
        int itemId = input.nextInt ();
        ArrayList <Item> listItems = storeStub.getInventory ();
        int size = listItems.size ();
        boolean item_found = false;
        for (int i = 0; i < size; i++) {
            if (listItems.get (i).getItemId() == itemId) {
                item_found = true;
                listItems.remove (i);       // removing the first one encountered, and then breaking out of the loop
                break;      // otherwise, it keeps removing same itemId items (eventually, i gets out of bound)
            } // end if
        } // end for

        if (!item_found) {
            System.out.println ("No item with that item ID was found :(");
        } // end if

        storeStub.setInventory (listItems);

        if (item_found) {
            System.out.println ("Item removed successfully...");
        }
    } // end execute ()

} // end class def
