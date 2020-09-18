import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckSavedAccount {

    private static String usernamePath = "/html[1]/body[1]/div[2]/div[1]/form[1]/p[2]/input[1]";
    private static String passwordPath = "/html[1]/body[1]/div[2]/div[1]/form[1]/p[2]/input[2]";
    private static String lohgInPath = "/html[1]/body[1]/div[2]/div[1]/form[1]/input[1]";

    public static void setUserName(WebDriver wd, String userName){
        wd.findElement(By.xpath(usernamePath)).sendKeys(userName);
    }
    public static void setPassword(WebDriver wd, String password){
        wd.findElement(By.xpath(passwordPath)).clear();
       wd.findElement(By.xpath(passwordPath)).sendKeys(password);
    }
    public static void clickLogIn(WebDriver wd){
        wd.findElement(By.xpath(lohgInPath)).click();
    }
}
