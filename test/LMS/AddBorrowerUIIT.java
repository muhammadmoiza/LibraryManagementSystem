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
public final class AddBorrowerUIIT {
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
        LMS.UI.AddBorrowerUI frame;
        frame = runner.execute(() -> new LMS.UI.AddBorrowerUI(handler,  new Librarian(1, "", "", "", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
    }
    
    @Test
    public void AddBorrowerTestCase1() throws InterruptedException {
        
        window.textBox("BorrowerNameTextBox").enterText("Sample Borrower 1");
        window.textBox("BorrowerAddressTextBox").enterText("City Paris");
        window.textBox("BorrowerPhoneTextBox").enterText("48394");
        window.textBox("BorrowerSalaryTextBox").enterText("10000");
        window.button("AddBorrowerButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("created successfully."), true);
    }
    
//------------------------ For Not Allowed Values
    @Test
    public void AddBorrowerTestCase2() throws InterruptedException {
        
        window.textBox("BorrowerNameTextBox").enterText("Sample Borrower 1");
        window.textBox("BorrowerAddressTextBox").enterText("City Paris");
        window.textBox("BorrowerPhoneTextBox").enterText("48394");
        window.textBox("BorrowerSalaryTextBox").enterText("Bogus10000");
        window.button("AddBorrowerButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Phone number and salary can only be numbers"), true);
    }
    
    @Test
    public void AddBorrowerTestCase3() throws InterruptedException {
        
        window.textBox("BorrowerNameTextBox").enterText("Sample Borrower 1");
        window.textBox("BorrowerAddressTextBox").enterText("City Paris");
        window.textBox("BorrowerPhoneTextBox").enterText("Bogus48394");
        window.textBox("BorrowerSalaryTextBox").enterText("10000");
        window.button("AddBorrowerButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Phone number and salary can only be numbers"), true);
    }
//------------------------ For NULL Values
    @Test
    public void AddBorrowerTestCase4() throws InterruptedException {
        
        window.textBox("BorrowerAddressTextBox").enterText("City Paris");
        window.textBox("BorrowerPhoneTextBox").enterText("48394");
        window.textBox("BorrowerSalaryTextBox").enterText("10000");
        window.button("AddBorrowerButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void AddBorrowerTestCase5() throws InterruptedException {
        
        window.textBox("BorrowerNameTextBox").enterText("Sample Borrower 1");
        window.textBox("BorrowerPhoneTextBox").enterText("48394");
        window.textBox("BorrowerSalaryTextBox").enterText("10000");
        window.button("AddBorrowerButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void AddBorrowerTestCase6() throws InterruptedException {
        
        window.textBox("BorrowerNameTextBox").enterText("Sample Borrower 1");
        window.textBox("BorrowerAddressTextBox").enterText("City Paris");
        window.textBox("BorrowerSalaryTextBox").enterText("10000");
        window.button("AddBorrowerButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void AddBorrowerTestCase7() throws InterruptedException {
        
        window.textBox("BorrowerNameTextBox").enterText("Sample Borrower 1");
        window.textBox("BorrowerAddressTextBox").enterText("City Paris");
        window.textBox("BorrowerPhoneTextBox").enterText("48394");
        window.button("AddBorrowerButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
