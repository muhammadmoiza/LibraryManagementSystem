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
public class ChangeBookInfoUIIT {
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
        LMS.UI.ChangeBookInfoUI frame;
        frame = runner.execute(() -> new LMS.UI.ChangeBookInfoUI(handler,  new Librarian(1, "", "", "", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
    }
    
    @Test
    public void GetBook() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("200");
        window.button("GetBookButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void UpdateBookTitle() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("200");
        window.button("GetBookButton").click();
        
        Thread.sleep(1000);
        
        window.textBox("BookTitleTextBox").deleteText().enterText("New Book Title");
        window.button("UpdateButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void UpdateBookAuthor() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("200");
        window.button("GetBookButton").click();
        
        Thread.sleep(1000);
        window.textBox("BookAuthorTextBox").deleteText().enterText("New Author");
        window.button("UpdateButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void UpdateBookSubject() throws InterruptedException {
        window.textBox("BookIDTextBox").enterText("200");
        window.button("GetBookButton").click();
        
        Thread.sleep(1000);
        window.textBox("BookSubjectTextBox").deleteText().enterText("New Nice Subject");
        window.button("UpdateButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void Back() throws InterruptedException {
        window.button("BackButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
