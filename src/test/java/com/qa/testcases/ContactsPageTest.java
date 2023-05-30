package com.qa.testcases;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.testng.Assert;

import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

import java.util.concurrent.TimeUnit;

public class ContactsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil; // we do import because switchToFrame method we are using from Util Class
    ContactsPage contactsPage;

    String sheetName = "contacts"; // var for contact sheet


    //constructor for initial property from Testbase class to be invoke everything that is in try/catch
    public ContactsPageTest(){
        super();
    }


    @BeforeMethod
    public void setUp(){
        initialization();
        testUtil = new TestUtil(); // mora objekt za da se iskoristi vo test case
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        testUtil.switchToFrame();
       contactsPage = homePage.clickOnContactsTab();

    }

    @Test(priority = 1)
    public void ContactLabelIsDisplayedTest(){
    Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");
    }

    @Test (priority = 2)
    public void selectContactsTest(){
        contactsPage.selectSingleContactsByName("Test 2 test 2");
    }


    @Test (priority = 3)
    public void selectMultipleContactsTest(){
        contactsPage.selectSingleContactsByName("Test 2 test 2");
        contactsPage.selectSingleContactsByName("Test 3 Test 3");
    }


/*How to read data from excel table - method is created in TestUtil class*/
    @DataProvider //is fatching data from the excell sheet
    public Object[][] getCRMTestData(){
        Object data[][] = TestUtil.getTestData(sheetName); //TWO DIMENZIONAL ARRAY OBJECT
        return data;
    }
    @Test (priority = 4, dataProvider = "getCRMTestData")
    public void CreateNewContactTest(String title,String firstName, String lastName, String company) {
        homePage.ClickOnNewContactLink();
        //contactsPage.createNewContact("Mr.","Sanja4","Stojanovska24","Polar4");
        contactsPage.createNewContact(title,firstName,lastName,company);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
