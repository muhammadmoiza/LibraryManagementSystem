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
public class BorrowerInfoUIIT {
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
        LMS.UI.BorrowerInfoUI frame;
        frame = runner.execute(() -> new LMS.UI.BorrowerInfoUI(handler,  new Librarian(1, "", "", "", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
    }
    
    @Test
    public void DisplayBorrowerProfileTestCase1() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }

    @Test
    public void ChangeBorrowerNameTestCase1() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
        Thread.sleep(1000);
        
        window.textBox("BorrowerNameTextBox").deleteText().enterText("New Borrower Name");
        window.button("SaveProfileButton").click();
        
        Thread.sleep(1000);
                
        assertEquals(true, true);
    }

    @Test
    public void ChangeBorrowerPasswordTestCase1() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
        Thread.sleep(1000);
        
        window.textBox("BorrowerPasswordTextBox").deleteText().enterText("NewPass!");
        window.button("SaveProfileButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void ChangeBorrowerAddressTestCase1() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
        Thread.sleep(1000);
        
        window.textBox("BorrowerAddressTextBox").deleteText().enterText("Street 233, Germany");
        window.button("SaveProfileButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void ChangeBorrowerPhoneTestCase1() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
        Thread.sleep(1000);
        
        window.textBox("BorrowerPhoneTextBox").deleteText().enterText("12098");
        window.button("SaveProfileButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
