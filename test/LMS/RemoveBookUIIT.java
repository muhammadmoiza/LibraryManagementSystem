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
public class RemoveBookUIIT {
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
        LMS.UI.RemoveBookUI frame;
        frame = runner.execute(() -> new LMS.UI.RemoveBookUI(handler, new Librarian(1, "John", "StreetABC", "0123", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
    }
    
    @Test
    public void RemoveBookTestCase1() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("201");
        window.button("RemoveButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("The book is successfully removed"), true);
    }
    
    @Test
    public void RemoveBookTestCase2() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("20102");
        window.button("RemoveButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("No book found against this id"), true);
    }
    
    @Test
    public void RemoveBookTestCase3() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("2a0h1");
        window.button("RemoveButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("ID can only be numbers"), true);
    }
    
    @Test
    public void RemoveBookTestCase4() throws InterruptedException {
        window.button("RemoveButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void GoBack() throws InterruptedException {
        window.button("BackButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
