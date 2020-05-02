
package LMS;

public class Librarian extends Staff {
    
    int officeNo;     //Office Number of the Librarian
    public static int currentOfficeNumber = 0;
     
    public Librarian(int id,String nam, String addr, String pno, String pass, double sal,int of) 
    {
        super(id,nam,addr,pno, pass,sal);

        if(of == -1)
            officeNo = currentOfficeNumber;        
        else
            officeNo = of;
        
        currentOfficeNumber++;
    }
    
    // Printing Librarian's Info
    @Override
    public void printInfo()
    {
        super.printInfo();
        System.out.println("Office Number: " + officeNo);
    }       
    public String toString(){
        return super.toString() + "Office Number: " + Integer.toString(officeNo) + "\n";
    }
}
