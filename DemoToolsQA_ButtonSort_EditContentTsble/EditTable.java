import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EditTable {
    public static void main(String[] args) throws InterruptedException {

        String chromeDriverpath = "C:\\Users\\kaca\\Desktop\\JAR Files\\Selenium za IDE\\chromedriver.exe";
        String url = "https://demoqa.com/";
        String formsPath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/*[local-name()='svg'][1]";
        String elementsExpandPath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[2]/div[2]/*[local-name()='svg'][1]/*[name()='g'][1]/*[name()='path'][2]";
        String webTablesPath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/span[1]";
        String deleteRowPath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[7]/div[1]/span[2]/*[local-name()='svg'][1]/*[name()='path'][1]";
        String editButtonPath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[7]/div[1]/span[1]/*[local-name()='svg'][1]";
        String addRowButtonPath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]";
        String firstNameCssSelecror = "#firstName";
        String lastNameCssSelector= "#lastName";
        String emailCssSelector= "#userEmail";
        String ageCssSelector= "#age";
        String salaryCssSelector= "#salary";
        String departmentCssSelector= "#department";
        String submitPath = "#submit";
        String excelFilePath = "C:\\Users\\kaca\\Desktop\\DemoToolsQA_TableContent.xlsx";

       
	   System.setProperty("webdriver.chrome.driver",chromeDriverpath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.xpath(formsPath)).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS) ;
        driver.findElement(By.xpath(elementsExpandPath)).click();
        driver.findElement(By.xpath(webTablesPath)).click();
        driver.findElement(By.xpath(deleteRowPath)).click();
        driver.findElement(By.xpath(deleteRowPath)).click();
        driver.findElement(By.xpath(editButtonPath)).click();
        driver.findElement(By.cssSelector(firstNameCssSelecror)).clear();
        driver.findElement(By.cssSelector(firstNameCssSelecror)).sendKeys("Radmila");
        driver.findElement(By.cssSelector(lastNameCssSelector)).clear();
        driver.findElement(By.cssSelector(lastNameCssSelector)).sendKeys("Radmilovic");
        driver.findElement(By.cssSelector(emailCssSelector)).clear();
        driver.findElement(By.cssSelector(emailCssSelector)).sendKeys("radmilovic@mail.com");
        driver.findElement(By.cssSelector(ageCssSelector)).clear();
        driver.findElement(By.cssSelector(ageCssSelector)).sendKeys("32");
        driver.findElement(By.cssSelector(salaryCssSelector)).clear();
        driver.findElement(By.cssSelector(salaryCssSelector)).sendKeys("65000");
        driver.findElement(By.cssSelector(departmentCssSelector)).clear();
        driver.findElement(By.cssSelector(departmentCssSelector)).sendKeys("HR");
        driver.findElement(By.cssSelector(submitPath)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(deleteRowPath)).click();
		
		
        for (int i = 1; i <=3 ; i++) {
            driver.findElement(By.xpath(addRowButtonPath)).click();
            driver.findElement(By.cssSelector(firstNameCssSelecror)).sendKeys( ExcelDataReaderWriter.readDataFromExcel(excelFilePath,0,i));
            driver.findElement(By.cssSelector(lastNameCssSelector)).sendKeys( ExcelDataReaderWriter.readDataFromExcel(excelFilePath,1,i));
            driver.findElement(By.cssSelector(emailCssSelector)).sendKeys( ExcelDataReaderWriter.readDataFromExcel(excelFilePath,2,i));
            driver.findElement(By.cssSelector(ageCssSelector)).sendKeys( ExcelDataReaderWriter.readDataFromExcel(excelFilePath,3,i));
            driver.findElement(By.cssSelector(salaryCssSelector)).sendKeys( ExcelDataReaderWriter.readDataFromExcel(excelFilePath,4,i));
            driver.findElement(By.cssSelector(departmentCssSelector)).sendKeys( ExcelDataReaderWriter.readDataFromExcel(excelFilePath,5,i));
            driver.findElement(By.cssSelector(submitPath)).click();
        }
    }
}
