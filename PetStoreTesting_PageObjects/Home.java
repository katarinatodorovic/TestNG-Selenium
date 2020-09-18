import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
    public static String url = "https://petstore.octoperf.com/";
    private static String enterTheStoreXpath = "body:nth-child(2) div:nth-child(1) p:nth-child(2) > a:nth-child(1)";
    public  static WebElement getEnterTheStoreElement(WebDriver wd){
        return wd.findElement(By.cssSelector(enterTheStoreXpath));
    }
    public static void clickEnterTheStore(WebDriver wd){
        getEnterTheStoreElement(wd).click();
    }
}
