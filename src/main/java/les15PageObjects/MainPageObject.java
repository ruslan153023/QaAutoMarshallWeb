package les15PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import les19PageObjects.PageObjects;

import java.time.Duration;

public class MainPageObject {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        PageObjects pageObjects = new PageObjects("https://www.demoblaze.com/");

        PageObjects.setDriver();
        pageObjects.openWeb(driver);
        pageObjects.login(driver,"admin", "admin");

        PageObjects.mySleep();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element = driver.findElement(By.xpath("//a[@id='nameofuser']"));
        String nameOfUser = element.getText();
        Assert.assertEquals(nameOfUser, "Welcome admin");

    }
}
