package server;

import common.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

// like the data model for the store
public class RemoteOnlineStore extends UnicastRemoteObject implements OnlineStore {

    ArrayList<Item> inventory;
    private ArrayList <CustomerAccount> customers;      // list of customers
    private ArrayList <AdminAccount> admins;            // list of administrators


    public RemoteOnlineStore() throws RemoteException {
        this.inventory = new ArrayList <Item> ();
        this.customers = new ArrayList <CustomerAccount> ();
        this.admins = new ArrayList <AdminAccount> ();
        // initial setup users before the program starts
        this.init ();
    } // end constructor


    public void init () throws RemoteException {
        // to add some dummy data
        // create some users
        CustomerAccount c1 = new CustomerAccount ("John Smith", "customer", "c1", "c1pass");
        CustomerAccount c2 = new CustomerAccount ("Neha Patel", "customer", "c2", "c2pass");
        CustomerAccount c3 = new CustomerAccount ("Gurpreet Singh", "customer", "c3", "c3pass");
        c1.setUserId(1);
        c2.setUserId(2);
        c3.setUserId(3);


        // create some admins
        AdminAccount a1 = new AdminAccount ("Jasmine Williams", "admin", "a1", "a1pass");
        AdminAccount a2 = new AdminAccount ("Harry Woods", "admin", "a2", "a2pass");
        a1.setUserId(1);
        a2.setUserId(2);
        // add the admins to the admins list
        admins.add (a1);
        admins.add (a2);

        // create some items
        Item i1 = new Item ("footwear", "socks", 5.00, 100);
        Item i2 = new Item ("clothes", "tops", 15.99, 100);
        Item i3 = new Item ("clothes", "jeans", 23.99, 100);
        Item i4 = new Item ("footwear", "shoes", 49.99, 100);
        Item i5 = new Item ("electronics", "headphones", 60.00, 100);

        i1.setItemId(1);
        i2.setItemId(2);
        i3.setItemId(3);
        i4.setItemId(4);
        i5.setItemId(5);
        i1.setPurchaseQuantity(1);
        i2.setPurchaseQuantity(1);

        c1.getShoppingCart().add (i1);
        c1.getShoppingCart().add (i2);

        c1.getOrders().add (i3);
        c1.getOrders().add (i4);

        // add the items to the inventory
        inventory.add (i1);
        inventory.add (i2);
        inventory.add (i3);
        inventory.add (i4);
        inventory.add (i5);

        // add the customers to the customers list
        customers.add (c1);
        customers.add (c2);
        customers.add (c3);

    } // end init ()


    @Override
    public Item findItem (int itemId)  throws RemoteException {
        Item return_item = null;
        for (int i = 0; i < inventory.size (); i++) {
            if (inventory.get (i).getItemId () == itemId) {
                return_item = inventory.get (i);
            } // end if
        } // end for
        return return_item;
    } // end findItem

    @Override
    public CustomerAccount findCustomer (String username, String password)  throws RemoteException {
        int num_customers = customers.size ();
        CustomerAccount customer;
        for (int i = 0; i < num_customers; i++) {
            customer = customers.get (i);
            if (customer.getUsername().equals (username) && customer.getPassword().equals (password)) {
                return customer;
            } // end if
        } // end for
        return null;
    } // end findCustomer

    @Override
    // based on username and password
    public AdminAccount findAdmin (String username, String password)  throws RemoteException {
        int num_admins = admins.size ();
        AdminAccount admin = null;
        for (int i = 0; i < num_admins; i++) {
            admin = admins.get (i);
            if (admin.getUsername().equals (username) && admin.getPassword().equals (password)) {
                return admin;
            } // end if
        } // end for
        return null;
    } // end findAdmin ()


    @Override
    public void addAdminAccount(String name, String username, String password) throws RemoteException {
        AdminAccount newAdmin = new AdminAccount (name, "admin", username, password);
        //set adminId as well
        int last_Id = admins.get ( admins.size() - 1 ).getUserId ();
        newAdmin.setUserId (last_Id + 1);
        admins.add (newAdmin);
    }


    @Override
    public void addCustomerAccount(String name, String username, String password) throws RemoteException {
        CustomerAccount newCustomer = new CustomerAccount (name, "customer", username, password);
        //set customerId as well
        int last_Id = customers.get ( customers.size() - 1 ).getUserId ();
        newCustomer.setUserId (last_Id + 1);
        customers.add (newCustomer);
    }


    @Override
    public void deleteAdmin (int adminId)  throws RemoteException {
        int size = this.admins.size ();
        AdminAccount cur_account;
        int num_admins_deleted = 0;
        for (int i = 0; i < size; i ++ ) {
            cur_account = admins.get(i);
            if (cur_account.getUserId () == adminId) {
                admins.remove (i);
                num_admins_deleted++;
                break;
            } // end if
        } // end for

        if (num_admins_deleted == 0) {
            System.out.println ("No admin with that admin ID was found!");
        } // end if
    } // end deleteAdmin ()


    @Override
    public void deleteCustomer (int customerId) throws RemoteException {
        int size = this.customers.size ();
        CustomerAccount cur_account;
        int num_customers_deleted = 0;

        for (int i = 0; i < size; i ++ ) {
            cur_account = customers.get(i);
            if (cur_account.getUserId () == customerId) {
                customers.remove (i);
                num_customers_deleted ++;
                break;
            } // end if
        } // end for

        if (num_customers_deleted == 0) {
            System.out.println ("No customer with that customer ID was found!");
        } // end if
    } // end deleteCustomer ()

    @Override
    public void addItem (String type, String description, double price, int quantity) {
        Item newItem = new Item(type, description, price, quantity);
        int last_Id = inventory.get (inventory.size () - 1).getItemId ();
        newItem.setItemId (last_Id + 1);
        inventory.add (newItem);
    } // end addItem ()

    public void updateItemQuantity (int itemId) throws RemoteException {
        for (int i = 0; i < inventory.size (); i++) {
            if (inventory.get (i).getItemId () == itemId) {
                inventory.get (i).updateQuantity ();
            } // end if
        } // end for
    }

    @Override
    public void addItem (Item newItem) {
        inventory.add (newItem);
    }



    // access methods
    public ArrayList<Item> getInventory() throws RemoteException  {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) throws RemoteException  {
        this.inventory = inventory;
    }

    public ArrayList<CustomerAccount> getCustomers() throws RemoteException  {
        return customers;
    }

    public void setCustomers (ArrayList<CustomerAccount> customers) throws RemoteException  {
        this.customers = customers;
    }

    public ArrayList<AdminAccount> getAdmins() throws RemoteException {
        return admins;
    }

    public void setAdmins(ArrayList<AdminAccount> admins) throws RemoteException {
        this.admins = admins;
    }
} // end class def
