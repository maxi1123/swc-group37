Task 1
-------------
Customers:

For the customers, we started by creating the interface "BankOps" with all the
operations that the customer should be able to do with his account.

Further, we created the super class "Customer" which implements "BankOps", to have the main attributes of all
accounts in one place to inherit from. Thus we created the classes "Regular", "Platinum",
 and "Gold" through inheritance for each account type.
 
Employees:

For all the employees we created a super class called "Employee" to inherit their
basic attributes from. The employees that are not involved with banking operations, "BackendTech"
and "WebTech" directly inherited from employee. For all other employees we created
both the interface "EmpOps" to include the operations every banking operations involved
employee should be able to do, which are to upgrade a regular account to gold, and to
allocate a card to a customer.

Then "BankEmployee" was created as a subclass of "Employee" implementing "EmpOps"
to serve as a super class for the bank employee classes with their own
operations and attributes.

Cards:

For the cards we simply used a super class "Cards" and created
sub classes for each category of card with their own limits. Cards can only be assigned
to a customer through a "BankEmployee" operation.

For the UML's, please refer to the three .png files within
the "SoftCon2020_Assignment_4" folder. The dotted arrows stand for "implements".

Task 2
---------
The implemented tests can be found within the Test.java file in the tests folder with
the documentation within. 