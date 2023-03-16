package client;

import common.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

// commands that have the store as their receiver or account as their receiver
public abstract class Command {

    Scanner input = new Scanner (System.in);    // for derived classes
    // receivers: either of the following one
    protected static OnlineStore storeStub;

    static {
        try {
            storeStub = (OnlineStore) Naming.lookup ("rmi://in-csci-rrpc04.cs.iupui.edu:3909/RemoteOnlineStore");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    // online store is being updated

    // static user because the same user is using these commands
    protected static CustomerAccount customer = new CustomerAccount ();         // user that is performing the command
    protected static AdminAccount admin = new AdminAccount ();         // user that is performing the command

    public boolean success = false;    // specially, for admin login and customer login

    public Command () throws RemoteException, MalformedURLException, NotBoundException {

    } // end constructor

    public abstract void execute () throws RemoteException;

    // access methods
    public OnlineStore getStore () {
        return storeStub;
    }

    public void setStore (OnlineStore updated) {
        storeStub = updated;
    }

    public static CustomerAccount getCustomer() {
        return customer;
    }

    public static void setCustomer(CustomerAccount customer) {
        Command.customer = customer;
    }

    public static AdminAccount getAdmin() {
        return admin;
    }

    public static void setAdmin(AdminAccount admin) {
        Command.admin = admin;
    }
} // end class def
