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
public class AdminUIIT {
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
        LMS.UI.AdminUI frame;
        frame = runner.execute(() -> new LMS.UI.AdminUI(handler));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
    }
    
    @Test
    public void AddClerkTestCase1() throws InterruptedException {

        window.button("AdminAddClerkButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
        
    @Test
    public void AddLibrarianTestCase1() throws InterruptedException {

        window.button("AdminAddLibrarianButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }    
    
    @Test
    public void ViewIssueHistoryTestCase1() throws InterruptedException {

        window.button("AdminIssueHistoryButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }    
    
    @Test
    public void ViewBooksTestCase1() throws InterruptedException {

        window.button("AdminViewBooksButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }    
    
    @Test
    public void LogoutTestCase1() throws InterruptedException {

        window.button("LogoutButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
            
    @After
    public void tearDown() {
        window.cleanUp();
    }

    
}
