package client;

import common.CustomerAccount;
import common.Item;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ViewCartCommand extends Command {

    public ViewCartCommand() throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute() {
        View view = new View ();
        // print all the items in the orders list
        int size = customer.getShoppingCart().size();
        Item cur_item;
        if (size > 0) {
            for (int i = 0; i < size; i ++ ) {
                cur_item = customer.getShoppingCart().get(i);
                view.printCartItem (cur_item, i);
            } // end for
        } else {
            System.out.println ("There are no items in your cart currently.");
        } // end if-else

    } // end execute ()

} // end class def
