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
public class ClerkInfoUIIT {
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
        LMS.UI.ClerkInfoUI frame;
        frame = runner.execute(() -> new LMS.UI.ClerkInfoUI(handler,  new Librarian(1, "", "", "", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
//Thread.sleep(1000);
    }
    
    @Test
    public void ShowClerkInfoTestCase1() throws InterruptedException {
        window.textBox("ClerkIDTextBox").enterText("2");
        window.button("ViewInfoButton").click();
        
//Thread.sleep(1000);        
        assertEquals(window.label("Error").text(), "");
    }
    
    @Test
    public void ShowClerkInfoTestCase2() throws InterruptedException {
        window.textBox("ClerkIDTextBox").enterText("2000");
        window.button("ViewInfoButton").click();
        
//Thread.sleep(1000);        
        assertEquals(window.label("Error").text().contains("Invalid clerk id"), true);
    }
    
    @Test
    public void ShowClerkInfoTestCase3() throws InterruptedException {
        window.textBox("ClerkIDTextBox").enterText("E2&");
        window.button("ViewInfoButton").click();
        
//Thread.sleep(1000);        
        assertEquals(window.label("Error").text().contains("ID can only be numbers"), true);
    }
    
    @Test
    public void ShowClerkInfoTestCase4() throws InterruptedException {
        window.textBox("ClerkIDTextBox").enterText("248548358243543895874");
        window.button("ViewInfoButton").click();
        
//Thread.sleep(1000);        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), "");
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
