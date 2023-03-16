package client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class FrontController {

    public static void main (String[] args) {

        // create an instance of FrontController to be able to run the program
        FrontController store = new FrontController ();
        try {
            store.begin ();
        } catch (Exception e) {
            System.out.println ("An exception occurred while execution:\n" + e.getMessage());
            e.printStackTrace ();
        } // end try-catch

    } // end main


    Scanner input = new Scanner (System.in);    // to take input
    View view;
    int MAIN_MENU_EXIT = 4;
    int CUSTOMER_LOGOUT = 6;
    int ADMIN_LOGOUT = 13;
    // user stored as an instance of command
    Command command;
    CommandFactory factory;


    public FrontController () {
        view = new View ();
        factory = new CommandFactory ();
    } // end constructor


    public void begin () throws NotBoundException, RemoteException, MalformedURLException {
        int userChoice = -1;        // stores user response

        while (userChoice != MAIN_MENU_EXIT) {
            // if not the first time
            view.mainMenu ();
            userChoice = getInput ();

            if (userChoice == 1) {
                // customer login process
                // handle customer process
                startCustomerProcess ();

            } else if (userChoice == 2) {
                // admin login process
                // handle admin process
                startAdminProcess();

            } else if (userChoice == 3) {
                // new customer registration
                command = factory.createCusAcctCommand ();
                command.execute ();
                System.out.println ("successfully added new user");

            } else {
                if (userChoice != MAIN_MENU_EXIT) {
                    // invalid choice
                    System.out.println ("Invalid choice entered. Please try again.");
                }
            } // end if-else
        } // end while

        System.out.println ("Thanks for using our online store! Good Bye!");
    } // end begin ()


    public void startCustomerProcess () throws MalformedURLException, NotBoundException, RemoteException {
        // login first
        command = factory.createCustomerLoginCommand ();
        while (!command.success) {
            command.execute ();
            if (!command.success) {
                System.out.println ("Please try again.");
            } // end if
        } // end while

        boolean execute_command = true;
        // once logged in, pull up the customer menu and begin those operations
        int cus_response = 0;
        while (cus_response != CUSTOMER_LOGOUT) {
            view.customerMenu ();
            cus_response = getInput ();

            if (cus_response == 1) {
                // browse items
                command = factory.createBrowseItemsCommand ();

            } else if (cus_response == 2) {
                // add an item to cart
                command = factory.createChooseItemCommand ();

            } else if (cus_response == 3) {
                // purchase an item
                command = factory.createPurchaseItemCommand ();

            } else if (cus_response == 4) {
                // view shopping cart
                command = factory.createViewCartCommand ();

            } else if (cus_response == 5) {
                // view past orders
                command = factory.createViewOrdersCommand ();

            } else {
                if (cus_response != CUSTOMER_LOGOUT) {
                    System.out.println ("Invalid choice entered. Please try again.");
                    execute_command = false;
                }
            } // end if-else

            // if not logging out
            if (cus_response != CUSTOMER_LOGOUT && execute_command != false) {
                if (command != null) {
                    command.execute ();
                } // end if
            } // end if

        } // end while

        // exit while when the customer logs out
        System.out.println ("\nLogging user out..... Getting back to main menu");
        // command.setUser (null); // no current user

    } // end startCustomerProcess



    public void startAdminProcess () throws MalformedURLException, NotBoundException, RemoteException {
        // login first: similar to customer's processes
        command = factory.createAdminLoginCommand ();
        while (!command.success) {
            command.execute ();
            if (!command.success) {
                System.out.println ("Please try again.");
            } // end if
        } // end while

        // once logged in, pull up the customer menu and begin those operations
        int admin_response = 0;
        boolean execute_command = true;
        while (admin_response != ADMIN_LOGOUT) {
            view.adminMenu();
            admin_response = getInput ();

            if (admin_response == 1) {
                // add an item
                command = factory.createAddItemCommand ();

            } else if (admin_response == 2) {
                // remove an item
                command = factory.createRemoveItemCommand ();

            } else if (admin_response == 3) {
                // update an item's price
                command = factory.createUpdatePriceCommand ();

            } else if (admin_response == 4) {
                command = factory.createUpdateQuantityCommand ();

            } else if (admin_response == 5) {
                command = factory.createUpdateDescriptionCommand ();

            } else if (admin_response == 6) {
                command = factory.createViewItemsCommand ();

            } else if (admin_response == 7) {
                command = factory.createAdminAcctCommand ();

            } else if (admin_response == 8) {
                command = factory.createCusAcctCommand ();

            } else if (admin_response == 9) {
                command = factory.createDelAdminAcctCommand();

            } else if (admin_response == 10) {
                command = factory.createDelCusAcctCommand ();
            } else if (admin_response == 11) {
                command = factory.createViewCustomersCommand ();
            } else if (admin_response == 12) {
                command = factory.createViewAdminsCommand ();
            } else {
                if (admin_response != ADMIN_LOGOUT) {
                    System.out.println ("Invalid choice entered. Please try again.");
                    execute_command = false;
                } // end if
            } // end if-else

            // only execute command, if admin not logging out currently, because otherwise it's the command from previous iteration
            if (admin_response != ADMIN_LOGOUT && execute_command != false) {
                if (command != null) {
                    command.execute ();
                } // end command
            } // end if
        } // end while

        // admin logging out
        System.out.println ("Logging out admin..... Getting back to main menu");
    } // end startCustomerProcess



    // get an integer input from the user
        // this method makes sure it is an integer because it converts to an integer
    public int getInput () {
        int userInput = -1;
        try {
            userInput = input.nextInt ();
        } catch (Exception e) {
            System.out.println ("Please enter a valid integer choice: " + e.getMessage());
        } // end try-catch
        return userInput;
    } // end getInput ()

} // end class def
