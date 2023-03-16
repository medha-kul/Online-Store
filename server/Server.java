package server;

import common.*;

import java.rmi.Naming;

public class Server {

    public static void main (String [] args) {
        try {
            OnlineStore remote_obj = new RemoteOnlineStore ();
            Naming.rebind("rmi://in-csci-rrpc04.cs.iupui.edu:3909/RemoteOnlineStore", remote_obj);
            System.out.println("Server is ready");
        } catch(Exception e) {
            System.out.println("Server err: " + e.getMessage());
            e.printStackTrace();
        }
    } // end main

} // end class def
