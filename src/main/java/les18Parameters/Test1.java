package les18Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import les19PageObjects.PageObjects;

import java.time.Duration;

public class Test1 {
    @Parameters({"login", "password"}) //сами параметры прописываются в файле testng.xml
    @Test(groups = "regress")
    public void login(String login, String password) {
        WebDriver driver = new ChromeDriver();
        PageObjects pageObjects = new PageObjects("https://www.demoblaze.com/");

        PageObjects.setDriver();
        pageObjects.openWeb(driver);
        pageObjects.login(driver, login, password);

        PageObjects.mySleep();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element = driver.findElement(By.xpath("//a[@id='nameofuser']"));
        String nameOfUser = element.getText();
        Assert.assertEquals(nameOfUser, "Welcome admin");
        driver.quit();
    }
}
