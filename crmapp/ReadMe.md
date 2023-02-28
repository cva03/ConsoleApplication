                                    CRM Application
           
jar files required : 
  * mysql-connector-j-8.0.32.zip
  
Three tables created :  admin , customer , interaction

Modules:
  * admin
  * login
  
  New admin can sign-up through the login page and the username password will be added to the admin table;

what admin can do:
  1. View all customers
  2. Add a customer
  3. Update a customer
  4. Delete a customer
  5. View all interactions
  6. Add an interaction
  7. Update an interaction
  8. Delete an interaction
  
  The admin to CRUD operations to the customer and interaction tables. 
  The customer consist of name , email address, customer id and phone no
  The interaction consist of type of interaction, notes of interaction and the interaction id and the customer id, here the customer id act as the foreign key.
