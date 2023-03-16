## Requirements
Requirements Description: The following is a description of the clients request for an Online Store.
The client desires an online store where they can sell goods (and possibly services) to customers
geographically dispersed around the world. Think Amazon but on a smaller scale and budget. Their
desire is to have a system that is constructed in a portable language (Java) and makes use of their
existing network. The system itself should present a view for the customer to interact with as well as a
view for the employees or administrators of the company to interface with. For the customer there is a
need for them to be able to browse available products – this should present the customer with the type,
description and price of the item with the options to add to their shopping cart. If the customer
attempts to add a quantity of the item more than the current supply the system should prevent the
customer from adding these and prompt them with a message on the availability of the item. The
customer should be able to also purchase their items from the shopping cart. The administrators should
be able to update an item’s description within the system, update its price, and update its quantity. The
administrator should also be able to remove items from the system if so desired. Administrators should
be able to add other administrators as well as add/remove customer accounts. A customer should be
able to initially register for their account by themselves. The system should handle any faults or
unexpected scenarios gracefully. It should be reliable and should allow for multiple customer requests
during the course of execution.

## Specific actions/events that should be handled as part of the system:
    Users/Administrators Login & Registration
    Browsing Items
    Updating Items
    Removing Items
    Adding Items
    Purchasing Items

Makefile commands:
    to compile:             make
    to run the server:      make runServer
    to run the client:      make run Client
    

Pre-existing admins to refer off of:
John Smith
Neha Patel
Gurpreet Singh

Pre-existing customers to refer off of:
Jasmine Williams
Harry Woods
