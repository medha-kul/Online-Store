package client;
import client.*;
import common.AdminAccount;
import common.CustomerAccount;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LoginAdminCommand extends Command {

    public LoginAdminCommand() throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute() throws RemoteException {
        this.success = false;

        System.out.println ("Enter username: ");
        String username = input.nextLine ();
        System.out.println ("Enter password: ");
        String password = input.nextLine ();
        AdminAccount logging_in_admin = storeStub.findAdmin (username, password);

        if (logging_in_admin != null) {
            admin = logging_in_admin;
            System.out.println ("Login successful! Welcome back, " + admin.getName() + "!\n");
            this.success = true;
        } else {
            System.out.println ("This admin does not exist.");
        } // end if-else
    } // end execute ()

} // end class def
