package client;

import common.AdminAccount;
import common.CustomerAccount;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ViewAdminsCommand extends Command {

    public ViewAdminsCommand () throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute() throws RemoteException {
        // view customers of the store
        View view = new View ();
        int size = storeStub.getAdmins().size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                AdminAccount cur_admin = storeStub.getAdmins().get(i);
                view.print (cur_admin, i);
            } // end for
        } else {
            System.out.println ("There are no admins of the store currently.\n");
        } // end if-else
    } // end execute ()

} // end class def
