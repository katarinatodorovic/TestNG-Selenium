import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SortButtonsReverseOrder {
    public static void main(String[] args) throws InterruptedException {

        String interactionsPath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[3]";
        String chromeDriverpath = "C:\\Users\\kaca\\Desktop\\JAR Files\\Selenium za IDE\\chromedriver.exe";
        String sortablePath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/ul[1]/li[1]";
        String url = "https://demoqa.com/";
        String oneButtonPath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]";
        String secondButtonpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]";
        String thitdButtonpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]";
        String fourthButtonPath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]";
        String fifthButtonPath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]";
        String sixthButtonPath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[6]";


        System.setProperty("webdriver.chrome.driver",chromeDriverpath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        driver.findElement(By.xpath(interactionsPath)).click();
        driver.findElement(By.xpath(sortablePath)).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS) ;
		
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath(oneButtonPath))).clickAndHold().
                moveToElement(driver.findElement(By.xpath(sixthButtonPath))).click();
        actions.click(driver.findElement(By.xpath(oneButtonPath))).clickAndHold().
                moveToElement(driver.findElement(By.xpath(fifthButtonPath))).click();
        actions.click(driver.findElement(By.xpath(oneButtonPath))).clickAndHold().
                moveToElement(driver.findElement(By.xpath(fourthButtonPath))).click();
        actions.click(driver.findElement(By.xpath(oneButtonPath))).clickAndHold().
                moveToElement(driver.findElement(By.xpath(thitdButtonpath))).click();
        actions.click(driver.findElement(By.xpath(oneButtonPath))).clickAndHold().
                moveToElement(driver.findElement(By.xpath(secondButtonpath))).click();
        actions.build().perform();

    }
}
