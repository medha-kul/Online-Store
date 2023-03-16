package client;

import common.*;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AddItemCommand extends Command {


    public AddItemCommand () throws MalformedURLException, NotBoundException, RemoteException {
        super ();
    }

    @Override
    public void execute () throws RemoteException {
        System.out.println ("Enter the following information:");
        System.out.println ("Type of item: ");
        String type = input.nextLine ();
        System.out.println ("Description:");
        String description = input.nextLine ();
        System.out.println ("Price:");
        double price = input.nextDouble ();
        System.out.println ("Quantity:");
        int quantity = input.nextInt ();
        // perform operation on the store
        storeStub.addItem (type, description, price, quantity);       // TO think about: will this change made here be updated on the store's inventory (pass by reference)

        System.out.println ("Item added..");
    } // end execute ()

} // end class def
