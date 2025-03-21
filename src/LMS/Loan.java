
package LMS;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class Loan 
{
    private Borrower borrower;      
    private Book book;
    
    private Staff issuer;
    private Date issuedDate;
    
    private Date dateReturned;
    private Staff receiver;
    
    private boolean finePaid;
       
    public Loan(Borrower borr, Book bk, Staff in, Staff rt, Date issdat, Date retdate, boolean fPaid)  
    {
        borrower = borr;
        book = bk;
        issuer = in;
        receiver = rt;
        issuedDate = issdat;
        dateReturned = retdate;
        
        finePaid = fPaid;
    }
    
    
    public Book getBook()       //Returns the book
    {
        return book;
    }
    
    public Staff getIssuer()     //Returns the Staff Member who issued the book
    {
        return issuer;
    }
    
    public Staff getReceiver()  //Returns the Staff Member to whom book is returned
    {
        return receiver;
    }
    
    public Date getIssuedDate()     //Returns the date on which this particular book was issued
    {
        return issuedDate;
    } 

    public Date getReturnDate()     //Returns the date on which this particular book was returned
    {
        return dateReturned;
    }
    
    public Borrower getBorrower()   //Returns the Borrower to whom the book was issued
    {
        return borrower;
    }
    
    public boolean getFineStatus()  // Returns status of fine
    {
        return finePaid;
    }
   
    public void setReturnedDate(Date retdat)
    {
        dateReturned = retdat;
    }
    
    public void setFineStatus(boolean fStat)
    {
        finePaid = fStat;
    }    
    
    public void setReceiver(Staff rec)
    {
        receiver = rec;
    }
    /*-------------------------------------------*/
    



    //Computes fine for a particular loan only
    public double computeFine1()
    {

        //-----------Computing Fine-----------        
        double totalFine = 0;
        
        if (!finePaid)
        {    
            Date issDate = issuedDate;
            Date retDate = new Date();                

            long days =  ChronoUnit.DAYS.between(retDate.toInstant(), issDate.toInstant());        
            days=0-days;

            days = days - Library.getInstance().book_return_deadline;

            if(days>0)
                totalFine = days * Library.getInstance().per_day_fine;
            else
                totalFine=0;
        }
        return totalFine;
    }
    
    
    public void payFine()
    {
        //-----------Computing Fine-----------//
        
        double totalFine = computeFine1();
                
        if (totalFine > 0)
        {
                finePaid = true;
        }      
    }


    // Extending issued Date 
    public void renewIssuedBook(Date issDate)
    {        
        issuedDate = issDate;
        
        System.out.println("\nThe deadline of the book " + getBook().getTitle() + " has been extended.");
        System.out.println("Issued Book is successfully renewed!\n");
    }












    
}   