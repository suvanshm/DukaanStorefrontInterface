# Dukaan Storefront Interface

A storefront interface built using Java, Netbeans Swing GUI at the front-end and SQLite at the back-end. 

The program provides a user-friendly interface to keep track of a store's inventory, register sales and look at sale statistics. 
Every invoice is registered and can be printed out on the spot. Invoices can be retrieved by their invoice number or customer name. 
Reports of invoices in a particular date range can also be retrieved.

Further, the program is capable of maintaining a reorder list of inventory items that reach below a particular quantity. 
The program also provides basic accounting functionality and can calculate current cash balance as well as revenue and profit reports for any specified time period.

The platform provides a login screen and is password protected. Access is only granted to credentials present in the worker database. 
Users are segregated into 'Admin' and 'Volunteer' type with variable functionality. 
For example, the feature of examining ang maintaining details of valid users on the platform is restricted only to admins. 

## Program Functionality
Video showing program in action: https://youtu.be/hrLFwDaN2Ts

## Getting Started

### Prerequisites
* [NetBeans](https://netbeans.org/) - Used for Swing GUI
* [Java 7](https://www.java.com/en/download/manual.jsp) - Development
* [SQLite](https://sqlitestudio.pl/) - Or any alternative SQLite workbench

### Installing and Deployment

Setup your database on your workbench and then link it in the code. 
In ComputerScienceIA.java in the source code, replace your database location in line 37.

```
String url = "jdbc:sqlite:/Users/mac/Desktop/products.db";
```

## Acknowledgments

This program was built as a project for my Computer Science HL course in the International Baccalaureate.
