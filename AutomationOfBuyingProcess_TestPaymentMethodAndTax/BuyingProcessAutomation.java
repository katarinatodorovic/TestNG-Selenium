import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BuyingProcessAutomation {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaca\\Desktop\\Selenium za IDE\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

            for (int i = 1; i <= 2; i++) {
                try {
                    FileInputStream file = new FileInputStream("C:\\Users\\kaca\\Desktop\\SauceDemoUsers.xlsx");
                    XSSFWorkbook wb = new XSSFWorkbook(file);

                    Sheet sheet = wb.getSheetAt(0);
                    Row row = sheet.getRow(i);

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
                    WebElement finish = driver.findElement(By.xpath("//a[@class='btn_action cart_button']"));
                    finish.click();

                    Thread.sleep(1500);

                    WebElement menu = driver.findElement(By.xpath("//button[contains(text(),'Open Menu')]"));
                    menu.click();
                    Thread.sleep(1500);
                    driver.findElement(By.id("logout_sidebar_link")).click();


                } catch (FileNotFoundException e) {

                    e.printStackTrace();

                } catch (IOException e) {

                    e.printStackTrace();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

