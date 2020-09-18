import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationForm {
    private static String userIDPath ="/html[1]/body[1]/div[2]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]";
    private static String newPasswordPath="/html[1]/body[1]/div[2]/div[1]/form[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]";
    private static String repeatPasswordPath ="/html[1]/body[1]/div[2]/div[1]/form[1]/table[1]/tbody[1]/tr[3]/td[2]/input[1]";
    private static String firstNamePath ="/html[1]/body[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[2]/input[1]";
    private static String lastNamePath ="/html[1]/body[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[2]/td[2]/input[1]";
    private static String emailPath ="/html[1]/body[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[3]/td[2]/input[1]";
    private static String phonePath ="/html[1]/body[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[4]/td[2]/input[1]";
    private static String address1Path ="/html[1]/body[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[5]/td[2]/input[1]";
    private static String address2Path ="/html[1]/body[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[6]/td[2]/input[1]";
    private static String cityPath ="/html[1]/body[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[7]/td[2]/input[1]";
    private static String statePath ="/html[1]/body[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[8]/td[2]/input[1]";
    private static String zipPath ="/html[1]/body[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[9]/td[2]/input[1]";
    private static String countryPath ="/html[1]/body[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[10]/td[2]/input[1]";
    private static String languagePreferencePath ="account.languagePreference";
    private static String favouriteCategoryPath ="account.favouriteCategoryId";
    private static String enableMyListPath ="/html[1]/body[1]/div[2]/div[1]/form[1]/table[3]/tbody[1]/tr[3]/td[2]/input[1]";
    private static String enableMyBannerPath ="/html[1]/body[1]/div[2]/div[1]/form[1]/table[3]/tbody[1]/tr[4]/td[2]/input[1]";
    private static String saveAccountInformationPath ="/html[1]/body[1]/div[2]/div[1]/form[1]/input[1]";


    //User Information*****************************************************

    public static WebElement getUserId(WebDriver wd){
        return wd.findElement(By.xpath(userIDPath));
    }
    public static void setUserID(WebDriver wd,String id){
        getUserId(wd).sendKeys(id);
    }
    public static WebElement getNewPassword(WebDriver wd){
        return wd.findElement(By.xpath(newPasswordPath));
    }
    public static void setNewPassword(WebDriver wd, String newPassword){
        getNewPassword(wd).sendKeys(newPassword);
    }
    public static WebElement getRepeatPassword(WebDriver wd){
        return  wd.findElement(By.xpath(repeatPasswordPath));
    }
    public static void setRepeatPassword(WebDriver wd, String repeatPassword){
        getRepeatPassword(wd).sendKeys(repeatPassword);
    }

    //Account Information************************************************
    public static void setFirstName(WebDriver wd, String firstName){
        wd.findElement(By.xpath(firstNamePath)).sendKeys(firstName);
    }
    public static void  setLastName(WebDriver wd, String lastName){
        wd.findElement(By.xpath(lastNamePath)).sendKeys(lastName);
    }
    public static void  setEmail(WebDriver wd, String email){
        wd.findElement(By.xpath(emailPath)).sendKeys(email);
    }
    public static void  setPhone(WebDriver wd, String phone){
        wd.findElement(By.xpath(phonePath)).sendKeys(phone);
    }
    public static void  setAddress1(WebDriver wd, String address1){
        wd.findElement(By.xpath(address1Path)).sendKeys(address1);
    }
    public static void  setAddress2(WebDriver wd, String address2){
        wd.findElement(By.xpath(address2Path)).sendKeys(address2);
    }
    public static void  setCity(WebDriver wd, String city){
        wd.findElement(By.xpath(cityPath)).sendKeys(city);
    }
    public static void  setState(WebDriver wd, String state){
        wd.findElement(By.xpath(statePath)).sendKeys(state);
    }
    public static void  setZip(WebDriver wd, String zip){
        wd.findElement(By.xpath(zipPath)).sendKeys(zip);
    }
    public static void  setCountry(WebDriver wd, String country){
        wd.findElement(By.xpath(countryPath)).sendKeys(country);
    }

    //Profile Information****************************************************

    public static void  setLanguagePreference(WebDriver wd, String languagePreference){

        Select languagePreferenc = new Select(wd.findElement(By.name(languagePreferencePath)));
        languagePreferenc.selectByValue(languagePreference);
    }
    public static void  setFavouriteCategory(WebDriver wd, String favouriteCategory){
       Select category = new Select(wd.findElement(By.name(favouriteCategoryPath)));
       category.selectByValue(favouriteCategory);
    }
    public static void  setEnableMyList(WebDriver wd){
        wd.findElement(By.xpath(enableMyListPath)).click();
    }
    public static void  setEnableMyBanner(WebDriver wd){
        wd.findElement(By.xpath(enableMyBannerPath)).click();
    }
    public static void  clickSaveAccountInformation(WebDriver wd){
        wd.findElement(By.xpath(saveAccountInformationPath)).click();
    }
}
