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
//Thread.sleep(1000);
    }
    
    @Test
    public void SearchBookTitleTestCase1() throws InterruptedException {
        window.radioButton("TitleRadioButton").check();
        window.textBox("SearchFilterTextBox").enterText("Dic");
        window.button("SearchButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error").text(), "");
    }
    
    @Test
    public void SearchBookTitleTestCase2() throws InterruptedException {
        window.radioButton("TitleRadioButton").check();
        window.button("SearchButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.textBox("SearchBox").text().contains("No field(s) can be empty"), true);
    }
    
    @Test
    public void SearchBookTitleTestCase3() throws InterruptedException {
        window.radioButton("TitleRadioButton").check();
        window.textBox("SearchFilterTextBox").enterText("Ddsfdskfskdfksdjkfljsdlkfjksdjfksjdkafjksdjfkjsadkfjksdfksdjfkjkasfkjsdkfsdkfkdakfjsdkjfkldic");
        window.button("SearchButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void SearchBookAuthorTestCase1() throws InterruptedException {
        window.radioButton("AuthorRadioButton").check();
        window.textBox("SearchFilterTextBox").enterText("Neil");
        window.button("SearchButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error").text(), "");
    }
    
    @Test
    public void SearchBookAuthorTestCase2() throws InterruptedException {
        window.radioButton("AuthorRadioButton").check();
        window.textBox("SearchFilterTextBox");
        window.button("SearchButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.textBox("SearchBox").text().contains("No field(s) can be empty"), true);
    }
    
    @Test
    public void SearchBookAuthorTestCase3() throws InterruptedException {
        window.radioButton("AuthorRadioButton").check();
        window.textBox("SearchFilterTextBox").enterText("Nefadfjkdsfsjkfhjksdhfjkhsfjkhdskjfhkjsdahfkjsdhfkjhsdkjfhsdkjfhksjdhfkjsdhkjfhskjdil");
        window.button("SearchButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void SearchBookSubjectTestCase1() throws InterruptedException {
        window.radioButton("SubjectRadioButton").check();
        window.textBox("SearchFilterTextBox").enterText("Misc");
        window.button("SearchButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error").text(), "");
    }
    
    @Test
    public void SearchBookSubjectTestCase2() throws InterruptedException {
        window.radioButton("SubjectRadioButton").check();
        window.textBox("SearchFilterTextBox");
        window.button("SearchButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.textBox("SearchBox").text().contains("No field(s) can be empty"), true);
    }
    
    @Test
    public void SearchBookSubjectTestCase3() throws InterruptedException {
        window.radioButton("SubjectRadioButton").check();
        window.textBox("SearchFilterTextBox").enterText("Mifsadfsdjkfsdjflkjdlkfjlksdjlkjflkasjdlfjsdkjflksdjflksjflksc");
        window.button("SearchButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(window.label("Error").text().contains("Word limit of field(s) exceeded"), true);
    }
    
    @Test
    public void GoBack() throws InterruptedException {
        window.button("BackButton").click();
        
//Thread.sleep(1000);
        
        assertEquals(true, true);
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
}
