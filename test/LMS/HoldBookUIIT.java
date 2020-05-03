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
    public void HoldBookBorrowerTestCase1() throws InterruptedException {
        LMS.UI.HoldBookUI frame;
        frame = runner.execute(() -> new LMS.UI.HoldBookUI(handler, new Borrower(5000, "", "", "", "")));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
        window.textBox("BookIDTextBox").enterText("200");
        window.button("PlaceOnHoldButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Hold request added"), true);
    }
    
    @Test
    public void HoldBookBorrowerTestCase2() throws InterruptedException {
        LMS.UI.HoldBookUI frame;
        frame = runner.execute(() -> new LMS.UI.HoldBookUI(handler, new Borrower(5000, "", "", "", "")));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
        window.textBox("BookIDTextBox").enterText("500000");
        window.button("PlaceOnHoldButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Invalid book id"), true);
    }
    
    @Test
    public void HoldBookBorrowerTestCase3() throws InterruptedException {
        LMS.UI.HoldBookUI frame;
        frame = runner.execute(() -> new LMS.UI.HoldBookUI(handler, new Borrower(5000, "", "", "", "")));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
        window.textBox("BookIDTextBox").enterText("A1");
        window.button("PlaceOnHoldButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("ID can only be numbers"), true);
    }
    
    @Test
    public void HoldBookBorrowerTestCase4() throws InterruptedException {
        LMS.UI.HoldBookUI frame;
        frame = runner.execute(() -> new LMS.UI.HoldBookUI(handler, new Borrower(5000, "", "", "", "")));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
        window.button("PlaceOnHoldButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void HoldBookOtherTestCase1() throws InterruptedException {
        LMS.UI.HoldBookUI frame;
        frame = runner.execute(() -> new LMS.UI.HoldBookUI(handler,  new Librarian(1, "", "", "", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
        window.textBox("BookIDTextBox").enterText("200");
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("PlaceOnHoldButton").click();
        
        Thread.sleep(1000);
        assertEquals((window.label("Error").text().contains("Hold request added") || (window.label("Error").text().contains("You already have one hold request for this book"))), true);
    }
    
    @Test
    public void HoldBookOtherTestCase2() throws InterruptedException {
        LMS.UI.HoldBookUI frame;
        frame = runner.execute(() -> new LMS.UI.HoldBookUI(handler,  new Librarian(1, "", "", "", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
        window.textBox("BookIDTextBox").enterText("20000");
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("PlaceOnHoldButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Invalid book id"), true);
    }
    
    @Test
    public void HoldBookOtherTestCase3() throws InterruptedException {
        LMS.UI.HoldBookUI frame;
        frame = runner.execute(() -> new LMS.UI.HoldBookUI(handler,  new Librarian(1, "", "", "", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
        window.textBox("BookIDTextBox").enterText("200A");
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("PlaceOnHoldButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("ID can only be numbers"), true);
    }
    
    @Test
    public void HoldBookOtherTestCase4() throws InterruptedException {
        LMS.UI.HoldBookUI frame;
        frame = runner.execute(() -> new LMS.UI.HoldBookUI(handler,  new Librarian(1, "", "", "", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("PlaceOnHoldButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void HoldBookOtherTestCase5() throws InterruptedException {
        LMS.UI.HoldBookUI frame;
        frame = runner.execute(() -> new LMS.UI.HoldBookUI(handler,  new Librarian(1, "", "", "", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
        window.textBox("BookIDTextBox").enterText("200");
        window.textBox("BorrowerIDTextBox").enterText("10000");
        window.button("PlaceOnHoldButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Invalid book id or borrower id"), true);
    }
    
    @Test
    public void HoldBookOtherTestCase6() throws InterruptedException {
        LMS.UI.HoldBookUI frame;
        frame = runner.execute(() -> new LMS.UI.HoldBookUI(handler,  new Librarian(1, "", "", "", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
        window.textBox("BookIDTextBox").enterText("200");
        window.textBox("BorrowerIDTextBox").enterText("100BA");
        window.button("PlaceOnHoldButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("ID can only be numbers"), true);
    }
    
    @Test
    public void HoldBookOtherTestCase7() throws InterruptedException {
        LMS.UI.HoldBookUI frame;
        frame = runner.execute(() -> new LMS.UI.HoldBookUI(handler,  new Librarian(1, "", "", "", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
        window.textBox("BookIDTextBox").enterText("200");
        window.button("PlaceOnHoldButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
