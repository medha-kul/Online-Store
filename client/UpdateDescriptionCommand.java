package client;

import common.Item;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class UpdateDescriptionCommand extends Command {
    public UpdateDescriptionCommand() throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute() throws RemoteException {
        // ask for item ID
        System.out.println ("Enter the item ID:");
        int itemId = input.nextInt ();
        input.nextLine ();  // throw away the '\n' not consumed by nextInt ()
        System.out.println ("Set the description to:");
        String newDescrp = input.nextLine ();
        ArrayList<Item> listItems = storeStub.getInventory ();
        boolean item_found = false;
        int size = listItems.size ();
        for (int i = 0; i < size; i++) {
            if (listItems.get (i).getItemId () == itemId) {
                item_found = true;
                listItems.get (i).setDescription (newDescrp);
                break;      // break out of the loop after the first one encountered if updated
            } // end if
        } // end for

        if (!item_found) {
            System.out.println ("No item with that item ID was found :(");
        } // end if

        storeStub.setInventory (listItems);

        if (item_found) {
            System.out.println("Item Description updated...");
        }
    } // end execute ()


} // end class def
