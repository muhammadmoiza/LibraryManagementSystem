
package LMS;

public class Staff extends Person 
{
    protected double salary;
    
    public Staff(int id, String nam, String addr,String pno, String pass, double sal)
    {
        super(id,nam,addr,pno, pass);
        salary = sal;
    }
    
    @Override
    public void printInfo()
    {
        super.printInfo();
        System.out.println("Salary: " + salary + "\n");         
    }
    
    public String toString(){
        return super.toString() + "Salary: " + Integer.toString((int) salary) + "\n";
    }
    
    public double getSalary()
    {
        return salary;
    }
}