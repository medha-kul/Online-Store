package client;

import common.CustomerAccount;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LoginCustomerCommand extends Command {


    public LoginCustomerCommand() throws RemoteException, MalformedURLException, NotBoundException {
        super ();
    }

    @Override
    public void execute() throws RemoteException {
        this.success = false;

        System.out.println ("Enter username: ");
        String username = input.nextLine ();
        System.out.println ("Enter password: ");
        String password = input.nextLine ();
        CustomerAccount logging_in_customer = storeStub.findCustomer (username, password);

        if (logging_in_customer != null) {
            customer = logging_in_customer;
            System.out.println ("Login successful! Welcome back, " + customer.getName () + "!\n");
            this.success = true;
        } else {
            System.out.println ("Such a user does not exist.");
        } // end if-else
    } // end execute ()

} // end class def
