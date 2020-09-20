package DemoToolsQA_ButtonSort_EditContentTsble;

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
        String buttonPath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[";


        System.setProperty("webdriver.chrome.driver", chromeDriverpath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        driver.findElement(By.xpath(interactionsPath)).click();
        driver.findElement(By.xpath(sortablePath)).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Actions actions = new Actions(driver);
        for (int i = 6; i >= 1; i--) {
            actions.click(driver.findElement(By.xpath(oneButtonPath))).clickAndHold().
                    moveToElement(driver.findElement(By.xpath(buttonPath + i + "]"))).click();
        }
        actions.build().perform();
    }
}
