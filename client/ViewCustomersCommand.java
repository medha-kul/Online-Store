package client;

import common.CustomerAccount;
import common.Item;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ViewCustomersCommand extends Command {


    public ViewCustomersCommand () throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute() throws RemoteException {
        // view customers of the store
        View view = new View ();
        int size = storeStub.getCustomers().size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                CustomerAccount cur_customer = storeStub.getCustomers().get(i);
                view.print (cur_customer, i);
            } // end for
        } else {
            System.out.println ("There are no customers registered currently.\n");
        } // end if-else
    } // end execute ()

} // end class def
