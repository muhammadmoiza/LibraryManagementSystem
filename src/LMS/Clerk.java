
package LMS;

public class Clerk extends Staff {
  
    int deskNo;     //Desk Number of the Clerk
    public static int currentdeskNumber = 0;
  
    public Clerk(int id, String nam, String addr, String ph, String pass, double sal,int dk) 
    {
        super(id,nam,addr,ph,pass,sal);
        
        if(dk == -1)
        {
            deskNo = currentdeskNumber;
        }
        else
        {
            deskNo=dk;
        }
        
        currentdeskNumber++;
    }
    
    // Printing Clerk's Info
    @Override
    public void printInfo()
    {
        super.printInfo();
        System.out.println("Desk Number: " + deskNo);
    }
    
    public String toString(){
        return super.toString() + "Desk Number: " + Integer.toString(deskNo) + "\n";
    }
    
}   // Clerk's Class Closed