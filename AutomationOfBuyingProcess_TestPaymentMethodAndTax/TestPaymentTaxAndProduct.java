import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestPaymentTaxAndProduct {

    Row row;
    WebDriver driver;

    @BeforeTest
    public void setConditions() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaca\\Desktop\\Selenium za IDE\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        File src=new File("C:\\Users\\kaca\\Desktop\\SauceDemoUsers.xlsx");
        FileInputStream finput = new FileInputStream(src);
        XSSFWorkbook wb; wb = new XSSFWorkbook(finput);
        XSSFSheet sheet= wb.getSheetAt(0);
        row = sheet.getRow(1);

        Cell cell = row.getCell(0);
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys(cell.toString());

        cell = row.getCell(1);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(cell.toString());

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        Select continent = new Select(driver.findElement(By.className("product_sort_container")));
        continent.selectByVisibleText("Price (low to high)");

        WebElement addToCart = driver.findElement(By.xpath("//div[6]//div[3]//button[1]"));
        addToCart.click();

        WebElement goToCart = driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]"));
        goToCart.click();

        Thread.sleep(1500);
        WebElement checkOut = driver.findElement(By.xpath("//a[@class='btn_action checkout_button']"));
        checkOut.click();

        cell = row.getCell(2);
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys(cell.toString());

        cell = row.getCell(3);
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys(cell.toString());

        cell = row.getCell(4);
        WebElement zipCode = driver.findElement(By.id("postal-code"));
        zipCode.sendKeys(cell.toString());

        WebElement confirmPurchase = driver.findElement(By.xpath("//input[@class='btn_primary cart_button']"));//continue
        confirmPurchase.click();

    }
    @Test
    public void checkItemName() throws IOException, InterruptedException {

        String itemName = row.getCell(5).getStringCellValue();
        String siteItemName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        Assert.assertEquals(itemName,siteItemName);

    }
    @Test
    public void checkTax() throws IOException, InterruptedException {

        String tax = row.getCell(6).getStringCellValue();
        String tax_label = driver.findElement(By.className("summary_tax_label")).getText();
        Assert.assertEquals(tax,tax_label);

    }
    @Test
    public void checkPayment() throws IOException, InterruptedException {

        String paymentInformation = row.getCell(7).getStringCellValue();
        String sitePaymentInfo = driver.findElement(By.xpath("//div[contains(text(),'SauceCard #31337')]")).getText();
        Assert.assertEquals(paymentInformation,sitePaymentInfo);


    }
}


