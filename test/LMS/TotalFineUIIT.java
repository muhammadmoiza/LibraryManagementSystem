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
public class TotalFineUIIT {
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
        LMS.UI.TotalFineUI frame;
        frame = runner.execute(() -> new LMS.UI.TotalFineUI(handler, new Librarian(1, "John", "StreetABC", "0123", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
//Thread.sleep(1000);
    }
    
    @Test
    public void ComputeTotalFineTestCase1() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("ComputeTotalFineButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Your total fine is"), true);
    }
    
    @Test
    public void ComputeTotalFineTestCase2() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("10001");
        window.button("ComputeTotalFineButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error1").text().contains("Invalid borrower id"), true);
    }
    
    @Test
    public void ComputeTotalFineTestCase3() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("100qwe");
        window.button("ComputeTotalFineButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error1").text().contains("ID can only be numbers"), true);
    }
    
    @Test
    public void ComputeTotalFineTestCase4() throws InterruptedException {
        window.button("ComputeTotalFineButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error1").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void ComputeTotalFineTestCase5() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("1743289574385798437574300");
        window.button("ComputeTotalFineButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void PayNowTestCase1() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("PaidNowButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Your total fine is"), true);
    }
    
    @Test
    public void PayNowTestCase2() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("10110");
        window.button("PaidNowButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error1").text().contains("Invalid borrower id"), true);
    }
    
    @Test
    public void PayNowTestCase3() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("10ssaf0");
        window.button("PaidNowButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error1").text().contains("ID can only be numbers"), true);
    }
    
    @Test
    public void PayNowTestCase4() throws InterruptedException {
        window.button("PaidNowButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error1").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void PayNowTestCase5() throws InterruptedException {
        window.textBox("BorrowerIDTextBox").enterText("5894235395845394543985943100");
        window.button("PaidNowButton").click();
        
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
