import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterNow {

    private static String registerNowXpath = "/html[1]/body[1]/div[2]/div[1]/a[1]";

    public static void registerNowClick(WebDriver wd){
      wd.findElement(By.xpath(registerNowXpath)).click();
    }
}
