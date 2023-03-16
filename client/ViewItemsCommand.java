package client;

import common.Item;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ViewItemsCommand extends Command {


    public ViewItemsCommand() throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute() throws RemoteException {
        // view items in the store
        View view = new View ();
        int size = storeStub.getInventory().size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                Item cur_item = storeStub.getInventory().get (i);
                view.print (cur_item, i);
            } // end for
        } else {
            System.out.println ("There are no items in the store currently.\n");
        } // end if-else
    } // end execute ()

} // end class def
