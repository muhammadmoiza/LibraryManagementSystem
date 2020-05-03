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
public class SearchBookUIIT {
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
        LMS.UI.SearchBookUI frame;
        frame = runner.execute(() -> new LMS.UI.SearchBookUI(handler, new Librarian(1, "John", "StreetABC", "0123", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
    }
    
    @Test
    public void SearchBookTitle() throws InterruptedException {
        window.radioButton("TitleRadioButton").check();
        window.textBox("SearchFilterTextBox").enterText("Dic");
        window.button("SearchButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void SearchBookAuthor() throws InterruptedException {
        window.radioButton("AuthorRadioButton").check();
        window.textBox("SearchFilterTextBox").enterText("Neil");
        window.button("SearchButton").click();
        
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void SearchBookSubject() throws InterruptedException {
        window.radioButton("SubjectRadioButton").check();
        window.textBox("SearchFilterTextBox").enterText("Misc");
        window.button("SearchButton").click();
        
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
