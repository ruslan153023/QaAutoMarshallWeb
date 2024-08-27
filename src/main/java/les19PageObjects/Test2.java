package les19PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;


public class Test2 {
    @Parameters({"login", "password"})
    @Test (groups = "regress")
    public void addToCart(String login, String password) {
        WebDriver driver = new ChromeDriver();
        PageObjects pageObjects = new PageObjects("https://www.demoblaze.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(pageObjects.getSECONDS()));

        PageObjects.setDriver();
        pageObjects.openWeb(driver);
        pageObjects.login(driver,login, password);

        PageObjects.mySleep();
        pageObjects.addPhoneToCart(driver);

        driver.quit();
    }
}
