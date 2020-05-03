
package LMS;


// Including Header Files.
import static LMS.GUIHandler.lib;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Types;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Library {
    
    private String name;                                // name of library
    private Librarian librarian;                        // object of Librarian (only one)                       
    private ArrayList <Person> persons;                 // all clerks and borrowers  
    private ArrayList <Book> booksInLibrary;            // all books in library are here!
    
    private ArrayList <Loan> loans;                     // history of all books which have been issued
        
    public int book_return_deadline;                   //return deadline after which fine will be generated each day
    public double per_day_fine;
    
    public int hold_request_expiry;                    //number of days after which a hold request will expire
    
    
    /*----Following Singleton Design Pattern (Lazy Instantiation)------------*/
    private static Library obj;
   
    public static Library getInstance()
    {
        if(obj==null)
        {
            obj = new Library();
        }
        
        return obj;
    }
    
    
    private Library()   
    {
        name = null;
        librarian = null;
        persons = new ArrayList();
    
        booksInLibrary = new ArrayList();
        loans = new ArrayList();
    }

    private void clearLibrary()
    {
        name = null;                                // name of library
        librarian = null;                        // object of Librarian (only one)                       
        persons = new ArrayList();                 // all clerks and borrowers  
        booksInLibrary = new ArrayList();            // all books in library are here!

        loans = new ArrayList();                     // history of all books which have been issued

    }
    
    public void setReturnDeadline(int deadline)
    {
        book_return_deadline = deadline;
    }

    public void setFine(double perDayFine)
    {
        per_day_fine = perDayFine;
    }

    public void setRequestExpiry(int hrExpiry)
    {
        hold_request_expiry = hrExpiry;
    }

    public void setName(String n)   
    {
        name = n;
    }
    
    public Librarian getLibrarian(){
        return librarian;
    }
    
    public int getHoldRequestExpiry()
    {
        return hold_request_expiry;
    }
    
    public ArrayList<Person> getPersons()
    {
        return persons;
    }
    
      
    public String getLibraryName()
    {
        return name;
    }

    public ArrayList<Book> getBooks()
    {
        return booksInLibrary;
    }
    
    public ArrayList<Loan> getLoans(){
        return loans;
    }
    /*---------------------------------------*/
    
    /*-----Adding all People in Library----*/
    public boolean addLibrarian(Librarian lib)
    {
        //One Library can have only one Librarian
        if (librarian == null)
        {
            librarian = lib;
            persons.add(librarian);
            return true;
        }
        else
            System.out.println("\nSorry, the library already has one librarian. New Librarian can't be created.");
        return false;
    }
    
    public void addClerk(Clerk cle) 
    {
        persons.add(cle);
    }

    public void addBorrower(Borrower borr)
    {
        persons.add(borr);
    }

    
    public void addLoan(Loan lo)
    {
        loans.add(lo);
    }
    
    /*----------------------------------------------*/
      
    /*-----------Finding People in Library--------------*/
    public Borrower findBorrower(int id)
    {
        for (int i = 0; i < persons.size(); i++)
        {
            if (persons.get(i).getID() == id && !persons.get(i).getClass().getSimpleName().equals("Clerk") && !persons.get(i).getClass().getSimpleName().equals("Librarian"))
            {
                return (Borrower)(persons.get(i));
            }
        }
        return null;
    }
    
    public Clerk findClerk(int id)
    {

        for (int i = 0; i < persons.size(); i++)
        {
            if (persons.get(i).getID() == id && persons.get(i).getClass().getSimpleName().equals("Clerk"))
                return (Clerk)(persons.get(i));
        }
        
        return null;
    }
    
    /*------- FUNCS. on Books In Library--------------*/
    public void addBookinLibrary(Book b)
    {
        booksInLibrary.add(b);
    }
    
    //When this function is called, only the pointer of the book placed in booksInLibrary is removed. But the real object of book
    //is still there in memory because pointers of that book placed in IssuedBooks and ReturnedBooks are still pointing to that book. And we
    //are maintaining those pointers so that we can maintain history.
    //But if we donot want to maintain history then we can delete those pointers placed in IssuedBooks and ReturnedBooks as well which are
    //pointing to that book. In this way the book will be really removed from memory.
    public String removeBookfromLibrary(int id)  
    {
        String string = "";
        boolean delete = true;
        
        Book bk = null;
        for(int i = 0;i < lib.getBooks().size();i++)
        {
            if(lib.getBooks().get(i).getID() == id){
                bk = lib.getBooks().get(i);
            }
        }
        if(bk == null){
            string += "No book found against this id";
            return string;
        }
        
        //Checking if this book is currently borrowed by some borrower
        for (int i = 0; i < persons.size() && delete; i++)
        {
            if (persons.get(i).getClass().getSimpleName().equals("Borrower"))
            {
                ArrayList<Loan> borBooks = ((Borrower)(persons.get(i))).getBorrowedBooks();
                
                for (int j = 0; j < borBooks.size() && delete; j++)
                {
                    if (borBooks.get(j).getBook() == bk)
                    {
                        delete = false;
                    }
                }              
            }
        }
        
        if (delete)
        {
            ArrayList<HoldRequest> hRequests = bk.getHoldRequests();
            
            if(!hRequests.isEmpty())
            {
                string += "This particular book is currently held by somw borrower. Delete Unsuccessful.";
            }
            else{
                booksInLibrary.remove(bk);
                string += "The book is successfully removed.";
            }
        }
        else{
            string += "This particular book is currently borrowed by some borrower. ";
            string += "Delete Unsuccessful.";
        }
        return string;
    }
    
    
    
    // Searching Books on basis of title, Subject or Author 
    public String searchForBooks(String string, int searchBy) throws IOException
    {
        String matchedBooks = "";
        int n = 0;
        //Printing all the matched Books
        matchedBooks += "--------------------------------------------------------------------------------------------------\n";
        matchedBooks += "ID\t\tTitle\t\tSubject\t\tAuthor\n";
        matchedBooks += "--------------------------------------------------------------------------------------------------\n";

        //Retrieving all the books which matched the user's search query
        for(int i = 0; i < booksInLibrary.size(); i++)
        {
            Book b = booksInLibrary.get(i);

            if (searchBy == 1)
            {
                if (b.getTitle().contains(string)){
                    matchedBooks += b.toString();
                    n++;
                }
            }
            else if (searchBy == 2)
            { 
                if (b.getSubject().contains(string)){
                    matchedBooks += b.toString();
                    n++;
                }
            }
            else if(searchBy == 3)
            {
                if (b.getAuthor().contains(string)){
                    matchedBooks += b.toString();   
                    n++;
                }
            }
        }
        if(n == 0)
        {
            matchedBooks = "\nSorry. No Books were found related to your query.";
        }
        return matchedBooks;
    }
    
    
    
    // View Info of all Books in Library
     public String viewAllBooks()
    {
        String string;
        if (!booksInLibrary.isEmpty())
        { 
            string = "\nBooks are: \n";
            
            string += "------------------------------------------------------------------------------------------\n";            
            string += "No.\t\tTitle\t\t\tAuthor\t\t\tSubject\n";
            string += "------------------------------------------------------------------------------------------\n";
            
            for (int i = 0; i < booksInLibrary.size(); i++)
            {                      
                string += Integer.toString(i) + "-" + "\t";
                string += booksInLibrary.get(i).toString();
                string += "\n";
            }
        }
        else
        {
            string = "\nCurrently, Library has no books.";
        }
        return string;
    }

    public Book findBook(int id){
        for(int i = 0;i < lib.getBooks().size();i++){
            if(lib.getBooks().get(i).getID() == id){
                return lib.getBooks().get(i);
            }
        }
        return null;
    }
     
    //Computes total fine for all loans of a borrower
    public double computeFine2(Borrower borrower)
    {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");            
        System.out.println("No.\t\tBook's Title\t\tBorrower's Name\t\t\tIssued Date\t\t\tReturned Date\t\t\t\tFine(Rs)");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");        
        
        double totalFine = 0;        
        double perloanfine = 0;
        
        for (int i = 0; i < loans.size(); i++)
        {
            Loan l = loans.get(i);
            
            if ((l.getBorrower() == borrower))
            {
                perloanfine = l.computeFine1();
                System.out.print(i + "-" + "\t\t" + loans.get(i).getBook().getTitle() + "\t\t\t" + loans.get(i).getBorrower().getName() + "\t\t" + loans.get(i).getIssuedDate() +  "\t\t\t" + loans.get(i).getReturnDate() + "\t\t\t\t" + perloanfine  + "\n");                
                
                totalFine += perloanfine;
            }            
        }
        
        return totalFine;
    }
    
    
    public String createPerson(char x, String name, String address, String phone, double salary)
    {  
        String string = "";
        //If clerk is to be created, it needs           Name, Address, Phone, Salary
        if (x == 'c')
        {            
            Clerk c = new Clerk(-1,name,address,phone, "-1",salary,-1);            
            addClerk(c);
            
            string += "\nClerk with name " + name + " created successfully.n";
            string += "\nYour ID is : " + c.getID() + "\n";
            string += "Your Password is : " + c.getPassword() + "\n";
        }
        
        //If librarian is to be created
        else if (x == 'l')
        {            
            Librarian l = new Librarian(-1,name,address,phone, "-1",salary,-1); 
            if(addLibrarian(l))
            {
                string += "\nLibrarian with name " + name + " created successfully.\n";
                string += "\nYour ID is : " + l.getID() + "\n";
                string += "Your Password is : " + l.getPassword() + "\n";
            }
        }

        //If borrower is to be created
        else
        {
            Borrower b = new Borrower(-1,name,address,phone, "-1");
            addBorrower(b);            
            string += "\nBorrower with name " + name + " created successfully.\n";
            string += "\nYour ID is : " + b.getID() + "\n";
            string += "Your Password is : " + b.getPassword() + "\n";            
        }        
        return string;
    }
     

       
    public void createBook(String tit, String sub, String aut)
    {
        Book b = new Book(-1,tit,sub,aut,false);
        
        addBookinLibrary(b);
        
        System.out.println("\nBook with Title " + b.getTitle() + " is successfully created.");
    }
    

    
    // Called when want an access to Portal
    public Person login(String uid, String password)
    {
        int id = Integer.parseInt(uid);
        for (int i = 0; i < persons.size(); i++)
        {
            System.out.println(persons.get(i).getID() + ":" + persons.get(i).getPassword());
            if (persons.get(i).getID() == id && persons.get(i).getPassword().equals(password))
            {
                System.out.println("\nLogin Successful");
                return persons.get(i);
            }
        }
        
        if(librarian!=null)
        {
            if (librarian.getID() == id && librarian.getPassword().equals(password))
            {
                System.out.println("\nLogin Successful");
                return librarian;
            }
        }
        
        System.out.println("\nSorry! Wrong ID or Password");        
        return null;
    }
    
    
    // History when a Book was Issued and was Returned!
    public String viewHistory()
    {
        String string;
        if (!loans.isEmpty())
        { 
            string = "\nIssued Books are: \n";
            
            string += "------------------------------------------------------------------------------------------------------------------------------------------------------\n";            
            string += "No.\tBook's Title\tBorrower's Name\tIssuer's Name\tIssued Date\tReceiver's Name\tReturned Date\tFine Paid\n";
            string += "------------------------------------------------------------------------------------------------------------------------------------------------------\n";
            
            for (int i = 0; i < loans.size(); i++)
            {    
                if(loans.get(i).getIssuer()!=null)
                    string += Integer.toString(i) + "-" + "\t" + loans.get(i).getBook().getTitle() + "\t" + loans.get(i).getBorrower().getName() + "\t" + loans.get(i).getIssuer().getName() + "\t" + loans.get(i).getIssuedDate();
                
                if (loans.get(i).getReceiver() != null)
                {
                    string += "\t" + loans.get(i).getReceiver().getName() + "\t" + loans.get(i).getReturnDate() +"\t" + loans.get(i).getFineStatus() + "\n";
                }
                else
                    string += "\t" + "--" + "\t" + "--" + "\t" + "--" + "\n";
            }
        }
        else{
            string = "\nNo issued books.\n";    
        }
        return string;
    }
    
    
    // Making Connection With Database    
    public Connection makeConnection()
    {        
        try
        {
            String host = "jdbc:sqlserver://localhost:1433;databaseName=LMS";//"jdbc:derby://localhost:1527/LMS";
            String uName = "sa";//"haris";
            String uPass= "admin";//"123";
            Connection con = DriverManager.getConnection( host, uName, uPass );
            System.out.println("DB Connected");
            return con;
        }
        catch ( SQLException err ) 
        {
            System.out.println( err.getMessage( ));
            return null;
        }   
    }
    
    
    // Loading all info in code via Database.
    public void populateLibrary(Connection con) throws SQLException, IOException
    {       
        this.clearLibrary();
        Library lib = this;
        Statement stmt = con.createStatement();

        /* --- Populating Book ----*/
        String SQL = "SELECT * FROM BOOK";
        ResultSet rs = stmt.executeQuery( SQL );

        if(!rs.next())
        {
           System.out.println("\nNo Books Found in Library"); 
        }
        else
        {
            int maxID = 0;

            do
            {
                if(rs.getString("TITLE") !=null && rs.getString("AUTHOR")!=null && rs.getString("SUBJECT")!=null && rs.getInt("ID")!=0)
                {
                    String title=rs.getString("TITLE");
                    String author=rs.getString("AUTHOR");
                    String subject=rs.getString("SUBJECT");
                    int id= rs.getInt("ID");
                    boolean issue=rs.getBoolean("IS_ISSUED");
                    Book b = new Book(id,title,subject,author,issue);
                    addBookinLibrary(b);

                    if (maxID < id)
                        maxID = id;
                }
            }while(rs.next());

            // setting Book Count
            Book.setIDCount(maxID);              
        }

        /* ----Populating Clerks----*/

        SQL="SELECT ID,PNAME,ADDRESS,PASSWORD,PHONE_NO,SALARY,DESK_NO FROM PERSON INNER JOIN CLERK ON ID=C_ID INNER JOIN STAFF ON S_ID=C_ID";

        rs=stmt.executeQuery(SQL);

        if(!rs.next())
        {
           System.out.println("No clerks Found in Library"); 
        }
        else
        {
            do
            {
                int id=rs.getInt("ID");
                String cname=rs.getString("PNAME");
                String adrs=rs.getString("ADDRESS"); 
                String phn=rs.getString("PHONE_NO");
                String pass=rs.getString("PASSWORD");
                double sal=rs.getDouble("SALARY");
                int desk=rs.getInt("DESK_NO");
                Clerk c = new Clerk(id,cname,adrs,phn, pass,sal,desk);

                addClerk(c);
            }
            while(rs.next());

        }

        /*-----Populating Librarian---*/
        SQL="SELECT ID,PNAME,ADDRESS,PASSWORD,PHONE_NO,SALARY,OFFICE_NO FROM PERSON INNER JOIN LIBRARIAN ON ID=L_ID INNER JOIN STAFF ON S_ID=L_ID";

        rs=stmt.executeQuery(SQL);
        if(!rs.next())
        {
           System.out.println("No Librarian Found in Library"); 
        }
        else
        {
            do
            {
                int id=rs.getInt("ID");
                String lname=rs.getString("PNAME");
                String adrs=rs.getString("ADDRESS"); 
                String phn=rs.getString("PHONE_NO");
                String pass=rs.getString("PASSWORD");
                double sal=rs.getDouble("SALARY");
                int off=rs.getInt("OFFICE_NO");
                Librarian l= new Librarian(id,lname,adrs,phn,pass,sal,off);

                System.out.println(Integer.toString(id));

                addLibrarian(l);

            }while(rs.next());

        }

        /*---Populating Borrowers --------*/

        SQL="SELECT ID,PNAME,ADDRESS,PASSWORD,PHONE_NO FROM PERSON INNER JOIN BORROWER ON ID=B_ID";

        rs=stmt.executeQuery(SQL);

        if(!rs.next())
        {
           System.out.println("No Borrower Found in Library"); 
        }
        else
        {
            do
            {
                int id=rs.getInt("ID");
                String name=rs.getString("PNAME");
                String addr=rs.getString("ADDRESS"); 
                String phno=rs.getString("PHONE_NO");
                String pass=rs.getString("PASSWORD");

                System.out.println(Integer.toString(id));

                Borrower b= new Borrower(id,name,addr,phno, pass);
                addBorrower(b);

            }while(rs.next());

        }

        /*----Populating Loan----*/

        SQL="SELECT * FROM LOAN";

        rs=stmt.executeQuery(SQL);
        if(!rs.next())
        {
           System.out.println("No Books Issued Yet!"); 
        }
        else
        {
            do
            {
                int borrid=rs.getInt("BORROWER");
                int bookid=rs.getInt("BOOK");
                int issid=rs.getInt("ISSUER");
                Integer recid=(Integer)rs.getObject("RECEIVER");
                int rd=0;
                Date rdate;

                Date issdate=new Date (rs.getTimestamp("ISS_DATE").getTime());

                if(recid!=null)    // if there is a receiver 
                {
                    rdate=new Date (rs.getTimestamp("RET_DATE").getTime()); 
                    rd=(int)recid;
                }
                else
                {
                    rdate=null;
                }

                boolean fineStatus = rs.getBoolean("FINE_PAID");

                boolean set=true;

                Borrower bb = null;


                for(int i=0;i<getPersons().size() && set;i++)
                {
                    if(getPersons().get(i).getID()==borrid)
                    {
                        set=false;
                        bb=(Borrower)(getPersons().get(i));
                    }
                }

                set =true;
                Staff s[]=new Staff[2];

                if(issid==getLibrarian().getID())
                {
                    s[0]=getLibrarian();
                }

                else
                {                                
                    for(int k=0;k<getPersons().size() && set;k++)
                    {
                        if(getPersons().get(k).getID()==issid && getPersons().get(k).getClass().getSimpleName().equals("Clerk"))
                        {
                            set=false;
                            s[0]=(Clerk)(getPersons().get(k));
                        }
                    }
                }       

                set=true;
                // If not returned yet...
                if(recid==null)
                {
                    s[1]=null;  // no reciever 
                    rdate=null;      
                }
                else
                {
                    if(rd==getLibrarian().getID())
                        s[1]=getLibrarian();

                    else
                    {    //System.out.println("ff");
                         for(int k=0;k<getPersons().size() && set;k++)
                        {
                            if(getPersons().get(k).getID()==rd && getPersons().get(k).getClass().getSimpleName().equals("Clerk"))
                            {
                                set=false;
                                s[1]=(Clerk)(getPersons().get(k));
                            }
                        }
                    }     
                }

                set=true;

                ArrayList<Book> books = getBooks();

                for(int k=0;k<books.size() && set;k++)
                {
                    if(books.get(k).getID()==bookid)
                    {
                      set=false;   
                      Loan l = new Loan(bb,books.get(k),s[0],s[1],issdate,rdate,fineStatus);
                      loans.add(l);
                    }
                }

            } while(rs.next());
        }

        /*----Populationg Hold Books----*/

        SQL="SELECT * FROM ON_HOLD_BOOK";

        rs=stmt.executeQuery(SQL);
        if(!rs.next())
        {
           System.out.println("No Books on Hold Yet!"); 
        }
        else
        {
            do
            {
                int borrid=rs.getInt("BORROWER");
                int bookid=rs.getInt("BOOK");
                Date off=new Date (rs.getDate("REQ_DATE").getTime());

                boolean set=true;
                Borrower bb =null;

                ArrayList<Person> persons = lib.getPersons();

                for(int i=0;i<persons.size() && set;i++)
                {
                    if(persons.get(i).getID()==borrid)
                    {
                        set=false;
                        bb=(Borrower)(persons.get(i));
                    }
                }

                set=true;

                ArrayList<Book> books = lib.getBooks();

                for(int i=0;i<books.size() && set;i++)
                {
                    if(books.get(i).getID()==bookid)
                    {
                      set=false;   
                      HoldRequest hbook= new HoldRequest(bb,books.get(i),off);
                      books.get(i).addHoldRequest(hbook);
                      bb.addHoldRequest(hbook);
                    }
                }
            } while(rs.next());
        }

        /* --- Populating Borrower's Remaining Info----*/

        // Borrowed Books
        SQL="SELECT ID,BOOK FROM PERSON INNER JOIN BORROWER ON ID=B_ID INNER JOIN BORROWED_BOOK ON B_ID=BORROWER ";

        rs=stmt.executeQuery(SQL);

        if(!rs.next())
        {
           System.out.println("No Borrower has borrowed yet from Library"); 
        }
        else
        {

            do
            {
                int id=rs.getInt("ID");      // borrower
                int bookid=rs.getInt("BOOK");   // book

                Borrower bb=null;
                boolean set=true;
                boolean okay=true;

                for(int i=0;i<lib.getPersons().size() && set;i++)
                {
                    if(lib.getPersons().get(i).getClass().getSimpleName().equals("Borrower"))
                    {
                        if(lib.getPersons().get(i).getID()==id)
                        {
                           set =false;
                            bb=(Borrower)(lib.getPersons().get(i));
                        }
                    }
                }

                set=true;

                ArrayList<Loan> books = loans;

                for(int i=0;i<books.size() && set;i++)
                {
                    if(books.get(i).getBook().getID()==bookid &&books.get(i).getReceiver()==null )
                    {
                      set=false;   
                      Loan bBook= new Loan(bb,books.get(i).getBook(),books.get(i).getIssuer(),null,books.get(i).getIssuedDate(),null,books.get(i).getFineStatus());
                      bb.addBorrowedBook(bBook);
                    }
                }
            } while(rs.next());               
        }

        ArrayList<Person> persons = lib.getPersons();

        /* Setting Person ID Count */
        int max=0;

        for(int i=0;i<persons.size();i++)
        {
            if (max < persons.get(i).getID())
                max=persons.get(i).getID();
        }

        Person.setIDCount(max);  
    }
    
    
    // Filling Changes back to Database
    public void fillItBack(Connection con) throws SQLException,SQLIntegrityConstraintViolationException
    {
        System.out.println("CLEARING NOW!");
        /*-----------Loan Table Cleared------------*/

        String template = "DELETE FROM LOAN";
        PreparedStatement stmts = con.prepareStatement(template);

        stmts.executeUpdate();

        /*-----------Borrowed Books Table Cleared------------*/

        template = "DELETE FROM BORROWED_BOOK";
        stmts = con.prepareStatement(template);

        stmts.executeUpdate();

        /*-----------OnHoldBooks Table Cleared------------*/

        template = "DELETE FROM ON_HOLD_BOOK";
        stmts = con.prepareStatement(template);

        stmts.executeUpdate();

        /*-----------Books Table Cleared------------*/

        template = "DELETE FROM BOOK";
        stmts = con.prepareStatement(template);

        stmts.executeUpdate();

        /*-----------Clerk Table Cleared------------*/

        template = "DELETE FROM CLERK";
        stmts = con.prepareStatement(template);

        stmts.executeUpdate();

        /*-----------Librarian Table Cleared------------*/

        template = "DELETE FROM LIBRARIAN";
        stmts = con.prepareStatement(template);

        stmts.executeUpdate();

        /*-----------Borrower Table Cleared------------*/

        template = "DELETE FROM BORROWER";
        stmts = con.prepareStatement(template);

        stmts.executeUpdate();

        /*-----------Staff Table Cleared------------*/

        template = "DELETE FROM STAFF";
        stmts = con.prepareStatement(template);

        stmts.executeUpdate();

        /*-----------Person Table Cleared------------*/

        template = "DELETE FROM PERSON";
        stmts = con.prepareStatement(template);

        stmts.executeUpdate();
        System.out.println("PERSON CLEARED!");
        Library lib = this;
            
        /* Filling Person's Table*/
        for(int i=0;i<lib.getPersons().size();i++)
        {
            template = "INSERT INTO PERSON (ID,PNAME,PASSWORD,ADDRESS,PHONE_NO) values (?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(template);
            
            stmt.setInt(1, lib.getPersons().get(i).getID());
            stmt.setString(2, lib.getPersons().get(i).getName());
            stmt.setString(3,  lib.getPersons().get(i).getPassword());
            stmt.setString(4, lib.getPersons().get(i).getAddress());
            stmt.setString(5, lib.getPersons().get(i).getPhoneNumber());
            
            stmt.executeUpdate();
        }
        
        /* Filling Clerk's Table and Staff Table*/
        for(int i=0;i<lib.getPersons().size();i++)
        {
            if (lib.getPersons().get(i).getClass().getSimpleName().equals("Clerk"))
            {
                template = "INSERT INTO STAFF (S_ID,TYPE,SALARY) values (?,?,?)";
                PreparedStatement stmt = con.prepareStatement(template);

                stmt.setInt(1,lib.getPersons().get(i).getID());
                stmt.setString(2,"Clerk");
                stmt.setFloat(3, (float)((Clerk)(lib.getPersons().get(i))).getSalary());

                stmt.executeUpdate();

                template = "INSERT INTO CLERK (C_ID,DESK_NO) values (?,?)";
                stmt = con.prepareStatement(template);

                stmt.setInt(1,lib.getPersons().get(i).getID());
                stmt.setInt(2, ((Clerk)(lib.getPersons().get(i))).deskNo);

                stmt.executeUpdate();
            }
        
        }
        
        if(lib.getLibrarian()!=null)    // if  librarian is there
        {
            template = "INSERT INTO STAFF (S_ID,TYPE,SALARY) values (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(template);
             
            stmt.setInt(1, lib.getLibrarian().getID());
            stmt.setString(2,"Librarian");
            stmt.setDouble(3,lib.getLibrarian().getSalary());
            
            stmt.executeUpdate();
            
            template = "INSERT INTO LIBRARIAN (L_ID,OFFICE_NO) values (?,?)";
            stmt = con.prepareStatement(template);
            
            stmt.setInt(1,lib.getLibrarian().getID());
            stmt.setInt(2, lib.getLibrarian().officeNo);
            
            stmt.executeUpdate();  
        }
        
        /* Filling Borrower's Table*/
        for(int i=0;i<lib.getPersons().size();i++)
        {
            if (lib.getPersons().get(i).getClass().getSimpleName().equals("Borrower"))
            {
                template = "INSERT INTO BORROWER(B_ID) values (?)";
                PreparedStatement stmt = con.prepareStatement(template);

                stmt.setInt(1, lib.getPersons().get(i).getID());

                stmt.executeUpdate();    
            }
        }
                       
        ArrayList<Book> books = lib.getBooks();
        
        /*Filling Book's Table*/
        for(int i=0;i<books.size();i++)
        {
            template = "INSERT INTO BOOK (ID,TITLE,AUTHOR,SUBJECT,IS_ISSUED) values (?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(template);
            
            stmt.setInt(1,books.get(i).getID());
            stmt.setString(2,books.get(i).getTitle());
            stmt.setString(3, books.get(i).getAuthor());
            stmt.setString(4, books.get(i).getSubject());
            stmt.setBoolean(5, books.get(i).getIssuedStatus());
            stmt.executeUpdate();
            
        }
         
        /* Filling Loan Book's Table*/
        for(int i=0;i<loans.size();i++)
        {
            template = "INSERT INTO LOAN(L_ID,BORROWER,BOOK,ISSUER,ISS_DATE,RECEIVER,RET_DATE,FINE_PAID) values (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(template);
            
            stmt.setInt(1,i+1);
            stmt.setInt(2,loans.get(i).getBorrower().getID());
            stmt.setInt(3,loans.get(i).getBook().getID());
            stmt.setInt(4,loans.get(i).getIssuer().getID());
            stmt.setTimestamp(5,new java.sql.Timestamp(loans.get(i).getIssuedDate().getTime()));
            stmt.setBoolean(8,loans.get(i).getFineStatus());
            if(loans.get(i).getReceiver()==null)
            {
                stmt.setNull(6,Types.INTEGER); 
                stmt.setDate(7,null);
            }
            else
            {
                stmt.setInt(6,loans.get(i).getReceiver().getID());  
                stmt.setTimestamp(7,new java.sql.Timestamp(loans.get(i).getReturnDate().getTime()));
            }
                
            stmt.executeUpdate(); 
   
        }
       
        /* Filling On_Hold_ Table*/
        
        int x=1;
        for(int i=0;i<lib.getBooks().size();i++)
        {
            for(int j=0;j<lib.getBooks().get(i).getHoldRequests().size();j++)
            {
                template = "INSERT INTO ON_HOLD_BOOK(REQ_ID,BOOK,BORROWER,REQ_DATE) values (?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(template);

                stmt.setInt(1,x);
                stmt.setInt(3,lib.getBooks().get(i).getHoldRequests().get(j).getBorrower().getID());
                stmt.setInt(2,lib.getBooks().get(i).getHoldRequests().get(j).getBook().getID());
                stmt.setDate(4,new java.sql.Date(lib.getBooks().get(i).getHoldRequests().get(j).getRequestDate().getTime()));

                stmt.executeUpdate(); 
                x++;
            
            }
        }
       
            
        /* Filling Borrowed Book Table*/
        for(int i=0;i<lib.getBooks().size();i++)
        {
            if(lib.getBooks().get(i).getIssuedStatus()==true)
            {
                boolean set=true;
                for(int j=0;j<loans.size() && set ;j++)
                {
                    if(lib.getBooks().get(i).getID()==loans.get(j).getBook().getID())
                    {
                        if(loans.get(j).getReceiver()==null)
                        {
                          template = "INSERT INTO BORROWED_BOOK(BOOK,BORROWER) values (?,?)";
                          PreparedStatement stmt = con.prepareStatement(template);
                          stmt.setInt(1,loans.get(j).getBook().getID());
                          stmt.setInt(2,loans.get(j).getBorrower().getID());

                          stmt.executeUpdate();
                          set=false;
                        }
                    }

                }

            }
        }   
    }   
 
}   // Library Class Closed