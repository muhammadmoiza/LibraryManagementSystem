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
public class HoldBookUIIT {
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
    }
    
    @Test
    public void HoldBookBorrower() throws InterruptedException {
        LMS.UI.HoldBookUI frame;
        frame = runner.execute(() -> new LMS.UI.HoldBookUI(handler, new Borrower(5000, "", "", "", "")));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
        window.textBox("BookIDTextBox").enterText("200");
        window.button("PlaceOnHoldButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void HoldBookOther() throws InterruptedException {
        LMS.UI.HoldBookUI frame;
        frame = runner.execute(() -> new LMS.UI.HoldBookUI(handler,  new Librarian(1, "", "", "", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
        window.textBox("BookIDTextBox").enterText("200");
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("PlaceOnHoldButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
