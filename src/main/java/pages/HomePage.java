package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;

import static base.TestBase.driver;

public class HomePage {

    @FindBy(xpath = "//frame[@name='mainpanel']")
    WebElement iframeElement;

    @FindBy(xpath = "//td[contains(text(),'User: Sanja Sanja')]")
    WebElement userNameLabel;


    @FindBy(xpath = "//a[@title='Contacts']")
    WebElement contactsLink;

    @FindBy(xpath = "//a[@title='Deals']")
    WebElement dealsLink;

    @FindBy(xpath = "//a[@title='Tasks']")
    WebElement taskLink;

    @FindBy(xpath = "//a[@title='New Contact']")
    WebElement newContactLink;

//constructor Initializing the page object
    public HomePage(){
    PageFactory.initElements(driver, this);
}


//Define actions on home page
    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

//ACTIONS
     /*  public boolean verifyCorrectUserName() {
             // Switch to the iframe that contains the element
        driver.switchTo().frame(iframeElement);
        // Verify the user name label is displayed
        boolean isDisplayed = userNameLabel.isDisplayed();
        // Switch back to the default content
        driver.switchTo().defaultContent();
        // Return the result of the verification
        return isDisplayed;
    }*/

    public boolean verifyCorrectUserName() {
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsTab(){
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsTab(){
        dealsLink.click();
        return new DealsPage();
    }
    public TaskPage clickOnTaskTab(){
        taskLink.click();
        return new TaskPage();
    }

    public void ClickOnNewContactLink() {
        // Scroll to the element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newContactLink);
        Actions action = new Actions(driver); //mouse over to see the dropdown
        action.moveToElement(newContactLink).build().perform(); // glumi mouse over na contacts linkot
        newContactLink.click();

       }

}
