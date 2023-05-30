package com.qa.testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil; // we do import because switchToFrame method we are using from Util Class
    ContactsPage contactsPage;

    //constructor for initial property from Testbase class to be invoke everything that is in try/catch
    public HomePageTest(){
        super();
    }


  /*  testcases should be independent with each other - separated
    before each test cases launch the browser and login
    @test - execute test case
    after each test cases -- close the browser*/

    @BeforeMethod
    public void setUp(){
        initialization();
        testUtil = new TestUtil(); // mora objekt za da se iskoristi vo test case
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        //we should login to be in home page
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        testUtil.switchToFrame();

    }

    @Test (priority = 1)
    public void verifyHomePageTitleTest(){
       String homePageTitle= homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title not matched");
         }

    @Test (priority = 2)
    public void verifyUserNameTest(){
        //testUtil.switchToFrame();
       Assert.assertTrue(homePage.verifyCorrectUserName());
    }

    @Test (priority = 3)
    public void verifyContactsLinkTest(){
       // testUtil.switchToFrame();
       contactsPage = homePage.clickOnContactsTab();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
