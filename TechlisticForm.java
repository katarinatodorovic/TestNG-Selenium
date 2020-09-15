import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;

public class TechlisticForm {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaca\\Desktop\\Selenium za IDE\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Bora");

        WebElement lastName = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/main[1]/div[1]" +
                "/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[6]/input[1]"));
        lastName.sendKeys("Jovanovic");

        WebElement radioMale = driver.findElement(By.cssSelector("#sex-0"));
        radioMale.click();

        WebElement yearsOfExperiance = driver.findElement(By.id("exp-4"));
        yearsOfExperiance.click();

        WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
        date.sendKeys("15.9.2020");

        WebElement checkBoxManual = driver.findElement(By.cssSelector("#profession-0"));
            checkBoxManual.click();

        WebElement checkBoxAutomation = driver.findElement(By.xpath("//label[@class='checkbox']"));
        checkBoxAutomation.click();

        WebElement checkBoxSelenium = driver.findElement(By.cssSelector("#tool-2"));
        checkBoxSelenium.click();

        Select continent = new Select(driver.findElement(By.id("continents")));
        continent.selectByVisibleText("Europe");

        Select controls = new Select(driver.findElement(By.id("selenium_commands")));
        controls.selectByVisibleText("Navigation Commands");

       WebElement chooseFile = driver.findElement(By.xpath("//input[@id='photo']"));
       chooseFile.sendKeys("C:\\Users\\kaca\\Desktop\\Registar\\Poliranje Cenovnik.jpg");

        driver.findElement(By.xpath("//a[contains(text(),'Click here to Download File')]")).click();

        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        submit.click();
    }
}
