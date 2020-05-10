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
public class BorrowerInfoUIIT {
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
        LMS.UI.BorrowerInfoUI frame;
        frame = runner.execute(() -> new LMS.UI.BorrowerInfoUI(handler,  new Librarian(1, "John", "StreetABC", "0123", "", 100000, 1)));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
//        Thread.sleep(1000);
    }
    
    @Test
    public void DisplayBorrowerProfileTestCase1() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text(), "");
    }
    
    @Test
    public void DisplayBorrowerProfileTestCase2() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("1000");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Invalid borrower id"), true);
    }
    
    @Test
    public void DisplayBorrowerProfileTestCase3() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("ABCD");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("ID can only be numbers"), true);
    }
    
    @Test
    public void DisplayBorrowerProfileTestCase4() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("13487584372857348578438527353478500");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void ChangeBorrowerNameTestCase1() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        window.textBox("BorrowerNameTextBox").deleteText().enterText("New Borrower Name");
        window.button("SaveProfileButton").click();
        
//        Thread.sleep(1000);
                
        assertEquals(window.label("Error").text().contains("Profile updated"), true);
    }
    
    @Test
    public void ChangeBorrowerNameTestCase2() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        window.textBox("BorrowerNameTextBox").deleteText();
        window.button("SaveProfileButton").click();
        
//        Thread.sleep(1000);
                
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void ChangeBorrowerNameTestCase3() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        window.textBox("BorrowerNameTextBox").deleteText().enterText("Newfjsakfjsdklflksdkfjsdjfkkalsjfklskdjfkjsdkjfksdfkldskfjsdkfkalksdfksdfk Borrower Name");
        window.button("SaveProfileButton").click();
        
//        Thread.sleep(1000);
                
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void ChangeBorrowerPasswordTestCase1() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        window.textBox("BorrowerPasswordTextBox").deleteText().setText("NewPass!");
        window.button("SaveProfileButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Profile updated"), true);
    }
    
    @Test
    public void ChangeBorrowerPasswordTestCase2() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        window.textBox("BorrowerPasswordTextBox").deleteText();
        window.button("SaveProfileButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void ChangeBorrowerPasswordTestCase3() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        window.textBox("BorrowerPasswordTextBox").deleteText().setText("NewPjsdafkdsjlkfdskljflksadjfkjsdjfkjksdajfkjsdaklfjsdjfksdjafjsdfajsdfsdafass!");
        window.button("SaveProfileButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void ChangeBorrowerAddressTestCase1() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        window.textBox("BorrowerAddressTextBox").deleteText().enterText("Street 233, Germany");
        window.button("SaveProfileButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Profile updated"), true);
    }
    
    @Test
    public void ChangeBorrowerAddressTestCase2() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        window.textBox("BorrowerAddressTextBox").deleteText();
        window.button("SaveProfileButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void ChangeBorrowerAddressTestCase3() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        window.textBox("BorrowerAddressTextBox").deleteText().enterText("Strdskjfsdklfklsdfkjsdlfjlksdajflksdjflksadjflksdjflkjdskfjsdlkfjlskdjflksdjflksdjfeet 233, Germany");
        window.button("SaveProfileButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void ChangeBorrowerPhoneTestCase1() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        window.textBox("BorrowerPhoneTextBox").deleteText().enterText("12098");
        window.button("SaveProfileButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Profile updated"), true);
    }
    
    @Test
    public void ChangeBorrowerPhoneTestCase2() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        window.textBox("BorrowerPhoneTextBox").deleteText().enterText("QWERTY12098");
        window.button("SaveProfileButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("ID and phone number can only be numbers"), true);
    }
    
    @Test
    public void ChangeBorrowerPhoneTestCase3() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        window.textBox("BorrowerPhoneTextBox").deleteText();
        window.button("SaveProfileButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Field(s) cannot be empty"), true);
    }
    
    @Test
    public void ChangeBorrowerPhoneTestCase4() throws InterruptedException {
        // successful borrower profile display
        window.textBox("BorrowerIDTextBox").enterText("100");
        window.button("GetProfileButton").click();
        
//        Thread.sleep(1000);
        
        window.textBox("BorrowerPhoneTextBox").deleteText().enterText("12084854389578943587439857439875983478954753453488498");
        window.button("SaveProfileButton").click();
        
//        Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
