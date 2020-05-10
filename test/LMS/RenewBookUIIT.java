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
public class RenewBookUIIT {
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
        LMS.UI.RenewBookUI frame;
        frame = runner.execute(() -> new LMS.UI.RenewBookUI(handler, new Librarian(1, "John", "StreetABC", "0123", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
//Thread.sleep(1000);
    }
    
    @Test
    public void GetBooksTestCase1() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetBooksButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error").text(), "");
    }
    
    @Test
    public void GetBooksTestCase2() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("10101");
        window.button("GetBooksButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Invalid borrower id"), true);
    }
    
    @Test
    public void GetBooksTestCase3() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("100a");
        window.button("GetBooksButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("ID can only be numbers"), true);
    }
    
    @Test
    public void GetBooksTestCase4() throws InterruptedException {
        window.button("GetBooksButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void GetBooksTestCase5() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("1457249578439875247900");
        window.button("GetBooksButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void RenewBookIssueTestCase1() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetBooksButton").click();
        
//Thread.sleep(1000);
        window.textBox("BookIDTextBox").enterText("200");
        window.button("RenewBookButton").click();
        
//Thread.sleep(1000);
        assertEquals(window.label("Error1").text().contains("Book issue renewed"), true);
    }
    
    @Test
    public void RenewBookIssueTestCase2() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetBooksButton").click();
        
//Thread.sleep(1000);
        window.textBox("BookIDTextBox").enterText("20202");
        window.button("RenewBookButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Invalid borrower id or book id"), true);
    }
    
    @Test
    public void RenewBookIssueTestCase3() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetBooksButton").click();
        
//Thread.sleep(1000);
        window.textBox("BookIDTextBox").enterText("2ao0oa0");
        window.button("RenewBookButton").click();
        
//Thread.sleep(1000);
        assertEquals(window.label("Error").text().contains("ID can only be numbers"), true);
    }
    
    @Test
    public void RenewBookIssueTestCase4() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetBooksButton").click();
        
//Thread.sleep(1000);
        window.button("RenewBookButton").click();
        
//Thread.sleep(1000);
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void RenewBookIssueTestCase5() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetBooksButton").click();
        
//Thread.sleep(1000);
        window.textBox("BookIDTextBox").enterText("22584375847543852347700");
        window.button("RenewBookButton").click();
        
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
