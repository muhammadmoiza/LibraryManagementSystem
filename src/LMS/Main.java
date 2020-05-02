
package LMS;

// Including Header Files.
import LMS.UI.MainUI;
import java.io.*;
import java.sql.*;

public class Main 
{  
    public static void main(String[] args) throws SQLException, IOException
    {        
        GUIHandler handler = new GUIHandler();
              
        MainUI mainui = new MainUI(handler); 
        mainui.setVisible(true);
             
    }    // Main Closed
    
}   // Class closed.

