
package LMS;

public abstract class Person 
{   
    protected int id;           // ID of every person related to library
    protected String password;  // Password of every person related to library
    protected String name;      // Name of every person related to library
    protected String address;   // Address of every person related to library
    protected String phoneNo;      // PhoneNo of every person related to library
    
    static int currentIdNumber = 0;     //This will be unique for every person, since it will be incremented when everytime
                                       //when a person is created

    public Person(int dd, String nam, String addr, String pno)  
    {
        currentIdNumber++;
        
        if(dd==-1)
        {
            id = currentIdNumber;
        }
        else
            id = dd;
        
        password = Integer.toString(id);
        name = nam;
        address = addr;
        phoneNo = pno;
    }  
    
    public Person(int dd, String nam, String addr, String pno, String pass)  
    {
        currentIdNumber++;
        
        if(dd==-1)
        {
            id = currentIdNumber;
        }
        else
            id = dd;
        if(pass == "-1")
            password = Integer.toString(id);
        else
            password = pass;
        name = nam;
        address = addr;
        phoneNo = pno;
    }
    
    // Printing Info of a Person
    public void printInfo()
    {
        System.out.println("-----------------------------------------");
        System.out.println("\nThe details are: \n");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone No: " + phoneNo + "\n");
    }
    
    public String toString(){
        String string = "";
        string += "-----------------------------------------";
        string += "\nThe details are: \n";
        string += "ID: " + Integer.toString(id) + "\n";
        string += "Name: " + name + "\n";
        string += "Address: " + address + "\n";
        string += "Phone No: " + phoneNo + "\n";
        return string;
    }
    
    /*---------Setter FUNCs.---------*/
    public void setAddress(String a)
    {
        address = a;
    }
    
    public void setPhone(String p)
    {
        phoneNo = p;
    }
    
    public void setName(String n)
    {
        name = n;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getPassword()
    {
        return password;
    }
    
     public String getAddress()
    {
        return address;
    }
     
     public String getPhoneNumber()
    {
        return phoneNo;
    }
    public int getID()
    {
        return id;
    }
    /*---------------------------*/
    
     public static void setIDCount(int n)
    {
        currentIdNumber=n;
    }
   
} // Person Class Closed
