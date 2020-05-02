package LMS;

import java.util.Date;

public class HoldRequest {
    
    Borrower borrower;
    Book book;
    Date requestDate;
    
    public HoldRequest(Borrower bor, Book b, Date reqDate)  
    {
        borrower = bor;
        book = b;
        requestDate = reqDate;
    }
    
    /*----- Getter FUNCs.--------*/
    public Borrower getBorrower()
    {
        return borrower;
    }
    
    public Book getBook()
    {
        return book;
    }
    
    public Date getRequestDate()
    {
        return requestDate;
    }
    /*--------------------------*/
    
    // Print Hold Request Info 
    public String print()
    {
        return (book.getTitle() + "\t" + borrower.getName() + "\t"  + requestDate + "\n");
    }
}// HoldRequest Class Closed
