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
public class ViewHoldRequestsUIIT {
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
        LMS.UI.ViewHoldRequestsUI frame;
        frame = runner.execute(() -> new LMS.UI.ViewHoldRequestsUI(handler, new Librarian(1, "John", "StreetABC", "0123", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
//Thread.sleep(1000);
    }
    
    @Test
    public void ViewHoldRequestsTestCase1() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("200");
        window.button("ViewRequestsButton").click();
        
//Thread.sleep(1000);
        assertEquals(window.label("Error").text(), "");
    }
    
    @Test
    public void ViewHoldRequestsTestCase2() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("220022");
        window.button("ViewRequestsButton").click();
        
//Thread.sleep(1000);
        assertEquals(window.label("Error").text().contains("Invalid book id"), true);
    }
    
    @Test
    public void ViewHoldRequestsTestCase3() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("2A0A0");
        window.button("ViewRequestsButton").click();
        
//Thread.sleep(1000);
        assertEquals(window.label("Error").text().contains("ID can only be numbers"), true);
    }
    
    @Test
    public void ViewHoldRequestsTestCase4() throws InterruptedException {
        window.button("ViewRequestsButton").click();
        
//Thread.sleep(1000);
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void ViewHoldRequestsTestCase5() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("82385437584375743589200");
        window.button("ViewRequestsButton").click();
        
//Thread.sleep(1000);
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void GoBack() throws InterruptedException {
        window.button("BackButton").click();
        
//Thread.sleep(1000);
        assertEquals(true, true);
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
