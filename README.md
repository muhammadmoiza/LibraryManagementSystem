# LibraryManagementSystem
A full fledge Library Management System application covering all the key components of a library, developed in java backend and java swing frontend along with black box testing components in assertj swing.

![alt Sample Librarian Home UI](https://github.com/muhammadmoiza/LibraryManagementSystem/blob/master/LibrarianUISample.png?raw=true)

# Project Components
The project is divided into three packages
- Application backend:   Source Packages/LMS
- Application frontend:  Source Packages/LMS.UI
- Application testing:   Test Packages/LMS

# Use Cases
## Actors
1. Admin
2. Librarian
3. Clerk
4. User/Borrower
## Functionalities
- Login / Logout
- Add Clerk
- Add Librarian
- Issue History
- View Books
- Search Book
- Place Book on Hold
- Profile Info
- Check Fine
- Book Request Queue
- Check In Book / Issue Book
- Check Out Book / Return Book
- Renew Book Issue
- Add Borrower / User
- Borrower / User Info
- Change Borrower / User Info
- Add Book
- Remove Book
- View Book Info
- Change Book Info
- Clerk Info

# Predefined Configurations
--> Admin have a fixed password which is: 'lib'

# Pre-requisites
## MS SQL Database
The file 'LMS.sql' is a database query file which is supposed to be run before executing application itself
## Netbeans or other IDE Installed
A java IDE, preferably NetBeans should be installed already.
## Dependency Libraries / JAR
Add following dependencies, like in Netbeans, using JAR files provided in root folder of this project:
- assertj-core-3.8.0
- assertj-swing-3.8.0
- fest-util-1.2.5
- hamcrest-core-1.3
- junit-4.13
- sqljdbc4-chs-4.0.2206.100

# Run app
To run app:
- Right-Click on 'Main.java' file in 'LMS' source package and select 'Run File'.

To test app:
- Right-Click on 'AA_ALL_TEST_CASES_RUN.java' file in 'LMS' test package and select 'Test File'.
