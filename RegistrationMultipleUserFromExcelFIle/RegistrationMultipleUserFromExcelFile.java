import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RegistrationMultipleUserFromExcelFile {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver","C:\\Users\\srdjan\\Desktop\\Selenium za IDE\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();


        for(int i = 1; i <= 7; i++ ) {
            try {

                FileInputStream fi = new FileInputStream("C:\\Users\\srdjan\\Desktop\\Korisnici.xlsx");
                XSSFWorkbook  wb = new XSSFWorkbook(fi);


                Sheet sheet = wb.getSheetAt(0);
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(0);

                WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
                firstName.sendKeys(cell.toString());

                cell = row.getCell(1);
                WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
                lastName.sendKeys(cell.toString());

                cell = row.getCell(2);
                WebElement email = driver.findElement(By.id("userEmail"));
                email.sendKeys(cell.toString());


				cell = row.getCell(3);
                WebElement gender = driver.findElement(By.xpath("//label[contains(text(),'"+cell.toString()+"')]"));
                gender.click();

              /*  cell = row.getCell(3);
                if (row.getCell(3).getStringCellValue().contains("f") ){
                         WebElement femail = driver.findElement(By.xpath("//label[contains(text(),'Female')]"));
                         femail.click(); }
                else{ WebElement male = driver.findElement
                        (By.xpath("//label[contains(text(),'Male')]"));
                        male.click(); }*/


                cell = row.getCell(4);
                WebElement phoneNum = driver.findElement(By.id("userNumber"));
                phoneNum.sendKeys(cell.toString());
                phoneNum.sendKeys(Keys.PAGE_DOWN);


                Thread.sleep(1500);

                WebElement submit = driver.findElement(By.cssSelector("#submit"));
                submit.click();
                Actions actions = new Actions(driver);
                actions.moveToElement(submit).click().perform();

                Thread.sleep(1500);

                WebElement close = driver.findElement(By.id("closeLargeModal"));
                close.click();

                Thread.sleep(1500);

            } catch (FileNotFoundException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }
        }

    }
}
