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
//Thread.sleep(1000);
    }
    
    @Test
    public void AdminLoginTestCase1() throws InterruptedException {
        // Successful login
        window.radioButton("MainAdminLoginRadioButton").check();
        window.textBox("LUITB").enterText("lib");
        window.button("LoginButton").click();
        
//Thread.sleep(1000);

        assertEquals(true, true);
    }
    
    @Test
    public void AdminLoginTestCase2() throws InterruptedException {
        // Successful login
        window.radioButton("MainAdminLoginRadioButton").check();
        window.button("LoginButton").click();
        
//Thread.sleep(1000);

        assertEquals(window.label("Error").text().contains("Field cannot be empty"), true);
    }
    
    @Test
    public void AdminLoginTestCase3() throws InterruptedException {
        // Wrong Master Password
        window.radioButton("MainAdminLoginRadioButton").check();
        window.textBox("LUITB").enterText("sdfdskfjkasdfkljk");
        window.button("LoginButton").click();
        
//Thread.sleep(1000);

        assertEquals(window.label("Error").text().contains("Incorrect Password"), true);
    }
    
    @Test
    public void AdminLoginTestCase4() throws InterruptedException {
        // Successful login
        window.radioButton("MainAdminLoginRadioButton").check();
        window.textBox("LUITB").enterText("7dsfkdfjdsklfjskljflksdjflkjk4j3lkj5l3k4jlkjfd8f7sd98fnn3k43k2kj23kd89fsf");
        window.button("LoginButton").click();
        
//Thread.sleep(1000);

        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void OtherUserLoginTestCase1() throws InterruptedException {
        // Successful login
        window.radioButton("LoginRadioButton").check();
        window.textBox("LUITB").enterText("1");
        window.textBox("PTB").enterText("123");
        window.button("LoginButton").click();
        
//Thread.sleep(1000);

        assertEquals(true, true);
    }
    
    @Test
    public void OtherUserLoginTestCase2() throws InterruptedException {
        // Successful login
        window.radioButton("LoginRadioButton").check();
        window.textBox("LUITB").enterText("11111");
        window.textBox("PTB").enterText("123");
        window.button("LoginButton").click();
        
//Thread.sleep(1000);
        assertEquals(window.label("Error").text().contains("Incorrect User Id or Password"), true);
    }
    
    @Test
    public void OtherUserLoginTestCase3() throws InterruptedException {
        // Successful login
        window.radioButton("LoginRadioButton").check();
        window.textBox("LUITB").enterText("a1b");
        window.textBox("PTB").enterText("123");
        window.button("LoginButton").click();
        
//Thread.sleep(1000);

        assertEquals(window.label("Error").text().contains("ID can only be numbers"), true);
    }
    
    @Test
    public void OtherUserLoginTestCase4() throws InterruptedException {
        // Successful login
        window.radioButton("LoginRadioButton").check();
        window.textBox("PTB").enterText("123");
        window.button("LoginButton").click();
        
//Thread.sleep(1000);

        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void OtherUserLoginTestCase5() throws InterruptedException {
        // Successful login
        window.radioButton("LoginRadioButton").check();
        window.textBox("LUITB").enterText("1");
        window.button("LoginButton").click();
        
//Thread.sleep(1000);

        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void OtherUserLoginTestCase6() throws InterruptedException {
        // Successful login
        window.radioButton("LoginRadioButton").check();
        window.textBox("LUITB").enterText("239458454753757825473857438757284534598431");
        window.textBox("PTB").enterText("123");
        window.button("LoginButton").click();
        
//Thread.sleep(1000);

        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void OtherUserLoginTestCase7() throws InterruptedException {
        // Successful login
        window.radioButton("LoginRadioButton").check();
        window.textBox("LUITB").enterText("1");
        window.textBox("PTB").enterText("854fnnj43h5hjk2345jkb5b4j54b23j5jk34h5jk43h5jh435j5kj345hjhkj43hjk5h4jj34k5h435j24");
        window.button("LoginButton").click();
        
//Thread.sleep(1000);

        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
