package client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CommandFactory {

    // modify based on any parameters needed to be passed in
    public Command createBrowseItemsCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new BrowseItemsCommand ();
    }

    public Command createPurchaseItemCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new PurchaseItemCommand ();
    }

    public Command createChooseItemCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new ChooseItemCommand ();
    }

    public Command createViewCartCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new ViewCartCommand ();
    }

    public Command createViewOrdersCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new ViewOrdersCommand ();
    }

    public Command createAddItemCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new AddItemCommand ();
    } // end createAddItemCommand ()

    public Command createRemoveItemCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new RemoveItemCommand ();
    }

    public Command createUpdatePriceCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new UpdatePriceCommand ();
    }

    public Command createUpdateQuantityCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new UpdateQuantityCommand ();
    }

    public Command createUpdateDescriptionCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new UpdateDescriptionCommand ();
    }

    public Command createViewItemsCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new ViewItemsCommand ();
    }

    public Command createAdminAcctCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new AdminAcctCreateCommand ();
    }

    public Command createCusAcctCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new CusAcctCreateCommand ();
    }

    public Command createDelCusAcctCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new DeleteCusAcctCommand ();
    }

    public Command createDelAdminAcctCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new DeleteAdminAcctCommand ();
    }

    public Command createCustomerLoginCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new LoginCustomerCommand ();
    }

    public Command createAdminLoginCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new LoginAdminCommand ();
    }

    public Command createViewCustomersCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new ViewCustomersCommand ();
    }

    public Command createViewAdminsCommand () throws MalformedURLException, NotBoundException, RemoteException {
        return new ViewAdminsCommand ();
    }


} // end class def
