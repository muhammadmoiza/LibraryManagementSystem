/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author itsme
 */
public class GUIHandler {    
    
    public static Library lib;
    public Connection con;
    
    GUIHandler(){
        lib = Library.getInstance();
        
        // Setting some by default information like name of library ,fine, deadline and limit of hold request
        lib.setFine(20);
        lib.setRequestExpiry(7);
        lib.setReturnDeadline(5);
        lib.setName("FAST Library");
        
        
        // Making connection with Database.
        con = lib.makeConnection();
    
        if (con == null)    // Oops can't connnect !
        {
            System.out.println("\nError connecting to Database. Exiting.");
            return;
        }
        
        
        try {

            lib.populateLibrary(con);   // Populating Library with all Records
            
        } catch(Exception e){}
    }
    
    // Clearing Required Area of Screen
    public static void clrscr()
    {
        for (int i = 0; i < 20; i++)
            System.out.println();
    }

    // Asking for Input as Choice
    public static int takeInput(int mi, int ma)
    {    
        String choice;
        Scanner input = new Scanner(System.in);        
        
        while(true)
        {
            System.out.println("\nEnter Choice: ");

            choice = input.next();

            if((!choice.matches(".*[a-zA-Z]+.*")) && (Integer.parseInt(choice) > mi && Integer.parseInt(choice) < ma))
            {
                return Integer.parseInt(choice);
            }
            
            else
                System.out.println("\nInvalid Input.");
        }
          
    }

/*    
    // Functionalities of all Persons
    public static void allFunctionalities(Person per, int choice) throws IOException
    {
        Library lib = Library.getInstance();
        
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        
        //Search Book
        if (choice == 1)
        {
            String book_filter = scanner.nextLine();
            lib.searchForBooks(book_filter, 1);
        }
        
        //Do Hold Request
        else if (choice == 2)
        {
            String book_filter = scanner.nextLine();
            String book = lib.searchForBooks(book_filter, 1);
            
            if (book != null)
            {
                input = takeInput(-1,books.size());
                
                Book b = book.get(input);
                
                if("Clerk".equals(per.getClass().getSimpleName()) || "Librarian".equals(per.getClass().getSimpleName()))
                {                
                    Borrower bor = lib.findBorrower();

                    if (bor != null)
                        b.makeHoldRequest(bor);
                }
                else                
                    b.makeHoldRequest((Borrower)per);
            }
        }
        
        //View borrower's personal information
        else if (choice == 3)
        {
            if("Clerk".equals(per.getClass().getSimpleName()) || "Librarian".equals(per.getClass().getSimpleName()))
            {
                Borrower bor = lib.findBorrower();
                
                if(bor!=null)
                    bor.printInfo();
            }
            else
                per.printInfo();
        }
        
        //Compute Fine of a Borrower
        else if (choice == 4)
        {
            if("Clerk".equals(per.getClass().getSimpleName()) || "Librarian".equals(per.getClass().getSimpleName()))
            {
                Borrower bor = lib.findBorrower();
                
                if(bor!=null)
                {
                    double totalFine = lib.computeFine2(bor);
                    System.out.println("\nYour Total Fine is : Rs " + totalFine );                    
                }
            }
            else
            {
                double totalFine = lib.computeFine2((Borrower)per);
                System.out.println("\nYour Total Fine is : Rs " + totalFine );                 
            }
        }
        
        //Check hold request queue of a book
        else if (choice == 5)
        {
            ArrayList<Book> books = lib.searchForBooks();
            
            if (books != null)
            {
                input = takeInput(-1,books.size());
                books.get(input).printHoldRequests();
            }
        }
                       
        //Issue a Book
        else if (choice == 6)
        {
            ArrayList<Book> books = lib.searchForBooks();

            if (books != null)
            {
                input = takeInput(-1,books.size());
                Book b = books.get(input);
                
                Borrower bor = lib.findBorrower();

                if(bor!=null)
                {
                    b.issueBook(bor, (Staff)per);            
                }
            }
        }        

        //Return a Book
        else if (choice == 7)
        {
            Borrower bor = lib.findBorrower();

            if(bor!=null)
            {
                bor.printBorrowedBooks();
                ArrayList<Loan> loans = bor.getBorrowedBooks();
                
                if (!loans.isEmpty())
                {
                    input = takeInput(-1,loans.size());
                    Loan l = loans.get(input);
                    
                    l.getBook().returnBook(bor, l, (Staff)per);            
                }
                else
                    System.out.println("\nThis borrower " + bor.getName() + " has no book to return.");
            }
        }        

        //Renew a Book
        else if (choice == 8)
        {
            Borrower bor = lib.findBorrower();

            if(bor!=null)
            {
                bor.printBorrowedBooks();
                ArrayList<Loan> loans = bor.getBorrowedBooks();
                
                if (!loans.isEmpty())
                {
                    input = takeInput(-1,loans.size());
 
                    loans.get(input).renewIssuedBook(new java.util.Date()); 
                }
                else
                    System.out.println("\nThis borrower " + bor.getName() + " has no issued book which can be renewed.");                    
            }
        }        

        //Add new Borrower
        else if (choice == 9)
        {
            lib.createPerson('b');
        }        

        //Update Borrower's Personal Info
        else if (choice == 10)
        {
            Borrower bor = lib.findBorrower();
            
            if(bor != null)
                bor.updateBorrowerInfo();
        }        
        
        //Add new Book
        else if (choice == 11)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("\nEnter Title:");
            String title = reader.readLine();

            System.out.println("\nEnter Subject:");
            String subject = reader.readLine();

            System.out.println("\nEnter Author:");
            String author = reader.readLine();
            
            lib.createBook(title, subject, author);
        }        
        
        //Remove a Book
        else if (choice == 12)
        {
            ArrayList<Book> books = lib.searchForBooks();
            
            if (books != null)
            {
                input = takeInput(-1,books.size());
            
                lib.removeBookfromLibrary(books.get(input));
            }
        }        

        //Change a Book's Info
        else if (choice == 13)
        {
            ArrayList<Book> books = lib.searchForBooks("try", 1);
            
            if (books!=null)
            {
                input = takeInput(-1,books.size());
            
                books.get(input).changeBookInfo();
            }
        }        
            
        //View clerk's personal information
        else if (choice == 14)
        {
            Clerk clerk = lib.findClerk();

            if(clerk!=null)
                clerk.printInfo();
        }
        
        // Functionality Performed.
        System.out.println("\nPress any key to continue..\n");
        scanner.next();
    }
*/
}
