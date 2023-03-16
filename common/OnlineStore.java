package common;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface OnlineStore extends Remote {

    public void init () throws RemoteException;
    public Item findItem (int itemId) throws RemoteException;
    public CustomerAccount findCustomer (String username, String password) throws RemoteException;
    public AdminAccount findAdmin (String username, String password) throws RemoteException;

    public void addAdminAccount (String name, String username, String password) throws RemoteException;

    public void addCustomerAccount (String name, String username, String password) throws RemoteException;

    public void deleteAdmin (int adminId) throws RemoteException;
    public void deleteCustomer (int customerId) throws RemoteException;
    public void addItem (Item newItem) throws RemoteException;
    public void addItem (String type, String description, double price, int quantity) throws RemoteException;
    public void updateItemQuantity (int itemId) throws RemoteException;

    // getters and setter
    public ArrayList<Item> getInventory() throws RemoteException;
    public void setInventory(ArrayList<Item> inventory) throws RemoteException;
    public ArrayList<CustomerAccount> getCustomers() throws RemoteException;
    public void setCustomers(ArrayList<CustomerAccount> customers) throws RemoteException;
    public ArrayList<AdminAccount> getAdmins() throws RemoteException;
    public void setAdmins(ArrayList<AdminAccount> admins) throws RemoteException;

} // end class def
