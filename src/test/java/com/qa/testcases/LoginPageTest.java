package com.qa.testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {

    LoginPage loginPage; //initialize login page var from SetupMethod
    HomePage homePage; // Initialize home page becouse after login home page opens

    //Constructor needs to be created to be called constructor from test base class
    public LoginPageTest(){
        super(); // super word comes in testbase and read test base class constructor
    }


    //define annotatitons and in this method call Initialization method from test base class
    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage(); // this object we can use in @test for calling the methods
    }

    // in the loginPage we defined method for title = validateLoginPageTitle
    @Test(priority = 1)
    public void LoginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"Free CRM - CRM software for customer relationship management, sales, and support.");
    }

    /*Explanation how we are writing tests:
     * In LoginPage we defined methods for validation of the logo if the logo is displayed
     * Here in the test we are using boolean and flag variable because that methods needs to return TRUE or False, because
     * of that boolean is defined in the test
     * loginPage is the object that is defined in the LoginPageTest
     * */

    @Test (priority = 2)
    public void logoImageTest(){
        boolean flag = loginPage.validateLogo();
        Assert.assertTrue(flag);
    }

    @Test (priority = 3)
    public void LoginTest(){
        homePage =  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




}
