package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import util.TestUtil;

//iminja vo dinamicka tabela
public class ContactsPage extends TestBase {


    @FindBy(xpath = "//frame[@name='mainpanel']")
    WebElement iframeElement;
    @FindBy (xpath = "//td[contains(text(),'Contacts')]") //vo razlicen frame e
    WebElement contactsLabel;

    @FindBy (id="first_name")
    WebElement FirstName;

    @FindBy(id="surname")
    WebElement LastName;

    @FindBy(name="client_lookup")
    WebElement Company;

    @FindBy (xpath = "//input[@value='Save' and @type='submit']") //vo razlicen frame e
    WebElement SaveBtn;


    //constructor
    public ContactsPage() {
        PageFactory.initElements(driver, this);
      }

//Actions -Initializing the page objects:
     public boolean verifyContactsLabel(){
                return contactsLabel.isDisplayed();
    }


//***********For selecting different contacts CHECKBOX from table
    public void selectSingleContactsByName(String name){
        driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
    }



    public void createNewContact(String title, String ftName, String ltName, String comp){
        Select select = new Select(driver.findElement(By.name("title")));
        select.selectByVisibleText(title);

        FirstName.sendKeys(ftName);
        LastName.sendKeys(ltName);
        Company.sendKeys(comp);
        SaveBtn.click();
    }
}
