/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author itsme
 */
public class LibrarianUIIT {
    
    private FrameFixture window;
    private GuiActionRunner runner;
    private LMS.GUIHandler handler;

    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }
    
    @Before
    public void setUp() throws InterruptedException {
        handler = new LMS.GUIHandler();
        LMS.UI.LibrarianUI frame;
        frame = runner.execute(() -> new LMS.UI.LibrarianUI(handler, new Librarian(1, "John", "StreetABC", "0123", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
//Thread.sleep(1000);
    }    
    
    @Test
    public void SearchBook() throws InterruptedException {
        window.button("SearchBookButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void PlaceOnHold() throws InterruptedException {
        window.button("PlaceOnHoldButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void ProfileInfo() throws InterruptedException {
        window.button("ProfileInfoButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void CheckFine() throws InterruptedException {
        window.button("CheckFineButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void RequestQueue() throws InterruptedException {
        window.button("RequestQueueButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void CheckInBook() throws InterruptedException {
        window.button("CheckInBookButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void CheckOutBook() throws InterruptedException {
        window.button("CheckOutBookButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void RenewBook() throws InterruptedException {
        window.button("RenewBookButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void AddBorrower() throws InterruptedException {
        window.button("AddBorrowerButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void BorrowerInfo() throws InterruptedException {
        window.button("BorrowerInfoButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void AddBook() throws InterruptedException {
        window.button("AddBookButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void RemoveBook() throws InterruptedException {
        window.button("RemoveBookButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void BookInfo() throws InterruptedException {
        window.button("BookInfoButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void ClerkInfo() throws InterruptedException {
        window.button("ClerkInfoButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void Logout() throws InterruptedException {
        window.button("LogoutButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }

    
}
