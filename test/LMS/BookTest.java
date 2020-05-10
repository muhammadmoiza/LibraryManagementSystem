/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class BookTest {
    
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

 


    /**
     * Test of printHoldRequests method, of class Book.
     */
    @Test
    public void testPrintHoldRequests() {
        System.out.println("printHoldRequests");
        //Book instance = null;
        Book test_book = new Book(203, "my book","my subject", "hamza", true);
        String expResult = "\nNo Hold Requests.";
        String result = test_book.printHoldRequests();
        assertEquals(expResult, result);
        
    }
 
 
       /**
     * Test of printHoldRequests method 2, of class Book.
     */
    @Test
    public void testPrintHoldRequests1() {
        System.out.println("printHoldRequests");
        //Book instance = null;
        Book test_book = new Book(203, "my book","my subject", "hamza", true);
        Borrower borrower = new Borrower(1, "Hamza", "address", "0123", "123");
        HoldRequest holdRequest = new HoldRequest(borrower, test_book, new Date());
        test_book.addHoldRequest(holdRequest);
        
        /// expected result making
        
        String expResult = "";
        expResult += "\nHold Requests are: \n";

        expResult += "---------------------------------------------------------------------------------------------------------------------------------------\n";
        expResult += "No.\t\tBook's Title\t\t\tBorrower's Name\t\t\tRequest Date\n";
        expResult += "---------------------------------------------------------------------------------------------------------------------------------------\n";

        expResult += Integer.toString(0) + "-" + "\t\t\n";
        expResult += test_book.getTitle() + "\t" + borrower.getName() + "\t"  + new Date() + "\n";
 
        String result = test_book.printHoldRequests();
        assertEquals(expResult, result);
    }
    
   
    /**
     * Test of makeHoldRequest method, of class Book.
     */
    @Test
    public void testMakeHoldRequest1() {
        System.out.println("makeHoldRequest");
    
        Book test_book = new Book(203, "my book","my subject", "hamza", true);
        Borrower borrower = new Borrower(1, "Hamza", "address", "0123", "123");
        
        String expResult = "Hold request added";
        String result = test_book.makeHoldRequest(borrower);
        assertEquals(expResult, result);
    }

    /**
     * Test of makeHoldRequest method, of class Book.
     */
    @Test
    public void testMakeHoldRequest2() {
        System.out.println("makeHoldRequest");
        // when perwson has already borrowed that book
        
        Book test_book = new Book(203, "my book","my subject", "hamza", true);
        Borrower borrower = new Borrower(1, "Hamza", "address", "0123", "123");
        Staff s = new Staff(1, "Hamza", "my_addrr", "0320", "123", 10000);
        Loan loan = new Loan(borrower, test_book, s, s, new Date(), new Date(), true);
        
        borrower.addBorrowedBook(loan);
        
        String expResult = "You have already borrowed " + test_book.getTitle();
        String result = test_book.makeHoldRequest(borrower);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of makeHoldRequest method, of class Book.
     */
    @Test
    public void testMakeHoldRequest3() {
        System.out.println("makeHoldRequest");
        // when perwson has not already borrowed that book
        
        Book test_book = new Book(203, "my book","my subject", "hamza", true);
        Borrower borrower = new Borrower(1, "Hamza", "address", "0123", "123");
        Staff s = new Staff(1, "Hamza", "my_addrr", "0320", "123", 10000);
        Date date = new Date();
        date = Date.from(Instant.EPOCH);
        
        // borrower had books but not this one
        
        Book not_this = new Book(2019, "not my book","not my subject", "not hamza", true);
        Loan loan = new Loan(borrower, not_this, s, s, date, date, true);
        borrower.addBorrowedBook(loan);
        
        String expResult = "Hold request added";
        String result = test_book.makeHoldRequest(borrower);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
   /**
     * Test of makeHoldRequest method, of class Book.
     */
    @Test
    public void testMakeHoldRequest4() {
        System.out.println("makeHoldRequest");
        // when perwson has hold requests
        
        Book test_book = new Book(203, "my book","my subject", "hamza", true);
        Borrower borrower = new Borrower(1, "Hamza", "address", "0123", "123");

        // borrower had books but not this one
        
        Book not_this = new Book(2019, "not my book","not my subject", "not hamza", true);
        HoldRequest hr = new HoldRequest(borrower, not_this, new Date());
        borrower.addHoldRequest(hr);
        
        String expResult = "Hold request added";
        String result = test_book.makeHoldRequest(borrower);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of makeHoldRequest method, of class Book.
     */
    @Test
    public void testMakeHoldRequest5() {
        System.out.println("makeHoldRequest");
        // when perwson has already hold requested for that book
        
        Book test_book = new Book(203, "my book","my subject", "hamza", true);
        Borrower borrower = new Borrower(1, "Hamza", "address", "0123", "123");
        
        HoldRequest hr = new HoldRequest(borrower, test_book, new Date());
        borrower.addHoldRequest(hr);
        test_book.placeBookOnHold(borrower);
                
        String expResult = "\nYou already have one hold request for this book.\n";
        String result = test_book.makeHoldRequest(borrower);
        assertEquals(expResult, result);
    }
    
    
    
    
    /**
     * Test of issueBook method, of class Book.
     */
    @Test
    public void testIssueBook() {
        System.out.println("issueBook");
        
        // data preparation when book had hold requests
        Book test_book = new Book(203, "my book","my subject", "hamza", false);
        Borrower borrower = new Borrower(1, "Hamza", "address", "0123", "123");
        
        HoldRequest hr = new HoldRequest(borrower, test_book, new Date());
        test_book.addHoldRequest(hr);
        
        String output = "";
        
        Staff sta = new Staff(5, "Ali", "Imperial Gardens", "0320", "123", 10000);

        output += "\nThe book " + test_book.getTitle() + " is successfully issued to " + borrower.getName() + ". ";
        output += "\nIssued by: " + sta.getName() + ".";
        
        String result = test_book.issueBook(borrower, sta);
        assertEquals(output, result);
    }

    
    /**
     * Test of issueBook method, of class Book.
     */
    @Test
    public void testIssueBook2() {
        System.out.println("issueBook");
        
        // data preparation when book had no hold requests
        
        Book test_book = new Book(203, "my book","my subject", "hamza", false);
        Borrower borrower = new Borrower(1, "Hamza", "address", "0123", "123");
        
        String output = "";
        
        Staff sta = new Staff(5, "Ali", "Imperial Gardens", "0320", "123", 10000);

        output += "\nThe book " + test_book.getTitle() + " is successfully issued to " + borrower.getName() + ". ";
        output += "\nIssued by: " + sta.getName() + ".";
        
        String result = test_book.issueBook(borrower, sta);
        assertEquals(output, result);
    }
    
    /**
     * Test of issueBook method, of class Book.
     */
    @Test
    public void testIssueBook3() {
        System.out.println("issueBook");
        
        // data preparation when book was issued 
        Book test_book = new Book(203, "my book","my subject", "hamza", true);
        Borrower borrower = new Borrower(1, "Hamza", "address", "0123", "123");
        
        String output = "";
        
        Staff sta = new Staff(5, "Ali", "Imperial Gardens", "0320", "123", 10000);

        output += "\nThe book " + test_book.getTitle() + " is already issued. You are added to hold requests.";
        
        String result = test_book.issueBook(borrower, sta);
        assertEquals(output, result);
    }
    
    
    /**
     * Test of issueBook method, of class Book.
     */
    @Test
    public void testIssueBook4() {
        System.out.println("issueBook");
        
        // data preparation when book was issued 
        Book test_book = new Book(203, "my book","my subject", "hamza", false);
        Borrower borrower = new Borrower(1, "Hamza", "address", "0123", "123");
      
        
        String output = "";        
        Staff sta = new Staff(5, "Ali", "Imperial Gardens", "0320", "123", 10000);

        output += "\nThe book " + test_book.getTitle() + " is successfully issued to " + borrower.getName() + ". ";
        output += "\nIssued by: " + sta.getName() + ".";  
        
        String result = test_book.issueBook(borrower, sta);
        assertEquals(output, result);
    }
    
    /**
     * Test of issueBook method, of class Book.
     */
    @Test
    public void testIssueBook5() {
        System.out.println("issueBook");
        
        // data preparation when book was issued 
        Book test_book = new Book(203, "my book","my subject", "hamza", false);
        Borrower borrower1 = new Borrower(1, "Hamza", "address", "0123", "123");
        Borrower borrower2 = new Borrower(3, "hello", "ajsda", "0320", "123");
        Borrower borrower3 = new Borrower(5, "sam969696", "address", "0123", "123");        

        //assigning this book to some other user
        test_book.placeBookOnHold(borrower1);
        test_book.placeBookOnHold(borrower2);
        
        // 3 ttrying to get this book
        String output = "";        
        Staff sta = new Staff(5, "Ali", "Imperial Gardens", "0320", "123", 10000);
        output += "\nSorry some other users have requested for this book earlier than you. So you have to wait until their hold requests are processed.";

        String result = test_book.issueBook(borrower2, sta);
        assertEquals(output, result);
    }
}
    





