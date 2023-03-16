package client;

import common.*;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AdminAcctCreateCommand extends Command {

    public AdminAcctCreateCommand() throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute() throws RemoteException {
        // ask for account info for the new account
        System.out.println("Enter account info: ");
        System.out.println ("Name: ");
        String name = input.nextLine ();
        System.out.println ("Username: ");
        String username = input.nextLine ();
        System.out.println ("Password: ");
        String password = input.nextLine ();
        // create a user account
        storeStub.addAdminAccount (name, username, password);
    } // end execute ()

} // end class def
