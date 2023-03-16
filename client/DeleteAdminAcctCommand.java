package client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class DeleteAdminAcctCommand extends Command {

    public DeleteAdminAcctCommand() throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute() throws RemoteException {
        // ask for admin ID
        System.out.println("Enter admin ID for the account to be deleted: ");
        int adminId = input.nextInt ();
        storeStub.deleteAdmin (adminId);

        System.out.println ("Admin deleted successfully....");
    } // end execute ()

} // end class def
