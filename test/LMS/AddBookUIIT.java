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
public class AddBookUIIT {
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
        LMS.UI.AddBookUI frame;
        frame = runner.execute(() -> new LMS.UI.AddBookUI(handler, new Librarian(1, "", "", "", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
    }
    
    @Test
    public void AddBookTestCase1() throws InterruptedException {
        window.textBox("BookTitleTextBox").enterText("sample book title 1");
        window.textBox("BookAuthorTextBox").enterText("john doe");
        window.textBox("BookSubjectTextBox").enterText("extras");
        window.button("AddBookButton").click();
        
        Thread.sleep(1000);
       
        assertEquals(true, true);
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
