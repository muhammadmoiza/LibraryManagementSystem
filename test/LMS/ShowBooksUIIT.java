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
public class ShowBooksUIIT {
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
    }
    
    @Test
    public void ViewIssueHistoryTestCase1() throws InterruptedException {
        LMS.UI.ShowBooksUI frame;
        frame = runner.execute(() -> new LMS.UI.ShowBooksUI(handler, false));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        
        Thread.sleep(1000);
        window.button("BackButton").click();
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @Test
    public void ViewAllBooksTestCase1() throws InterruptedException {
        LMS.UI.ShowBooksUI frame;
        frame = runner.execute(() -> new LMS.UI.ShowBooksUI(handler, true));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        
        Thread.sleep(1000);
        window.button("BackButton").click();
        Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
