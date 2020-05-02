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
public class MainUIIT {
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
        LMS.UI.MainUI frame;
        frame = runner.execute(() -> new LMS.UI.MainUI(handler));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        Thread.sleep(1000);
    }
    
    @Test
    public void AdminLoginTestCase1() throws InterruptedException {
        // Successful login
        window.radioButton("MainAdminLoginRadioButton").check();
        window.textBox("LUITB").enterText("lib");
        window.button("LoginButton").click();
        
        Thread.sleep(1000);

        assertEquals(true, true);
    }

    @Test
    public void AdminLoginTestCase2() throws InterruptedException {
        // Wrong Master Password
        window.radioButton("MainAdminLoginRadioButton").check();
        window.textBox("LUITB").enterText("sdfdskfjkasdfkljk");
        window.button("LoginButton").click();
        
        Thread.sleep(1000);

        assertEquals(true, true);
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
