package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManager;
import util.TestUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    private static final String CONFIG_FILE = "config.properties";

    public TestBase() {
        try {
            prop = new Properties();
            InputStream ip = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE);
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            String chPath = SeleniumManager.getInstance().getDriverPath("chromedriver");
            System.setProperty("webdriver.chrome.driver", chPath);
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            String chPath = SeleniumManager.getInstance().getDriverPath("geckodriver");
            System.setProperty("webdriver.gecko.driver", chPath);
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}
