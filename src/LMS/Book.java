package LMS;

import java.io.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Book {

    private int bookID;           // ID given by a library to a book to make it distinguishable from other books
    private String title;         // Title of a book 
    private String subject;       // Subject to which a book is related!
    private String author;        // Author of book!
    private boolean isIssued;        // this will be true if the book is currently issued to some borrower.
    private ArrayList<HoldRequest> holdRequests; // record of all hold request on that book

    static int currentIdNumber = 0;     //This will be unique for every book, since it will be incremented when everytime
    //when a book is created

    public Book(int id, String titl, String sub, String aut, boolean issued) // Parameterise cons.
    {
        currentIdNumber++;
        if (id == -1) {
            bookID = currentIdNumber;
        } else {
            bookID = id;
        }

        title = titl;
        subject = sub;
        author = aut;
        isIssued = issued;

        holdRequests = new ArrayList();
    }

    // adding a hold req.
    public void addHoldRequest(HoldRequest hr) {
        holdRequests.add(hr);
    }

    // removing a hold req.
    public void removeHoldRequest() {
        if (!holdRequests.isEmpty()) {
            holdRequests.remove(0);
        }
    }

    // printing all hold req on a book.
    public String printHoldRequests() {
        String string = "";
        if (!holdRequests.isEmpty()) {
            string += "\nHold Requests are: \n";

            string += "---------------------------------------------------------------------------------------------------------------------------------------\n";
            string += "No.\t\tBook's Title\t\t\tBorrower's Name\t\t\tRequest Date\n";
            string += "---------------------------------------------------------------------------------------------------------------------------------------\n";

            for (int i = 0; i < holdRequests.size(); i++) {
                string += Integer.toString(i) + "-" + "\t\t\n";
                string += holdRequests.get(i).print();
            }
        } else {
            string += "\nNo Hold Requests.";
        }
        return string;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // printing book's Info
    public void printInfo() {
        System.out.println(title + "\t\t\t" + author + "\t\t\t" + subject);
    }

    public String toString() {
        return (Integer.toString(bookID) + "\t" + title + "\t" + author + "\t" + subject + "\n");
    }

    // changign Info of a Book
    public void changeBookInfo() throws IOException {
        Scanner scan = new Scanner(System.in);
        String input;

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nUpdate Author? (y/n)");
        input = scan.next();

        if (input.equals("y")) {
            System.out.println("\nEnter new Author: ");
            author = read.readLine();
        }

        System.out.println("\nUpdate Subject? (y/n)");
        input = scan.next();

        if (input.equals("y")) {
            System.out.println("\nEnter new Subject: ");
            subject = read.readLine();
        }

        System.out.println("\nUpdate Title? (y/n)");
        input = scan.next();

        if (input.equals("y")) {
            System.out.println("\nEnter new Title: ");
            title = read.readLine();
        }

        System.out.println("\nBook is successfully updated.");

    }

    /*------------Getter FUNCs.---------*/
    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getIssuedStatus() {
        return isIssued;
    }

    public void setIssuedStatus(boolean s) {
        isIssued = s;
    }

    public int getID() {
        return bookID;
    }

    public ArrayList<HoldRequest> getHoldRequests() {
        return holdRequests;
    }
    /*-----------------------------------*/

    // Setter Static Func.
    public static void setIDCount(int n) {
        currentIdNumber = n;
    }

    //-------------------------------------------------------------------//
    // Placing book on Hold
    public void placeBookOnHold(Borrower bor) {
        HoldRequest hr = new HoldRequest(bor, this, new Date());

        addHoldRequest(hr);        //Add this hold request to holdRequests queue of this book
        bor.addHoldRequest(hr);      //Add this hold request to that particular borrower's class as well

        System.out.println("\nThe book " + title + " has been successfully placed on hold by borrower " + bor.getName() + ".\n");
    }

    // Request for Holding a Book
    public String makeHoldRequest(Borrower borr) {
        boolean makeRequest = true;

        //If that borrower has already borrowed that particular book. Then he isn't allowed to make request for that book. He will have to renew the issued book in order to extend the return deadline.
        for (int i = 0; i < borr.getBorrowedBooks().size(); i++) {
            if (borr.getBorrowedBooks().get(i).getBook() == this) {
                return ("You have already borrowed " + title);
            }
        }

        //If that borrower has already requested for that particular book. Then he isn't allowed to make the same request again.
        for (int i = 0; i < holdRequests.size(); i++) {
            if ((holdRequests.get(i).getBorrower() == borr)) {
                makeRequest = false;
                break;
            }
        }

        if (makeRequest) {
            placeBookOnHold(borr);
            return "Hold request added";
        } else {
            return "\nYou already have one hold request for this book.\n";
        }
    }

    // Gertting Info of a Hold Request
    public void serviceHoldRequest(HoldRequest hr) {
        removeHoldRequest();
        hr.getBorrower().removeHoldRequest(hr);
    }

    // Issuing a Book
    public String issueBook(Borrower borro, Staff sta) {
        //First deleting the expired hold requests
        Date today = new Date();
        String string = "";
        ArrayList<HoldRequest> hRequests = holdRequests;

        for (int i = 0; i < hRequests.size(); i++) {
            HoldRequest hr = hRequests.get(i);

            //Remove that hold request which has expired
            long days = ChronoUnit.DAYS.between(today.toInstant(), hr.getRequestDate().toInstant());
            days = 0 - days;

            if (days > Library.getInstance().getHoldRequestExpiry()) {
                removeHoldRequest();
                hr.getBorrower().removeHoldRequest(hr);
            }
        }

        if (isIssued) {
            string += "\nThe book " + title + " is already issued. You are added to hold requests.";
            makeHoldRequest(borro);
        } else {
            if (!holdRequests.isEmpty()) {
                boolean hasRequest = false;

                for (int i = 0; i < holdRequests.size() && !hasRequest; i++) {
                    if (holdRequests.get(i).getBorrower() == borro) {
                        hasRequest = true;
                    }

                }

                if (hasRequest) {
                    //If this particular borrower has the earliest request for this book
                    if (holdRequests.get(0).getBorrower() == borro) {
                        serviceHoldRequest(holdRequests.get(0));
                    } else {
                        string += "\nSorry some other users have requested for this book earlier than you. So you have to wait until their hold requests are processed.";
                        return string;
                    }
                } else {
                    string += "\nYou have not placed a request before and others have, your request have been added now. Please wait for your turn";
                    makeHoldRequest(borro);

                    return string;
                }
            }

            //If there are no hold requests for this book, then simply issue the book.            
            setIssuedStatus(true);

            Loan iHistory = new Loan(borro, this, sta, null, new Date(), null, false);

            Library.getInstance().addLoan(iHistory);
            borro.addBorrowedBook(iHistory);

            string += "\nThe book " + title + " is successfully issued to " + borro.getName() + ". ";
            string += "\nIssued by: " + sta.getName() + ".";
        }
        return string;
    }

    // Returning a Book
    public void returnBook(Borrower borrower, Loan l, Staff staff) {
        l.getBook().setIssuedStatus(false);
        l.setReturnedDate(new Date());
        l.setReceiver(staff);

        borrower.removeBorrowedBook(l);

        l.payFine();

        System.out.println("\nThe book " + l.getBook().getTitle() + " is successfully returned by " + borrower.getName() + ".");
        System.out.println("\nReceived by: " + staff.getName());
    }

}   // Book Class Closed
