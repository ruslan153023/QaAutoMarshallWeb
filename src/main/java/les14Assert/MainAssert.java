package les14Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import les19PageObjects.PageObjects;

import java.time.Duration;

public class MainAssert {
    public static void main(String[] args) {
        PageObjects.setDriver();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://www.demoblaze.com/index.html");

        String title = driver.getTitle();

        Assert.assertEquals(title, "STORE");

        driver.quit();

    }
}
