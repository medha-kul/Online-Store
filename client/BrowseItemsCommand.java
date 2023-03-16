package client;

import common.Item;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class BrowseItemsCommand extends Command {

    public BrowseItemsCommand() throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute() throws RemoteException {
        View view = new View ();

        // ask about the type of item to browse
        System.out.println ("What type of item do you want to browse (example: clothes, footwear, electronics, etc)? Type one word.");
        String itemType = input.nextLine ();
        System.out.println ("Give some item description (example: socks in clothes, shoes in footwear, headphones in electronics, etc): ");
        String itemDescription = input.nextLine ();
        ArrayList<Item> listItems = storeStub.getInventory ();
        int size = listItems.size ();
        System.out.println ("------------ Resulting items are ------------- ");
        int num_result_items = 0;
        for (int i = 0; i < size; i++) {
            Item cur_item = listItems.get (i);
            if (cur_item.getType().equals (itemType) || cur_item.getDescription().equals (itemDescription)) {
                // print this item out
                view.print (cur_item, i + 1);
                num_result_items ++;
            } // end if
        } // end for

        if (num_result_items == 0) {
            System.out.println("Sorry, no items matching your type or description provided were found :(\n");
        }
    } // end execute ()

} // end class def
