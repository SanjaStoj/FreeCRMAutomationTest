package pages;

//import com.qa.base.TestBase;
import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //we have to define page factory -OR;
    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password" )
    WebElement password;

    @FindBy (xpath ="//input[@value='Login']")
    WebElement LoginButton;


    @FindBy(xpath = "//img[@src='https://classic.freecrm.com/img/logo.png']")
    WebElement logo;

    /*constructor method for a LoginPage class,
    and it uses the initElements method from the PageFactory class to initialize the web elements on the page.
    The PageFactory class is a part of the Selenium WebDriver API,
    and it provides a way to initialize the web elements defined in a page object class.
     When you use the PageFactory.initElements method,
     it initializes the web elements on the page by using the FindBy annotations defined in the page object class.*/
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions:
    //Difine different actions on login page
    public String validateLoginPageTitle(){
                return driver.getTitle();
    }

    public boolean validateLogo(){
        return logo.isDisplayed();
    }

    //this method after login is return home page - because we are landing on home page after login
    public HomePage login (String name, String pass){
        username.sendKeys(name);
        password.sendKeys(pass);
        LoginButton.click();

        return new HomePage();
    }















}

