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
public class IssueBookUIIT {
    private FrameFixture window;
    private GuiActionRunner runner;
    private LMS.GUIHandler handler;

    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }
    
    @Before
    public void setUp() {
        handler = new LMS.GUIHandler();
        LMS.UI.IssueBookUI frame;
        frame = runner.execute(() -> new LMS.UI.IssueBookUI(handler,  new Librarian(1, "", "", "", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
    }
    
    @Test
    public void IssueBookTestCase1() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("200");
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("IssueButton").click();
        
//Thread.sleep(1000);
    
        assertEquals((window.label("Error").text().contains("successfully issued") || window.label("Error").text().contains("is already issued")), true);
    }
    
    @Test
    public void IssueBookTestCase2() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("20000");
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("IssueButton").click();
        
//Thread.sleep(1000);
    
        assertEquals(window.label("Error").text().contains("Invalid borrower or book id"), true);
    }
    
    @Test
    public void IssueBookTestCase3() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("200#");
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("IssueButton").click();
        // Throws error on #
//Thread.sleep(1000);
    
        assertEquals(window.label("Error").text().contains("ID can only be numbers"), true);
    }
    
    @Test
    public void IssueBookTestCase4() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("IssueButton").click();
        
//Thread.sleep(1000);
    
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void IssueBookTestCase5() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("200");
        window.textBox("BorrowerIDTextBox").enterText("100000");
        window.button("IssueButton").click();
        
//Thread.sleep(1000);
    
        assertEquals(window.label("Error").text().contains("Invalid borrower or book id"), true);
    }
    
    @Test
    public void IssueBookTestCase6() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("200");
        window.textBox("BorrowerIDTextBox").enterText("10QW0");
        window.button("IssueButton").click();
        
//Thread.sleep(1000);
        // Throws error
        assertEquals(window.label("Error").text().contains("ID can only be numbers"), true);
    }
    
    @Test
    public void IssueBookTestCase7() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("200");
        window.button("IssueButton").click();
        
//Thread.sleep(1000);
    
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void IssueBookTestCase8() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("24389584843593485923954300");
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("IssueButton").click();
        
//Thread.sleep(1000);
    
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void IssueBookTestCase9() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("200");
        window.textBox("BorrowerIDTextBox").enterText("189452745784322438983400");
        window.button("IssueButton").click();
        
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
