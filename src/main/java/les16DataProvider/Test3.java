package les16DataProvider;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import les19PageObjects.PageObjects;

import java.time.Duration;

public class Test3 {
    @DataProvider(name = "dp")
    public static Object[][] dpData (){
        return new Object [][]{
                {"admin", "admin"},
                {"Serg", "123"}
        };
    }

    int count = 0;

    @Test (dataProvider = "dp")
    public void login(String login, String password) {
        count++;
        WebDriver driver = new ChromeDriver();
        PageObjects pageObjects = new PageObjects("https://www.demoblaze.com/");

        PageObjects.setDriver();
        pageObjects.openWeb(driver);
        pageObjects.login(driver, login, password);

        if (count == 2){
            PageObjects.mySleep();
            Alert alert1 = driver.switchTo().alert();
            alert1.accept();
            driver.findElement(By.xpath("//button[@onclick='logIn()']/../button[@class='btn btn-secondary']")).click();
            PageObjects.mySleep();
            driver.quit();
            return;
        }

        PageObjects.mySleep();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element = driver.findElement(By.xpath("//a[@id='nameofuser']"));
        String nameOfUser = element.getText();
        Assert.assertEquals(nameOfUser, "Welcome admin");
        driver.quit();

    }
}
