package client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class DeleteCusAcctCommand extends Command {

    public DeleteCusAcctCommand() throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute () throws RemoteException {
        System.out.println("Enter customer ID for the account to be deleted: ");
        int customerId = input.nextInt ();
        storeStub.deleteCustomer (customerId);

        System.out.println ("Customer deleted successfully....");
    } // end execute ()

} // end class def
