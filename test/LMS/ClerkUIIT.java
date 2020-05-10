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
public class ClerkUIIT {
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
        LMS.UI.ClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.ClerkUI(handler, new Clerk(5000, "", "", "", "", 20000, 5000)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
//Thread.sleep(1000);
    }
    
    @Test
    public void SearchBookTestCase1() throws InterruptedException {
        window.button("SearchBookButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void PlaceOnHoldTestCase1() throws InterruptedException {
        window.button("PlaceOnHoldButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void ProfileInfoTestCase1() throws InterruptedException {
        window.button("ProfileInfoButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void CheckFineTestCase1() throws InterruptedException {
        window.button("CheckFineButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void RequestQueueTestCase1() throws InterruptedException {
        window.button("RequestQueueButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void CheckInBookTestCase1() throws InterruptedException {
        window.button("CheckInBookButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void CheckOutBookTestCase1() throws InterruptedException {
       window.button("CheckOutBookButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void RenewBookTestCase1() throws InterruptedException {
        window.button("RenewBookButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void AddBorrowerTestCase1() throws InterruptedException {
        window.button("AddBorrowerButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void BorrowerInfoTestCase1() throws InterruptedException {
        window.button("BorrowerInfoButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void LogoutTestCase1() throws InterruptedException {
        window.button("LogoutButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
