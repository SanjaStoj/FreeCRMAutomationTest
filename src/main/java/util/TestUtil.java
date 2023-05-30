package util;
import com.sun.media.sound.InvalidFormatException;
import io.ous.jtoml.impl.ObjectDeserializer;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import base.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {
    //The pageLoadTimeout method is a part of the Timeouts interface in the Selenium WebDriver API, which is used to configure timeouts for different WebDriver-related operations.

    public static final long PAGE_LOAD_TIMEOUT = 30;
    public static final long IMPLICIT_WAIT = 20;

    //is used in homePageTest.java class
    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");
    }



//Method is created in ContacsPage.java - how to read data from excel
    public static String TESTDATA_SHEET_PATH = "C:\\Users\\svasi\\IdeaProjects\\AutomationNaveenFrameworkWebdriverManager\\src\\main\\java\\TestData\\FreeCrmTestData.xlsx";
    static Workbook book;
    static Sheet sheet;

    public static Object[][] getTestData(String sheetName) { // this method excepting sheetName for two dimenzion object array  bases on rows and columns
            FileInputStream file = null;
            try {
                file = new FileInputStream(TESTDATA_SHEET_PATH);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            try {
                book = WorkbookFactory.create(file);
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            sheet = book.getSheet(sheetName);
            Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
            System.out.println(sheet.getLastRowNum() + "------------" +
            sheet.getRow(0).getLastCellNum());

            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                    data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                    System.out.println(data[i][k]);
                }
            }

            return data;
        }
    }


