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
public class AddClerkUIIT {
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
    public void AddNewClerkTestCase1() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, true));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        
        window.textBox("ClerkNameTextBox").enterText("Clerk1");
        window.textBox("ClerkAddressTextBox").enterText("City XYZ");
        window.textBox("ClerkPhoneTextBox").enterText("12345");
        window.textBox("ClerkSalaryTextBox").enterText("30000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Clerk has been added"), true);
    }
    
    @Test
    public void AddNewClerkTestCase2() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, true));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        
        window.textBox("ClerkNameTextBox").enterText("Clerk1");
        window.textBox("ClerkAddressTextBox").enterText("City XYZ");
        window.textBox("ClerkPhoneTextBox").enterText("ABC12345");
        window.textBox("ClerkSalaryTextBox").enterText("30000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Phone number can only be numbers"), true);
    }
    
    @Test
    public void AddNewClerkTestCase3() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, true));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        
        window.textBox("ClerkNameTextBox").enterText("Clerk1");
        window.textBox("ClerkAddressTextBox").enterText("City XYZ");
        window.textBox("ClerkPhoneTextBox").enterText("12345");
        window.textBox("ClerkSalaryTextBox").enterText("Bogus30000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Salary can only be number"), true);
    }
    
    @Test
    public void AddNewClerkTestCase4() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, true));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        
        window.textBox("ClerkAddressTextBox").enterText("City XYZ");
        window.textBox("ClerkPhoneTextBox").enterText("12345");
        window.textBox("ClerkSalaryTextBox").enterText("30000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void AddNewClerkTestCase5() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, true));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        
        window.textBox("ClerkNameTextBox").enterText("Clerk1");
        window.textBox("ClerkPhoneTextBox").enterText("12345");
        window.textBox("ClerkSalaryTextBox").enterText("30000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void AddNewClerkTestCase6() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, true));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        
        window.textBox("ClerkNameTextBox").enterText("Clerk1");
        window.textBox("ClerkAddressTextBox").enterText("City XYZ");
        window.textBox("ClerkSalaryTextBox").enterText("30000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void AddNewClerkTestCase7() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, true));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        
        window.textBox("ClerkNameTextBox").enterText("Clerk1");
        window.textBox("ClerkAddressTextBox").enterText("City XYZ");
        window.textBox("ClerkPhoneTextBox").enterText("12345");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void AddNewClerkTestCase8() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, true));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        
        window.textBox("ClerkNameTextBox").enterText("Cleajkldjfksdkjfkjaskjfksdjklfjlksdjfkjsdkfjljakldjfkjsdkfldjfadkjfkjljfadsrk1");
        window.textBox("ClerkAddressTextBox").enterText("City XYZ");
        window.textBox("ClerkPhoneTextBox").enterText("12345");
        window.textBox("ClerkSalaryTextBox").enterText("30000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void AddNewClerkTestCase9() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, true));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        
        window.textBox("ClerkNameTextBox").enterText("Clerk1");
        window.textBox("ClerkAddressTextBox").enterText("Ciklsdlakfsdkljfkljaksdjkfljsdlkjflkjsdkfjkjaslkdjflksdlkflkjsdlkfhjfdlkasjdklfjsdkljfkjdskjfdsajfsdty XYZ");
        window.textBox("ClerkPhoneTextBox").enterText("12345");
        window.textBox("ClerkSalaryTextBox").enterText("30000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void AddNewClerkTestCase10() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, true));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        
        window.textBox("ClerkNameTextBox").enterText("Clerk1");
        window.textBox("ClerkAddressTextBox").enterText("City XYZ");
        window.textBox("ClerkPhoneTextBox").enterText("12344385783479579843598723845874385897432897874387287437734952438843785");
        window.textBox("ClerkSalaryTextBox").enterText("30000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void AddNewClerkTestCase11() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, true));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        
        window.textBox("ClerkNameTextBox").enterText("Clerk1");
        window.textBox("ClerkAddressTextBox").enterText("City XYZ");
        window.textBox("ClerkPhoneTextBox").enterText("12345");
        window.textBox("ClerkSalaryTextBox").enterText("3008743825498293542375700");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void AddNewLibrarianTestCase1() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, false));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        window.textBox("ClerkNameTextBox").enterText("Librarian1");
        window.textBox("ClerkAddressTextBox").enterText("City JKL");
        window.textBox("ClerkPhoneTextBox").enterText("678912");
        window.textBox("ClerkSalaryTextBox").enterText("70000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals((window.label("Error").text().contains("Librarian has been added") || window.label("Error").text().contains("Library already has one librarian")), true);
    }
    
    @Test
    public void AddNewLibrarianTestCase2() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, false));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        window.textBox("ClerkNameTextBox").enterText("Librarian1");
        window.textBox("ClerkAddressTextBox").enterText("City JKL");
        window.textBox("ClerkPhoneTextBox").enterText("Bogus678912");
        window.textBox("ClerkSalaryTextBox").enterText("70000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Phone number can only be numbers"), true);
    }
    
    @Test
    public void AddNewLibrarianTestCase3() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, false));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        window.textBox("ClerkNameTextBox").enterText("Librarian1");
        window.textBox("ClerkAddressTextBox").enterText("City JKL");
        window.textBox("ClerkPhoneTextBox").enterText("678912");
        window.textBox("ClerkSalaryTextBox").enterText("Bogus70000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Salary can only be number"), true);
    }
    
    @Test
    public void AddNewLibrarianTestCase4() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, false));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        window.textBox("ClerkAddressTextBox").enterText("City JKL");
        window.textBox("ClerkPhoneTextBox").enterText("678912");
        window.textBox("ClerkSalaryTextBox").enterText("70000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void AddNewLibrarianTestCase5() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, false));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        window.textBox("ClerkNameTextBox").enterText("Librarian1");
        window.textBox("ClerkPhoneTextBox").enterText("678912");
        window.textBox("ClerkSalaryTextBox").enterText("70000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void AddNewLibrarianTestCase6() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, false));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        window.textBox("ClerkNameTextBox").enterText("Librarian1");
        window.textBox("ClerkAddressTextBox").enterText("City JKL");
        window.textBox("ClerkSalaryTextBox").enterText("70000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void AddNewLibrarianTestCase7() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, false));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        window.textBox("ClerkNameTextBox").enterText("Librarian1");
        window.textBox("ClerkAddressTextBox").enterText("City JKL");
        window.textBox("ClerkPhoneTextBox").enterText("678912");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void AddNewLibrarianTestCase8() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, false));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        window.textBox("ClerkNameTextBox").enterText("Librarkadfksdfkjkalsdfkldjklflsdjflkjsdklfjsadlkjflksdjflkjdslkfjdslakjflksdjian1");
        window.textBox("ClerkAddressTextBox").enterText("City JKL");
        window.textBox("ClerkPhoneTextBox").enterText("678912");
        window.textBox("ClerkSalaryTextBox").enterText("70000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void AddNewLibrarianTestCase9() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, false));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        window.textBox("ClerkNameTextBox").enterText("Librarian1");
        window.textBox("ClerkAddressTextBox").enterText("Citkjfklsdaflksdkfjkajsdlkfjsdlkjflksdjflkjsdlkfjksdajfjsdkfjdsjfdsfjsdfjldsfalsdfjy JKL");
        window.textBox("ClerkPhoneTextBox").enterText("678912");
        window.textBox("ClerkSalaryTextBox").enterText("70000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void AddNewLibrarianTestCase10() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, false));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        window.textBox("ClerkNameTextBox").enterText("Librarian1");
        window.textBox("ClerkAddressTextBox").enterText("City JKL");
        window.textBox("ClerkPhoneTextBox").enterText("6789584372843825843973285794378582483523858438543512");
        window.textBox("ClerkSalaryTextBox").enterText("70000");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void AddNewLibrarianTestCase11() throws InterruptedException {
        LMS.UI.AddClerkUI frame;
        frame = runner.execute(() -> new LMS.UI.AddClerkUI(handler, false));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        window.textBox("ClerkNameTextBox").enterText("Librarian1");
        window.textBox("ClerkAddressTextBox").enterText("City JKL");
        window.textBox("ClerkPhoneTextBox").enterText("678912");
        window.textBox("ClerkSalaryTextBox").enterText("7008437985437584329858400");
        window.button("AddClerkButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    
    @After
    public void tearDown() {
        window.cleanUp();
    }   
}
