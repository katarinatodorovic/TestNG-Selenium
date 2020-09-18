import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPetStore {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\kaca\\Desktop\\JAR Files\\Selenium za IDE\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(Home.url);
        Home.clickEnterTheStore(driver);
        Catalog.signInClicl(driver);
        RegisterNow.registerNowClick(driver);

        String filePath = "C:\\Users\\kaca\\Desktop\\PetStoreUsers.xlsx";


        AccountRegistrationForm.setUserID(driver,ExcelDataReader.readDataFromExcel(filePath,0,1));
        AccountRegistrationForm.setNewPassword(driver,ExcelDataReader.readDataFromExcel(filePath,1,1));
        AccountRegistrationForm.setRepeatPassword(driver,ExcelDataReader.readDataFromExcel(filePath,2,1));

        AccountRegistrationForm.setFirstName(driver,ExcelDataReader.readDataFromExcel(filePath,3,1));
        AccountRegistrationForm.setLastName(driver,ExcelDataReader.readDataFromExcel(filePath,4,1));
        AccountRegistrationForm.setEmail(driver,ExcelDataReader.readDataFromExcel(filePath,5,1));
        AccountRegistrationForm.setPhone(driver,ExcelDataReader.readDataFromExcel(filePath,6,1));
        AccountRegistrationForm.setAddress1(driver,ExcelDataReader.readDataFromExcel(filePath,7,1));
        AccountRegistrationForm.setAddress2(driver,ExcelDataReader.readDataFromExcel(filePath,8,1));
        AccountRegistrationForm.setCity(driver,ExcelDataReader.readDataFromExcel(filePath,9,1));
        AccountRegistrationForm.setState(driver,ExcelDataReader.readDataFromExcel(filePath,10,1));
        AccountRegistrationForm.setZip(driver,ExcelDataReader.readDataFromExcel(filePath,11,1));
        AccountRegistrationForm.setCountry(driver,ExcelDataReader.readDataFromExcel(filePath,12,1));

        AccountRegistrationForm.setLanguagePreference(driver,ExcelDataReader.readDataFromExcel(filePath,13,1));
        AccountRegistrationForm.setFavouriteCategory(driver,ExcelDataReader.readDataFromExcel(filePath,14,1).toUpperCase());
        AccountRegistrationForm.setEnableMyList(driver);
        AccountRegistrationForm.setEnableMyBanner(driver);
        AccountRegistrationForm.clickSaveAccountInformation(driver);
        driver.close();

        System.setProperty("webdriver.chrome.driver","C:\\Users\\kaca\\Desktop\\JAR Files\\Selenium za IDE\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Home.url);
        Home.clickEnterTheStore(driver);
        Catalog.signInClicl(driver);
        CheckSavedAccount.setUserName(driver,ExcelDataReader.readDataFromExcel(filePath,0,1));
        CheckSavedAccount.setPassword(driver,ExcelDataReader.readDataFromExcel(filePath,1,1));
        CheckSavedAccount.clickLogIn(driver);
        Thread.sleep(1000);
        driver.close();


       System.setProperty("webdriver.chrome.driver","C:\\Users\\kaca\\Desktop\\JAR Files\\Selenium za IDE\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.get(Home.url);
       Home.clickEnterTheStore(driver);
       Catalog.signInClicl(driver);
       RegisterNow.registerNowClick(driver);

        AccountRegistrationForm.setUserID(driver,"Milica");
        AccountRegistrationForm.setNewPassword(driver,"Milica1111");
        AccountRegistrationForm.setRepeatPassword(driver,"Milica1111");

        AccountRegistrationForm.setFirstName(driver,"Milica");
        AccountRegistrationForm.setLastName(driver,"Mitrovic");
        AccountRegistrationForm.setEmail(driver,"milica@mail.com");
        AccountRegistrationForm.setPhone(driver,"065222333444");
        AccountRegistrationForm.setAddress1(driver,"Bulevar Zorana Djindjica 22");
        AccountRegistrationForm.setAddress2(driver,"/");
        AccountRegistrationForm.setCity(driver,"Beograd");
        AccountRegistrationForm.setState(driver,"Srbija");
        AccountRegistrationForm.setZip(driver,"11000");
        AccountRegistrationForm.setCountry(driver,"Srbija");

        AccountRegistrationForm.setLanguagePreference(driver,"English".toLowerCase());
        AccountRegistrationForm.setFavouriteCategory(driver,"fish".toUpperCase());
        AccountRegistrationForm.setEnableMyList(driver);
        AccountRegistrationForm.setEnableMyBanner(driver);
        AccountRegistrationForm.clickSaveAccountInformation(driver);
        driver.close();

        System.setProperty("webdriver.chrome.driver","C:\\Users\\kaca\\Desktop\\JAR Files\\Selenium za IDE\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Home.url);
        Home.clickEnterTheStore(driver);
        Catalog.signInClicl(driver);
        CheckSavedAccount.setUserName(driver,"Milica");
        CheckSavedAccount.setPassword(driver,"Milica1111");
        CheckSavedAccount.clickLogIn(driver);
        Thread.sleep(1000);
        driver.close();

      ExcelDataReader.setCellValueString(filePath,1,2,"Milena");
      System.out.println(ExcelDataReader.readDataFromExcel(filePath,1,2));


    }
}
