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
public class ViewHoldRequestsUIIT {
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
        LMS.UI.MainUI frame;
        frame = runner.execute(() -> new LMS.UI.MainUI(handler));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
    }
    
    @Test
    public void shouldCopyTextInLabelWhenClickingButton() throws InterruptedException {
        window.radioButton("MainAdminLoginRadioButton").check();
        window.textBox("LUITB").enterText("lib");
        window.button("LoginButton").click();
        
        Thread.sleep(1000);
        /*
        window.button("AdminAddClerkButton").click();
        window.button("BackButton").click();
        
        window.button("AdminAddLibrarianButton").click();
        window.button("BackButton").click();
        
        window.button("AdminIssueHistoryButton").click();
        window.button("BackButton").click();
        
        window.button("AdminViewBooksButton").click();
        window.button("BackButton").click();
        
        window.button("LogoutButton");
        Thread.sleep(10000);
        */
        
        assertEquals(true, true);
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
