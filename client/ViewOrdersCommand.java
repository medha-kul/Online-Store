package client;

import common.*;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ViewOrdersCommand extends Command {

    public ViewOrdersCommand() throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute() {
        View view = new View ();
        // print all the items in the orders list
        int size = customer.getOrders().size();
        if (size > 0) {
            Item cur_item;
            for (int i = 0; i < size; i ++ ) {
                cur_item = customer.getOrders().get(i);
                view.print (cur_item, i);
            } // end for
        } else {
            System.out.println ("You do not have any past orders yet :(");
        } // end if-else

    } // end execute ()

} // end class def

