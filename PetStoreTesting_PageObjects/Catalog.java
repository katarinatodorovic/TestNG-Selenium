import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Catalog {

    private static String signInPath ="//a[contains(text(),'Sign In')]";
    public static WebElement getSignIn(WebDriver wd){
        return wd.findElement(By.xpath(signInPath));
    }
    public static void signInClicl(WebDriver wd){
         getSignIn(wd).click();
    }

}
